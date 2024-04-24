package busBooking.view;

import java.util.Scanner;

import busBooking.Models.User;
import busBooking.controller.BusManagement;
import exceptions.NoInputException;

public class App 
{
	public static String loggedInUserPhone=null;
	
	static Scanner sc=new Scanner(System.in);
	
    public static User getUserDetails() {
    	try {
    		System.out.println("\nEnter the below Details");
    	    
        	System.out.printf("%10s : ","Full Name");
        	sc.nextLine();
        	String name=sc.nextLine();
        	if(name.trim().equals("")) {throw new NoInputException();}
        	
        	System.out.printf("%10s :","Age");
        	int age =sc.nextInt();
        	
        	System.out.printf("%10s :","Gender");
        	sc.nextLine();
        	String gender=sc.nextLine();
        	if(gender.trim().equals("")) {throw new NoInputException();}
        	
        	System.out.printf("%10s :","Phone Number");
        	String phNo=sc.nextLine();
        	if(phNo.trim().equals("")) {throw new NoInputException();}
        	
        	System.out.printf("%10s :","Set Password");
        	String pwd =sc.nextLine();
        	if(pwd.trim().equals("")) {throw new NoInputException();}
      
        	User newUser=new User(pwd,name,age,gender,phNo);
        	return newUser;
    	}catch(NoInputException e) {
    		System.out.println(e.getMessage());
    		return null;
    	}
    	
    }
    
   public static void main(String[] args) {
	   
	boolean quit=false;
	while (!quit) {
		System.out.println("\nEnter your choice:\n 1. Register New User\n 2. Login\n 3. Book a bus ticket\n 4. Show My Booking\n 5. Cancel ticket\n 6. Logout\n 7. Quit");
	    int choice =sc.nextInt();
	    BusManagement bm=new BusManagement();
	    switch(choice) {
	    case 1:
	    	User user = getUserDetails();
	    	if(user!=null) {
	    		UserRegistration.registerNewUser(user);
	    	}
	    	
	    	break;
	    
	    case 2: 
	    	loggedInUserPhone =null;
	    	System.out.print("Enter registered Phone Number:");
	    	String phNo=sc.next();
	    	System.out.print("Enter Password:");
	    	String pwd=sc.next();
	    	boolean loginSuccess=UserLogin1.login(phNo, pwd);
	    	if(loginSuccess) {
	    		loggedInUserPhone =phNo;
	    	}
	    	break;
	    case 3:
	    	if(loggedInUserPhone==null) {
	    		System.out.println("Login to your account.");
	    		break;	
	    	}
	    	else {
	    		bm.bookTicket(loggedInUserPhone);
	    	}
	    	break;
	    	
	    case 4:
	    	if(loggedInUserPhone==null) {
	    		System.out.println("Login to your account.");
	    		break;	
	    	}
	    	else {
	    		bm.showMyBookings(loggedInUserPhone);
	    	}
	    	break;    	
	    case 5:
	    	if(loggedInUserPhone==null) {
	    		System.out.println("Login to your account.");
	    		break;	
	    	}
	    	else {
	    	    bm.cancelTicket(loggedInUserPhone);
	    	}
	    	break;   	
	    case 6:
	    	
	    	loggedInUserPhone=null;
	    	break;
	    
	    case 7:
	    	quit=true;
	    	break;
	    }
	}
   }
}
    