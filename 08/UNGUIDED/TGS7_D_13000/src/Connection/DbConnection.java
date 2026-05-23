package Connection;

import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.Connection;

/*
* @author Farelino Alexander Kim - 240713000
*/


public class DbConnection {

    public static Connection CON;
    public static final String URL = "jdbc:mysql://";
    public static final String DBNAME = "object_persistence_d";
    public static final String PATH = "localhost:3306/";

    public static String USERNAME = "root";
    public static String PASSWORD = "";

    public DbConnection() {
        USERNAME = "root";
        PASSWORD = "";
    }

    public DbConnection(String username, String password) {
        USERNAME = username;
        PASSWORD = password;
    }

    public Connection makeConnection() {
        System.out.println("Opening database...");
        try {
            CON = DriverManager.getConnection(URL + PATH + DBNAME, USERNAME, PASSWORD);
            
            System.out.println("");
        } catch (Exception e) {
            System.out.println("Error oppening database");
            System.err.println(e.getMessage());
        }
        return CON;
    }

    public void closeConnection() {
        System.out.println("Clossing database...");
        try {
            CON.close();
            System.out.println("Success...");
        } catch (Exception e) {
            System.out.println("Error clossing database");
            System.err.println(e.getMessage());
        }
    }
}
