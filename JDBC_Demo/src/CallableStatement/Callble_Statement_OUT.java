/*
MYSQL stored procedure with 1 OUT parameter to get count of records from a table

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `student_count`(OUT `cnt` INT)
    NO SQL
BEGIN
SELECT COUNT(*) FROM student;
END$$
DELIMITER ;


 */
package callable_statement;

/**
 *
 * @author admin
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
    import java.sql.*; 

    public class Callble_Statement_OUT {  
    public static void main(String[] args) throws Exception{  
      
    Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MU","root","");  
    
        
        // call stored procedure INSERTR
      CallableStatement cs=con.prepareCall("{call student_count(?)}");  
      
      
      
     
    cs.registerOutParameter(1, java.sql.Types.INTEGER);
    cs.executeQuery();
    System.out.println("Student count " + cs.getInt(1));
    
      // execute stored procedure
      cs.execute();
     
   
   
  
  
    }  
    }  