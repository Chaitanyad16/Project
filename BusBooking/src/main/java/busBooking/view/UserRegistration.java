package busBooking.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import busBooking.DAO.BusManagementDAO;
import busBooking.DAO.DBConnection;
import busBooking.Models.User;

public class UserRegistration {
	static BusManagementDAO bmd=new BusManagementDAO();
	static Scanner sc = new Scanner(System.in);
	public static boolean registerNewUser(User newUser) {
		try {
			if(isValidPassword(newUser) && isValidPhoneNumber(newUser) && isValidFullName(newUser)) {
				bmd.implementRegisterUser(newUser);
				System.out.println("User Registered Successfully.");
				return true;
			}
			else {
				System.out.println("User Not Registered.");
				return false;
			}
		
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("User Not Registered. Issue with DB.");
			return false;
		}
	}

	private static boolean isValidFullName(User newUser) throws SQLException{
		String name = newUser.getFullName();
		if( !name.matches("^[a-zA-Z\\s]*$")) {
			System.out.println("Enter Only Alphabets in Full Name");
			return false;
		}
		return true;
	}
	private static boolean isValidPhoneNumber(User newUser) throws SQLException{
		Connection con=DBConnection.getConnection();
		Statement s=con.createStatement();
		int noOfDigits=newUser.getPhoneNumber().length();
		if(!newUser.getPhoneNumber().matches("[6-9][0-9]{9}")) {
			System.out.println("Please enter the 10 digit Phone Number.");
			return false;
		}
		ResultSet rs=s.executeQuery("select phone_number from users where phone_number="+ newUser.getPhoneNumber());
		
		if(rs.next()) {
			System.out.println("Entered Phone Number is already registered.");
			return false;
		}
		
		return true;

	}

	private static boolean isValidPassword(User newUser) {
		String pwd=newUser.getPassword();
		if(pwd.length()<6) {
			System.out.println("Password should contain alteast 6 characters.");
			return false;
		}
		return true;
	}

}
