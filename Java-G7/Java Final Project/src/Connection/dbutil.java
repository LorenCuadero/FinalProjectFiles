package Connection;

import java.beans.Statement;
import java.sql.*;

public class dbutil{
    // create a function to connect with mysql database
    public static Connection getConnection() {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bookingsystem", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return con;
    }

}