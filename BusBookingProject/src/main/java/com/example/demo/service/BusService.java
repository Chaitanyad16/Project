package com.example.demo.service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.BookingDetails;
import com.example.demo.entites.Bus;
import com.example.demo.entites.BusAvailability;
import com.example.demo.entites.Passenger;
import com.example.demo.entites.User;
import com.example.demo.repositories.BookingDetailsRepository;
import com.example.demo.repositories.BusAvailabilityRepository;
import com.example.demo.repositories.BusRepository;
import com.example.demo.repositories.PassengerRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class BusService {
	@Autowired
	BusAvailabilityRepository busAvailabilityRepo;
	
	@Autowired
	BusRepository busRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BookingDetailsRepository bookingDetailsRepo;
	
	@Autowired
	PassengerRepository passengerRepo;
	

	public List<BusAvailability> getAvailableBuses(String source, String destination, Date dateofjourney) {
		List<BusAvailability> buses = busAvailabilityRepo.findAvailableBusesBySourceAndDestinationAndDOJ(source,destination, dateofjourney);
		return buses;
	}

	public Bus findBus(int bus) {
		return busRepo.findById(bus).get();
		
	}

	public User findUser(String user) {
		return userRepo.findById(user).get();
		
	}

	public float getTicketCost(int busNumber, String type) {
		 
	
			Bus bus = busRepo.findById(busNumber).get();
			switch (type) {
			case "sleeper": {
				return bus.getSleeperPrice();
			}
			case "seater": {
				return bus.getSeaterPrice();
			}
			
			default:
				return 0;
			}
		
	 
	}


		public int getAvailableSeatsCount(int busNumber, Date doj, String type) {
			
			BusAvailability availability = busAvailabilityRepo.findByBusNumberAndDOJ(busNumber, doj).get(0);
			return availability.getSeatsCountByType(type);
		}
		
	
	
		public BookingDetails makeReservation(BookingDetails bookingDetail) {
			for (Passenger p : bookingDetail.getPassengers()) {
				p.setBookingDetails(bookingDetail);
			}
	 
			String type = bookingDetail.getType();
			int noOfSeats = bookingDetail.getNoOfSeats();
			int busNumber = bookingDetail.getBus().getBusNumber();
			Date doj = bookingDetail.getDOJ();
			
	 

			int availableSeatsCount = getAvailableSeatsCount(busNumber, doj, type);
	 
			List<Integer> ReservedSeatNumbers = passengerRepo.getBookedSeatNumbers(busNumber, doj.toString(),type);
	 
			int totalSeatsCount = availableSeatsCount + ReservedSeatNumbers.size();
			int foundSeats = 0;
			for (int seatNumber = 1; seatNumber <= totalSeatsCount; seatNumber++) {
				if (!ReservedSeatNumbers.contains(seatNumber)) {
					bookingDetail.getPassengers().get(foundSeats).setSeatNumber(seatNumber);
					foundSeats += 1;
				}
				if (noOfSeats == foundSeats) {
					break;
				}
			}
	 
			// Add to Booking Details and Passengers
			bookingDetailsRepo.save(bookingDetail);
//	 reducing the seats
			switch (type) {
			case "sleeper":
				busAvailabilityRepo.reduceSleeperSeats(noOfSeats,busNumber, doj);
				break;
			case "seater":
				busAvailabilityRepo.reduceSeaterSeats(noOfSeats, busNumber, doj);
				break;
			
			}
			return bookingDetail;
		}



		public List<BookingDetails> getAllBookingDetails(String phoneNumber ) {
			return bookingDetailsRepo.findByUserPhoneNumber(phoneNumber );
		}



		public void cancelReservation(int bookingId) {
			BookingDetails bookingDetail = bookingDetailsRepo.findById(bookingId).get();
			int busNumber = bookingDetail.getBus().getBusNumber();
			Date doj = bookingDetail.getDOJ();
			int noOfSeats = bookingDetail.getNoOfSeats();
			String type = bookingDetail.getType();
			
			// Deleting the booking detail
			bookingDetailsRepo.deleteById(bookingId);
			
			// Increasing the Seats Count
			switch (type) {
			case "sleeper":
				busAvailabilityRepo.increaseSleeperSeats(noOfSeats,busNumber, doj);
				break;
			case "seater":
				busAvailabilityRepo.increaseSeaterSeats(noOfSeats, busNumber, doj);
				break;
			
			}
			
		}
		public Set<String> getStops(){
			Set<String> stops = new HashSet<>();
			List<Bus> buses = busRepo.findAll();
			for(Bus bus: buses) {
				stops.add(bus.getSource());
				stops.add(bus.getDestination());
			}
			return stops;
		}

		
		

}
