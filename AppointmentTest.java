package test.java.com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import main.java.Appointment;
import org.junit.jupiter.api.Test;
import java.time.*;

class AppointmentTest {
	// LocalDate variables are declared to be used with the appointment date system
	LocalDate appointmentDate = LocalDate.of(2024, 9, 9);
	LocalDate expectedAppointmentDate = LocalDate.of(2024, 9, 9);
	LocalDate datePast = LocalDate.of(2024, 5, 5);
	LocalDate today = LocalDate.now();
	
	// The following will test for proper execution of the constructor
	@Test
	void testAppointment() {
		Appointment appointment = new Appointment("123456789", appointmentDate, "Root canal");

		assertEquals(appointment.getAppointmentId(), "123456789");
		assertEquals(appointment.getAppointmentDate(),expectedAppointmentDate);
		assertEquals(appointment.getAppointmentDescription(), "Root canal");
	};
	// The following will test if ID is too long
	@Test
	void testAppointmentIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789012345", appointmentDate, "Root canal");
		});
	}
	// The following will test is the ID is null
	@Test
	void testAppointmentIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, appointmentDate, "Root canal");
		});
	}
	// The following will if appointment is in the past (May 5 2024)
	@Test
	void testAppointmentDatePast() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789", datePast, "Root canal");
		});
	}
	// The following will test if the appointment date is null
	@Test
	void testAppointmentDateNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789", null, "Root canal");
		});
	}
	// The following will test if appointment description is too long
	@Test
	void testAppointmentDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789", appointmentDate, "Root Canalddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
		});
	}
}
