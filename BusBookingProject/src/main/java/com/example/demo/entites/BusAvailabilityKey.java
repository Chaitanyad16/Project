package com.example.demo.entites;

import java.sql.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class BusAvailabilityKey {

	@ManyToOne
	@JoinColumn(name="bus_number")
	private Bus bus;
	
	private Date DOJ;

	@Override
	public String toString() {
		return "..";
	}
}
