package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Connection.DbConnection;
import interfaceDAO.IDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
public class PembelianDAO implements IDAO<PembelianKendaraan, String> {
    private DbConnection dbCon = new DbConnection();
    private Connection conn;
    
    @Override
    public void insert(PembelianKendaraan pk) {
        conn = dbCon.makeConnection();
        
        String sql = "INSERT INTO pembelian_kendaraan " 
                + "(id_customer, id_kendaraan, jumlah, tambahan, metode_pembayaran) "
                + "VALUES (?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, pk.getId_customer());
            ps.setString(2, pk.getId_kendaraan());
            ps.setInt(3, pk.getJumlah());
            ps.setString(4, pk.getTambahan());
            ps.setString(5, pk.getMetode_pembayaran());
            
            int result = ps.executeUpdate();
            System.out.println("Added " + result + " Pembelian");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error adding Pembelian...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public List<PembelianKendaraan> showData(String query) {
        conn = dbCon.makeConnection();
        
        String sql = "SELECT "
                + "PK.*, "
                + "C.nama AS nama_customer, C.alamat, C.no_telepon, "
                + "K.nama AS nama_kendaraan, K.jenis, K.id_kendaraan "
                + "FROM pembelian_kendaraan PK "
                + "JOIN customer C ON (PK.id_customer = c.id_customer) "
                + "JOIN kendaraan K ON (PK.id_kendaraan = K.id_kendaraan) "
                + "WHERE (C.nama LIKE ? "
                + "OR K.nama LIKE ? "
                + "OR PK.tambahan LIKE ? "
                + "OR PK.metode_pembayaran LIKE ?)";
        
        System.out.println("Mengambil data Pembelian Kendaraan...");
        List<PembelianKendaraan> listPembelian = new ArrayList<>();
        KendaraanE k = null;
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            String param = "%" + query + "%";
            ps.setString(1, param);
            ps.setString(2, param);
            ps.setString(3, param);
            ps.setString(4, param);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs!= null) {
                while (rs.next()) {
                    CustomerE c = new CustomerE(
                            rs.getInt("id_customer"),
                            rs.getString("nama_customer"),
                            rs.getString("alamat"),
                            rs.getString("no_telepon")
                    );
                    if(rs.getString("jenis").equalsIgnoreCase("Motor")) {
                        k = new MotorE(
                                rs.getString("id_kendaraan"),
                                rs.getString("nama_kendaraan"),
                                rs.getString("jenis"));
                    } else {
                        k = new MobilE(
                                rs.getString("id_kendaraan"),
                                rs.getString("nama_kendaraan"),
                                rs.getString("jenis"));
                    }
                    
                    PembelianKendaraan PK = new PembelianKendaraan(
                            rs.getInt("id_customer"),
                            rs.getInt("jumlah"),
                            rs.getInt("no_resi"),
                            rs.getString("id_kendaraan"),
                            rs.getString("tambahan"),
                            rs.getString("metode_pembayaran"),
                            c,
                            k
                    );
                    listPembelian.add(PK);
                }
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error Fetching data...");
            System.out.println(e);
        } 
        System.out.println("Berhasil");
        dbCon.closeConnection();
        return listPembelian;
    }
    
    @Override
    public void update(PembelianKendaraan pk, String no_resi) {
        conn = dbCon.makeConnection();
        
        String sql = "UPDATE pembelian_kendaraan SET "
                + "id_kendaraan = ?, "
                + "jumlah = ?, "
                + "tambahan = ?, "
                + "metode_pembayaran = ? "
                + "WHERE no_resi = ?";
        
        System.out.println("Editing Pembelian Kendaraan...");
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, pk.getId_kendaraan());
            ps.setInt(2, pk.getJumlah());
            ps.setString(3, pk.getTambahan());
            ps.setString(4, pk.getMetode_pembayaran());
            ps.setInt(5, Integer.parseInt(no_resi));
            
            int result = ps.executeUpdate();
            System.out.println("Edited " + result + " Pembelian " + no_resi);
            ps.close();
        } catch (Exception e) {
            System.out.println("Error Updating Pembelian...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public void delete(String no_resi) {
        conn = dbCon.makeConnection();
        
        String sql = "DELETE FROM pembelian_kendaraan WHERE no_resi = ?";
        
        System.out.println("Deleting Pembelian Kendaraan (NO RESI : "+no_resi+")");
        
        try {
           
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(no_resi));
            
            int result = ps.executeUpdate();
            
            if(result == 0) {
                System.out.println("Data tidak ditemukan!");
            } else {
                System.out.println("Delete " + result + " Pembelian " + no_resi);
            }
            
            ps.close();
        } catch (Exception e) {
            System.out.println("Error Deleting Pembelian...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public PembelianKendaraan search(String data) {
        return null;
    }
}
