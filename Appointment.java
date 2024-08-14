package main.java;
// Imports of packages needed
// Decided to import the java.time package instead of date due to it being more recent
import java.time.*;

public class Appointment {
	// Variable declarations along with a new form of class type LocalDate.
	final String appointmentId;
	LocalDate appointmentDate = null;
	String appointmentDescription;
	LocalDate today = LocalDate.now();
	// Appointment constructor with 2 string and LocalDate parameters
	public Appointment(String appointmentId, LocalDate appointmentDate, String appointmentDescription) {
		// An exception for an invalid appointment ID
		if (appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Invalid Appointment ID, try again");
		}
		// Sets the appointment ID
		this.appointmentId = appointmentId;
		// Setter method declarations
		setAppointmentDate(appointmentDate);
		setAppointmentDescription(appointmentDescription);
	}
	// Defines the appointment date setter of type LocalDate
	void setAppointmentDate(LocalDate appointmentDate) {
		// An exception if an appointment date is null or is before today
		if (appointmentDate == null || appointmentDate.isBefore(today)) {
			throw new IllegalArgumentException("Invalid date, please try another one");
		}
		this.appointmentDate = appointmentDate;
	}
	// Defines the setter method and sets the appointment description
	void setAppointmentDescription(String appointmentDescription) {
		// An exception is thrown if the appointment description is null or longer than 50 characters
		if (appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid appointment description, please try again");
		}
		this.appointmentDescription = appointmentDescription;
	}
	// The following three methods are getters
	public String getAppointmentId() {
		return this.appointmentId;
	}
	public LocalDate getAppointmentDate() {
		return this.appointmentDate;
	}
	public String getAppointmentDescription() {
		return this.appointmentDescription;
	}
	}

