from petshop import *

def main():
    shop = PetShop()
    while True:
        show_menu()
        choice = int(input("Pilih menu: "))

        if choice == 1:
            print("Tambah Produk")
            show_kategori()
            kategori_choice = int(input("Pilih kategori produk: "))
            kategori = set_kategori(kategori_choice)

            id = int(input("ID: "))

            if shop.find_produk(id) is not None:
                print("ID sudah ada. Silakan masukkan ID yang berbeda.")
                continue

            nama = input("Nama: ")
            harga = int(input("Harga (Rp): "))

            if kategori_choice == 1:
                umur = int(input("Umur (bulan): "))
                status_vaksin = bool(int(input("Status Vaksin (1: Sudah, 0: Belum): ")))
                jenis = input("Jenis: ")
                ras = input("Ras: ")
                warna = input("Warna: ")
                shop.create_produk(Hewan(id, nama, kategori, harga, umur, status_vaksin, jenis, ras, warna))

            elif kategori_choice == 2:
                berat = int(input("Berat: "))
                jenis = input("Jenis: ")
                tanggal_kadaluarsa = input("Tanggal Kadaluarsa: ")
                shop.create_produk(Makanan(id, nama, kategori, harga, berat, jenis, tanggal_kadaluarsa))

            elif kategori_choice == 3:
                bahan = input("Bahan: ")
                jenis = input("Jenis: ")
                warna = input("Warna: ")
                shop.create_produk(Aksesoris(id, nama, kategori, harga, bahan, jenis, warna))

            elif kategori_choice == 4:
                dosis = input("Dosis: ")
                jenis = input("Jenis: ")
                tanggal_kadaluarsa = input("Tanggal Kadaluarsa: ")
                shop.create_produk(Obat(id, nama, kategori, harga, dosis, jenis, tanggal_kadaluarsa))

            elif kategori_choice == 5:
                bahan = input("Bahan: ")
                jenis = input("Jenis: ")
                warna = input("Warna: ")
                shop.create_produk(Mainan(id, nama, kategori, harga, bahan, jenis, warna))

            else:
                print("Pilihan tidak valid")

        elif choice == 2:
            print("Tampilkan Produk")
            shop.read_produk()

        elif choice == 3:
            print("Cari Produk")
            id = int(input("ID: "))
            produk = shop.find_produk(id)
            if produk is not None:
                print("Produk ditemukan")
                produk.display()
            else:
                print("Produk tidak ditemukan")

        elif choice == 4:
            print("Ubah Produk")
            id = int(input("ID: "))
            produk = shop.find_produk(id)
            if produk is not None:
                show_kategori()
                kategori_choice = int(input("Pilih kategori produk: "))
                kategori = set_kategori(kategori_choice)

                nama = input("Nama: ")
                harga = int(input("Harga (Rp): "))

                if kategori_choice == 1:
                    umur = int(input("Umur (bulan): "))
                    status_vaksin = bool(int(input("Status Vaksin (1: Sudah, 0: Belum): ")))
                    jenis = input("Jenis: ")
                    ras = input("Ras: ")
                    warna = input("Warna: ")
                    shop.update_produk(id, Hewan(id, nama, kategori, harga, umur, status_vaksin, jenis, ras, warna))

                elif kategori_choice == 2:
                    berat = int(input("Berat: "))
                    jenis = input("Jenis: ")
                    tanggal_kadaluarsa = input("Tanggal Kadaluarsa: ")
                    shop.update_produk(id, Makanan(id, nama, kategori, harga, berat, jenis, tanggal_kadaluarsa))

                elif kategori_choice == 3:
                    bahan = input("Bahan: ")
                    jenis = input("Jenis: ")
                    warna = input("Warna: ")
                    shop.update_produk(id, Aksesoris(id, nama, kategori, harga, bahan, jenis, warna))

                elif kategori_choice == 4:
                    dosis = input("Dosis: ")
                    jenis = input("Jenis: ")
                    tanggal_kadaluarsa = input("Tanggal Kadaluarsa: ")
                    shop.update_produk(id, Obat(id, nama, kategori, harga, dosis, jenis, tanggal_kadaluarsa))

                elif kategori_choice == 5:
                    bahan = input("Bahan: ")
                    jenis = input("Jenis: ")
                    warna = input("Warna: ")
                    shop.update_produk(id, Mainan(id, nama, kategori, harga, bahan, jenis, warna))

                else:
                    print("Pilihan tidak valid")
            else:
                print("Produk tidak ditemukan")

        elif choice == 5:
            print("Hapus Produk")
            id = int(input("ID: "))
            shop.delete_produk(id)

        elif choice == 6:
            print("Keluar")
            break

        else:
            print("Pilihan tidak valid")

if __name__ == "__main__":
    main()