/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcdemo;

/**
 *
 * @author Ravikumar Natarajan
 */

/**
 *
 * @author admin
 */
import java.sql.*;
public class JDBC_Demo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
          try {
            //1. Register the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //2. establish connection by con object
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/4tc","root","");

            System.out.println("Connection established");
            
            //3. Create the statement object which is 
            //used to execute query in database
            
                Statement stmt=con.createStatement();  
  
            //step4 execute query //RS maintains cursor 

                ResultSet rs=stmt.executeQuery("select * from demo");  
                while(rs.next())  
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
                System.out.println("DATA FETCHED");
            //5.close the connection
            
            con.close();
            
        } catch (Exception e) {
        }
    }
    
}
