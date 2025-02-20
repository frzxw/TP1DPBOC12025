<?php
class PetShop {
    // deklarasi properti private
    private $id_produk;
    private $nama_produk;
    private $kategori_produk;
    private $harga_produk;
    private $foto_produk;

    // konstruktor untuk menginisialisasi properti
    public function __construct($id_produk, $nama_produk, $kategori_produk, $harga_produk, $foto_produk) {
        $this->id_produk = $id_produk;
        $this->nama_produk = $nama_produk;
        $this->kategori_produk = $kategori_produk;
        $this->harga_produk = $harga_produk;
        $this->foto_produk = $foto_produk;
    }

    // metode untuk mendapatkan id produk
    public function get_id_produk() {
        return $this->id_produk;
    }

    // metode untuk mendapatkan nama produk
    public function get_nama_produk() {
        return $this->nama_produk;
    }

    // metode untuk mendapatkan kategori produk
    public function get_kategori_produk() {
        return $this->kategori_produk;
    }

    // metode untuk mendapatkan harga produk
    public function get_harga_produk() {
        return $this->harga_produk;
    }

    // metode untuk mendapatkan foto produk
    public function get_foto_produk() {
        return $this->foto_produk;
    }

    // metode untuk mengatur id produk
    public function set_id_produk($id_produk) {
        $this->id_produk = $id_produk;
    }

    // metode untuk mengatur nama produk
    public function set_nama_produk($nama_produk) {
        $this->nama_produk = $nama_produk;
    }

    // metode untuk mengatur kategori produk
    public function set_kategori_produk($kategori_produk) {
        $this->kategori_produk = $kategori_produk;
    }

    // metode untuk mengatur harga produk
    public function set_harga_produk($harga_produk) {
        $this->harga_produk = $harga_produk;
    }

    // metode untuk mengatur foto produk
    public function set_foto_produk($foto_produk) {
        $this->foto_produk = $foto_produk;
    }

    // metode untuk membuat produk baru
    public function create_produk($id_produk, $nama_produk, $kategori_produk, $harga_produk, $foto_produk) {
        $this->id_produk = $id_produk;
        $this->nama_produk = $nama_produk;
        $this->kategori_produk = $kategori_produk;
        $this->harga_produk = $harga_produk;
        $this->foto_produk = $foto_produk;
    }

    // metode untuk membaca data produk
    public function read_produk() {
        echo "ID Produk: " . $this->id_produk . "\n";
        echo "Nama Produk: " . $this->nama_produk . "\n";
        echo "Kategori Produk: " . $this->kategori_produk . "\n";
        echo "Harga Produk: " . $this->harga_produk . "\n";
        echo "Foto Produk: " . $this->foto_produk . "\n";
    }

    // metode untuk memperbarui data produk
    public function update_produk($id_produk, $nama_produk, $kategori_produk, $harga_produk, $foto_produk) {
        $this->id_produk = $id_produk;
        $this->nama_produk = $nama_produk;
        $this->kategori_produk = $kategori_produk;
        $this->harga_produk = $harga_produk;
        $this->foto_produk = $foto_produk;
    }

    // metode untuk menghapus data produk
    public function delete_produk() {
        $this->id_produk = 0;
        $this->nama_produk = "";
        $this->kategori_produk = "";
        $this->harga_produk = 0;
        $this->foto_produk = "";
    }
}
?>