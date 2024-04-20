import java.sql.*;
import java.util.Scanner;

public class CreateDatabase {

    //database path, root, and password
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "0000";
    

    //creates a connection, and performs operations on the databased based on string input 
    public static void createDB()
    {
        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS); 
        Statement s = c.createStatement();)
        {
            String sql = "CREATE DATABASE data";
            s.executeUpdate(sql);
            sql = "USE data";
            s.executeUpdate(sql);
            sql = "CREATE TABLE login (uid VARCHAR(50) PRIMARY KEY not null, pass VARCHAR(100))";
            s.executeUpdate(sql);
            sql = "INSERT INTO login " + "VALUES('hxm220056', 'lola')"; 
            s.executeUpdate(sql);
            sql = "INSERT INTO login " + "VALUES('axp200003', 'show')"; 
            s.executeUpdate(sql);
            sql = "INSERT INTO login " + "VALUES('zoo230000', 'feather')"; 
            s.executeUpdate(sql);
            sql = "INSERT INTO login " + "VALUES('dtz200000', 'flew')"; 
            s.executeUpdate(sql);
            sql = "INSERT INTO login " + "VALUES('utd123456', 'CorrectPassword')";
            s.executeUpdate(sql);
            s.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }
}
