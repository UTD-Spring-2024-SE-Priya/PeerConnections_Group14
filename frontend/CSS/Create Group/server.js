//creating server 

const express = require('express');
const cors = require('cors');  

const app = express();
const port = 3000;
const bodyParser = require("body-parser");


app.use(express.json());
app.use(cors());
app.use(bodyParser.json());        // parse JSON bodies


//if server asks for OPTIONS, respond successful 
app.options('/api', (req, res) => {
    res.status(200).send();
});

app.post('/api', async (req, res) => {
    const uid = req.body.uid;
    const pass = req.body.pass;

    var o = {};
    o["clientId"] = "4e0b2b26ee2dc9369c393b8d700492be";
    o["clientSecret"] = "98457dc9ab45b33a5569cf0cbf520c9cb4c125b49170834572942719e1b7e53b";
    o["script"] = "import java.sql.*;\r\nimport java.util.Scanner;\r\nimport java.util.*;\r\nimport java.io.*;\r\n\r\npublic class authenticateForProject {\r\n    //database path, root, and password\r\n    static final String DB_URL = \"jdbc:mysql://localhost:3306/\";\r\n    static final String USER = \"root\";\r\n    static final String PASS = \"0000\";\r\n    static final String db = \"sespring2024project\";\r\n    static final String table = \"login\";\r\n    \r\n    \r\n\r\n    //creates a connection, and performs operations on the databased based on string input \r\n    public static void createDB()\r\n    {\r\n        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS); \r\n        Statement s = c.createStatement();)\r\n        {\r\n            String sql = \"CREATE DATABASE \" + db;\r\n            s.executeUpdate(sql);\r\n            sql = \"USE \" + db;\r\n            s.executeUpdate(sql);\r\n            sql = \"CREATE TABLE login (uid VARCHAR(50) PRIMARY KEY not null, pass VARCHAR(100))\";\r\n            s.executeUpdate(sql);\r\n            sql = \"INSERT INTO login \" + \"VALUES('hxm220056', 'lola')\"; \r\n            s.executeUpdate(sql);\r\n            sql = \"INSERT INTO login \" + \"VALUES('axp200003', 'show')\"; \r\n            s.executeUpdate(sql);\r\n            sql = \"INSERT INTO login \" + \"VALUES('zoo230000', 'feather')\"; \r\n            s.executeUpdate(sql);\r\n            sql = \"INSERT INTO login \" + \"VALUES('dtz200000', 'flew')\"; \r\n            s.executeUpdate(sql);\r\n            sql = \"INSERT INTO login \" + \"VALUES('utd123456', 'CorrectPassword')\";\r\n            s.executeUpdate(sql);\r\n            s.close();\r\n        }catch(SQLException e)\r\n        {\r\n            e.printStackTrace();\r\n        }\r\n        \r\n    }\r\n    //creates tables in a specified database \r\n    public static void createTable()\r\n    {\r\n        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS); \r\n        Statement s = c.createStatement();)\r\n        {\r\n            String sql = \"USE \" + db;\r\n            s.executeUpdate(sql);\r\n            sql = \"CREATE TABLE \" + table + \" (uid VARCHAR(50) PRIMARY KEY not null, pass VARCHAR(100))\";\r\n            s.executeUpdate(sql);\r\n            s.close();\r\n        }catch(SQLException e)\r\n        {\r\n            e.printStackTrace();\r\n        }\r\n    }\r\n\r\n    //populates data into specified database and specified tables \r\n    public static void populateTable(String id, String p)\r\n    {\r\n        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS); \r\n        Statement s = c.createStatement();)\r\n        {\r\n            String sql = \"USE \" + db;\r\n            s.executeUpdate(sql);\r\n            sql = \"INSERT INTO \" + table +  \" VALUES('\" + id + \"', '\" + p + \"')\"; \r\n            s.executeUpdate(sql);\r\n            s.close();\r\n        }catch(SQLException e)\r\n        {\r\n            e.printStackTrace();\r\n        }\r\n    }\r\n\r\n    //searches the database and returns true if found \r\n    public static boolean searchDB(String uid, String pass) throws SQLException\r\n    {\r\n        try(Connection c = DriverManager.getConnection(DB_URL, USER, PASS); \r\n        Statement s = c.createStatement();) \r\n        {\r\n            String sql = \"USE \" + db;\r\n            s.executeUpdate(sql);\r\n            sql = \"SELECT uid FROM \" + table + \" where uid='\" + uid + \"' AND pass='\" + pass + \"'\";\r\n            ResultSet rs = s.executeQuery(sql);\r\n            while(rs.next())\r\n            {\r\n                return true;\r\n            }\r\n            s.close();\r\n\r\n        }catch(SQLException e)\r\n        {\r\n            e.printStackTrace();\r\n        }\r\n        \r\n        \r\n        return false;\r\n    }\r\n\r\n\r\n    @SuppressWarnings(\"resource\")\r\n    public static void main(String[] args) throws FileNotFoundException, SQLException\r\n    {\r\n        int count = 0;\r\n        boolean found = false;\r\n        Scanner scanIN = new Scanner(System.in);\r\n        String UTDId = null;\r\n        String password =null;\r\n\r\n      \r\n        \r\n\r\n        while(count < 3 && found == false)\r\n        {\r\n            try{\r\n                UTDId = scanIN.next();\r\n                UTDId.toLowerCase();\r\n              password = scanIN.next();\r\n                System.out.println(UTDId + \" \"+ password);\r\n                }\r\n                catch(Exception e)\r\n                {\r\n                    return;\r\n                }\r\n                \r\n           \r\n\r\n            found = searchDB(UTDId, password);\r\n            if(found == false)\r\n            {\r\n                System.out.println(\"Invalid LogIn attempt \" + (count+1));\r\n                count++;\r\n            }\r\n            else\r\n            {\r\n                System.out.println(\"Successful login!\");\r\n              \r\n            }\r\n        }\r\n\r\n    }\r\n}\r\n";
    o["language"] = "java";
    o["versionIndex"] = "0";
    o["uid"] = uid;
    o["pass"] = pass;
    var jsonStr = JSON.stringify(o);
    console.log(jsonStr);

    const response = await fetch('https://api.jdoodle.com/v1/execute', {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json',
        },
        body: jsonStr
    });


    const data = await response.json();
    res.json(data);
    

});


app.listen(port, () => {
    console.log(`Server listening at http://localhost:3000/api`);});



