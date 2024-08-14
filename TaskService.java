package main.java;

import java.util.LinkedList;


public class TaskService {
	// Used a linked list to store tasks due to its dynamic nature
	public LinkedList<Task> taskList = new LinkedList<Task>();
	// The following method will add a task by passing it a task object
	public void addTask(Task newTask) {
		// Will iterate through the task list in order to check for any duplicates and exiting if one similar is found
		for (Task task : taskList) {
			if (newTask.uniqueTaskId == task.uniqueTaskId) {
				System.out.println("That task already exists, please enter another one");
				return;
			}
			
		}
			// The following will add the object to the first index in the list
			if(taskList.isEmpty()) {
				taskList.addFirst(newTask);
			}
			// Else statement that adds the object to the next index available
			else {
				taskList.add(newTask);
			}
		}
	// The following method will delete a task element from the list by passing it a ID
	public void deleteTask(String uniqueTaskId) {
		// Iterates through the task list in order to find matching ID, if found then task element will be deleted
		for (Task task :taskList) {
			if (task.uniqueTaskId == uniqueTaskId) {
				taskList.remove(task);
			}
		}
	
	}
	// The following will add multiple task objects by using a variable argument
	public void addMultipleTasks(Task ...newTask) {
		// The following will go through the newTask objects that were passed to the method and add them to the task list with each iteration.
		for (Task task : newTask) {
				taskList.add(task);
				// A message will print of each task name for verification of list addition
				System.out.println("Task: " + task.getTaskName() + " has been added");
				}	
			}
	// The following method will update task name by passing a ID and new task name.
	public void updateTaskName(String uniqueTaskId, String updatedTaskName) {
		// Declaration of variables
		String oldTaskName = null;
		// For statement that will iterate through the task list and gets original task name to assign to a variable
		// We call the setTaskName() method with the desired new name as a argument
		// I then print out a statement confirming the change from the old name to new name.
		for (Task task : taskList) {
			if (task.getUniqueTaskId() == uniqueTaskId) {
				oldTaskName = task.getTaskName();
				task.setTaskName(updatedTaskName);
				System.out.println("Your task name was changed from " + oldTaskName + " to " + task.getTaskName());
				
			}
		}
	}
	// The following method will work the same as the previous updateTaskName() but with the task description instead
	public void updateTaskDescription(String uniqueTaskId, String updatedTaskDescription) {
		String oldTaskDescription = null;
		
		for (Task task : taskList) {
			if (task.getUniqueTaskId() == uniqueTaskId) {
				oldTaskDescription = task.getTaskDescription();
				task.setTaskDescription(updatedTaskDescription);
				System.out.println("Your task description was changed from " + oldTaskDescription + " to " + task.getTaskDescription());

			}
		}
	}
	public String getTaskInfo(String uniqueTaskId) {
		String prompt = null;;
		// For loop that iterates through the task list to find a matching ID, once found then the method will return the results from the search.
		for (Task task : taskList) {
			if (task.getUniqueTaskId() == uniqueTaskId) {
				prompt = "\nTask name: " + task.getTaskName().toString();
				prompt += "\nTask Description: " + task.getTaskDescription().toString();
				prompt += "\nTask ID: " + task.getUniqueTaskId().toString();
				System.out.println(prompt);

			}
		}
		return prompt;
	}
}
