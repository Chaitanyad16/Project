package busBooking.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import busBooking.DAO.DBConnection;

public class UserLogin1 {
	public static boolean login(String phoneNumber,String password) {
		try {
			Connection con= DBConnection.getConnection();
			PreparedStatement s=con.prepareStatement("SELECT * FROM users WHERE phone_number = ? and password=?");
			s.setString(1, phoneNumber);
			s.setString(2, password);
			ResultSet rs=s.executeQuery();
			
			
			if(rs.next()) {
				System.out.println("Login Successfull.");
				return true;
			}
			System.out.println("Wrong UserName or Password.");
			return false;
			
		}
		catch(SQLException e) {
			System.out.println("Login Failed.Try again later...");
			return false;
		}
	}

}
