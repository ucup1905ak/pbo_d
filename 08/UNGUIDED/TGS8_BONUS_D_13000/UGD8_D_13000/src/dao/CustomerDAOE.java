package dao;
import java.sql.PreparedStatement;
import model.CustomerE;
import interfaceDAO.IShowForDropdown;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
public class CustomerDAOE extends dao.CustomerDAO implements IShowForDropdown<CustomerE>{
    
    @Override
    public List<CustomerE> IShowForDropdown() {
        conn = dbCon.makeConnection();
        
        String sql = "SELECT * FROM customer";
        System.out.println("Fetching Data...");
        List<CustomerE> c = new ArrayList<>();
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            
            if(rs != null) {
                while(rs.next()) {
                    c.add(new CustomerE(
                            rs.getInt("id_customer"),
                            rs.getString("nama"),
                            rs.getString("alamat"),
                            rs.getString("no_telepon")));
                }
            }
            
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return c;
    }
}
