/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Exception.InputKosongException;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
* @author Farelino Alexander Kim - 240713000
 */
public class PaketLengkapE extends PaketServisE {

    private String fasilitas_paket;

    public PaketLengkapE(String id, String nama, String jenis, int durasi, String fasilitas_paket) throws InputKosongException {
        super(id, nama, "Lengkap", durasi);
        this.fasilitas_paket = fasilitas_paket;
    }

    public PaketLengkapE(String nama, String jenis, int durasi, String fasilitas_paket) throws InputKosongException {
        super(nama, "Lengkap", durasi);
        this.fasilitas_paket = fasilitas_paket;
    }

    public PaketLengkapE(ResultSet rs) throws SQLException, InputKosongException {
        super(rs.getString("id_paketservis"),
                rs.getString("nama_paketservis"),
                rs.getString("jenis_paketservis"),
                rs.getInt("durasi_pengerjaan"));
        this.fasilitas_paket = rs.getString("fasilitas_paket");
    }

    public String getFasilitas_paket() {
        return fasilitas_paket;
    }

    public void setFasilitas_paket(String fasilitas_paket) {
        this.fasilitas_paket = fasilitas_paket;
    }

    @Override
    public String getSpecial() {
        return fasilitas_paket;
    }

}
