package busBooking.Models;

public class User {
	private String password;
	private String fullName;
	private int age;
	private String gender;
	private String phoneNumber;
	
	
	public User(String password, String fullName, int age, String gender, String phoneNumber) {
		super();
		
		this.password = password;
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}
