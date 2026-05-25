/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PaketLengkap;
import model.PaketRingan;
import model.PaketServis;

/**
 *
 * @author farel
 */
public class PaketLengkapDAOE extends PaketServisDAOE {

    public List<PaketServis> showAllPaketRIngan() {
        con = dbCon.makeConnection();

        String sql = "SELECT paket_servis.* , r.layanan_tambahan, l.fasilitas_paket "
                + "FROM paket_servis "
                + "LEFT JOIN paket_ringan r ON paket_servis.id_paketservis = r.id_paketservis "
                + "LEFT JOIN paket_lengkap l ON paket_servis.id_paketservis = l.id_paketservis "
                + "WHERE paket_servis.jenis_paketservis = 'ringan'";

        System.out.println("Fetching data...");

        List<PaketServis> list = new ArrayList<>();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
//            statement.setString(1, jenis);
            ResultSet rs = statement.executeQuery();

            if (rs != null) {
                while (rs.next()) {

                    if (rs.getString("jenis_paketservis").equalsIgnoreCase("ringan")) {
                        list.add(new PaketRingan(rs));
                    } else if (rs.getString("jenis_paketservis").equalsIgnoreCase("lengkap")) {
                        list.add(new PaketLengkap(rs));
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

    public void insertNewRole(PaketServis paketServis) {

        con = dbCon.makeConnection();

        String sql = "INSERT INTO `paket_lengkap` (`id_paketservis`, `fasilitas_paket`) VALUES (? , ?)";

        System.out.println("Adding Paket Ringan...");

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, paketServis.getId());
            statement.setString(2, paketServis.getSpecial());
            int result = statement.executeUpdate();

            System.out.println("Added " + result + " into paket lengkap");
        } catch (Exception e) {
            System.out.println("Error Adding paket ringan... ");
            System.out.println(e);
        }

        dbCon.closeConnection();

    }

    public void deleteOldRole(String id) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `paket_lengkap` WHERE `id_paketservis` = ?";
        System.out.println("Deleting paket ringan...");

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, id);
            int result = statement.executeUpdate();
            System.out.println("deleted " + result + " From Paket Ringan ");

            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Paket Ringan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    public void updateRole(PaketServis paketServis, String id) {

        con = dbCon.makeConnection();

        String sql = "UPDATE `paket_lengkap` SET `fasilitas_paket` = ? WHERE `id_paketservis` = ?";

        System.out.println("Edit Paket Servis ...");

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, paketServis.getSpecial());
            statement.setString(2, id);
            int result = statement.executeUpdate();
            System.out.println("Edited " + result + " Paket RIngan.");

            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Kendaraan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

}
