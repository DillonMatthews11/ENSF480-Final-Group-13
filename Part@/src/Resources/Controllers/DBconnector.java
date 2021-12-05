package Resources.Controllers;
import java.sql.*;
import java.util.Vector;

public class DBconnector {
    private String url;
    private String user;
    private String password;
    private Connection con;

    public void connectDatabase() throws SQLException{
        try {
            con = DriverManager.getConnection(url, user, password); //!!need this filled in...
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Could not connect to: " + url);
        }
    }
    
    public ResultSet databasePull(String query) throws SQLException {
        try {
            Statement stmt = con.createStatement();
            ResultSet ret = stmt.executeQuery(query);
            return ret;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Could not execute query: " + query);
            return null;
        }
    }

    public boolean databasePush(String query) throws SQLException {
        try {
            Statement stmt = con.createStatement();
            stmt.executeQuery(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}