package model;

/**
 *
 * @author Farelino Alexander Kim / 240713000
 */
public class Motor extends Kendaraan {

    private int jumlah_tak;

    public Motor(int jumlah_tak, String nama, String jenis, float harga) {
        super(nama, "Motor", harga);
        this.jumlah_tak = jumlah_tak;
    }

    public Motor(int jumlah_tak, String id_kendaraan, String nama, String jenis,float harga) {
        super(id_kendaraan, nama, "Motor", harga);
        this.jumlah_tak = jumlah_tak;
    }

    public int getJumlah_tak() {
        return jumlah_tak;
    }

    @Override
    public String getSpecial() {
        return jumlah_tak + "";
    }

    @Override
    public String getString() {
        return super.getString() + " | " + jumlah_tak;
    }

}
