package test.java.com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import main.java.Contact;
import org.junit.jupiter.api.Test;



public class ContactTest {
// Our first test will check if the object contact is successfully created by comparing the object's current attributes with expected attributes	
	@Test
	void testContact() {
		Contact contact = new Contact("123456789", "Sebastian", "Jimenez", "7143530216", "123 House Drive");
		assertTrue(contact.getUniqueId().equals("123456789"));
		assertTrue(contact.getFirstName().equals("Sebastian"));
		assertTrue(contact.getLastName().equals("Jimenez"));
		assertTrue(contact.getPhoneNumber().equals("7143530216"));
		assertTrue(contact.getAddress().equals("123 House Drive"));
		}
// This test will check for a IllegalArgumentException throw whenever the unique id argument is too long	
	@Test
	void testContactUniqueIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		  new Contact("12345678901", "Sebastian", "Jimenez", "7143530216", "123 House Drive");
	});
	}
// This test will check for a IllegalArgumentException throw whenever the unique id argument is null	
	@Test
	void testContactUniqueIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Sebastian", "Jimenez", "7143530216", "123 House Drive");
	});
	}
// The following test methods will follow the same pattern as the previous two methods but with each contact attribute (Null and too long tests).
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		  new Contact("123456789", "Sebastianfdfddfd", "Jimenez", "7143530216", "123 House Drive");
	});
	}
	
	@Test
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Contact("123456789", null, "Jimenez", "7143530216", "123 House Drive");
	});
	}
	@Test
	void testContacLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		  new Contact("123456789", "Sebastian", "Jimenezfdfd", "7143530216", "123 House Drive");
	});
	}
	
	@Test
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "Sebastian", null, "7143530216", "123 House Drive");
	});
	}
	@Test
	void testContactPhoneNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		  new Contact("123456789", "Sebastian", "Jimenez", "71435302161234", "123 House Drive");
	});
	}
	
	@Test
	void testContactPhoneNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "Sebastian", "Jimenez", null, "123 House Drive");
	});
	}
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		  new Contact("123456789", "Sebastian", "Jimenez", "7143530216", "123 House Drivefffffffffffffffffffffffffffffff");
	});
	}
	
	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "Sebastian", "Jimenez", "7143530216", null);
	});
	}
}
