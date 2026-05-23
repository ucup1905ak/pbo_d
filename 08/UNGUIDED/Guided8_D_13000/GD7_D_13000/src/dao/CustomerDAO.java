package dao;

import Connection.DbConnection;
//import com.mysql.jdbc.Connection;
import interfaceDAO.IDAO;
import model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author farel
 */
public class CustomerDAO implements IDAO<Customer, Integer> {

    protected DbConnection dbCon = new DbConnection();
    protected Connection conn;

    @Override
    public void insert(Customer data) {
        conn = dbCon.makeConnection();
        String sql
                = "INSERT INTO `customer` (`nama`, `alamat`, `no_telepon`) "
                + "VALUES (`" + data.getNama() + "`,`" + data.getAlamat() + "`,`" + data.getNo_telepon() + "`)";

        try {
            System.out.println("Adding Customer...");
            Statement s = conn.createStatement();
            int res = s.executeUpdate(sql);
            System.out.println("Added " + res + " Customer...");
            s.close();
        } catch (SQLException e) {
            System.err.println("Error adding customer...");
            System.err.println(e);
        } finally {
            dbCon.closeConnection();
        }

    }

    @Override
    public List<Customer> showData(Integer data) {
        conn = dbCon.makeConnection();

        String sql = "SELECT * FROM customer";
        List<Customer> c = new ArrayList<>();
        try {
            System.out.println("Fetching Data...");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    c.add(new Customer(rs.getInt("id_customer"),
                            rs.getString("nama"),
                            rs.getNString("alamat"),
                            rs.getNString("no_telepon")));
                }
            }
            rs.close();
            s.close();
        } catch (SQLException e) {
            System.err.println("Error Fetching data...");
            System.err.println(e);
        } finally {
            dbCon.closeConnection();
        }
        return c;
    }

    @Override
    public void update(Customer c, Integer id_customer) {
        conn = dbCon.makeConnection();
        String sql = "UPDATE `customer` SET"
                + "`nama`='" + c.getNama() + "', "
                + "``='" + c.getAlamat() + "', "
                + "``='" + c.getNo_telepon() + "', "
                + "WHERE `id_customer` = '" + id_customer + "'";
        try {
            System.out.println("Updating customer...");
            Statement s = conn.createStatement();
            int res = s.executeUpdate(sql);
            System.out.println("Edited " + res + " Customer " + id_customer);
            s.close();
        } catch (SQLException e) {
            System.err.println("Error __ data....");
            System.err.println(e);
        } finally {
            dbCon.closeConnection();
        }
    }

    @Override
    public void delete(Integer id_customer) {
        conn = dbCon.makeConnection();
        String sql = "DELETE FROM `customer` WHERE `id_customer` = '" + id_customer + "'";
        try {

            System.out.println("Deleting customer...");
            Statement s = conn.createStatement();
            int res = s.executeUpdate(sql);
            System.out.println("Deleted " + res + " Customer " + id_customer);
            s.close();
        } catch (SQLException e) {
            System.err.println("Error __ data....");
            System.err.println(e);
        } finally {
            dbCon.closeConnection();
        }
    }

    @Override
    public Customer search(Integer id_customer) {
        conn = dbCon.makeConnection();
        String sql = "SELECT * FROM `customer` WHERE `id_customer` = '" + id_customer + "'";
        Customer c = null;
        try {
            System.out.println("Searching data...");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    c = new Customer(rs.getInt("id_customer"),
                            rs.getString("nama"),
                            rs.getNString("alamat"),
                            rs.getNString("no_telepon"));
                }
            }
            rs.close();
            s.close();
        } catch (SQLException e) {
            System.err.println("Error fetching data....");
            System.err.println(e);
        } finally {
            dbCon.closeConnection();
        }
        return c;
    }

}
