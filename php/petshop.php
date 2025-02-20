<?php
class PetShop {
    private $id_produk;
    private $nama_produk;
    private $kategori_produk;
    private $harga_produk;
    private $foto_produk;

    public function __construct($id_produk, $nama_produk, $kategori_produk, $harga_produk, $foto_produk) {
        $this->id_produk = $id_produk;
        $this->nama_produk = $nama_produk;
        $this->kategori_produk = $kategori_produk;
        $this->harga_produk = $harga_produk;
        $this->foto_produk = $foto_produk;
    }

    public function get_id_produk() {
        return $this->id_produk;
    }

    public function get_nama_produk() {
        return $this->nama_produk;
    }

    public function get_kategori_produk() {
        return $this->kategori_produk;
    }

    public function get_harga_produk() {
        return $this->harga_produk;
    }

    public function get_foto_produk() {
        return $this->foto_produk;
    }

    public function set_id_produk($id_produk) {
        $this->id_produk = $id_produk;
    }

    public function set_nama_produk($nama_produk) {
        $this->nama_produk = $nama_produk;
    }

    public function set_kategori_produk($kategori_produk) {
        $this->kategori_produk = $kategori_produk;
    }

    public function set_harga_produk($harga_produk) {
        $this->harga_produk = $harga_produk;
    }

    public function set_foto_produk($foto_produk) {
        $this->foto_produk = $foto_produk;
    }

    public function create_produk($id_produk, $nama_produk, $kategori_produk, $harga_produk, $foto_produk) {
        $this->id_produk = $id_produk;
        $this->nama_produk = $nama_produk;
        $this->kategori_produk = $kategori_produk;
        $this->harga_produk = $harga_produk;
        $this->foto_produk = $foto_produk;
    }

    public function read_produk() {
        echo "ID Produk: " . $this->id_produk . "\n";
        echo "Nama Produk: " . $this->nama_produk . "\n";
        echo "Kategori Produk: " . $this->kategori_produk . "\n";
        echo "Harga Produk: " . $this->harga_produk . "\n";
        echo "Foto Produk: " . $this->foto_produk . "\n";
    }

    public function update_produk($id_produk, $nama_produk, $kategori_produk, $harga_produk, $foto_produk) {
        $this->id_produk = $id_produk;
        $this->nama_produk = $nama_produk;
        $this->kategori_produk = $kategori_produk;
        $this->harga_produk = $harga_produk;
        $this->foto_produk = $foto_produk;
    }

    public function delete_produk() {
        $this->id_produk = 0;
        $this->nama_produk = "";
        $this->kategori_produk = "";
        $this->harga_produk = 0;
        $this->foto_produk = "";
    }
}
?>