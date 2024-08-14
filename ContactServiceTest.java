package test.java;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import main.java.ContactService;
import main.java.Contact;

public class ContactServiceTest {
// This test checks to see if contact element was added properly
	@Test
	public void testAddContact() throws Throwable {
// Create a fake contact element to insert into linked list
		Contact dummyNewContact = new Contact("123456789", "Sebastian", "Jimenez", "7143530216", "123 House Drive");
		
		ContactService fakeInstance = new ContactService();
		fakeInstance.addContact(dummyNewContact);
// Statement that checks whether the list contains the new contact that was added
		assertTrue(fakeInstance.contactList.contains(dummyNewContact));
		}
// The following method will check that a object is properly added to contact list whenever there is already a element in there.
	@Test
	public void contactIsNotFirstInList() throws Throwable {
		Contact dummyNewContact = new Contact("123456789", "Sebastian", "Jimenez", "7143530216", "123 House Drive");
		Contact dummyNewContact2 = new Contact("987654321", "Johnny", "Herrera", "7141231234", "321 Mansion Drive");
		ContactService fakeInstance = new ContactService();
		fakeInstance.addContact(dummyNewContact);
		fakeInstance.addContact(dummyNewContact2);
// This statement will verify that New contact was added properly when there is already another contact in list by
// checking the second element in the list.
		assertEquals(fakeInstance.contactList.get(1), dummyNewContact2);
		
	}
// The following method will check to verify that a object is not added to the list when there already exists an element with the same unique Id in order to avoid duplicate contacts.
	@Test
	public void contactAlreadyExists() throws Throwable {
		Contact dummyNewContact = new Contact("123456789", "Sebastian", "Jimenez", "7143530216", "123 House Drive");
		ContactService fakeInstance = new ContactService();
		fakeInstance.addContact(dummyNewContact);
// We are preventing the second contact with duplicate id from getting added to the linked list	
		Contact dummyNewContact2 = new Contact("123456789", "Sebastian", "Jimenez", "7143530216", "123 House Drive");
		fakeInstance.addContact(dummyNewContact2);
		
// This statement will verify that the duplicate contact does not get added to the database
		assertFalse(fakeInstance.contactList.contains(dummyNewContact2));
	}
// The following test method will verify to make sure that a contact element gets deleted properly	
	@Test
	public void testDeleteContact() throws Throwable {
		String dummyUniqueId = "123456789";
		Contact dummyContact = new Contact("123456789", "Sebastian", "Jimenez", "7143530216", "123 House Drive");
		
	
		ContactService fakeInstance = new ContactService();
		fakeInstance.addContact(dummyContact);
		fakeInstance.deleteContact(dummyUniqueId);
// The following statement will return true if the contact element is not present due to deletion.		
		assertFalse(fakeInstance.contactList.contains(dummyContact));
		
	}
// The following method will verify that code runs smoothly even when the search unique id doesn't match with any of the  element's unique id.
// This will test several methods since the methods are called with the unique id as a search parameter.
	@Test
	public void uniqueIdDoesNotMatch() {
		Contact dummyContact = new Contact("123456789", "Sebastian", "Jimenez", "7143530216", "123 House Drive");
		String wrongDummyUniqueId = "987654321";
	
		
		ContactService fakeInstance = new ContactService();
		fakeInstance.addContact(dummyContact);
		fakeInstance.deleteContact(wrongDummyUniqueId);
		fakeInstance.updateFirstName(wrongDummyUniqueId, "Johnny");
		fakeInstance.updateLastName(wrongDummyUniqueId, "Herrera");
		fakeInstance.updatePhoneNumber(wrongDummyUniqueId, "7141999999");
		fakeInstance.updateAddress(wrongDummyUniqueId, "321 Mansion Drive");
// The following methods will assert whether previous methods work as intended even when the search unique id doesn't match with any of the lists' elements
		assertTrue(fakeInstance.contactList.contains(dummyContact));
		assertEquals(fakeInstance.contactList.get(0).getFirstName(), "Sebastian");
		assertEquals(fakeInstance.contactList.get(0).getLastName(), "Jimenez");	
		assertEquals(fakeInstance.contactList.get(0).getPhoneNumber(), "7143530216");
		assertEquals(fakeInstance.contactList.get(0).getAddress(), "123 House Drive");
	}
// The following method will verify whether the updateFirstName method properly changes an element's first name
	@Test
	public void testUpdateFirstName() throws Throwable {
		String dummyUniqueId = "123456789";
		String newFirstName = "Johnny";
		Contact dummyContact = new Contact("123456789", "Sebastian", "Jimenez", "7143530216", "123 House Drive");
		
		ContactService fakeInstance = new ContactService();
		fakeInstance.addContact(dummyContact);
		fakeInstance.updateFirstName(dummyUniqueId, newFirstName);
// The following statement tracks the contact element by assigning the index to a variable for retrieval later
		int updatedContactIndex = fakeInstance.contactList.indexOf(dummyContact);
// 	The following statement compares the current element's first name with desired first name to make sure that they match.
		assertTrue(fakeInstance.contactList.get(updatedContactIndex).getFirstName().equals(newFirstName));
	}
// The following three methods work exactly like the previous testUpdateFirstName but with different attributes (testUpdateLastName, testUpdatePhoneNumber, testUpdateAddress)
	@Test
	public void testUpdateLastName() throws Throwable {
		String dummyUniqueId = "123456789";
		String newLastName = "Herrera";
		Contact dummyContact = new Contact("123456789", "Sebastian", "Jimenez", "7143530216", "123 House Drive");
		
		ContactService fakeInstance = new ContactService();
		fakeInstance.addContact(dummyContact);
		fakeInstance.updateLastName(dummyUniqueId, newLastName);
		int updatedContactIndex = fakeInstance.contactList.indexOf(dummyContact);
		
		assertTrue(fakeInstance.contactList.get(updatedContactIndex).getLastName().equals(newLastName));
		
	}
	@Test
	public void testUpdatePhoneNumber() throws Throwable {
		String dummyUniqueId = "123456789";
		String newPhoneNumber = "7143531000";
		Contact dummyContact = new Contact("123456789", "Sebastian", "Jimenez", "7143530216", "123 House Drive");

		ContactService fakeInstance = new ContactService();
		fakeInstance.addContact(dummyContact);
		fakeInstance.updatePhoneNumber(dummyUniqueId, newPhoneNumber);
		int updatedContactIndex = fakeInstance.contactList.indexOf(dummyContact);
		
		assertTrue(fakeInstance.contactList.get(updatedContactIndex).getPhoneNumber().equals(newPhoneNumber));
		
	}
	@Test
	public void testUpdateAddress() throws Throwable {
		String dummyUniqueId = "123456789";
		String newAddress = "321 Mansion Drive";
		Contact dummyContact = new Contact("123456789", "Sebastian", "Jimenez", "7143530216", "123 House Drive");

		ContactService fakeInstance = new ContactService();
		fakeInstance.addContact(dummyContact);
		fakeInstance.updateAddress(dummyUniqueId, newAddress);
		int updatedContactIndex = fakeInstance.contactList.indexOf(dummyContact);
		
		assertTrue(fakeInstance.contactList.get(updatedContactIndex).getAddress().equals(newAddress));
		
	}
	
		
	}
	


