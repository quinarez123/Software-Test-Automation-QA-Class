package main.java;

import java.util.LinkedList;
// Contact Service class
public class ContactService {
	
// Chose a Linked list since I need a dynamic data structure for adding and deleting contacts
	public LinkedList<Contact> contactList = new LinkedList<Contact>();
	
	
// Adds a contact by uniqueId
	public void addContact(Contact newContact) {
// This for loop will check the contactList (linked list) for any elements with the same unique
//ID as our newContact before adding the Contact type element
// if same uniqueId is found then new contact object will not be added and exits method
		for (Contact contact : contactList) {
			if (newContact.uniqueId == contact.uniqueId) {
				System.out.println("That contact already exists");
				return;
			}
		
				
		}
// Checks to see if contactList is empty so it can add it to the front or else
// just simply adds it
		if (contactList.isEmpty()) {
			contactList.addFirst(newContact);
		}
		else {
			contactList.add(newContact);
		}
	}
// Code that deletes a contact with unique ID
	public void deleteContact(String uniqueId) {
// Checks to see if there is a matching contact, if there is then it deletes it from the linked list
		for (Contact contact : contactList) {
			if (contact.uniqueId == uniqueId) {
				contactList.remove(contact);
			}
		
		}
		}
	
// Code that updates first name
	public void updateFirstName(String uniqueId, String updatedFirstName) {
		String oldFirstName = null;
// 'for loop' will try and look for the search uniqueId and when it finds it in the list the setter method will be called with a new name to replace old name	
		for (Contact contact : contactList) {
			if (contact.getUniqueId() == uniqueId) {
				oldFirstName = contact.getFirstName();
				contact.setFirstName(updatedFirstName);
// Prints statement for feedback to let user know that name was properly changed
				System.out.println("Your first name was changed from " + oldFirstName + " to " + contact.getFirstName());
			}
		}
	}
// Code that updates last name
	public void updateLastName(String uniqueId, String updatedLastName) {
		String oldLastName = null;
// Similar for loop as updateFirstName method but will update last name instead of first name	
		for (Contact contact : contactList) {
			if (contact.getUniqueId() == uniqueId) {
				oldLastName = contact.getLastName();
				contact.setLastName(updatedLastName);
				System.out.println("Your last name was changed from " + oldLastName + " to " + contact.getLastName());
			}
		}
	}
// Code that updates last name
	public void updatePhoneNumber(String uniqueId, String updatedPhoneNumber) {
		String oldPhoneNumber = null;
//Similar for loop as updateFirstName method but will update phone number instead of first name		
		for (Contact contact : contactList) {
			if (contact.getUniqueId() == uniqueId) {
				oldPhoneNumber = contact.getPhoneNumber();
				contact.setPhoneNumber(updatedPhoneNumber);
				System.out.println("Your phone number was changed from " + oldPhoneNumber + " to " + contact.getPhoneNumber());
			}
		}
	}
// Code that updates address
	public void updateAddress(String uniqueId, String updatedAddress) {
		String oldAddress = null;
// Similar for loop as updateFirstName but will update address instead of first name
		for (Contact contact : contactList) {
			if (contact.getUniqueId() == uniqueId) {
				oldAddress = contact.getAddress();
				contact.setAddress(updatedAddress);
				System.out.println("Your address was changed from " + oldAddress + " to " + contact.getAddress());
			}
		}
	}

}
