/*
This is our "Connection Class".
It is responsible for making our connection with database.
*/
package library.management.system;

import java.sql.*;                                                               // We need to include this package "MySql", inorder to use JDBC.

public class conn {
    Connection c;                                                                // These are interfaces provided by the package. It also provides different classes.
    Statement s;
    
    public conn(){                                                               // Constructor of our 'conn' Class.
        try{
            Class.forName("com.mysql.jdbc.Driver");                                        // 1st Step :- Registring Driver Class.
            c = DriverManager.getConnection("jdbc:mysql:///librarydatabase", "root", "");  // 2nd Step :- Creating Connection.
            s = c.createStatement();                                                       // 3rd Step :- Creating Statement.
            
        }catch(Exception e){                                                               // 4th Step :- We will use the above statement for excution, but in other classes.
            System.out.println(e);
        }
    }
}



/*
Steps to connect Java Application to MySql using JDBC.
1] Register Driver Class.
2] Create Connection.
3] Create Statement.
4] Execute Queries.
5] Close Connection (Optional).
*/