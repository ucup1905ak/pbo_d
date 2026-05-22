/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import interfaceDAO.IShowForDropdown;
import java.sql.PreparedStatement;
import model.KendaraanE;
import model.MobilE;
import model.MotorE;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
public class KendaraanDAOE extends dao.KendaraanDAO implements IShowForDropdown<KendaraanE>{
    
    @Override
    public List<KendaraanE> IShowForDropdown() {
        conn = dbCon.makeConnection();
        
        String sql = "SELECT kendaraan.*, motor.jumlah_tak, mobil.jenis_mesin FROM kendaraan\n" +
                "LEFT JOIN motor ON kendaraan.id_kendaraan = motor.id_kendaraan\n" + 
                "LEFT JOIN mobil ON kendaraan.id_kendaraan = mobil.id_kendaraan;";
        System.out.println("Fetching data...");
        
        List<KendaraanE> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            KendaraanE k = null;
            
            if(rs != null) {
                while(rs.next()) {
                    if(rs.getString("jenis").equals("Motor")) {
                        k = new MotorE(
                            rs.getInt("jumlah_tak"),
                            rs.getString("id_kendaraan"),
                            rs.getString("nama"),
                            rs.getString("jenis"),
                            rs.getInt("harga")
                        );
                    } else {
                        k = new MobilE(
                            rs.getString("jenis_mesin"),
                            rs.getString("id_kendaraan"),
                            rs.getString("nama"),
                            rs.getString("jenis"),
                            rs.getInt("harga")
                        );
                    }
                    list.add(k);
                }
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
}
