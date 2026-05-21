/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connection.DbConnection;
import interfaceDAO.IDAO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.PaketServis;
import model.PaketLengkap;
import model.PaketRingan;

/*
* @author Farelino Alexander Kim - 240713000
*/

public abstract class PaketServisDAO implements IDAO<PaketServis, String> {

    protected DbConnection dbCon = new DbConnection();
    protected Connection con = null;

    // DONE
    public void insert(PaketServis paketServis) {
        con = dbCon.makeConnection();

        String sql = "INSERT INTO `paket_servis` (`id_paketservis`,`nama_paketservis`,`jenis_paketservis`,`durasi_pengerjaan`) VALUES ( ?, ?, ?, ?)";
        System.out.println("Adding Paket Servis...");

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, paketServis.getId());
            statement.setString(2, paketServis.getNama());
            statement.setString(3, paketServis.getJenis());
            statement.setInt(4, paketServis.getDurasi());
            int result = statement.executeUpdate();

            System.out.println("Added " + result + " Paket Servis");

            statement.close();
        } catch (Exception e) {
            System.out.println("Error Adding Paket Servis...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        insertNewRole(paketServis);
    }

    @Override // DONE
    public List<PaketServis> showData(String jenis) {
        con = dbCon.makeConnection();

        String sql = "SELECT paket_servis.* , r.layanan_tambahan, l.fasilitas_paket "
                + "FROM paket_servis "
                + "LEFT JOIN paket_ringan r ON paket_servis.id_paketservis = r.id_paketservis "
                + "LEFT JOIN paket_lengkap l ON paket_servis.id_paketservis = l.id_paketservis "
                + "WHERE paket_servis.jenis_paketservis = ?";

        System.out.println("Fetching data...");

        List<PaketServis> list = new ArrayList<>();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, jenis);
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

    @Override//DONE
    public void update(PaketServis paketServis, String id_paketservis) {

        if (cekPerubahanJenis(paketServis.getJenis(), id_paketservis)) {
            insertNewRole(paketServis);
        } else {
            updateRole(paketServis, id_paketservis);
        }

        con = dbCon.makeConnection();

        String sql = "UPDATE `paket_servis` SET "
                + "`durasi_pengerjaan` = ? ,"
                + "`nama_paketservis` = ? ,"
                + "`jenis_paketservis` = ? "
                + "WHERE `id_paketservis` = ? ";

        System.out.println("Updating Paket Servis....");

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, paketServis.getDurasi());
            statement.setString(2, paketServis.getNama());
            statement.setString(3, paketServis.getJenis());
            statement.setString(4, id_paketservis);
            int result = statement.executeUpdate();

            System.out.println("Updated " + result + " Paket Servis : " + id_paketservis);
            statement.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error Updating Paket SErvis...");
            System.out.println(e);
        } finally {
            dbCon.closeConnection();
        }

    }

    @Override //DONE
    public void delete(String id_paketservis) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `paket_servis` WHERE `id_paketservis` = ? ";
        System.out.println("Deleting Paket Servis ...");

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, id_paketservis);
            int result = statement.executeUpdate();

            System.out.println("Deleted " + result + " from Paket Servis");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Kendaraan...");
            System.out.println(e);
        }
        dbCon.closeConnection();

    }

    @Override //DONE
    public PaketServis search(String id_paketservis) {
        con = dbCon.makeConnection();
        String sql = "SELECT "
                + "    ps.id_paketservis, "
                + "    ps.nama_paketservis, "
                + "    ps.jenis_paketservis, "
                + "    ps.durasi_pengerjaan, "
                + "    pl.fasilitas_paket, "
                + "    pr.layanan_tambahan "
                + "FROM paket_servis ps "
                + "LEFT JOIN paket_lengkap pl ON ps.id_paketservis = pl.id_paketservis "
                + "LEFT JOIN paket_ringan pr ON ps.id_paketservis = pr.id_paketservis "
                + "WHERE ps.id_paketservis = ?";
        try {
            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, id_paketservis);
            ResultSet res = s.executeQuery();

            while (res.next()) {
                if (res.getString("jenis_paketservis").equalsIgnoreCase("ringan")) {
                    return new PaketRingan(res);
                } else {
                    return new PaketLengkap(res);
                }
            }
            s.close();
            con.close();
        } catch (Exception e) {
            System.err.println("Search Error");
            System.err.println(e.getMessage());
        } finally {
            dbCon.closeConnection();
        }
        return null;
    }

    //DONE
    public int generateId() {
        con = dbCon.makeConnection();

        String sql = "SELECT MAX(CAST(SUBSTRING(id_paketservis, 4) AS SIGNED)) AS highest_number FROM paket_servis WHERE id_paketservis LIKE 'PS-%';";

        System.out.println("Generating Id...");
        int id = 0;

        try {
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            if (rs != null && rs.next()) {
                if (!rs.wasNull()) {
                    id = rs.getInt("highest_number") + 1;
                }

                rs.close();
                statement.close();
            }
        } catch (Exception e) {
            System.out.println("Error Fetching Data...");
            System.out.println(e);
        }

        dbCon.closeConnection();
        return id;
    }

    //DONE
    public boolean cekPerubahanJenis(String jenis, String id_pakeservis) {
        con = dbCon.makeConnection();

        String sql = "SELECT jenis_paketservis != '"
                + jenis + "' AS result "
                + "FROM `paket_servis` "
                + "WHERE `id_paketservis` = '"
                + id_pakeservis + "';";

//        System.out.println(sql);
        System.out.println("Checking Result...");

        boolean result = false;

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    result = rs.getBoolean("result");
                }
            }
            System.out.println("RESULT CEK PERUBAHAN : " + jenis + " <=>" + result);
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Fetching Data...");
            System.out.println(e);
        }

        dbCon.closeConnection();
        return result;
    }

    public abstract void insertNewRole(PaketServis paketServis);

    public abstract void deleteOldRole(String id);

    public abstract void updateRole(PaketServis paketServis, String id);

}
