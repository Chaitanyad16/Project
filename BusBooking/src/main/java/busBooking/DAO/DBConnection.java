package busBooking.DAO;
import java.sql.*;

public class DBConnection {
	public static Connection getConnection() {
		Connection con=null;
		try {
			String url= "jdbc:mysql://localhost:3306/busmanagement";
			con=DriverManager.getConnection(url, "root", "root");
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println("DB Connection Failed");	
		}
		return con;
	}

}
