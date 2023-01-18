/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RowSetDemo;

/**
 *
 * @author Ravikumar Natarajan
 */
import javax.sql.rowset.JdbcRowSet;  
import javax.sql.rowset.RowSetProvider;  
  
public class RowSet_Demo {  
        public static void main(String[] args) throws Exception {  
                 Class.forName("com.mysql.jdbc.Driver");  
      
    //Creating and Executing RowSet  
        JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet();  
        rs.setUrl("jdbc:mysql://localhost/4tc");  
        rs.setUsername("root");  
        rs.setPassword("");  
                   
        rs.setCommand("select * from demo");  
        rs.execute();  
                   
    while (rs.next()) {  
                        // Generating cursor Moved event  
        System.out.println("Student Id: " + rs.getInt(1)+     
  
                           " Student Name: " + rs.getString(2) + 
                           " Department Name: " + rs.getString(3));  
                }  
                 
        }  
} 
