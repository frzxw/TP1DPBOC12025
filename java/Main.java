package TP1DPBOC12025.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PetShop shop = new PetShop();
        Scanner scanner = new Scanner(System.in);
        int choice, id, harga, umur, berat;
        String nama, kategori, jenis, ras, warna, tanggalKadaluarsa, dosis, bahan;
        boolean statusVaksin;

        StringBuilder kategoriBuilder = new StringBuilder();
        while (true) {
            PetShop.showMenu();
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Tambah Produk");
                    PetShop.showKategori();
                    System.out.print("Pilih kategori produk: ");
                    choice = scanner.nextInt();

                    kategoriBuilder.setLength(0);
                    PetShop.setKategori(choice, kategoriBuilder);
                    kategori = kategoriBuilder.toString();

                    System.out.print("ID: ");
                    id = scanner.nextInt();

                    if (shop.findProduk(id) != null) {
                        System.out.println("ID sudah ada. Silakan masukkan ID yang berbeda.");
                        break;
                    }

                    System.out.print("Nama: ");
                    nama = scanner.next();
                    System.out.print("Harga (Rp): ");
                    harga = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.print("Umur (bulan): ");
                            umur = scanner.nextInt();
                            System.out.print("Status Vaksin (1: Sudah, 0: Belum): ");
                            statusVaksin = scanner.nextInt() == 1;
                            System.out.print("Jenis: ");
                            jenis = scanner.next();
                            System.out.print("Ras: ");
                            ras = scanner.next();
                            System.out.print("Warna: ");
                            warna = scanner.next();
                            shop.createProduk(
                                    shop.new Hewan(id, nama, kategori, harga, umur, statusVaksin, jenis, ras, warna));
                            break;

                        case 2:
                            System.out.print("Berat: ");
                            berat = scanner.nextInt();
                            System.out.print("Jenis: ");
                            jenis = scanner.next();
                            System.out.print("Tanggal Kadaluarsa: ");
                            tanggalKadaluarsa = scanner.next();
                            shop.createProduk(
                                    shop.new Makanan(id, nama, kategori, harga, berat, jenis, tanggalKadaluarsa));
                            break;

                        case 3:
                            System.out.print("Bahan: ");
                            bahan = scanner.next();
                            System.out.print("Jenis: ");
                            jenis = scanner.next();
                            System.out.print("Warna: ");
                            warna = scanner.next();
                            shop.createProduk(shop.new Aksesoris(id, nama, kategori, harga, bahan, jenis, warna));
                            break;

                        case 4:
                            System.out.print("Dosis: ");
                            dosis = scanner.next();
                            System.out.print("Jenis: ");
                            jenis = scanner.next();
                            System.out.print("Tanggal Kadaluarsa: ");
                            tanggalKadaluarsa = scanner.next();
                            shop.createProduk(
                                    shop.new Obat(id, nama, kategori, harga, dosis, jenis, tanggalKadaluarsa));
                            break;

                        case 5:
                            System.out.print("Bahan: ");
                            bahan = scanner.next();
                            System.out.print("Jenis: ");
                            jenis = scanner.next();
                            System.out.print("Warna: ");
                            warna = scanner.next();
                            shop.createProduk(shop.new Mainan(id, nama, kategori, harga, bahan, jenis, warna));
                            break;

                        default:
                            System.out.println("Pilihan tidak valid");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("Tampilkan Produk");
                    shop.readProduk();
                    break;

                case 3:
                    System.out.println("Cari Produk");
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    PetShop.Produk produk = shop.findProduk(id);
                    if (produk != null) {
                        System.out.println("Produk ditemukan");
                        produk.display();
                    } else {
                        System.out.println("Produk tidak ditemukan");
                    }
                    break;

                case 4:
                    System.out.println("Ubah Produk");
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    produk = shop.findProduk(id);
                    if (produk != null) {
                        PetShop.showKategori();
                        System.out.print("Pilih kategori produk: ");
                        choice = scanner.nextInt();

                        PetShop.setKategori(choice, kategoriBuilder);
                        kategori = kategoriBuilder.toString();

                        System.out.print("Nama: ");
                        nama = scanner.next();
                        System.out.print("Harga (Rp): ");
                        harga = scanner.nextInt();

                        switch (choice) {
                            case 1:
                                System.out.print("Umur (bulan): ");
                                umur = scanner.nextInt();
                                System.out.print("Status Vaksin (1: Sudah, 0: Belum): ");
                                statusVaksin = scanner.nextInt() == 1;
                                System.out.print("Jenis: ");
                                jenis = scanner.next();
                                System.out.print("Ras: ");
                                ras = scanner.next();
                                System.out.print("Warna: ");
                                warna = scanner.next();
                                shop.updateProduk(id, shop.new Hewan(id, nama, kategori, harga, umur, statusVaksin,
                                        jenis, ras, warna));
                                break;

                            case 2:
                                System.out.print("Berat: ");
                                berat = scanner.nextInt();
                                System.out.print("Jenis: ");
                                jenis = scanner.next();
                                System.out.print("Tanggal Kadaluarsa: ");
                                tanggalKadaluarsa = scanner.next();
                                shop.updateProduk(id,
                                        shop.new Makanan(id, nama, kategori, harga, berat, jenis, tanggalKadaluarsa));
                                break;

                            case 3:
                                System.out.print("Bahan: ");
                                bahan = scanner.next();
                                System.out.print("Jenis: ");
                                jenis = scanner.next();
                                System.out.print("Warna: ");
                                warna = scanner.next();
                                shop.updateProduk(id,
                                        shop.new Aksesoris(id, nama, kategori, harga, bahan, jenis, warna));
                                break;

                            case 4:
                                System.out.print("Dosis: ");
                                dosis = scanner.next();
                                System.out.print("Jenis: ");
                                jenis = scanner.next();
                                System.out.print("Tanggal Kadaluarsa: ");
                                tanggalKadaluarsa = scanner.next();
                                shop.updateProduk(id,
                                        shop.new Obat(id, nama, kategori, harga, dosis, jenis, tanggalKadaluarsa));
                                break;

                            case 5:
                                System.out.print("Bahan: ");
                                bahan = scanner.next();
                                System.out.print("Jenis: ");
                                jenis = scanner.next();
                                System.out.print("Warna: ");
                                warna = scanner.next();
                                shop.updateProduk(id, shop.new Mainan(id, nama, kategori, harga, bahan, jenis, warna));
                                break;

                            default:
                                System.out.println("Pilihan tidak valid");
                                break;
                        }
                    } else {
                        System.out.println("Produk tidak ditemukan");
                    }
                    break;

                case 5:
                    System.out.println("Hapus Produk");
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    shop.deleteProduk(id);
                    break;

                case 6:
                    System.out.println("Keluar");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        }
    }
}