package test.java.com;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import main.java.Appointment;
import main.java.AppointmentService;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	LocalDate appointmentDate = LocalDate.of(2024, 9, 9);
	AppointmentService fakeInstance;
	Appointment newAppointment;
	String testId;
	// The following is the setup method to initialize the instance with an object an a variable
	@BeforeEach
	void setup() {
		fakeInstance = new AppointmentService();
		testId = "123456789";
		newAppointment = new Appointment("123456789", appointmentDate, "Root canal");
		fakeInstance.addAppointment(newAppointment);
	}
	// The following will verify whether the appointment list contains the appointment that we wanted to add.
	@Test 
	public void testAddAppointment() throws Throwable {
		assertTrue(fakeInstance.appointmentList.contains(newAppointment));
	}
	// The following will verify that an appointment has been properly deleted
	@Test
	public void testDeleteAppointment() throws Throwable {
		// The delete appointment method will be called by passing it a test ID matching the ID of the appointment that we want to delete
		fakeInstance.deleteAppointment(testId);
		// The following assertions will check whether the appointment list contains our deleted appointment, if not then it returns true.
		assertFalse(fakeInstance.appointmentList.contains(newAppointment));
	}
	// The following will test a test case where user wants to add a appointment but a duplicate appointment already exists.
	@Test
	public void duplicateAppointmentExists() throws Throwable {
		// A new object is created to attempt to add it to the appointment list
		Appointment duplicateAppointment = new Appointment("123456789", appointmentDate, "This is a duplicate ID appointment");
		// Calls the add appointment method and passing the duplicate appointment object
		fakeInstance.addAppointment(duplicateAppointment);
		// The following will return true if duplicate appointment is not in our list
		assertFalse(fakeInstance.appointmentList.contains(duplicateAppointment));
	}
	// The following test will test a branch in the delete appointment method where a matching ID is not found
	@Test
	public void matchingIdNotFound() throws Throwable {
		// Variable declaration that will be used in the delete method
		String nonMatchingId = "123456780";
		// Call delete appointment and passing a unknown ID
		fakeInstance.deleteAppointment(nonMatchingId);
		// The following assertion is to check that the appointment objects still exists in the list and hasn't been deleted.
		assertTrue(fakeInstance.appointmentList.contains(newAppointment));
		
	}
	// A method that resets the instance after every test
	@AfterEach
	public void teardown() {
		fakeInstance = null;
	}
}
