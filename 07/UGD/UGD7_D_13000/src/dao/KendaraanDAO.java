
package dao;

import Connection.DbConnection;
import interfaceDAO.IDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Kendaraan;
import model.Mobil;
import model.Motor;

/*
* @author Farelino Alexander Kim - 240713000
*/


public class KendaraanDAO implements IDAO<Kendaraan, String> {

    protected DbConnection dbCon = new DbConnection();
    protected Connection con;

    //Create
    @Override
    public void insert(Kendaraan K) {
        con = dbCon.makeConnection();

        String sql = "INSERT INTO `kendaraan` (`id_kendaraan`, `nama`, `jenis`, `harga`) "
                + "VALUES ('" + K.getId_kendaraan() + "', '" + K.getNama() + "', '" + K.getJenis() + " ', '"
                + K.getHarga() + "')";

        System.out.println("Adding Kendaraan...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);

            System.out.println("Added " + result + " Kendaraan");

            statement.close();
        } catch (Exception e) {
            System.out.println("Error Adding Kendaraan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    //Read
    @Override
    public List<Kendaraan> showData(String jenis) {
        con = dbCon.makeConnection();

        String sql
                = "SELECT kendaraan.*, motor.jumlah_tak, mobil.jenis_mesin FROM kendaraan\n"
                + "LEFT JOIN motor ON kendaraan.id_kendaraan = motor.id_kendaraan\n"
                + "LEFT JOIN mobil ON kendaraan.id_kendaraan = mobil.id_kendaraan\n"
                + "WHERE kendaraan.jenis = '" + jenis + "';";

        System.out.println("Fetching data...");

        List<Kendaraan> list = new ArrayList<>();
        Kendaraan k = null;

        try {
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    if (rs.getString("jenis").equals("Motor")) {
                        k = new Motor(
                                rs.getInt("jumlah_tak"),
                                rs.getString("id_kendaraan"),
                                rs.getString("nama"),
                                rs.getString("jenis"),
                                rs.getInt("harga"));
                    } else {
                        k = new Mobil(
                                rs.getString("jenis_mesin"),
                                rs.getString("id_kendaraan"),
                                rs.getString("nama"),
                                rs.getString("jenis"),
                                rs.getInt("harga"));
                    }
                    list.add(k);
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

    //Update
    @Override
    public void update(Kendaraan k, String id_kendaraan) {
        con = dbCon.makeConnection();

        String sql = "UPDATE `kendaraan` SET "
                + "`nama` = '" + k.getNama() + "', "
                + "`jenis` = '" + k.getJenis() + "', "
                + "`harga` = '" + k.getHarga() + "' "
                + "WHERE `id_kendaraan` = '" + id_kendaraan + "'";

        System.out.println("Updating Kendaraan....");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);

            System.out.println("Updating " + result + " Kendaraan " + id_kendaraan);

            statement.close();
        } catch (Exception e) {
            System.out.println("Error Updating Kendaraan...");
            System.out.println(e);
        }
    }

    //Delete
    @Override
    public void delete(String id_kendaraan) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `kendaraan` WHERE `id_kendaraan` = '" + id_kendaraan + "'";

        System.out.println("Deleting Kendaraan...");

        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);

            System.out.println("Updating " + result + " Kendaraan " + id_kendaraan);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Kendaraan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    //Search
    @Override
    public Kendaraan search(String id_kendaraan) {
        con = dbCon.makeConnection();

        String sql
                = "SELECT `kendaraan`.*, `motor`.jumlah_tak, `mobil`.jenis_mesin FROM `kendaraan`\n"
                + "LEFT JOIN `motor` ON `kendaraan`.id_kendaraan = `motor`.id_kendaraan\n"
                + "LEFT JOIN `mobil` ON `kendaraan`.id_kendaraan = `mobil`.id_kendaraan\n"
                + "WHERE `kendaraan`.id_kendaraan = '" + id_kendaraan + "';";

        System.out.println("Searching kendaraan...");
        Kendaraan k = null;

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    if (rs.getString("jenis").equals("Motor")) {
                        k = new Motor(
                                rs.getInt("jumlah_tak"),
                                rs.getString("id_kendaraan"),
                                rs.getString("nama"),
                                rs.getString("jenis"),
                                rs.getInt("harga"));
                    } else {
                        k = new Mobil(
                                rs.getString("jenis_mesin"),
                                rs.getString("id_kendaraan"),
                                rs.getString("nama"),
                                rs.getString("jenis"),
                                rs.getInt("harga"));
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
        return k;
    }
//Generate ID

    public int generateId() {
        con = dbCon.makeConnection();

        String sql = "SELECT MAX(CAST(SUBSTRING(id_kendaraan, 2) AS SIGNED)) AS highest_number FROM kendaraan WHERE id_kendaraan LIKE 'K%';";

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

    //Cek Perubahan Jenis
    public boolean cekPerubahanJenis(String jenis, String id_kendaraan) {
        con = dbCon.makeConnection();

        String sql = "SELECT jenis!= '"
                + jenis + "' AS result "
                + "FROM `kendaraan` "
                + "WHERE `id_kendaraan` = '"
                + id_kendaraan + "';";

        System.out.println(sql);
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

            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Fetching Data...");
            System.out.println(e);
        }

        dbCon.closeConnection();
        return result;
    }
}
