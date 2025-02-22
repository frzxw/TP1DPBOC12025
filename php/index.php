<?php
require_once 'petshop.php';

session_start();

// Inisialisasi session untuk menyimpan data produk
if (!isset($_SESSION['shop'])) {
    $_SESSION['shop'] = [];
}

$shop = &$_SESSION['shop'];

// Memproses aksi berdasarkan request POST
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['action'])) {
    $action = $_POST['action'];
    $id = $_POST['id'] ?? 0;
    $nama = $_POST['nama'] ?? '';
    $kategori = $_POST['kategori'] ?? '';
    $harga = $_POST['harga'] ?? 0;
    $foto = '';

    if ($action == 'create') {
        foreach ($shop as $produk) {
            if ($produk->get_id_produk() == $id) {
                echo "<script>alert('ID sudah digunakan! Gunakan ID lain.'); window.history.back();</script>";
                exit;
            }
        }

        // Mengunggah foto produk jika ada
        if (isset($_FILES['foto']) && $_FILES['foto']['error'] == UPLOAD_ERR_OK) {
            $uploads_dir = 'uploads';
            if (!is_dir($uploads_dir)) {
                mkdir($uploads_dir, 0777, true);
            }
            $foto = "$uploads_dir/$id." . pathinfo($_FILES['foto']['name'], PATHINFO_EXTENSION);
            move_uploaded_file($_FILES['foto']['tmp_name'], $foto);
        }

        // Menambahkan produk baru ke dalam session
        $produk = new PetShop($id, $nama, $kategori, $harga, $foto);
        $shop[] = $produk;
    } elseif ($action == 'update') {
        foreach ($shop as $index => $produk) {
            if ($produk->get_id_produk() == $id) {
                $foto_lama = $produk->get_foto_produk();
                if (isset($_FILES['foto']) && $_FILES['foto']['error'] == UPLOAD_ERR_OK) {
                    if ($foto_lama && file_exists($foto_lama)) {
                        unlink($foto_lama);
                    }
                    $foto = "uploads/$id." . pathinfo($_FILES['foto']['name'], PATHINFO_EXTENSION);
                    move_uploaded_file($_FILES['foto']['tmp_name'], $foto);
                } else {
                    $foto = $foto_lama;
                }
                $shop[$index] = new PetShop($id, $nama, $kategori, $harga, $foto);
                $_SESSION['shop'] = $shop; // Memastikan perubahan tersimpan dalam session
                break;
            }
        }
    } elseif ($action == 'delete') {
        foreach ($shop as $key => $produk) {
            if ($produk->get_id_produk() == $id) {
                $foto_path = $produk->get_foto_produk();
                if ($foto_path && file_exists($foto_path)) {
                    unlink($foto_path);
                }
                unset($shop[$key]);
                $_SESSION['shop'] = array_values($shop); // Reset array keys
                break;
            }
        }
    }

    // Redirect setelah aksi selesai untuk memastikan tampilan diperbarui
    header("Location: " . $_SERVER['PHP_SELF']);
    exit;
}
?>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PetShop</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.7/dist/sweetalert2.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            color: #333;
            padding: 20px;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
        }

        .card {
            margin-bottom: 20px;
        }

        .table img {
            width: 100px;
            height: auto;
        }

        .form-group label {
            font-weight: bold;
        }

        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }

        .btn-warning {
            background-color: #ffc107;
            border-color: #ffc107;
        }

        .btn-danger {
            background-color: #dc3545;
            border-color: #dc3545;
        }
    </style>
</head>

<body>
    <div class="container">
        <h1 class="text-center my-4">PetShop</h1>
        <div class="card">
            <div class="card-header">
                <h2 class="card-title">Tambah Produk</h2>
            </div>
            <div class="card-body">
                <form id="createForm" method="POST" enctype="multipart/form-data">
                    <input type="hidden" name="action" value="create">
                    <div class="form-group">
                        <label for="id">ID Produk</label>
                        <input type="number" name="id" class="form-control" placeholder="ID Produk" required>
                    </div>
                    <div class="form-group">
                        <label for="nama">Nama Produk</label>
                        <input type="text" name="nama" class="form-control" placeholder="Nama Produk" required>
                    </div>
                    <div class="form-group">
                        <label for="kategori">Kategori Produk</label>
                        <select name="kategori" class="form-control" required>
                            <option value="">Pilih Kategori</option>
                            <option value="Hewan">Hewan</option>
                            <option value="Makanan">Makanan</option>
                            <option value="Aksesoris">Aksesoris</option>
                            <option value="Obat">Obat</option>
                            <option value="Mainan">Mainan</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="harga">Harga Produk</label>
                        <input type="number" name="harga" class="form-control" placeholder="Harga Produk" required>
                    </div>
                    <div class="form-group">
                        <label for="foto">Foto Produk</label>
                        <input type="file" name="foto" class="form-control-file">
                    </div>
                    <button type="submit" class="btn btn-primary">Tambah Produk</button>
                </form>
            </div>
        </div>

        <div class="card">
            <div class="card-header">
                <h2 class="card-title">Daftar Produk</h2>
            </div>
            <div class="card-body">
                <table class="table table-bordered">
                    <thead class="thead-dark">
                        <tr>
                            <th>ID Produk</th>
                            <th>Nama Produk</th>
                            <th>Kategori Produk</th>
                            <th>Harga Produk</th>
                            <th>Foto Produk</th>
                            <th>Aksi</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php foreach ($shop as $produk): ?>
                            <tr>
                                <td><?php echo $produk->get_id_produk(); ?></td>
                                <td><?php echo $produk->get_nama_produk(); ?></td>
                                <td><?php echo $produk->get_kategori_produk(); ?></td>
                                <td><?php echo $produk->get_harga_produk(); ?></td>
                                <td><img src="<?php echo $produk->get_foto_produk(); ?>" alt="Foto Produk"></td>
                                <td>
                                    <button class="btn btn-warning edit-btn"
                                        data-id="<?php echo $produk->get_id_produk(); ?>"
                                        data-nama="<?php echo $produk->get_nama_produk(); ?>"
                                        data-kategori="<?php echo $produk->get_kategori_produk(); ?>"
                                        data-harga="<?php echo $produk->get_harga_produk(); ?>"
                                        data-foto="<?php echo $produk->get_foto_produk(); ?>">Ubah</button>
                                    <form method="POST" class="deleteForm" style="display:inline-block;">
                                        <input type="hidden" name="action" value="delete">
                                        <input type="hidden" name="id" value="<?php echo $produk->get_id_produk(); ?>">
                                        <button type="submit" class="btn btn-danger">Hapus</button>
                                    </form>
                                </td>
                            </tr>
                        <?php endforeach; ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.7/dist/sweetalert2.all.min.js"></script>
    <script>
        $(document).ready(function () {
            // konfirmasi sebelum menghapus produk
            $('.deleteForm').on('submit', function (e) {
                e.preventDefault();
                var form = this;
                Swal.fire({
                    title: 'Apakah Anda yakin?',
                    text: "Anda tidak akan dapat mengembalikan ini!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Ya, hapus!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        form.submit();
                    }
                });
            });

            // konfirmasi sebelum menambah produk baru
            $('#createForm').on('submit', function (e) {
                e.preventDefault();
                var form = this;
                Swal.fire({
                    title: 'Apakah Anda yakin?',
                    text: "Anda akan menambahkan produk baru!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Ya, tambahkan!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        form.submit();
                    }
                });
            });

            // menampilkan form edit produk
            $('.edit-btn').on('click', function () {
                var id = $(this).data('id');
                var nama = $(this).data('nama');
                var kategori = $(this).data('kategori');
                var harga = $(this).data('harga');
                var foto = $(this).data('foto');

                Swal.fire({
                    title: 'Edit Produk',
                    html: `
                        <form id="editForm" method="POST" enctype="multipart/form-data">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="id" value="${id}">
                            <div class="form-group">
                                <label for="nama">Nama Produk</label>
                                <input type="text" name="nama" class="form-control" value="${nama}" required>
                            </div>
                            <div class="form-group">
                                <label for="kategori">Kategori Produk</label>
                                <select name="kategori" class="form-control" required>
                                    <option value="Hewan" ${kategori == 'Hewan' ? 'selected' : ''}>Hewan</option>
                                    <option value="Makanan" ${kategori == 'Makanan' ? 'selected' : ''}>Makanan</option>
                                    <option value="Aksesoris" ${kategori == 'Aksesoris' ? 'selected' : ''}>Aksesoris</option>
                                    <option value="Obat" ${kategori == 'Obat' ? 'selected' : ''}>Obat</option>
                                    <option value="Mainan" ${kategori == 'Mainan' ? 'selected' : ''}>Mainan</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="harga">Harga Produk</label>
                                <input type="number" name="harga" class="form-control" value="${harga}" required>
                            </div>
                            <div class="form-group">
                                <label for="foto">Foto Produk</label>
                                <input type="file" name="foto" class="form-control-file">
                            </div>
                            <button type="submit" class="btn btn-primary">Simpan Perubahan</button>
                        </form>
                    `,
                    showCancelButton: true,
                    showConfirmButton: false,
                    cancelButtonText: 'Batal'
                });

                // konfirmasi sebelum mengubah produk
                $('#editForm').on('submit', function (e) {
                    e.preventDefault();
                    var form = this;
                    Swal.fire({
                        title: 'Apakah Anda yakin?',
                        text: "Anda akan mengubah produk ini!",
                        icon: 'warning',
                        showCancelButton: true,
                        confirmButtonColor: '#3085d6',
                        cancelButtonColor: '#d33',
                        confirmButtonText: 'Ya, ubah!'
                    }).then((result) => {
                        if (result.isConfirmed) {
                            form.submit();
                        }
                    });
                });
            });
        });
    </script>
</body>

</html>