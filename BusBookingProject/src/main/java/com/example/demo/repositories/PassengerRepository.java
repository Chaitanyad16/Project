package com.example.demo.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entites.Passenger;
 

 

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
	@Query(value="select seat_number from Passenger join booking_details using(booking_id) where bus_number = :busNumber and DOJ =str_to_date(:DOJ,\"%Y-%m-%d\") and type = :type", nativeQuery=true)
	List<Integer> getBookedSeatNumbers(@Param("busNumber") int busNumber, @Param("DOJ") String doj, @Param("type") String type);
 
}


