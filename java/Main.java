import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

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

    public static String setKategori(int choice) {
        switch (choice) {
            case 1:
                return "Hewan";
            case 2:
                return "Makanan";
            case 3:
                return "Aksesoris";
            case 4:
                return "Obat";
            case 5:
                return "Mainan";
            default:
                System.out.println("Pilihan tidak valid");
                return "";
        }
    }

    public static void main(String[] args) {
        ArrayList<PetShop> shop = new ArrayList<>();
        boolean running = true;

        while (running) {
            showMenu();
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Tambah Produk");
                    showKategori();
                    System.out.print("Pilih kategori produk: ");
                    int kategoriChoice = scanner.nextInt();
                    String kategori = setKategori(kategoriChoice);

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    boolean idExists = false;
                    for (PetShop produk : shop) {
                        if (produk.getIdProduk() == id) {
                            idExists = true;
                            break;
                        }
                    }
                    if (idExists) {
                        System.out.println("ID sudah ada. Silakan masukkan ID yang berbeda.");
                        continue;
                    }

                    scanner.nextLine();
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Harga (Rp): ");
                    int harga = scanner.nextInt();

                    PetShop produk = new PetShop(id, nama, kategori, harga);
                    shop.add(produk);
                    break;

                case 2:
                    System.out.println("Tampilkan Produk");
                    for (PetShop p : shop) {
                        p.readProduk();
                    }
                    break;

                case 3:
                    System.out.println("Cari Produk");
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    boolean found = false;
                    for (PetShop p : shop) {
                        if (p.getIdProduk() == id) {
                            System.out.println("Produk ditemukan");
                            p.readProduk();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Produk tidak ditemukan");
                    }
                    break;

                case 4:
                    System.out.println("Ubah Produk");
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    for (PetShop p : shop) {
                        if (p.getIdProduk() == id) {
                            showKategori();
                            System.out.print("Pilih kategori produk: ");
                            kategoriChoice = scanner.nextInt();
                            kategori = setKategori(kategoriChoice);

                            scanner.nextLine();
                            System.out.print("Nama: ");
                            nama = scanner.nextLine();
                            System.out.print("Harga (Rp): ");
                            harga = scanner.nextInt();

                            p.updateProduk(id, nama, kategori, harga);
                            break;
                        }
                    }
                    System.out.println("Produk tidak ditemukan");
                    break;

                case 5:
                    System.out.println("Hapus Produk");
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    PetShop toRemove = null;
                    for (PetShop p : shop) {
                        if (p.getIdProduk() == id) {
                            toRemove = p;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        shop.remove(toRemove);
                        System.out.println("Produk berhasil dihapus!");
                    } else {
                        System.out.println("Produk tidak ditemukan");
                    }
                    break;

                case 6:
                    System.out.println("Keluar");
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        }
    }
}