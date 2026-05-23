package model;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
public class MobilE extends model.KendaraanE {

    private String jenis_mesin;

    public MobilE(String jenis_mesin, String nama, String jenis, float harga) {
        super(nama, "Mobil", harga);
        this.jenis_mesin = jenis_mesin;
    }

    public MobilE(String jenis_mesin, String id_kendaraan, String nama, String jenis, float harga) {
        super(id_kendaraan, nama, "Mobil", harga);
        this.jenis_mesin = jenis_mesin;
    }

    public MobilE(String id_kendaraan, String nama, String jenis) {
        super(id_kendaraan, nama, "Mobil");
    }

    public String getJenis_mesin() {
        return jenis_mesin;
    }

    @Override
    public String getSpecial() {
        return jenis_mesin;
    }
}
