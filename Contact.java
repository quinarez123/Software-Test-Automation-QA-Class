package main.java;


public class Contact {
// Declared variables
	final String uniqueId;
	String firstName;
	String lastName;
	String phoneNumber;
	String address;
// The constructor is created and will validate the uniqueId parameter
	public Contact(String uniqueId, String firstName, String lastName, String phoneNumber, String address) {	
// The following checks for uniqueId to be null or longer than 10 characters and throws the exception	
		if (uniqueId == null || uniqueId.length() > 10) {
			throw new IllegalArgumentException("Invalid ID, try again");
		}
		this.uniqueId = uniqueId;
// Declaration of setters		
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setAddress(address);
		
		
	}
// 'first name' setter that throws exception if first name is null or longer than 10 characters	
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name, try again");
		}
		this.firstName = firstName;
	}
// Last name setter that throws exception if last name is null or longer than 10 characters
	public void setLastName(String lastName) {
			if (lastName == null || lastName.length() > 10) {
				throw new IllegalArgumentException("Invalid Last Name, try again");
			}
			this.lastName = lastName;
	}
// Phone number setter that throws an exception if phone number is null or not 10 characters
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number, try again");
		}
		this.phoneNumber = phoneNumber;
	}
// Address setter that throws an exception if address is null or longer than 30 characters
	public void setAddress(String address){
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address, try again");
		}
		this.address = address;
	}
// The following 5 methods are getter methods for the variables
	public String getFirstName() {
		return this.firstName; 
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public String getAddress() {
		return this.address;
	}
	public String getUniqueId() {
		return this.uniqueId;
	}
	
	
	
		
}

