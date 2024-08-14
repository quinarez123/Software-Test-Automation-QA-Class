package test.java.com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import main.java.Task;
import org.junit.jupiter.api.Test;

class TaskTest {
// The following method will make sure that object is created properly by comparing attribute with expected result
// Used assertEquals method for a cleaner look than assertTrue 
	@Test
	void testTask() {
		Task task = new Task("123456789", "Clean bathroom", "You will clean the bathroom and scrub the floors");
		assertEquals(task.getUniqueTaskId(), "123456789");
		assertEquals(task.getTaskName(), "Clean bathroom");
		assertEquals(task.getTaskDescription(), "You will clean the bathroom and scrub the floors");
	}
	// The following method checks for an IllegalArgument by passing a long ID
	@Test
	void testUniqueTaskIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Task("1234567890123", "Clean bathroom", "You will clean the bathroom and scrub the floors");
	});
	}
	// The following checks for an Illegal Argument by passing a null ID
	@Test
	void testUniqueTaskIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Task(null, "Clean bathroom", "You will clean the bathroom and scrub the floors");
		});
	}
	// The following method checks for an Illegal Argument by passing it a long task name
	@Test
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Task("123456789", "Clean bathroomdddddddddddddddddddddddddddddddddddddddddddddddddddddd", "You will clean the bathroom and scrub the floors");
		});
	}
	// The following method will check for an Illegal Argument by passing a null task name argument
	@Test
	void testTaskNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Task("123456789", null, "You will clean the bathroom and scrub the floors");
		});
	}
	// The following method will check for an Illegal Argument by passing a long task description
	@Test
	void testUTaskDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Task("123456789", "Clean bathroom", "You will clean the bathroom and scrub the floorsffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
		});
	}
	// The following will check for an Illegal Argument by passing a null task description
	@Test
	void testTaskDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Task("123456789", "Clean bathroom", null);
		});
	}
}
	