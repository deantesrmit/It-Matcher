


import java.sql.Connection;
import java.sql.DriverManager;

public class connectDatabase {
   public static void main(String[] args) {
      Connection con = null;
      
      try {
         //Registering the HSQLDB JDBC driver
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         //Creating the connection with HSQLDB
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/itmatcherdb", "SA", "");
         if (con!= null){
            System.out.println("Connection created to IT MATCHER DB successfully");
            
         }else{
            System.out.println("Problem with creating connection to IT MATCHER DB");
         }
      
      }  catch (Exception e) {
         e.printStackTrace(System.out);
      }
   }
}


