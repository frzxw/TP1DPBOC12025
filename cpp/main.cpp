// include file petshop.cpp
#include "petshop.cpp"

int main()
{
    // membuat objek PetShop
    PetShop shop;
    int choice, id, harga, umur, berat;
    string nama, kategori, jenis, ras, warna, tanggal_kadaluarsa, dosis, bahan;
    bool status_vaksin;

    // loop utama program
    while (true)
    {
        // menampilkan menu
        show_menu();
        cout << "Pilih menu: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
            // menambah produk baru
            cout << "Tambah Produk" << endl;
            show_kategori();
            cout << "Pilih kategori produk: ";
            cin >> choice;

            set_kategori(choice, kategori);

            cout << "ID: ";
            cin >> id;

            // cek apakah id produk sudah ada
            if (shop.find_produk(id) != NULL)
            {
                cout << "ID sudah ada. Silakan masukkan ID yang berbeda." << endl;
                break;
            }

            cout << "Nama: ";
            cin >> nama;
            cout << "Harga (Rp): ";
            cin >> harga;

            // menambah produk berdasarkan kategori
            switch (choice)
            {
            case 1:
                cout << "Umur (bulan): ";
                cin >> umur;
                cout << "Status Vaksin (1: Sudah, 0: Belum): ";
                cin >> status_vaksin;
                cout << "Jenis: ";
                cin >> jenis;
                cout << "Ras: ";
                cin >> ras;
                cout << "Warna: ";
                cin >> warna;
                shop.create_produk(new Hewan(id, nama, kategori, harga, umur, status_vaksin, jenis, ras, warna));
                break;

            case 2:
                cout << "Berat: ";
                cin >> berat;
                cout << "Jenis: ";
                cin >> jenis;
                cout << "Tanggal Kadaluarsa: ";
                cin >> tanggal_kadaluarsa;
                shop.create_produk(new Makanan(id, nama, kategori, harga, berat, jenis, tanggal_kadaluarsa));
                break;

            case 3:
                cout << "Bahan: ";
                cin >> bahan;
                cout << "Jenis: ";
                cin >> jenis;
                cout << "Warna: ";
                cin >> warna;
                shop.create_produk(new Aksesoris(id, nama, kategori, harga, bahan, jenis, warna));
                break;

            case 4:
                cout << "Dosis: ";
                cin >> dosis;
                cout << "Jenis: ";
                cin >> jenis;
                cout << "Tanggal Kadaluarsa: ";
                cin >> tanggal_kadaluarsa;
                shop.create_produk(new Obat(id, nama, kategori, harga, dosis, jenis, tanggal_kadaluarsa));
                break;

            case 5:
                cout << "Bahan: ";
                cin >> bahan;
                cout << "Jenis: ";
                cin >> jenis;
                cout << "Warna: ";
                cin >> warna;
                shop.create_produk(new Mainan(id, nama, kategori, harga, bahan, jenis, warna));
                break;

            default:
                cout << "Pilihan tidak valid" << endl;
                break;
            }
            break;

        case 2:
            // menampilkan semua produk
            cout << "Tampilkan Produk" << endl;
            shop.read_produk();
            break;

        case 3:
            // mencari produk berdasarkan id
            cout << "Cari Produk" << endl;
            cout << "ID: ";
            cin >> id;
            if (shop.find_produk(id) != NULL)
            {
                cout << "Produk ditemukan" << endl;
                shop.find_produk(id)->display();
            }
            else
            {
                cout << "Produk tidak ditemukan" << endl;
            }
            break;

        case 4:
            // mengubah data produk
            cout << "Ubah Produk" << endl;
            cout << "ID: ";
            cin >> id;
            if (shop.find_produk(id) != NULL)
            {
                show_kategori();
                cout << "Pilih kategori produk: ";
                cin >> choice;

                set_kategori(choice, kategori);

                cout << "Nama: ";
                cin >> nama;
                cout << "Harga (Rp): ";
                cin >> harga;

                // mengubah produk berdasarkan kategori
                switch (choice)
                {
                case 1:
                    cout << "Umur (bulan): ";
                    cin >> umur;
                    cout << "Status Vaksin (1: Sudah, 0: Belum): ";
                    cin >> status_vaksin;
                    cout << "Jenis: ";
                    cin >> jenis;
                    cout << "Ras: ";
                    cin >> ras;
                    cout << "Warna: ";
                    cin >> warna;
                    shop.update_produk(id, new Hewan(id, nama, kategori, harga, umur, status_vaksin, jenis, ras, warna));
                    break;

                case 2:
                    cout << "Berat: ";
                    cin >> berat;
                    cout << "Jenis: ";
                    cin >> jenis;
                    cout << "Tanggal Kadaluarsa: ";
                    cin >> tanggal_kadaluarsa;
                    shop.update_produk(id, new Makanan(id, nama, kategori, harga, berat, jenis, tanggal_kadaluarsa));
                    break;

                case 3:
                    cout << "Bahan: ";
                    cin >> bahan;
                    cout << "Jenis: ";
                    cin >> jenis;
                    cout << "Warna: ";
                    cin >> warna;
                    shop.update_produk(id, new Aksesoris(id, nama, kategori, harga, bahan, jenis, warna));
                    break;

                case 4:
                    cout << "Dosis: ";
                    cin >> dosis;
                    cout << "Jenis: ";
                    cin >> jenis;
                    cout << "Tanggal Kadaluarsa: ";
                    cin >> tanggal_kadaluarsa;
                    shop.update_produk(id, new Obat(id, nama, kategori, harga, dosis, jenis, tanggal_kadaluarsa));
                    break;

                case 5:
                    cout << "Bahan: ";
                    cin >> bahan;
                    cout << "Jenis: ";
                    cin >> jenis;
                    cout << "Warna: ";
                    cin >> warna;
                    shop.update_produk(id, new Mainan(id, nama, kategori, harga, bahan, jenis, warna));
                    break;

                default:
                    cout << "Pilihan tidak valid" << endl;
                    break;
                }
            }
            else
            {
                cout << "Produk tidak ditemukan" << endl;
            }
            break;

        case 5:
            // menghapus produk berdasarkan id
            cout << "Hapus Produk" << endl;
            cout << "ID: ";
            cin >> id;
            shop.delete_produk(id);
            break;

        case 6:
            // keluar dari program
            cout << "Keluar" << endl;
            return 0;

        default:
            cout << "Pilihan tidak valid" << endl;
            break;
        }
    }

    return 0;
}
