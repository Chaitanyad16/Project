package com.example.demo.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.entites.BookingDetails;
import com.example.demo.entites.BusAvailability;
import com.example.demo.service.BusService;

@SessionAttributes({"phoneNumber","bookingDetail"})
@Controller


public class BookingController {


	@Autowired
	BusService busService;
	
	
	@GetMapping("booking")
	public String Home(ModelMap model) {
		model.put("stops",busService.getStops());
		return "sdd";
	}

	@PostMapping("booking")
	public String book(@RequestParam String source, @RequestParam String destination, @RequestParam  Date dateofjourney, ModelMap model) {
		
		List<BusAvailability> buses = busService.getAvailableBuses(source,destination,dateofjourney);
		
		model.put("availableBuses", buses);
		return "available_buses";
		
	}




	@GetMapping("passenger_details")
	public String showNoOfPassengerPage(@RequestParam int bus,@RequestParam String type, @RequestParam String doj, @ModelAttribute BookingDetails bookingDetail, ModelMap model) {
		String view = "";
		System.out.println(bus+type);
		if(model.get("phoneNumber")==null) {
			view = "redirect:login";
		}
		else {
			bookingDetail.setBus(busService.findBus(bus));
			bookingDetail.setType(type);
			try {
				Date doj1 = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(doj).getTime());
				bookingDetail.setDOJ(doj1);
			}catch(Exception e) {}
			
			model.put("bookingDetail", bookingDetail);
			view = "NoOfPassengers";
		}
		return view;
	}


	@PostMapping("passenger_details")

	public String showPassengerDetailsPage(BookingDetails bookingDetail, ModelMap model) {
		
		bookingDetail.setPassengers(new ArrayList<>());
		bookingDetail.setBus(((BookingDetails)model.get("bookingDetail")).getBus());
		
		
		
		model.put("bookingDetail", bookingDetail);

		
		
		return "PassengerDetails";
	}



	@PostMapping("confirm")
	public String showConfirmationPage(BookingDetails bookingDetail, ModelMap model) {
	
	
		float ticketCost = busService.getTicketCost(((BookingDetails)model.get("bookingDetail")).getBus().getBusNumber(), bookingDetail.getType());
		float totalFare = ticketCost * bookingDetail.getNoOfSeats();  // Total Cost
		bookingDetail.setTotalFare(totalFare);  
		
		bookingDetail.setBus(((BookingDetails)model.get("bookingDetail")).getBus());
		bookingDetail.setUser(busService.findUser(model.get("phoneNumber").toString()));
		
		model.put("bookingDetail", bookingDetail);
		
		return "confirmationPage";
	}


	@PostMapping("BookingStatus")
	public String showBookingStatusPage(ModelMap model) {
		BookingDetails bookingDetail = (BookingDetails) model.get("bookingDetail");
		BookingDetails finalBookingDetail = busService.makeReservation(bookingDetail);
		model.put("bookingDetail", finalBookingDetail);
		return "SuccessPage";
	}


}
