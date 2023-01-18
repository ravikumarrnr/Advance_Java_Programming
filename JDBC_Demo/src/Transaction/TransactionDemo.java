/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaction;

/**
 *
 * @author Ravikumar Natarajan
 */
import java.sql.*;  
import java.io.*;  
import java.util.*;
class TransactionDemo{  
public static void main(String args[]){  
try{  
  
Class.forName("com.mysql.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/4tc","root","");  
con.setAutoCommit(false);  
  
PreparedStatement ps=con.prepareStatement("insert into demo values(?,?,?)");  
  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
while(true){  
Scanner sc = new Scanner(System.in);
System.out.println("enter enroll");  
int s1=sc.nextInt();
 
  
System.out.println("enter name");  
String name=sc.next();  
  
System.out.println("enter city");  
String s3=sc.next();  

  
ps.setInt(1,s1);  
ps.setString(2,name);  
ps.setString(3,s3);  
ps.executeUpdate();  
  
System.out.println("commit/rollback");  
String answer=sc.next();  
if(answer.equals("commit")){  
con.commit();
System.out.println("record successfully saved"); 
}  
if(answer.equals("rollback")){  
con.rollback();
System.out.println("Current records not inserted");  
}  
  
  
System.out.println("Want to add more records y/n");  
String ans=br.readLine();  
if(ans.equals("n")){  
break;  
}  
  
}  
con.commit();  
//System.out.println("record successfully saved");  
  
con.close();//before closing connection commit() is called  
}catch(Exception e){System.out.println(e);}  
  
}} 
