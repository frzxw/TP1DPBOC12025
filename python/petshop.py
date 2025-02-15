class Produk:
    def __init__(self, id=0, nama="", kategori="", harga=0):
        self.id = id
        self.nama = nama
        self.kategori = kategori
        self.harga = harga

    def get_id(self):
        return self.id

    def get_nama(self):
        return self.nama

    def get_kategori(self):
        return self.kategori

    def get_harga(self):
        return self.harga

    def set_id(self, id):
        self.id = id

    def set_nama(self, nama):
        self.nama = nama

    def set_kategori(self, kategori):
        self.kategori = kategori

    def set_harga(self, harga):
        self.harga = harga

    def display(self):
        print(f"ID: {self.id}")
        print(f"Nama: {self.nama}")
        print(f"Kategori: {self.kategori}")
        print(f"Harga: {self.harga}")


class Hewan(Produk):
    def __init__(self, id=0, nama="", kategori="", harga=0, umur=0, status_vaksin=False, jenis="", ras="", warna=""):
        super().__init__(id, nama, kategori, harga)
        self.umur = umur
        self.status_vaksin = status_vaksin
        self.jenis = jenis
        self.ras = ras
        self.warna = warna

    def get_umur(self):
        return self.umur

    def get_status_vaksin(self):
        return self.status_vaksin

    def get_jenis(self):
        return self.jenis

    def get_ras(self):
        return self.ras

    def get_warna(self):
        return self.warna

    def set_umur(self, umur):
        self.umur = umur

    def set_status_vaksin(self, status_vaksin):
        self.status_vaksin = status_vaksin

    def set_jenis(self, jenis):
        self.jenis = jenis

    def set_ras(self, ras):
        self.ras = ras

    def set_warna(self, warna):
        self.warna = warna

    def display(self):
        super().display()
        print(f"Umur: {self.umur}")
        print(f"Status Vaksin: {'Sudah' if self.status_vaksin else 'Belum'}")
        print(f"Jenis: {self.jenis}")
        print(f"Ras: {self.ras}")
        print(f"Warna: {self.warna}")


class Makanan(Produk):
    def __init__(self, id=0, nama="", kategori="", harga=0, berat=0, jenis="", tanggal_kadaluarsa=""):
        super().__init__(id, nama, kategori, harga)
        self.berat = berat
        self.jenis = jenis
        self.tanggal_kadaluarsa = tanggal_kadaluarsa

    def get_berat(self):
        return self.berat

    def get_jenis(self):
        return self.jenis

    def get_tanggal_kadaluarsa(self):
        return self.tanggal_kadaluarsa

    def set_berat(self, berat):
        self.berat = berat

    def set_jenis(self, jenis):
        self.jenis = jenis

    def set_tanggal_kadaluarsa(self, tanggal_kadaluarsa):
        self.tanggal_kadaluarsa = tanggal_kadaluarsa

    def display(self):
        super().display()
        print(f"Berat: {self.berat}")
        print(f"Jenis: {self.jenis}")
        print(f"Tanggal Kadaluarsa: {self.tanggal_kadaluarsa}")


class Aksesoris(Produk):
    def __init__(self, id=0, nama="", kategori="", harga=0, bahan="", jenis="", warna=""):
        super().__init__(id, nama, kategori, harga)
        self.bahan = bahan
        self.jenis = jenis
        self.warna = warna

    def get_bahan(self):
        return self.bahan

    def get_jenis(self):
        return self.jenis

    def get_warna(self):
        return self.warna

    def set_bahan(self, bahan):
        self.bahan = bahan

    def set_jenis(self, jenis):
        self.jenis = jenis

    def set_warna(self, warna):
        self.warna = warna

    def display(self):
        super().display()
        print(f"Bahan: {self.bahan}")
        print(f"Jenis: {self.jenis}")
        print(f"Warna: {self.warna}")


class Obat(Produk):
    def __init__(self, id=0, nama="", kategori="", harga=0, dosis="", jenis="", tanggal_kadaluarsa=""):
        super().__init__(id, nama, kategori, harga)
        self.dosis = dosis
        self.jenis = jenis
        self.tanggal_kadaluarsa = tanggal_kadaluarsa

    def get_dosis(self):
        return self.dosis

    def get_jenis(self):
        return self.jenis

    def get_tanggal_kadaluarsa(self):
        return self.tanggal_kadaluarsa

    def set_dosis(self, dosis):
        self.dosis = dosis

    def set_jenis(self, jenis):
        self.jenis = jenis

    def set_tanggal_kadaluarsa(self, tanggal_kadaluarsa):
        self.tanggal_kadaluarsa = tanggal_kadaluarsa

    def display(self):
        super().display()
        print(f"Dosis: {self.dosis}")
        print(f"Jenis: {self.jenis}")
        print(f"Tanggal Kadaluarsa: {self.tanggal_kadaluarsa}")


class Mainan(Produk):
    def __init__(self, id=0, nama="", kategori="", harga=0, bahan="", jenis="", warna=""):
        super().__init__(id, nama, kategori, harga)
        self.bahan = bahan
        self.jenis = jenis
        self.warna = warna

    def get_bahan(self):
        return self.bahan

    def get_jenis(self):
        return self.jenis

    def get_warna(self):
        return self.warna

    def set_bahan(self, bahan):
        self.bahan = bahan

    def set_jenis(self, jenis):
        self.jenis = jenis

    def set_warna(self, warna):
        self.warna = warna

    def display(self):
        super().display()
        print(f"Bahan: {self.bahan}")
        print(f"Jenis: {self.jenis}")
        print(f"Warna: {self.warna}")


class PetShop:
    def __init__(self):
        self.list_produk = []

    def create_produk(self, produk):
        self.list_produk.append(produk)
        print("Produk berhasil ditambahkan!")

    def read_produk(self):
        for produk in self.list_produk:
            print("------------------------")
            produk.display()
            print("------------------------")

    def update_produk(self, id, produk):
        found = False
        for i in range(len(self.list_produk)):
            if self.list_produk[i].get_id() == id:
                self.list_produk[i] = produk
                found = True
                print("Produk berhasil diubah!")
                break
        if not found:
            print("Produk tidak ditemukan!")

    def delete_produk(self, id):
        found = False
        for i in range(len(self.list_produk)):
            if self.list_produk[i].get_id() == id:
                del self.list_produk[i]
                found = True
                print("Produk berhasil dihapus!")
                break
        if not found:
            print("Produk tidak ditemukan!")

    def find_produk(self, id):
        for produk in self.list_produk:
            if produk.get_id() == id:
                return produk
        return None


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