package busBooking.Models;

public class BookingDetails {
	public int booking_id;
	public String phoneNumber;
	public int busNumber;
	public String doj;
	public String type;
	public int noOfSeats;
	public float totalFare;
	
	public BookingDetails(int booking_id, String phoneNumber, int busNumber, String doj, String type, int noOfSeats, float totalFare) {
		this.booking_id = booking_id;
		this.phoneNumber = phoneNumber;
		this.busNumber = busNumber;
		this.doj = doj;
		this.type = type;
		this.noOfSeats = noOfSeats;
		this.totalFare = totalFare;
	}

}
