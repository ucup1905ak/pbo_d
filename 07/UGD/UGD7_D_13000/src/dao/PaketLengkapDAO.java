
package dao;

import interfaceDAO.IPaketServisDAO;
import java.sql.PreparedStatement;
import model.PaketLengkap;
import model.PaketServis;
/*
* @author Farelino Alexander Kim - 240713000
*/

public class PaketLengkapDAO extends PaketServisDAO implements IPaketServisDAO{
    
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
            System.out.println("Edited " + result+ " Paket RIngan.");

            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Kendaraan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

}
