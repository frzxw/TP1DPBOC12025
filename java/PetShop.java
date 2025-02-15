package TP1DPBOC12025.java;

import java.util.ArrayList;

public class PetShop {
    abstract class Produk {
        protected int id;
        protected String nama;
        protected String kategori;
        protected int harga;

        public Produk() {
            this.id = 0;
            this.nama = "";
            this.kategori = "";
            this.harga = 0;
        }

        public Produk(int id, String nama, String kategori, int harga) {
            this.id = id;
            this.nama = nama;
            this.kategori = kategori;
            this.harga = harga;
        }

        public int getId() {
            return id;
        }

        public String getNama() {
            return nama;
        }

        public String getKategori() {
            return kategori;
        }

        public int getHarga() {
            return harga;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public void setKategori(String kategori) {
            this.kategori = kategori;
        }

        public void setHarga(int harga) {
            this.harga = harga;
        }

        public void display() {
            System.out.println("ID: " + id);
            System.out.println("Nama: " + nama);
            System.out.println("Kategori: " + kategori);
            System.out.println("Harga: " + harga);
        }
    }

    class Hewan extends Produk {
        private int umur;
        private boolean statusVaksin;
        private String jenis;
        private String ras;
        private String warna;

        public Hewan() {
            this.umur = 0;
            this.statusVaksin = false;
            this.jenis = "";
            this.ras = "";
            this.warna = "";
        }

        public Hewan(int id, String nama, String kategori, int harga, int umur, boolean statusVaksin, String jenis,
                String ras, String warna) {
            super(id, nama, kategori, harga);
            this.umur = umur;
            this.statusVaksin = statusVaksin;
            this.jenis = jenis;
            this.ras = ras;
            this.warna = warna;
        }

        public int getUmur() {
            return umur;
        }

        public boolean getStatusVaksin() {
            return statusVaksin;
        }

        public String getJenis() {
            return jenis;
        }

        public String getRas() {
            return ras;
        }

        public String getWarna() {
            return warna;
        }

        public void setUmur(int umur) {
            this.umur = umur;
        }

        public void setStatusVaksin(boolean statusVaksin) {
            this.statusVaksin = statusVaksin;
        }

        public void setJenis(String jenis) {
            this.jenis = jenis;
        }

        public void setRas(String ras) {
            this.ras = ras;
        }

        public void setWarna(String warna) {
            this.warna = warna;
        }

        @Override
        public void display() {
            super.display();
            System.out.println("Umur: " + umur);
            System.out.println("Status Vaksin: " + (statusVaksin ? "Sudah" : "Belum"));
            System.out.println("Jenis: " + jenis);
            System.out.println("Ras: " + ras);
            System.out.println("Warna: " + warna);
        }
    }

    class Makanan extends Produk {
        private int berat;
        private String jenis;
        private String tanggalKadaluarsa;

        public Makanan() {
            this.berat = 0;
            this.jenis = "";
            this.tanggalKadaluarsa = "";
        }

        public Makanan(int id, String nama, String kategori, int harga, int berat, String jenis,
                String tanggalKadaluarsa) {
            super(id, nama, kategori, harga);
            this.berat = berat;
            this.jenis = jenis;
            this.tanggalKadaluarsa = tanggalKadaluarsa;
        }

        public int getBerat() {
            return berat;
        }

        public String getJenis() {
            return jenis;
        }

        public String getTanggalKadaluarsa() {
            return tanggalKadaluarsa;
        }

        public void setBerat(int berat) {
            this.berat = berat;
        }

        public void setJenis(String jenis) {
            this.jenis = jenis;
        }

        public void setTanggalKadaluarsa(String tanggalKadaluarsa) {
            this.tanggalKadaluarsa = tanggalKadaluarsa;
        }

        @Override
        public void display() {
            super.display();
            System.out.println("Berat: " + berat);
            System.out.println("Jenis: " + jenis);
            System.out.println("Tanggal Kadaluarsa: " + tanggalKadaluarsa);
        }
    }

    class Aksesoris extends Produk {
        private String bahan;
        private String jenis;
        private String warna;

        public Aksesoris() {
            this.bahan = "";
            this.jenis = "";
            this.warna = "";
        }

        public Aksesoris(int id, String nama, String kategori, int harga, String bahan, String jenis, String warna) {
            super(id, nama, kategori, harga);
            this.bahan = bahan;
            this.jenis = jenis;
            this.warna = warna;
        }

        public String getBahan() {
            return bahan;
        }

        public String getJenis() {
            return jenis;
        }

        public String getWarna() {
            return warna;
        }

        public void setBahan(String bahan) {
            this.bahan = bahan;
        }

        public void setJenis(String jenis) {
            this.jenis = jenis;
        }

        public void setWarna(String warna) {
            this.warna = warna;
        }

        @Override
        public void display() {
            super.display();
            System.out.println("Bahan: " + bahan);
            System.out.println("Jenis: " + jenis);
            System.out.println("Warna: " + warna);
        }
    }

    class Obat extends Produk {
        private String dosis;
        private String jenis;
        private String tanggalKadaluarsa;

        public Obat() {
            this.dosis = "";
            this.jenis = "";
            this.tanggalKadaluarsa = "";
        }

        public Obat(int id, String nama, String kategori, int harga, String dosis, String jenis,
                String tanggalKadaluarsa) {
            super(id, nama, kategori, harga);
            this.dosis = dosis;
            this.jenis = jenis;
            this.tanggalKadaluarsa = tanggalKadaluarsa;
        }

        public String getDosis() {
            return dosis;
        }

        public String getJenis() {
            return jenis;
        }

        public String getTanggalKadaluarsa() {
            return tanggalKadaluarsa;
        }

        public void setDosis(String dosis) {
            this.dosis = dosis;
        }

        public void setJenis(String jenis) {
            this.jenis = jenis;
        }

        public void setTanggalKadaluarsa(String tanggalKadaluarsa) {
            this.tanggalKadaluarsa = tanggalKadaluarsa;
        }

        @Override
        public void display() {
            super.display();
            System.out.println("Dosis: " + dosis);
            System.out.println("Jenis: " + jenis);
            System.out.println("Tanggal Kadaluarsa: " + tanggalKadaluarsa);
        }
    }

    class Mainan extends Produk {
        private String bahan;
        private String jenis;
        private String warna;

        public Mainan() {
            this.bahan = "";
            this.jenis = "";
            this.warna = "";
        }

        public Mainan(int id, String nama, String kategori, int harga, String bahan, String jenis, String warna) {
            super(id, nama, kategori, harga);
            this.bahan = bahan;
            this.jenis = jenis;
            this.warna = warna;
        }

        public String getBahan() {
            return bahan;
        }

        public String getJenis() {
            return jenis;
        }

        public String getWarna() {
            return warna;
        }

        public void setBahan(String bahan) {
            this.bahan = bahan;
        }

        public void setJenis(String jenis) {
            this.jenis = jenis;
        }

        public void setWarna(String warna) {
            this.warna = warna;
        }

        @Override
        public void display() {
            super.display();
            System.out.println("Bahan: " + bahan);
            System.out.println("Jenis: " + jenis);
            System.out.println("Warna: " + warna);
        }
    }

    private ArrayList<Produk> listProduk;

    public PetShop() {
        listProduk = new ArrayList<>();
    }

    public void createProduk(Produk produk) {
        listProduk.add(produk);
        System.out.println("Produk berhasil ditambahkan!");
    }

    public void readProduk() {
        for (Produk produk : listProduk) {
            System.out.println("------------------------");
            produk.display();
            System.out.println("------------------------");
        }
    }

    public void updateProduk(int id, Produk produk) {
        boolean found = false;
        for (int i = 0; i < listProduk.size(); i++) {
            if (listProduk.get(i).getId() == id) {
                listProduk.set(i, produk);
                found = true;
                System.out.println("Produk berhasil diubah!");
                break;
            }
        }
        if (!found) {
            System.out.println("Produk tidak ditemukan!");
        }
    }

    public void deleteProduk(int id) {
        boolean found = false;
        for (int i = 0; i < listProduk.size(); i++) {
            if (listProduk.get(i).getId() == id) {
                listProduk.remove(i);
                found = true;
                System.out.println("Produk berhasil dihapus!");
                break;
            }
        }
        if (!found) {
            System.out.println("Produk tidak ditemukan!");
        }
    }

    public Produk findProduk(int id) {
        for (Produk produk : listProduk) {
            if (produk.getId() == id) {
                return produk;
            }
        }
        return null;
    }

    public static void showMenu() {
        System.out.println("+----------------------+");
        System.out.println("|       MENU           |");
        System.out.println("+----------------------+");
        System.out.println("| 1. Tambah Produk     |");
        System.out.println("| 2. Tampilkan Produk  |");
        System.out.println("| 3. Cari Produk       |");
        System.out.println("| 4. Ubah Produk       |");
        System.out.println("| 5. Hapus Produk      |");
        System.out.println("| 6. Keluar            |");
        System.out.println("+----------------------+");
    }

    public static void showKategori() {
        System.out.println("+----------------------+");
        System.out.println("|     KATEGORI         |");
        System.out.println("+----------------------+");
        System.out.println("| 1. Hewan             |");
        System.out.println("| 2. Makanan           |");
        System.out.println("| 3. Aksesoris         |");
        System.out.println("| 4. Obat              |");
        System.out.println("| 5. Mainan            |");
        System.out.println("+----------------------+");
    }

    public static void setKategori(int choice, StringBuilder kategori) {
        switch (choice) {
            case 1:
                kategori.replace(0, kategori.length(), "Hewan");
                break;
            case 2:
                kategori.replace(0, kategori.length(), "Makanan");
                break;
            case 3:
                kategori.replace(0, kategori.length(), "Aksesoris");
                break;
            case 4:
                kategori.replace(0, kategori.length(), "Obat");
                break;
            case 5:
                kategori.replace(0, kategori.length(), "Mainan");
                break;
            default:
                System.out.println("Pilihan tidak valid");
                break;
        }
    }
}
