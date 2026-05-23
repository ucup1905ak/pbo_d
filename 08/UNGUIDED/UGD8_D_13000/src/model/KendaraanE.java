package model;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
public abstract class KendaraanE extends Kendaraan {

    public KendaraanE(String id_kendaraan, String nama, String jenis, float harga) {
        super(id_kendaraan, nama, jenis, harga);
    }

    public KendaraanE(String nama, String jenis, float harga) {
        super(nama, jenis, harga);
    }

    public KendaraanE(String id_kendaraan, String nama, String jenis) {
        super(id_kendaraan, nama, jenis);
    }

    @Override
    public String toString() {
        return getNama();
    }
}
