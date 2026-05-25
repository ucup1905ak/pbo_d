/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connection.DbConnection;
import java.sql.*;
import interfaceDAO.IDAO;
import java.util.ArrayList;
import java.util.List;
import model.Kasir;

/*
* @author Farelino Alexander Kim - 240713000
 */
public class KasirDAO implements IDAO<Kasir, Integer> {

    protected DbConnection db = new DbConnection();
    protected Connection con;

    @Override
    public void insert(Kasir k) {
        con = db.makeConnection();
        String sql = "insert into `kasir`(`nama_kasir`, `shift`, `nomor_loket`) values('"
                + k.getNama_kasir() + "', '"
                + k.getShift() + "', '"
                + k.getNomor_loket()
                + "')";
        System.out.println("SQL :");
        System.out.println(sql);
        try {
            System.out.println("Insert into kasir...");
            Statement s = con.createStatement();
            int res = s.executeUpdate(sql);
            System.out.printf("Inserted %d into kasir.\n", res);
            s.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Error executing SQL...");
            System.err.println(e);
        }
        db.closeConnection();
    }

    @Override
    public List<Kasir> showData(Integer data) {
        con = db.makeConnection();
        String sql = "SELECT  * FROM KASIR";
        List<Kasir> listKasir = new ArrayList<>();
        System.out.println("SQL :");
        System.out.println(sql);
        try {
            System.out.println("Insert into kasir...");
            Statement s = con.createStatement();
            ResultSet res = s.executeQuery(sql);

            if (res != null) {
                while (res.next()) {
                    listKasir.add(new Kasir(
                            res.getInt("id_kasir"),
                            res.getString("nama_kasir"),
                            res.getString("shift"),
                            res.getInt("nomor_loket")
                    ));
                }
            }

            s.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Error executing SQL...");
            System.err.println(e);
        } finally {
            db.closeConnection();
            return listKasir;
        }
    }

    @Override
    public void update(Kasir k, Integer id_kasir) {
        con = db.makeConnection();
        String sql = "update `kasir` set"
                + " `nama_kasir` = '" + k.getNama_kasir() + "'"
                + " , `shift` = '" + k.getShift()+ "'"
                + " , `nomor_loket` = '" + k.getNomor_loket()+ "'"
                + " where `id_kasir` = '" + id_kasir+ "'";
        System.out.println("SQL :");
        System.out.println(sql);
        try {
            System.out.println("Update data kasir...");
            Statement s = con.createStatement();
            int res = s.executeUpdate(sql);
            System.out.printf("Update %d data kasir.\n", res);
            s.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Error executing SQL...");
            System.err.println(e);
        }
        db.closeConnection();
    }

    @Override
    public void delete(Integer id_kasir) {
        con = db.makeConnection();
        String sql = "delete from `kasir` where  `id_kasir` = " + id_kasir + "";
        System.out.println("SQL :");
        System.out.println(sql);
        try {
            System.out.println("Delete data kasir...");
            Statement s = con.createStatement();
            int res = s.executeUpdate(sql);
            System.out.printf("Deleted %d data kasir.\n", res);
            s.close();
            con.close();
        } catch (SQLException e) {
            System.err.println("Error executing SQL...");
            System.err.println(e);
        }
        db.closeConnection();
    }

    @Override
    public Kasir search(Integer id_kasir) {
        con = db.makeConnection();
        String sql = "SELECT * FROM `kasir` where id_kasir = '" + id_kasir + "'";
        Kasir k = null;
        System.out.println("SQL :");
        System.out.println(sql);
        try {
            System.out.println("Search from kasir...");
            Statement s = con.createStatement();
            ResultSet res = s.executeQuery(sql);
            if (res != null) {
                while (res.next()) {
                    k = new Kasir(
                            res.getInt("id_kasir"),
                            res.getString("nama_kasir"),
                            res.getString("shift"),
                            res.getInt("nomor_loket")
                    );
                }
            }
            s.close();
            con.close();
            return k;
        } catch (SQLException e) {
            System.err.println("Error executing SQL...");
            System.err.println(e);
        } finally {
            db.closeConnection();
        }
        return k;
    }

}
