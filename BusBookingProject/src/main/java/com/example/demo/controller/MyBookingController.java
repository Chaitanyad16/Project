 package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.entites.BookingDetails;
import com.example.demo.service.BusService;
@SessionAttributes({"phoneNumber","bookingDetail"})
@Controller
public class MyBookingController {

	@Autowired
	BusService busService;
	
	@GetMapping("mybookings")
	public String showMyBookingsPage(ModelMap model) {
		String view = "";
		if(model.get("phoneNumber")==null) {
			view = "redirect:login";
		}
		else {
			List<BookingDetails> bookings = busService.getAllBookingDetails(model.get("phoneNumber").toString());
			model.put("myBookings",bookings);
			view = "mybookings";
		}
		return view;
	}
}
