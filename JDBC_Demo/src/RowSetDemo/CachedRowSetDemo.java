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

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Time;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
public class CachedRowSetDemo {
   public static void main(String args[]) throws Exception {
      //Registering the Driver
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      //Creating the RowSet object
      RowSetFactory factory = RowSetProvider.newFactory();
      CachedRowSet rowSet = factory.createCachedRowSet();
      //Setting the URL
      String mysqlUrl = "jdbc:mysql://localhost/4tc";
      rowSet.setUrl(mysqlUrl);
      //Setting the user name
      rowSet.setUsername("root");
      //Setting the password
      rowSet.setPassword("");
      //Setting the query/command
      rowSet.setCommand("select * from demo");
      rowSet.execute();
      System.out.println("Contents of the row set");
      while(rowSet.next()) {
         System.out.print("ID: "+rowSet.getInt("ID")+", ");
         System.out.print("Product Name: "+rowSet.getString("ProductName")+", ");
         System.out.print("Customer Name: "+rowSet.getString("CustomerName")+", ");
         System.out.print("Dispatch Date: "+rowSet.getDate("DispatchDate")+", ");
         System.out.print("Delivery Time: "+rowSet.getTime("DeliveryTime"));
         System.out.print("Price: "+rowSet.getString("Price")+", ");
         System.out.print("Location: "+rowSet.getString("Location"));
         System.out.println("");
      }
   }
}