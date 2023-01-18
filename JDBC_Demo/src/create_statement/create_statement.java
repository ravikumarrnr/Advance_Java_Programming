/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package create_statement;
import java.sql.*;

/**
 *
 * @author Ravikumar Natarajan
 */

public class create_statement {
    
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
     static final String DB_URL="jdbc:mysql://localhost/tc5";
     static final String USER="root";
      static final String PASS="";
      public static void main(String []args){
          Connection conn=null;
          Statement stmt=null;
          try{
              Class.forName("com.mysql.jdbc.Driver");
              conn=DriverManager.getConnection(DB_URL,USER,PASS);
              stmt=conn.createStatement();
              String sql="select *from student";
              
              ResultSet rs=stmt.executeQuery(sql);
              while(rs.next())
              System.out.println("name:"+rs.getString(1)+ " "+"enroll:"+rs.getInt(2)+ " "+"city:"+rs.getString(3));
             
             conn.close();
                      } catch(Exception e){
                      }
      }
}

