from petshop import PetShop

# fungsi untuk menampilkan menu utama
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

# fungsi untuk menampilkan kategori produk
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

# fungsi untuk mengatur kategori berdasarkan pilihan
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

# fungsi utama
def main():
    shop = []  # list untuk menyimpan produk
    running = True  # flag untuk menjalankan loop

    while running:
        show_menu()  # tampilkan menu
        choice = int(input("Pilih menu: "))  # input pilihan menu

        if choice == 1:
            # tambah produk baru
            print("Tambah Produk")
            show_kategori()  # tampilkan kategori
            kategori_choice = int(input("Pilih kategori produk: "))  # input pilihan kategori
            kategori = set_kategori(kategori_choice)  # set kategori berdasarkan pilihan

            id = int(input("ID: "))  # input id produk
            if any(p.get_id_produk() == id for p in shop):  # cek apakah id sudah ada
                print("ID sudah ada. Silakan masukkan ID yang berbeda.")
                continue

            nama = input("Nama: ")  # input nama produk
            harga = int(input("Harga (Rp): "))  # input harga produk

            produk = PetShop(id, nama, kategori, harga)  # buat objek produk baru
            shop.append(produk)  # tambahkan produk ke list

        elif choice == 2:
            # tampilkan semua produk
            print("Tampilkan Produk")
            for produk in shop:
                produk.read_produk()  # panggil method untuk menampilkan detail produk

        elif choice == 3:
            # cari produk berdasarkan id
            print("Cari Produk")
            id = int(input("ID: "))  # input id produk
            found = False
            for produk in shop:
                if produk.get_id_produk() == id:  # cek apakah id produk ditemukan
                    print("Produk ditemukan")
                    produk.read_produk()  # tampilkan detail produk
                    found = True
                    break
            if not found:
                print("Produk tidak ditemukan")

        elif choice == 4:
            # ubah detail produk
            print("Ubah Produk")
            id = int(input("ID: "))  # input id produk
            for produk in shop:
                if produk.get_id_produk() == id:  # cek apakah id produk ditemukan
                    show_kategori()  # tampilkan kategori
                    kategori_choice = int(input("Pilih kategori produk: "))  # input pilihan kategori
                    kategori = set_kategori(kategori_choice)  # set kategori berdasarkan pilihan

                    nama = input("Nama: ")  # input nama produk baru
                    harga = int(input("Harga (Rp): "))  # input harga produk baru

                    produk.update_produk(id, nama, kategori, harga)  # update detail produk
                    break
            else:
                print("Produk tidak ditemukan")

        elif choice == 5:
            # hapus produk berdasarkan id
            print("Hapus Produk")
            id = int(input("ID: "))  # input id produk
            for produk in shop:
                if produk.get_id_produk() == id:  # cek apakah id produk ditemukan
                    shop.remove(produk)  # hapus produk dari list
                    print("Produk berhasil dihapus!")
                    break
            else:
                print("Produk tidak ditemukan")

        elif choice == 6:
            # keluar dari program
            print("Keluar")
            running = False  # set flag running menjadi false

        else:
            print("Pilihan tidak valid")

if __name__ == "__main__":
    main()