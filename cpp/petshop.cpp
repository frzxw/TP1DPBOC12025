// library yang digunakan
#include <iostream>
#include <string>
#include <vector>

using namespace std;

// kelas petshop yang merupakan kelas utama
class PetShop
{
public:
    // kelas produk yang merupakan kelas abstrak
    class Produk
    {
        // protected agar dapat diakses oleh kelas turunannya
    protected:
        int id;
        string nama;
        string kategori;
        int harga;
        // public agar dapat diakses oleh kelas turunannya
    public:
        // konstruktor untuk kelas produk
        Produk()
        {
            this->id = 0;
            this->nama = "";
            this->kategori = "";
            this->harga = 0;
        }

        Produk(int id, string nama, string kategori, int harga)
        {
            this->id = id;
            this->nama = nama;
            this->kategori = kategori;
            this->harga = harga;
        }

        // getter dan setter untuk setiap atribut
        int get_id() { return id; }
        string get_nama() { return nama; }
        string get_kategori() { return kategori; }
        int get_harga() { return harga; }

        void set_id(int id) { this->id = id; }
        void set_nama(string nama) { this->nama = nama; }
        void set_kategori(string kategori) { this->kategori = kategori; }
        void set_harga(int harga) { this->harga = harga; }

        // metode display untuk menampilkan informasi produk
        virtual void display()
        {
            cout << "ID: " << id << endl;
            cout << "Nama: " << nama << endl;
            cout << "Kategori: " << kategori << endl;
            cout << "Harga: " << harga << endl;
        }

        // destruktor untuk kelas produk
        virtual ~Produk() {};
    };

    // kelas hewan yang merupakan turunan dari kelas produk
    class Hewan : public Produk
    {
        // private agar tidak dapat diakses oleh kelas lain
    private:
        int umur;
        bool status_vaksin;
        string jenis;
        string ras;
        string warna;
        // public agar dapat diakses oleh kelas lain
    public:
        // konstruktor untuk kelas hewan
        Hewan()
        {
            this->umur = 0;
            this->status_vaksin = false;
            this->jenis = "";
            this->ras = "";
            this->warna = "";
        }

        Hewan(int id, string nama, string kategori, int harga, int umur, bool status_vaksin, string jenis, string ras, string warna)
            : Produk(id, nama, kategori, harga), umur(umur), status_vaksin(status_vaksin), jenis(jenis), ras(ras), warna(warna) {}

        // getter dan setter untuk setiap atribut
        int get_umur() { return umur; }
        bool get_status_vaksin() { return status_vaksin; }
        string get_jenis() { return jenis; }
        string get_ras() { return ras; }
        string get_warna() { return warna; }

        void set_umur(int umur) { this->umur = umur; }
        void set_status_vaksin(bool status_vaksin) { this->status_vaksin = status_vaksin; }
        void set_jenis(string jenis) { this->jenis = jenis; }
        void set_ras(string ras) { this->ras = ras; }
        void set_warna(string warna) { this->warna = warna; }

        // metode display untuk menampilkan informasi hewan
        void display()
        {
            Produk::display();
            cout << "Umur: " << umur << endl;
            cout << "Status Vaksin: " << (status_vaksin ? "Sudah" : "Belum") << endl;
            cout << "Jenis: " << jenis << endl;
            cout << "Ras: " << ras << endl;
            cout << "Warna: " << warna << endl;
        }

        // destruktor untuk kelas hewan
        ~Hewan() {};
    };

    // kelas makanan yang merupakan turunan dari kelas produk
    class Makanan : public Produk
    {
        // private agar tidak dapat diakses oleh kelas lain
    private:
        int berat;
        string jenis;
        string tanggal_kadaluarsa;

        // public agar dapat diakses oleh kelas lain
    public:
        // konstruktor untuk kelas makanan
        Makanan()
        {
            this->berat = 0;
            this->jenis = "";
            this->tanggal_kadaluarsa = "";
        }

        Makanan(int id, string nama, string kategori, int harga, int berat, string jenis, string tanggal_kadaluarsa)
            : Produk(id, nama, kategori, harga), berat(berat), jenis(jenis), tanggal_kadaluarsa(tanggal_kadaluarsa) {}

        // getter dan setter untuk setiap atribut
        int get_berat() { return berat; }
        string get_jenis() { return jenis; }
        string get_tanggal_kadaluarsa() { return tanggal_kadaluarsa; }

        void set_berat(int berat) { this->berat = berat; }
        void set_jenis(string jenis) { this->jenis = jenis; }
        void set_tanggal_kadaluarsa(string tanggal_kadaluarsa) { this->tanggal_kadaluarsa = tanggal_kadaluarsa; }

        // metode display untuk menampilkan informasi makanans
        void display()
        {
            Produk::display();
            cout << "Berat: " << berat << endl;
            cout << "Jenis: " << jenis << endl;
            cout << "Tanggal Kadaluarsa: " << tanggal_kadaluarsa << endl;
        }

        // destruktor untuk kelas makanan
        ~Makanan() {};
    };

    // kelas aksesoris yang merupakan turunan dari kelas produk
    class Aksesoris : public Produk
    {
        // private agar tidak dapat diakses oleh kelas lain
    private:
        string bahan;
        string jenis;
        string warna;

        // public agar dapat diakses oleh kelas lain
    public:
        // konstruktor untuk kelas aksesoris
        Aksesoris()
        {
            this->bahan = "";
            this->jenis = "";
            this->warna = "";
        }

        Aksesoris(int id, string nama, string kategori, int harga, string bahan, string jenis, string warna)
            : Produk(id, nama, kategori, harga), bahan(bahan), jenis(jenis), warna(warna) {}

        // getter dan setter untuk setiap atribut
        string get_bahan() { return bahan; }
        string get_jenis() { return jenis; }
        string get_warna() { return warna; }

        void set_bahan(string bahan) { this->bahan = bahan; }
        void set_jenis(string jenis) { this->jenis = jenis; }
        void set_warna(string warna) { this->warna = warna; }

        // metode display untuk menampilkan informasi aksesoris
        void display()
        {
            Produk::display();
            cout << "Bahan: " << bahan << endl;
            cout << "Jenis: " << jenis << endl;
            cout << "Warna: " << warna << endl;
        }

        // destruktor untuk kelas aksesoris
        ~Aksesoris() {};
    };

    // kelas obat yang merupakan turunan dari kelas produk
    class Obat : public Produk
    {
        // private agar tidak dapat diakses oleh kelas lain
    private:
        string dosis;
        string jenis;
        string tanggal_kadaluarsa;

        // public agar dapat diakses oleh kelas lain
    public:
        // konstruktor untuk kelas obat
        Obat()
        {
            this->dosis = "";
            this->jenis = "";
            this->tanggal_kadaluarsa = "";
        }

        Obat(int id, string nama, string kategori, int harga, string dosis, string jenis, string tanggal_kadaluarsa)
            : Produk(id, nama, kategori, harga), dosis(dosis), jenis(jenis), tanggal_kadaluarsa(tanggal_kadaluarsa) {}

        // getter dan setter untuk setiap atribut
        string get_dosis() { return dosis; }
        string get_jenis() { return jenis; }
        string get_tanggal_kadaluarsa() { return tanggal_kadaluarsa; }

        void set_dosis(string dosis) { this->dosis = dosis; }
        void set_jenis(string jenis) { this->jenis = jenis; }
        void set_tanggal_kadaluarsa(string tanggal_kadaluarsa) { this->tanggal_kadaluarsa = tanggal_kadaluarsa; }

        // metode display untuk menampilkan informasi obat
        void display()
        {
            Produk::display();
            cout << "Dosis: " << dosis << endl;
            cout << "Jenis: " << jenis << endl;
            cout << "Tanggal Kadaluarsa: " << tanggal_kadaluarsa << endl;
        }

        // destruktor untuk kelas obat
        ~Obat() {};
    };

    // kelas mainan yang merupakan turunan dari kelas produk
    class Mainan : public Produk
    {
        // private agar tidak dapat diakses oleh kelas lain
    private:
        string bahan;
        string jenis;
        string warna;

        // public agar dapat diakses oleh kelas lain
    public:
        // konstruktor untuk kelas mainan
        Mainan()
        {
            this->bahan = "";
            this->jenis = "";
            this->warna = "";
        }

        Mainan(int id, string nama, string kategori, int harga, string bahan, string jenis, string warna)
            : Produk(id, nama, kategori, harga), bahan(bahan), jenis(jenis), warna(warna) {}

        // getter dan setter untuk setiap atribut
        string get_bahan() { return bahan; }
        string get_jenis() { return jenis; }
        string get_warna() { return warna; }

        void set_bahan(string bahan) { this->bahan = bahan; }
        void set_jenis(string jenis) { this->jenis = jenis; }
        void set_warna(string warna) { this->warna = warna; }

        // metode display untuk menampilkan informasi mainan
        void display()
        {
            Produk::display();
            cout << "Bahan: " << bahan << endl;
            cout << "Jenis: " << jenis << endl;
            cout << "Warna: " << warna << endl;
        }

        // destruktor untuk kelas mainan
        ~Mainan() {};
    };

private:
    vector<Produk *> list_produk;

public:
    PetShop()
    {
        list_produk.clear();
    }

    void create_produk(Produk *produk)
    {
        list_produk.push_back(produk);
        cout << "Produk berhasil ditambahkan!" << endl;
    }

    void read_produk()
    {
        for (int i = 0; i < list_produk.size(); i++)
        {
            cout << "------------------------" << endl;
            list_produk[i]->display();
            cout << "------------------------" << endl;
        }
    }

    void update_produk(int id, Produk *produk)
    {
        int i = 0, found = 0;
        while (i < list_produk.size() && found == 0)
        {
            if (list_produk[i]->get_id() == id)
            {
                list_produk[i] = produk;
                found = 1;
                cout << "Produk berhasil diubah!" << endl;
            }
            i++;
        }
        if (found == 0)
        {
            cout << "Produk tidak ditemukan!" << endl;
        }
    }

    void delete_produk(int id)
    {
        int i = 0, found = 0;
        while (i < list_produk.size() && found == 0)
        {
            if (list_produk[i]->get_id() == id)
            {
                list_produk.erase(list_produk.begin() + i);
                found = 1;
                cout << "Produk berhasil dihapus!" << endl;
            }
            i++;
        }
        if (found == 0)
        {
            cout << "Produk tidak ditemukan!" << endl;
        }
    }

    Produk *find_produk(int id)
    {
        int i = 0, found = 0;
        while (i < list_produk.size() && found == 0)
        {
            if (list_produk[i]->get_id() == id)
            {
                return list_produk[i];
            }
            i++;
        }
        return NULL;
    }
};

void show_menu()
{
    cout << "+----------------------+" << endl;
    cout << "|       MENU           |" << endl;
    cout << "+----------------------+" << endl;
    cout << "| 1. Tambah Produk     |" << endl;
    cout << "| 2. Tampilkan Produk  |" << endl;
    cout << "| 3. Cari Produk       |" << endl;
    cout << "| 4. Ubah Produk       |" << endl;
    cout << "| 5. Hapus Produk      |" << endl;
    cout << "| 6. Keluar            |" << endl;
    cout << "+----------------------+" << endl;
}

void show_kategori()
{
    cout << "+----------------------+" << endl;
    cout << "|     KATEGORI         |" << endl;
    cout << "+----------------------+" << endl;
    cout << "| 1. Hewan             |" << endl;
    cout << "| 2. Makanan           |" << endl;
    cout << "| 3. Aksesoris         |" << endl;
    cout << "| 4. Obat              |" << endl;
    cout << "| 5. Mainan            |" << endl;
    cout << "+----------------------+" << endl;
}

void set_kategori(int choice, string &kategori)
{
    switch (choice)
    {
    case 1:
        kategori = "Hewan";
        break;
    case 2:
        kategori = "Makanan";
        break;
    case 3:
        kategori = "Aksesoris";
        break;
    case 4:
        kategori = "Obat";
        break;
    case 5:
        kategori = "Mainan";
        break;
    default:
        cout << "Pilihan tidak valid" << endl;
        break;
    }
}