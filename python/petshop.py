class PetShop:
    # konstruktor untuk menginisialisasi atribut produk
    def __init__(self, id_produk, nama_produk, kategori_produk, harga_produk):
        self.id_produk = id_produk
        self.nama_produk = nama_produk
        self.kategori_produk = kategori_produk
        self.harga_produk = harga_produk

    # metode untuk mendapatkan id produk
    def get_id_produk(self):
        return self.id_produk

    # metode untuk mendapatkan nama produk
    def get_nama_produk(self):
        return self.nama_produk

    # metode untuk mendapatkan kategori produk
    def get_kategori_produk(self):
        return self.kategori_produk

    # metode untuk mendapatkan harga produk
    def get_harga_produk(self):
        return self.harga_produk

    # metode untuk mengatur id produk
    def set_id_produk(self, id_produk):
        self.id_produk = id_produk

    # metode untuk mengatur nama produk
    def set_nama_produk(self, nama_produk):
        self.nama_produk = nama_produk

    # metode untuk mengatur kategori produk
    def set_kategori_produk(self, kategori_produk):
        self.kategori_produk = kategori_produk

    # metode untuk mengatur harga produk
    def set_harga_produk(self, harga_produk):
        self.harga_produk = harga_produk

    # metode untuk membuat produk baru
    def create_produk(self, id_produk, nama_produk, kategori_produk, harga_produk):
        self.id_produk = id_produk
        self.nama_produk = nama_produk
        self.kategori_produk = kategori_produk
        self.harga_produk = harga_produk

    # metode untuk membaca informasi produk
    def read_produk(self):
        print(f"ID Produk: {self.id_produk}")
        print(f"Nama Produk: {self.nama_produk}")
        print(f"Kategori Produk: {self.kategori_produk}")
        print(f"Harga Produk: {self.harga_produk}")

    # metode untuk memperbarui informasi produk
    def update_produk(self, id_produk, nama_produk, kategori_produk, harga_produk):
        self.id_produk = id_produk
        self.nama_produk = nama_produk
        self.kategori_produk = kategori_produk
        self.harga_produk = harga_produk

    # metode untuk menghapus produk
    def delete_produk(self):
        self.id_produk = 0
        self.nama_produk = ""
        self.kategori_produk = ""
        self.harga_produk = 0
        
    # destruktor untuk menghapus objek produk
    def __del__(self):
        print(f"Produk dengan ID {self.id_produk} telah dihapus.")
