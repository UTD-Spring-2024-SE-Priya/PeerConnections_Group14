/*
This code is done using MYSQL, the database url, user name, and password are given
Database creation, population, and querying are all done in this file to minimize clutter
The MYSQL jar file needed to run this file is attached as a file in the backend folder 
*/


import java.sql.*;
import java.util.Scanner;

public class authenticate {

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

    //searches the database and returns true if found 
    public static boolean searchDB(String uid, String pass) throws SQLException
    {
        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS); 
        Statement s = c.createStatement();) 
        {
            String sql = "USE data";
            s.executeUpdate(sql);
            sql = "SELECT uid FROM login where uid='" + uid + "' AND pass='" + pass + "'";
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

    public static void main(String[] args) throws SQLException
    {
        int count = 0;
        boolean found = false;
        Scanner scanIN = new Scanner(System.in);
        createDB();

        while(count < 3 && found == false)
        {
            System.out.println("Enter UTD Id: ");                           
            String UTDId = scanIN.nextLine();
            UTDId.toLowerCase();
            System.out.println("Enter password: ");
            String password = scanIN.nextLine();

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
