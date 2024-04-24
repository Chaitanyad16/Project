package busBooking.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import busBooking.DAO.BusManagementDAO;
import busBooking.Models.BookingDetails;
import busBooking.Models.Bus;

public class BusManagement {
	BusManagementDAO bmd = new BusManagementDAO();
	Scanner sc = new Scanner(System.in);
	public void bookTicket(String loggedInUserPhone) {
		try {
		String source;
		while(true) {
			System.out.print("Enter the source station:");
			source = sc.nextLine();
			if(!bmd.isSourceStationAvailable(source)) {
				System.out.println("Entered source station is not available.");
			}
			else {
				break;
			}
		}
		
		String destination;
		while(true) {
			System.out.print("Enter the destination station:");
			destination = sc.nextLine();
			if(!bmd.isDestinationStationAvailable(destination)) {
				System.out.println("Entered Destination station is not available.");
			}
			else {
				break;
			}
		}

			System.out.print("Enter the Date of Journey:");
			String doj = sc.nextLine();
			
			List<Bus> buses ;
			List<String> types = new ArrayList<String>();
			types.add("seater");
			types.add("sleeper");
			
			List<Integer> availableBuses =new ArrayList<Integer>();
			
				buses = bmd.filterBuses(source, destination, doj);
				
				for(Bus bus: buses) {
					System.out.println("-".repeat(40));
					availableBuses.add(bus.busNumber);
					System.out.println("    "+bus.busNumber + "     " + bus.name );
					
					System.out.printf("%10s   %10s   %10s \n" , "TYPE", "AVALIABLE SEATS", "PRICE/SEAT");
					
					System.out.println("_".repeat(40));
					
	
					System.out.printf(" %10s   %10d   %10.2f \n" , "seater", bus.seaterSeats, bus.seaterPrice);
					System.out.printf(" %10s   %10d   %10.2f \n", "sleeper", bus.sleeperSeats, bus.sleeperPrice);
					
				
					System.out.println("-".repeat(40));
					
				}
				
				
				if(buses.size()==0) {
					System.out.println("Buses Not Found");
				}
				else {
					int busNumber;
					while(true) {
						System.out.print("Enter the bus number which you want to book :");
						busNumber = sc.nextInt() ;
						if(availableBuses.contains(busNumber)) {
							break;
						}
						else {
							System.out.println("Enter valid Bus number");
						}
					}
					String type;
					int availSeats;
					while(true) {
						System.out.print("Enter the Type :");
						type = sc.next();
						if(types.contains(type))
						{
							availSeats = bmd.getNoOfAvailableSeats(busNumber, doj, type);
							if(availSeats==0) {
								System.out.println("Seats in the selected type got Completed.");
								continue;
							}
	                             break;
						}
						else {
							System.out.println("Enter valid Type");
						}
					}
					
					System.out.print("Enter the number of tickets :");
					int noOfSeats;
					while(true) {
						noOfSeats = sc.nextInt();
						if(noOfSeats==0) {
							break;
						}
						if(noOfSeats>availSeats) {
							System.out.println("Insufficient Seats. Only "+ availSeats + " seats available.");
							System.out.print("Enter the number of tickets / Enter 0 to exit:");
						}
						else {
							break;
						}
					}
					if(noOfSeats > 0) {
						bmd.implementNewBooking(loggedInUserPhone, busNumber, doj, type, noOfSeats);
						System.out.println("Booking Successfull");
					}
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Booking Failed.");
			}
			
	}

	
		public List<BookingDetails> showMyBookings(String phoneNumber) {
			List<BookingDetails> myBookings = new ArrayList<BookingDetails>();
			
			try {
				myBookings = bmd.executeShowMyBookings(phoneNumber);
			}
			catch(SQLException e) {
				System.out.println("Could not fetch details.");
			}
			
			System.out.println("-".repeat(120));
			if(myBookings.size()!=0) {
				System.out.printf("   %10s  %12s  %18s  %18s  %10s  %18s  %15s\n","Booking Id", "Phone Number", "Bus Number", "Date of Journey", "Type", "No Of Seats", "Total Fare");
				System.out.println("-".repeat(120));
				for(BookingDetails detail : myBookings) {
					System.out.printf("%10d     %12s  %18d  %18s  %10s  %18d  %15.2f\n",detail.booking_id, detail.phoneNumber, detail.busNumber, detail.doj, detail.type, detail.noOfSeats, detail.totalFare);
				}
			}
			else {
				System.out.println("You have not booked any bus.");
			}
			System.out.println("-".repeat(120));
			return myBookings;
		}
		
		public void cancelTicket(String phoneNumber) {
			List<BookingDetails> myBookings = showMyBookings(phoneNumber);
			List<Integer> bookingIds = new ArrayList<Integer>();
			for(BookingDetails detail : myBookings) {
				bookingIds.add(detail.booking_id);
			}
			
			if(myBookings.size()!=0) {
				int bId;
				while(true) {
					System.out.print("Enter the Booking Id for which you want to cancel the ticket : ");
					bId = sc.nextInt();
					if(bookingIds.contains(bId)) {
						break;
					}
					else {
						System.out.println("Enter valid Booking ID.");
					}
				}
				
				try {
					bmd.executeCancelTicket(bId);
					System.out.println("Cancellation Successfull.");
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("Cancellation Failed.");
				}
			}
		}
		
	

}
