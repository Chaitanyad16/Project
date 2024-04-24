package com.example.demo.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entites.BusAvailability;
import com.example.demo.entites.BusAvailabilityKey;

import jakarta.transaction.Transactional;

public interface BusAvailabilityRepository extends JpaRepository <BusAvailability,BusAvailabilityKey>{
	
	
	
//	 Find Bus Availability by Bus Number and DOJ
		@Query("from BusAvailability where availabilityKey.bus.busNumber = :busNumber and availabilityKey.DOJ = :DOJ")
		List<BusAvailability> findByBusNumberAndDOJ( @Param("busNumber") int busNumber, @Param("DOJ") Date doj);
		
		// Finding All Available Buses
		@Query("from BusAvailability where availabilityKey.bus.source = :source and availabilityKey.bus.destination = :destination and availabilityKey.DOJ = :DOJ")
		List<BusAvailability> findAvailableBusesBySourceAndDestinationAndDOJ(@Param("source") String source, @Param("destination") String destination, @Param("DOJ") Date doj);
		
		@Modifying
		@Transactional
		@Query("UPDATE BusAvailability SET sleeperSeats = sleeperSeats - :noOfSeats where availabilityKey.bus.busNumber = :busNumber and availabilityKey.DOJ = :DOJ")
		void reduceSleeperSeats(@Param("noOfSeats") int noOfSeats, @Param("busNumber") int busNumber, @Param("DOJ") Date doj);
		
		@Modifying
		@Transactional
		@Query("UPDATE BusAvailability SET seaterSeats = seaterSeats - :noOfSeats where availabilityKey.bus.busNumber = :busNumber and availabilityKey.DOJ = :DOJ")
		void reduceSeaterSeats(@Param("noOfSeats") int noOfSeats, @Param("busNumber") int busNumber, @Param("DOJ") Date doj);
		
		
		@Modifying
		@Transactional
		@Query("UPDATE BusAvailability SET sleeperSeats = sleeperSeats + :noOfSeats where availabilityKey.bus.busNumber = :busNumber and availabilityKey.DOJ = :DOJ")
		void increaseSleeperSeats(@Param("noOfSeats") int noOfSeats, @Param("busNumber") int busNumber, @Param("DOJ") Date doj);
		
		@Modifying
		@Transactional
		@Query("UPDATE BusAvailability SET seaterSeats = seaterSeats + :noOfSeats where availabilityKey.bus.busNumber = :busNumber and availabilityKey.DOJ = :DOJ")
		void increaseSeaterSeats(@Param("noOfSeats") int noOfSeats, @Param("busNumber") int busNumber, @Param("DOJ") Date doj);
		
	
	
}
