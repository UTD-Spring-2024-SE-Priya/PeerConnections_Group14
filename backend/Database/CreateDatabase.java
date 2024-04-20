/*
This code is done using MYSQL, the database url, user name, and password are given
Database creation, population, and querying are all done in this file to minimize clutter
The MYSQL jar file needed to run this file is attached as a file in the backend folder 
*/


import java.sql.*;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class CreateDatabase {
    //database path, root, and password
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "0000";
    

    //creates a connection, and performs operations on the databased based on string input 
    public static void createDB(String DBname)
    {
        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS); 
        Statement s = c.createStatement();)
        {
            String sql = "CREATE DATABASE " + DBname;
            s.executeUpdate(sql);
            s.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }

    //creates tables in a specified database 
    public static void createTable(String db,String tableName)
    {
        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS); 
        Statement s = c.createStatement();)
        {
            String sql = "USE " + db;
            s.executeUpdate(sql);
            sql = "CREATE TABLE " + tableName + " (uid VARCHAR(50) PRIMARY KEY not null, pass VARCHAR(100))";
            s.executeUpdate(sql);
            s.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    //populates data into specified database and specified tables 
    public static void populateTable(String Db, String TableName, String id, String p)
    {
        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS); 
        Statement s = c.createStatement();)
        {
            String sql = "USE " + Db;
            s.executeUpdate(sql);
            sql = "INSERT INTO " + TableName +  " VALUES('" + id + "', '" + p + "')"; 
            s.executeUpdate(sql);
            s.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    //searches the database and returns true if found 
    public static boolean searchDB(String db, String table, String uid, String pass) throws SQLException
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
}
