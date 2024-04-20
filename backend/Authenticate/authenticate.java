/*
This code is done using MYSQL, the database url, user name, and password are given
Database creation, population, and querying are all done in this file to minimize clutter
The MYSQL jar file needed to run this file is attached as a file in the backend folder 
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

        /*   -- here to give use more flexibility with choosing database and table names  
        System.out.println("Enter database name: ");
        String database = scanIN.nextLine();
        System.out.println("Enter table name: ");
        String table = scanIN.nextLine();
        */

        //temporary database and table names, can be altered using above code.
        String database = "SESpring2024project";
        String table = "Login";
        CreateDatabase.createDB(database);
        CreateDatabase.createTable(database, table);

        //opening test file and scanning values in 
        File storedVerfication = new File("test.txt");     
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
