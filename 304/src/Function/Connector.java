package Function;
import java.sql.*;
public class Connector {
    //private static 
    public static Connection getConnection() {
    	Connection con=null;
        if (con == null) {
            try {
            	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());                
                 con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:ug","ora_b8m1b","a99036162");                
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Register failed");
            }
        }
        return con;
    }
}