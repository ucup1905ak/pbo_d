
package model;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
public class MotorE extends model.KendaraanE {
    private int jumlah_tak;
    
    public MotorE(int jumlah_tak, String nama, String jenis, float harga) {
        super(nama, "Motor", harga);
        this.jumlah_tak = jumlah_tak;
    }
    
    public MotorE(int jumlah_tak, String id_kendaraan, String nama, String jenis, float harga) {
        super(id_kendaraan, nama, jenis, harga);
        this.jumlah_tak = jumlah_tak;
    }
    
    public MotorE(String id_kendaraan, String nama, String jenis) {
        super(id_kendaraan, nama, "Motor");
    }
    
    public int getJumlah_tak() {
        return jumlah_tak;
    }
    
    @Override
    public String getSpecial() {
        return jumlah_tak + "";
    }
}
