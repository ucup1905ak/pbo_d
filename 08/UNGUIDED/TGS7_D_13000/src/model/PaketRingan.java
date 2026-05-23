package model;

import Exception.InputKosongException;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
* @author Farelino Alexander Kim - 240713000
 */
public class PaketRingan extends PaketServis {

    private String layanan_tambahan;

    public PaketRingan(String id, String nama, String jenis, int durasi, String layanan_tambahan) throws InputKosongException {
        super(id, nama, "Ringan", durasi);
        this.layanan_tambahan = layanan_tambahan;
    }

    public PaketRingan(String nama, String jenis, int durasi, String layanan_tambahan)throws InputKosongException  {
        super(nama, "Ringan", durasi);
        this.layanan_tambahan = layanan_tambahan;
    }

    public PaketRingan(ResultSet rs) throws SQLException, InputKosongException {
        super(rs.getString("id_paketservis"),
                rs.getString("nama_paketservis"),
                rs.getString("jenis_paketservis"),
                rs.getInt("durasi_pengerjaan"));
        this.layanan_tambahan = rs.getString("layanan_tambahan");
    }

    public String getLayanan_tambahan() {
        return layanan_tambahan;
    }

    public void setLayanan_tambahan(String layanan_tambahan) {
        this.layanan_tambahan = layanan_tambahan;
    }

    @Override
    public String getSpecial() {
        return layanan_tambahan;
    }

}
