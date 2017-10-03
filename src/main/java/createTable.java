


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class createTable {
   
   public static void main(String[] args) {
      
      Connection con = null;
      Statement stmt = null;
      int result = 0;
      
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/itmatcherdb", "SA", "");
         stmt = con.createStatement();
			// userID, FirstName, LastName, MobileNumber, Email, Password
         result = stmt.executeUpdate("CREATE TABLE tblUser (userID INT NOT NULL, FirstName VARCHAR(50) NOT NULL, LastName VARCHAR(50) NOT NULL, Email VARCHAR(100) NOT NULL, Password VARCHAR(50) NOT NULL, PRIMARY KEY (userID) ); " );
      }  catch (Exception e) {
         e.printStackTrace(System.out);
      }
      System.out.println("User Table created successfully");
	  
   }
}





