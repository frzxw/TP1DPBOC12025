public class PetShop {
    // deklarasi atribut kelas
    private int idProduk;
    private String namaProduk;
    private String kategoriProduk;
    private int hargaProduk;

    // konstruktor untuk inisialisasi objek
    public PetShop(int idProduk, String namaProduk, String kategoriProduk, int hargaProduk) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.kategoriProduk = kategoriProduk;
        this.hargaProduk = hargaProduk;
    }

    // getter untuk mendapatkan id produk
    public int getIdProduk() {
        return idProduk;
    }

    // getter untuk mendapatkan nama produk
    public String getNamaProduk() {
        return namaProduk;
    }

    // getter untuk mendapatkan kategori produk
    public String getKategoriProduk() {
        return kategoriProduk;
    }

    // getter untuk mendapatkan harga produk
    public int getHargaProduk() {
        return hargaProduk;
    }

    // setter untuk mengubah id produk
    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }

    // setter untuk mengubah nama produk
    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    // setter untuk mengubah kategori produk
    public void setKategoriProduk(String kategoriProduk) {
        this.kategoriProduk = kategoriProduk;
    }

    // setter untuk mengubah harga produk
    public void setHargaProduk(int hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    // method untuk membuat produk baru
    public void createProduk(int idProduk, String namaProduk, String kategoriProduk, int hargaProduk) {
        setIdProduk(idProduk);
        setNamaProduk(namaProduk);
        setKategoriProduk(kategoriProduk);
        setHargaProduk(hargaProduk);
    }

    // method untuk membaca informasi produk
    public void readProduk() {
        System.out.println("ID Produk: " + getIdProduk());
        System.out.println("Nama Produk: " + getNamaProduk());
        System.out.println("Kategori Produk: " + getKategoriProduk());
        System.out.println("Harga Produk: " + getHargaProduk());
    }

    // method untuk mengupdate informasi produk
    public void updateProduk(int idProduk, String namaProduk, String kategoriProduk, int hargaProduk) {
        setIdProduk(idProduk);
        setNamaProduk(namaProduk);
        setKategoriProduk(kategoriProduk);
        setHargaProduk(hargaProduk);
    }

    // method untuk menghapus informasi produk
    public void deleteProduk() {
        setIdProduk(0);
        setNamaProduk("");
        setKategoriProduk("");
        setHargaProduk(0);
    }
}
