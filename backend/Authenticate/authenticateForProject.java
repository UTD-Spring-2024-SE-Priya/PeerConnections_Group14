/*
This purposely create a database, table, and populated it with predefined data for running the project

*/


import java.sql.*;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class authenticateForProject {
    //database path, root, and password
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "0000";
    static final String db = "sespring2024project";
    static final String table = "login";
    
    

    //creates a connection, and performs operations on the databased based on string input 
    public static void createDB()
    {
        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS); 
        Statement s = c.createStatement();)
        {
            String sql = "CREATE DATABASE " + db;
            s.executeUpdate(sql);
            sql = "USE " + db;
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
    //creates tables in a specified database 
    public static void createTable()
    {
        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS); 
        Statement s = c.createStatement();)
        {
            String sql = "USE " + db;
            s.executeUpdate(sql);
            sql = "CREATE TABLE " + table + " (uid VARCHAR(50) PRIMARY KEY not null, pass VARCHAR(100))";
            s.executeUpdate(sql);
            s.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    //populates data into specified database and specified tables 
    public static void populateTable(String id, String p)
    {
        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS); 
        Statement s = c.createStatement();)
        {
            String sql = "USE " + db;
            s.executeUpdate(sql);
            sql = "INSERT INTO " + table +  " VALUES('" + id + "', '" + p + "')"; 
            s.executeUpdate(sql);
            s.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    //searches the database and returns true if found 
    public static boolean searchDB(String uid, String pass) throws SQLException
    {
        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS); 
        Statement s = c.createStatement();) 
        {
            String sql = "USE " + db;
            s.executeUpdate(sql);
            sql = "SELECT uid FROM " + table + " where uid='" + uid + "' AND pass='" + pass + "'";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next())
            {
                return true;
            }
            s.close();

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        
        return false;
    }


    @SuppressWarnings("resource")
    public static void main(String[] args) throws FileNotFoundException, SQLException
    {
        int count = 0;
        boolean found = false;
        Scanner scanIN = new Scanner(System.in);
        String UTDId = null;
        String password =null;

      
        

        while(count < 3 && found == false)
        {
            try{
                UTDId = scanIN.next();
                UTDId.toLowerCase();
              password = scanIN.next();
                System.out.println(UTDId + " "+ password);
                }
                catch(Exception e)
                {
                    return;
                }
                
           

            found = searchDB(UTDId, password);
            if(found == false)
            {
                System.out.println("Invalid LogIn attempt " + (count+1));
                count++;
            }
            else
            {
                System.out.println("Successful login!");
              
            }
        }

    }
}
