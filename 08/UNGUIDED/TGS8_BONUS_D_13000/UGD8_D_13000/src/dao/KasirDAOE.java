/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import interfaceDAO.IShowForDropdown;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.KasirE;

/**
 *
 * @author farel
 */
public class KasirDAOE extends KasirDAO implements IShowForDropdown<KasirE>{

    @Override
    public List<KasirE> IShowForDropdown() {
                con = db.makeConnection();
        String sql = "SELECT  * FROM KASIR";
        List<KasirE> listKasir = new ArrayList<>();
        System.out.println("SQL :");
        System.out.println(sql);
        try {
            System.out.println("Insert into kasir...");
            Statement s = con.createStatement();
            ResultSet res = s.executeQuery(sql);

            if (res != null) {
                while (res.next()) {
                    listKasir.add(new KasirE(
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
    
}
