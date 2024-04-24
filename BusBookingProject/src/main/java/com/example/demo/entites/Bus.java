package com.example.demo.entites;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="buses")
public class Bus {
	
@Id
 private int busNumber;
 private String name;
 private String source;
 private String destination;
 private float seaterPrice;
 private float sleeperPrice;
 
 @OneToMany(mappedBy="availabilityKey.bus",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
 List<BusAvailability> availabilities;

 
 
 
}



