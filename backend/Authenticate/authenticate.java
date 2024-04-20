/*
This code is done using MYSQL, the database url, user name, and password are given
Database creation, population, and querying are in another file call CreateDatabase.java
The MYSQL jar file needed to run this file is attached as a file in the Authenticate folder 

This code reads in the user data from test.txt and stores in a database 
*/


import java.sql.*;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class authenticate {
     
    @SuppressWarnings("resource")
    public static void main(String[] args) throws FileNotFoundException, SQLException
    {
        int count = 0;
        boolean found = false;
        Scanner scanIN = new Scanner(System.in);
        String database = "maybe";
        String table = "tempy";
        CreateDatabase.createDB(database);
        CreateDatabase.createTable(database, table);

        File storedVerfication = new File("test.txt");    //open file 
        Scanner scan = new Scanner(storedVerfication);
        String input;
        String valReadIN[];

        while(scan.hasNextLine())                                  //read in values from file and store in hashmap
        {
            input = scan.nextLine();
            valReadIN= input.split(" ");
            String l = valReadIN[0].toLowerCase();
            CreateDatabase.populateTable(database, table , l , valReadIN[1]);
        }
        

        while(count < 3 && found == false)
        {
            System.out.println("Enter UTD Id: ");                           
            String UTDId = scanIN.nextLine();
            UTDId.toLowerCase();
            System.out.println("Enter password: ");
            String password = scanIN.nextLine();

            found = CreateDatabase.searchDB(database, table, UTDId, password);
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
