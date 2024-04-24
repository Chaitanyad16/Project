package com.example.demo.entites;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bus_availability")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BusAvailability {
	
	@EmbeddedId
	private BusAvailabilityKey availabilityKey;
	
	private  int seaterSeats;
	private int sleeperSeats;
	
	@Override
	public String toString() {
		return "BusAvailability [availabilityKey=" + availabilityKey + ", seaterSeats=" + seaterSeats
				+ ", sleeperSeats=" + sleeperSeats + "]";
	}

	
	public int getSeatsCountByType(String type) {
		switch(type) {
			case "sleeper":
				return sleeperSeats;
				
			case "seater":
				return seaterSeats;
		
			default:
				return -1;
		}
	}

	

}




