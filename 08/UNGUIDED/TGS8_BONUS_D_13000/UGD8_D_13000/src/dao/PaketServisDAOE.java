/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PaketLengkapE;
import model.PaketRinganE;
import model.PaketServisE;

/**
 *
 * @author farel
 */
public abstract class PaketServisDAOE extends PaketServisDAO{
    
    public List<PaketServisE> showListAllPaketServis(){
            con = dbCon.makeConnection();

        String sql = "SELECT paket_servis.* , r.layanan_tambahan, l.fasilitas_paket "
                + "FROM paket_servis "
                + "LEFT JOIN paket_ringan r ON paket_servis.id_paketservis = r.id_paketservis "
                + "LEFT JOIN paket_lengkap l ON paket_servis.id_paketservis = l.id_paketservis";

        System.out.println("Fetching data...");

        List<PaketServisE> list = new ArrayList<>();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs != null) {
                while (rs.next()) {

                    if (rs.getString("jenis_paketservis").equalsIgnoreCase("ringan")) {
                        list.add(new PaketRinganE(rs));
                    } else if (rs.getString("jenis_paketservis").equalsIgnoreCase("lengkap")) {
                        list.add(new PaketLengkapE(rs));
                    }
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Fetching Data...");
            System.out.println(e);
        }

        dbCon.closeConnection();
        return list;
    }
    
}
