package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.BookingDetails;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer>{

	List<BookingDetails> findByUserPhoneNumber(String phoneNumber);
	

}
