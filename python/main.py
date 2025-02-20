from petshop import PetShop

def show_menu():
    print("+----------------------+")
    print("|       MENU           |")
    print("+----------------------+")
    print("| 1. Tambah Produk     |")
    print("| 2. Tampilkan Produk  |")
    print("| 3. Cari Produk       |")
    print("| 4. Ubah Produk       |")
    print("| 5. Hapus Produk      |")
    print("| 6. Keluar            |")
    print("+----------------------+")

def show_kategori():
    print("+----------------------+")
    print("|     KATEGORI         |")
    print("+----------------------+")
    print("| 1. Hewan             |")
    print("| 2. Makanan           |")
    print("| 3. Aksesoris         |")
    print("| 4. Obat              |")
    print("| 5. Mainan            |")
    print("+----------------------+")

def set_kategori(choice):
    kategori = ""
    if choice == 1:
        kategori = "Hewan"
    elif choice == 2:
        kategori = "Makanan"
    elif choice == 3:
        kategori = "Aksesoris"
    elif choice == 4:
        kategori = "Obat"
    elif choice == 5:
        kategori = "Mainan"
    else:
        print("Pilihan tidak valid")
    return kategori

def main():
    shop = []
    running = True

    while running:
        show_menu()
        choice = int(input("Pilih menu: "))

        if choice == 1:
            print("Tambah Produk")
            show_kategori()
            kategori_choice = int(input("Pilih kategori produk: "))
            kategori = set_kategori(kategori_choice)

            id = int(input("ID: "))
            if any(p.get_id_produk() == id for p in shop):
                print("ID sudah ada. Silakan masukkan ID yang berbeda.")
                continue

            nama = input("Nama: ")
            harga = int(input("Harga (Rp): "))

            produk = PetShop(id, nama, kategori, harga)
            shop.append(produk)

        elif choice == 2:
            print("Tampilkan Produk")
            for produk in shop:
                produk.read_produk()

        elif choice == 3:
            print("Cari Produk")
            id = int(input("ID: "))
            found = False
            for produk in shop:
                if produk.get_id_produk() == id:
                    print("Produk ditemukan")
                    produk.read_produk()
                    found = True
                    break
            if not found:
                print("Produk tidak ditemukan")

        elif choice == 4:
            print("Ubah Produk")
            id = int(input("ID: "))
            for produk in shop:
                if produk.get_id_produk() == id:
                    show_kategori()
                    kategori_choice = int(input("Pilih kategori produk: "))
                    kategori = set_kategori(kategori_choice)

                    nama = input("Nama: ")
                    harga = int(input("Harga (Rp): "))

                    produk.update_produk(id, nama, kategori, harga)
                    break
            else:
                print("Produk tidak ditemukan")

        elif choice == 5:
            print("Hapus Produk")
            id = int(input("ID: "))
            for produk in shop:
                if produk.get_id_produk() == id:
                    shop.remove(produk)
                    print("Produk berhasil dihapus!")
                    break
            else:
                print("Produk tidak ditemukan")

        elif choice == 6:
            print("Keluar")
            running = False

        else:
            print("Pilihan tidak valid")

if __name__ == "__main__":
    main()