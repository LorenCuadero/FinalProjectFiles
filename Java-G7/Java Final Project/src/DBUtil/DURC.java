package DBUtil;

import java.beans.Statement;
import java.sql.*;

public class DURC {

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

//    private void connect() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/sonoo", "root", "root");
////here sonoo is database name, root is username and password  
////Statement stmt=con.createStatement();  
////ResultSet rs=stmt.executeQuery("select * from emp");  
////while(rs.next())  
////System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
}
