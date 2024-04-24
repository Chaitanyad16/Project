package com.example.demo.entites;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="booking_details")
@NoArgsConstructor
@AllArgsConstructor

public class BookingDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingId;
	
	@ManyToOne
	@JoinColumn(name="phone_number")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="bus_number")
	private Bus bus;
	
	@Column(name="type")
	private String type;
	
	@Column(name="no_of_seats")
	private int noOfSeats;
	
	@Column(name="total_fare")
	private float totalFare;
	
	@Column(name="DOJ")
	private Date DOJ;
	

	
	@OneToMany(mappedBy="bookingDetails", cascade=CascadeType.ALL)
	private List<Passenger> passengers;
	

}
