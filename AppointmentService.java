package main.java;

import java.util.LinkedList;

public class AppointmentService {
	// Created a linked list for dynamic addition and deletion of objects
	public LinkedList<Appointment> appointmentList = new LinkedList<Appointment>();
	// Adds an appointment by passing the an appointment class object and an ID
	public void addAppointment(Appointment newAppointment) {
		// For loop that looks for a duplicate ID and exits to prevent from duplicate objects being added
		for (Appointment appointment : appointmentList) {
			if (newAppointment.getAppointmentId() == appointment.appointmentId) {
				System.out.println("That appointment already exists, please enter another one");
				return;
			}
		}
		// If no duplicate ID exists yet then this code will be executed, along with a confirmation message
			appointmentList.add(newAppointment);
	}
	// The following will delete any appointments with the appointment ID
	public void deleteAppointment(String appointmentId) {
		// Declaration of a boolean variable used for confirmation of found appointment
		Boolean appointmentIsFound = false;
		// For loop that will search for a appointment with a matching ID for removal.
		for (Appointment appointment : appointmentList ) {
			if (appointment.appointmentId == appointmentId) {
				System.out.println("Appointment ID: " + appointmentId + " deleted");
				appointmentList.remove(appointment);
				// Boolean becomes true only if appointment is found
				appointmentIsFound = true;
			}
		}
		// If no appointment is found the boolean stays false, thus triggering this code.
		if (appointmentIsFound == false) {
			System.out.println("No matching appointment was found, please try again");
		}
	}
}
