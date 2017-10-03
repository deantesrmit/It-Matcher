
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.Statement;  

public class insertQuery {
   public static void main(String[] args) { 
      Connection con = null; 
      Statement stmt = null; 
      int result = 0; 
      try { 
         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
         con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/itmatcherdb", "SA", ""); 
         stmt = con.createStatement(); 
         result = stmt.executeUpdate("INSERT INTO tblUser (userID, FirstName, LastName, Email, Password) VALUES ('7', 'Road', 'Runner', 'road.runner@acmeinc.com', 'rr');" );
         con.commit();
      }catch (Exception e) { 
         e.printStackTrace(System.out); 
      } 
      System.out.println(result+" rows effected"); 
      System.out.println("Rows inserted successfully into tblUser");
   } 
} 

