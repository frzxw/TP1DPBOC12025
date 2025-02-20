public class PetShop {
    private int idProduk;
    private String namaProduk;
    private String kategoriProduk;
    private int hargaProduk;

    public PetShop(int idProduk, String namaProduk, String kategoriProduk, int hargaProduk) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.kategoriProduk = kategoriProduk;
        this.hargaProduk = hargaProduk;
    }

    public int getIdProduk() {
        return idProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public String getKategoriProduk() {
        return kategoriProduk;
    }

    public int getHargaProduk() {
        return hargaProduk;
    }

    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public void setKategoriProduk(String kategoriProduk) {
        this.kategoriProduk = kategoriProduk;
    }

    public void setHargaProduk(int hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public void createProduk(int idProduk, String namaProduk, String kategoriProduk, int hargaProduk) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.kategoriProduk = kategoriProduk;
        this.hargaProduk = hargaProduk;
    }

    public void readProduk() {
        System.out.println("ID Produk: " + idProduk);
        System.out.println("Nama Produk: " + namaProduk);
        System.out.println("Kategori Produk: " + kategoriProduk);
        System.out.println("Harga Produk: " + hargaProduk);
    }

    public void updateProduk(int idProduk, String namaProduk, String kategoriProduk, int hargaProduk) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.kategoriProduk = kategoriProduk;
        this.hargaProduk = hargaProduk;
    }

    public void deleteProduk() {
        idProduk = 0;
        namaProduk = "";
        kategoriProduk = "";
        hargaProduk = 0;
    }
}
