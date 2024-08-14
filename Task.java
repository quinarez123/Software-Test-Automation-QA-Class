package main.java;

public class Task {
	// Variable declaration
	final String uniqueTaskId;
	String taskName;
	String taskDescription;
	
	// The task constructor takes three arguments, ID, task name, and task description
	public Task(String uniqueTaskId, String taskName, String taskDescription) {
		// THe following will throw an exception if the ID is too long or null
		if (uniqueTaskId == null || uniqueTaskId.length() > 10) {
			throw new IllegalArgumentException("Invalid ID try again");
		}
		this.uniqueTaskId = uniqueTaskId;
		// Method declaration
		setTaskName(taskName);
		setTaskDescription(taskDescription);
		
	}
	// The following two methods are setters.
	void setTaskName(String taskName) {
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid task name, please try again");
		}
		this.taskName = taskName;
	}
	// Setter method
	void setTaskDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid task description, please try again");
		}
		this.taskDescription = taskDescription;
	}
	// The following three methods are getter methods
	public String getTaskName() {
		return this.taskName;
	}
	// Getter method
	public String getTaskDescription() {
		return this.taskDescription;
	}
	// Getter method
	public String getUniqueTaskId() {
		return this.uniqueTaskId;
	}

}
