package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import main.java.Task;
import main.java.TaskService;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	// Declaration of instance object
	TaskService fakeInstance;
	// Declaration of linked list objects
	Task dummyTask;
	// Declaration of variables
	String dummyUniqueTaskId;
	
	// The following method will setup the variables and objects for every test
	@BeforeEach
	public void setup() {
		// Initialize Instance of TaskService
		fakeInstance = new TaskService();
		// Initialize variable
		dummyUniqueTaskId = "123456789";
		// Initialize linked list objects that will be used for testing
		dummyTask = new Task("123456789", "Clean bathroom", "You will clean the bathroom and scrub the floors");
		// A task will be added to the task list
		fakeInstance.addTask(dummyTask);
	

	}
	// The following test will verify whether task was added properly to linked list
	@Test
	public void testAddTask() throws Throwable {
		// The following will verify whether task object "dummyTask" was added to the linked list
		assertTrue(fakeInstance.taskList.contains(dummyTask));
		
		}
	// The following will check to verify that addMultipleTasks() method will add a variable amount of task objects, regardless of the the number 
	@Test
	public void addMultipleTasksTest() throws Throwable {
		Task dummyTask2 = new Task("123456780", "Clean bathroom", "You will clean the bathroom and scrub the floors");
		Task dummyTask3 = new Task("123456781", "Clean kitchen", "You will clean the bathroom and scrub the floors");
		Task dummyTask4 = new Task("123456782", "Clean garden", "You will clean the bathroom and scrub the floors");
		Task dummyTask5 = new Task("123456783", "Clean garage", "You will clean the bathroom and scrub the floors");
		
		fakeInstance.addMultipleTasks(dummyTask, dummyTask2, dummyTask3, dummyTask4, dummyTask5);
		// The following assertions will show that all of our objects were properly added
		assertTrue(fakeInstance.taskList.contains(dummyTask));
		assertTrue(fakeInstance.taskList.contains(dummyTask2));
		assertTrue(fakeInstance.taskList.contains(dummyTask3));
		assertTrue(fakeInstance.taskList.contains(dummyTask4));
		assertTrue(fakeInstance.taskList.contains(dummyTask5));

		
	}
	
	// The following test will verify whether task object gets added properly even if list has an object at index 0
	@Test
	public void taskIsNotFirstInList() throws Throwable {
		// Initializing second object to be added to list
		Task dummyTask2 = new Task("987654321", "Clean kitchen", "You will clean the kitchen and scrub the floors");
		// The following adds 2nd object to list
		fakeInstance.addTask(dummyTask2);
		// The following checks whether second object was added to second index
		assertEquals(fakeInstance.taskList.get(1), dummyTask2);
		
	}
	// The following test will check whether there is an already existing element task with the same ID and will prevent duplicate elements from being added
	@Test
	public void taskAlreadyExists() throws Throwable {	
		// 2nd duplicate object initialized
		Task dummyNewTask2 = new Task("123456789", "Clean bathroom", "You will clean the bathroom and scrub the floors");
		// Attempts to add the 2nd duplicate object
		fakeInstance.addTask(dummyNewTask2);
		// Asserts whether the 2nd duplicate object is not in the task list
		assertFalse(fakeInstance.taskList.contains(dummyNewTask2));
	}
	// The following test will check whether element was properly deleted from task list
	@Test
	public void testDeleteTask() throws Throwable {
		// Calls upon deleteTask method from TaskService class with Task ID as the search parameter
		fakeInstance.deleteTask(dummyUniqueTaskId);
		// The following will be true if the deleted task is not in the list
		assertFalse(fakeInstance.taskList.contains(dummyTask));
		
	}
	// The following method checks to see if code runs smoothly after "if (task.uniqueTaskId == uniqueTaskId)" is false for multiple methods
	@Test
	public void uniqueTaskIdDoesNotMatch() {
		// Initialization of an unknown task ID
		String wrongDummyUniqueTaskId = "987654321";
		// unknown task ID is used as a search parameter.
		fakeInstance.deleteTask(wrongDummyUniqueTaskId);
		fakeInstance.updateTaskName(wrongDummyUniqueTaskId, "Clean the kitchen");
		fakeInstance.updateTaskDescription(wrongDummyUniqueTaskId, "Clean the kitchen and scrub the floors thoroughly");
		fakeInstance.getTaskInfo(wrongDummyUniqueTaskId);
		// Verifies that tests were not executed due to an unknown task ID
		assertTrue(fakeInstance.taskList.contains(dummyTask));
		assertEquals(fakeInstance.taskList.get(0).getTaskName(), "Clean bathroom");
		assertEquals(fakeInstance.taskList.get(0).getTaskDescription(), "You will clean the bathroom and scrub the floors");
	}
	// The following method will check if task name was properly updated
	@Test
	public void testUpdateTaskName() throws Throwable {
		// Initialization of new task name
		String newTaskName = "Clean the kitchen";
		String updatedTaskName;
		// Calls upon the update method
		fakeInstance.updateTaskName(dummyUniqueTaskId, newTaskName);
		// We'll want the index of the manipulated element for retrieval in the next line
		int updatedTaskIndex = fakeInstance.taskList.indexOf(dummyTask);
		// Retrieves the name of the updated task name for comparison
		updatedTaskName = fakeInstance.taskList.get(updatedTaskIndex).getTaskName();
		// compares the current task name with desired task name
		assertEquals(updatedTaskName, newTaskName);
	}
		// Checks to see if task description was properly updated
		@Test 
		public void testUpdateTaskDescription() throws Throwable {
		// We will use this task description to replace the current one
		String newTaskDescription = "You will clean the kitchen and scrub the floors";
		String updatedTaskDescription;
		// The following calls on  the updateTaskDescription method with the replacement description as one of the arguments
		fakeInstance.updateTaskDescription(dummyUniqueTaskId, newTaskDescription);
		int updatedTaskIndex = fakeInstance.taskList.indexOf(dummyTask);
		// Retrieves the name of the updated task description for comparison
		updatedTaskDescription = fakeInstance.taskList.get(updatedTaskIndex).getTaskDescription();
		// compares the current task description with desired task name
		assertEquals(updatedTaskDescription, newTaskDescription);
		
	}
		// The following method will return the task attributes in a formatted manner by using a search ID.
		@Test
		public void getTaskInfoTest() throws Throwable {
			String expectedPrompt = "\nTask name: Clean bathroom";
			expectedPrompt += "\nTask Description: You will clean the bathroom and scrub the floors";
			expectedPrompt += "\nTask ID: 123456789";
			// Calls on the getTaskInfo() method with a matching ID
			String prompt = fakeInstance.getTaskInfo(dummyUniqueTaskId);
			assertEquals(prompt, expectedPrompt);
		}
		// A teardown method that will reset the instance
		@AfterEach
		public void teardown() {
			fakeInstance = null;
		}
}