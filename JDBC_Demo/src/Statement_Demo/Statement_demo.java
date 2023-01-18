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
/**
 *
 * @author admin
 */
public class Statement_demo {

    // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/4tc";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql = "select * from demo";
      
      // Let us check if it returns a true Result Set or not.
      Boolean ret = stmt.execute(sql);
      System.out.println("Return value is : " + ret.toString() );

      // Let us update age of the record with ID = 103;
      String sql1 = "update demo set Enroll=999 where Enroll=1213";
 
       int rows = stmt.executeUpdate(sql1);
    System.out.println("Rows impacted : " + rows );

      // Let us select all the records and display them.
      sql = "SELECT Enroll, StuName, City FROM demo";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt(1);
         String name = rs.getString(2);
         String city = rs.getString(3);

         //Display values
         System.out.print("Student ID: " + id);
         System.out.print(", Student Name: " + name);
         System.out.println(", Department Name: " + city);
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");}
    
}

