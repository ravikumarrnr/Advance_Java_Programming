/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statement_Demo;

/**
 *
 * @author Ravikumar Natarajan
 */
import java.sql.*;
public class Prepare_statement {
     public static void main(String[] args) throws Exception
    {
 
        // Register Driver Class
         //1. Register the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //2. establish connection by con object
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/4tc","root","");

            System.out.println("Connection established");
 
  
   
        // Query which needs parameters
        String query= "Select * from demo where StuName = ? and City = ?";
 
        // Prepare Statement
        PreparedStatement myStmt
            = con.prepareStatement(query);
 
        // Set Parameters
        myStmt.setString(1, "Ram");
        myStmt.setString(2, "Chennai");
 
        // Execute SQL query
        ResultSet rs = myStmt.executeQuery();
 
        System.out.println("Name      City");
 
        // Display function to show the Resultset
        while (rs.next()) {
            String Name = rs.getString("StuName");
            String City = rs.getString("City");
            System.out.println(Name + "     " + City);
        }
        
        
        System.out.println("Insert Record");
        PreparedStatement myStmt1=con.prepareStatement("insert into demo values(?,?,?)");  
        myStmt1.setInt(1,102);//1 specifies the first parameter in the query  
        myStmt1.setString(2,"tc7");  
        myStmt1.setString(3,"Rajkot");  
  
        int i=myStmt1.executeUpdate();  
        System.out.println(i+" records inserted");  
        
        //perform UPDATE - update emp set name=? where Enroll=?"
 
        // Close the connection
        con.close();
    }
}
    
