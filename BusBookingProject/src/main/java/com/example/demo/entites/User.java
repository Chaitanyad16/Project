package com.example.demo.entites;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
	
	@Pattern(regexp="[6-9]{1}[0-9]{9}",message="Phone Number should be valid with 10 digits." )
	@Column(name="phone_number", unique=true,nullable=false)
	@Id
	private String phoneNumber;
	
	@Size(min=1,message="Full Name is required." )
	@Column(name="full_name",nullable=false)
	private String fullName;
	
	@Min(value=1,message="Age should be positive." )
	@Column(name="age",nullable=false)
	private int age;
	
	@NotNull(message=" Select Gender." )
	@Column(name="gender",nullable=false)
	private String gender;
	
	@Size(min=5,message="Password should be minimum 5 characters required." )
	@Column(name="password",nullable=false)
	private String password;
	
	@OneToMany(mappedBy="user")
	List<BookingDetails> bookings;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<BookingDetails> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingDetails> bookings) {
		this.bookings = bookings;
	}
	
	
	
	
}
