import java.sql.Connection;
import java.sql.DriverManager;

public class sample {

	public sample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
			
			Connection c = null;
		      try {
		         Class.forName("org.postgresql.Driver");
		         c = DriverManager
		            .getConnection("jdbc:postgresql://localhost:5432/postgres",
		            "postgres", "password");
		      } catch (Exception e) {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		      }
		      System.out.println("Opened database successfully");

	}

}
