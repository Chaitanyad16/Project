package busBooking.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import busBooking.Models.BookingDetails;
import busBooking.Models.Bus;
import busBooking.Models.User;

public class BusManagementDAO {
	Connection con=DBConnection.getConnection();

	public void implementRegisterUser(User newUser) throws SQLException {
		PreparedStatement s= con.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?)");
		
		s.setString(1, newUser.getFullName());
		s.setInt(2, newUser.getAge());
		s.setString(3, newUser.getGender());
		s.setString(4, newUser.getPhoneNumber());
		s.setString(5,  newUser.getPassword());
		s.executeUpdate();
		
	}

	public List<Bus> filterBuses(String source, String destination, String doj) throws SQLException {
		
		List<Bus> buses = new ArrayList<Bus>();
				PreparedStatement s = con.prepareStatement("select * from buses join bus_availability using(bus_number) where source = ? and destination = ? and DOJ = str_to_date(?,\"%d-%m-%Y\")");
				s.setString(1, source);
				s.setString(2, destination);
				s.setString(3, doj);
				ResultSet rs = s.executeQuery();
				while(rs.next()) {
					int busNumber = rs.getInt("bus_Number");
					String name = rs.getString("name");
					int seaterSeats = rs.getInt("seater_seats");
					int sleeperSeats = rs.getInt("sleeper_seats");
				
					float seaterPrice = rs.getInt("seater_price");
					float sleeperPrice = rs.getInt("sleeper_price");
					
					buses.add(new Bus(busNumber, name, source, destination, doj,seaterSeats,
							sleeperSeats, seaterPrice, sleeperPrice));
				}
				return buses;
		
		
	}

	public void implementNewBooking(String loggedInUserPhone, int busNumber, String doj, String type, int noOfSeats) throws SQLException {
		// Reducing the number of seats available for the train in booked coach.
					PreparedStatement s1 = con.prepareStatement("UPDATE bus_availability SET "+ type + "_seats = "+ type+"_seats -"+noOfSeats+ " where bus_number = ? and DOJ =str_to_date(?,\"%d-%m-%Y\")");
					s1.setInt(1, busNumber);
					s1.setString(2, doj);
					s1.executeUpdate();
					
	// Calculate Total Fare
		PreparedStatement s2 = con.prepareStatement("SELECT "+type+"_price from buses where bus_number = ?");
		s2.setInt(1, busNumber);
		ResultSet rs = s2.executeQuery();
		rs.next();
		float totalFare = rs.getInt(type+"_price") * noOfSeats;
		
	// Adding booking details.
		PreparedStatement s = con.prepareStatement("INSERT INTO booking_details(phone_number, bus_number, DOJ, type, no_of_seats, total_fare) VALUES(?,?,str_to_date(?,\"%d-%m-%Y\"),?,?,?)");
		s.setString(1, loggedInUserPhone);
		s.setInt(2, busNumber);
		s.setString(3, doj);
		s.setString(4, type);
		s.setInt(5, noOfSeats);
		s.setFloat(6, totalFare);
		s.executeUpdate();
	
		
	}
	
	public List<BookingDetails> executeShowMyBookings(String phoneNumber) throws SQLException{
		List<BookingDetails> myBookings = new ArrayList<BookingDetails>();
		
		PreparedStatement s2 = con.prepareStatement("SELECT * from booking_details where phone_number = ?" );
		s2.setString(1, phoneNumber);
		ResultSet rs = s2.executeQuery();
		while(rs.next()) {
			int bId = rs.getInt("booking_id");
			String phNo = rs.getString("phone_Number");
			int tNo = rs.getInt("bus_number");
			String doj = rs.getString("doj");
			String type = rs.getString("type");
			int noOfSeats = rs.getInt("no_of_seats");
			float totalFare = rs.getFloat("total_fare");
			myBookings.add(new BookingDetails(bId, phNo, tNo, doj, type, noOfSeats, totalFare));
		}
		return myBookings;
	}
	
	public void executeCancelTicket(int bId) throws SQLException {
		PreparedStatement s0 = con.prepareStatement("SELECT * FROM booking_details WHERE booking_id = ?" );
		s0.setInt(1, bId);
		ResultSet rs = s0.executeQuery();
		rs.next();
		String type = rs.getString("TYPE");
		String doj = rs.getString("DOJ");
		int noOfSeats = rs.getInt("no_of_seats");
		int busNumber = rs.getInt("bus_number");
		
		PreparedStatement s2 = con.prepareStatement("DELETE FROM booking_details WHERE booking_id = ?" );
		s2.setInt(1, bId);
		s2.executeUpdate();
 
		PreparedStatement s1 = con.prepareStatement("UPDATE bus_availability SET "+ type + "_seats = "+ type+"_seats +"+noOfSeats+ " where bus_number = ? and DOJ =str_to_date(?,\"%Y-%m-%d\")" );
		s1.setInt(1, busNumber);
		s1.setString(2, doj);
		s1.executeUpdate();
	}


		public boolean f(String source) throws SQLException{
			PreparedStatement s0 = con.prepareStatement("SELECT * FROM buses WHERE source = ?");
			s0.setString(1, source);
			ResultSet rs = s0.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		}
		
		public boolean isDestinationStationAvailable(String destination) throws SQLException{
			PreparedStatement s0 = con.prepareStatement("SELECT * FROM buses WHERE destination = ?");
			s0.setString(1, destination);
			ResultSet rs = s0.executeQuery();
			if(rs.next()) {
				return true;
			}
			

		
		return false;
	}

		
			public int getNoOfAvailableSeats(int busNumber, String doj, String type) throws SQLException{
				PreparedStatement s0 = con.prepareStatement("SELECT * FROM bus_availability WHERE bus_number = ? and DOJ = str_to_date(?, \"%d-%m-%Y\")");
				s0.setInt(1, busNumber);
				s0.setString(2, doj);
				ResultSet rs = s0.executeQuery();
				rs.next();
				return rs.getInt(type+"_seats");
			}

			public boolean isSourceStationAvailable(String source) throws SQLException{
				PreparedStatement s0 = con.prepareStatement("SELECT * FROM buses WHERE source = ?");
				s0.setString(1, source);
				ResultSet rs = s0.executeQuery();
				if(rs.next()) {
					return true;
				}
				
				return false;
			}
			
	
	

}
