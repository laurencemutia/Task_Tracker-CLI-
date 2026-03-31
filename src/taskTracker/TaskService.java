package taskTracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

import model.Task;

public class TaskService {

	private ArrayList<Task> tasks;
	
	public TaskService(ArrayList<Task> tasks){
		this.tasks = tasks;
	}
	
	public void help() {
		System.out.println("\nAvailable Commands: ");
		System.out.println("------------------------------------");
		System.out.println("add \"description\" "
				+ "\nupdate <id> \"new description\" "
				+ "\ndelete <id> "
				+ "\nmark-in-progress <id> "
				+ "\nmark-done <id> "
				+ "\nlist "
				+ "\nlist done "
				+ "\nlist todo "
				+ "\nlist in-progress "
				+ "\nexit");
		System.out.println("------------------------------------");
	}
	
	public void addTask(String description) {
		int maxId = 0;
		
		//check is description is not empty
		if(description == null || description.isEmpty()) {
			System.out.println("Description must not be empty.");
			return;
		}
		
		//get maxId if have existing tasks
		for(Task t: tasks) {
			if(t.id() > maxId) {
				maxId = t.id();
			}
		}
		
		//provide ID
		int id = maxId + 1;
		
		//Add new task in arrayList and in the record
		tasks.add(new Task(id, description, "todo", LocalDateTime.now(), LocalDateTime.now()));
	}
	
	public void updateTask(int id, String desciption) {
		
	}
	
	public void deleteTask(int id) {
		
	}
	
	public void markTask(int id, String status) {
		
	}
	
	public void listTasks() {
		
	}
	
	public void saveToFile() {
		
	}
	
	public void loadFromFile() {
		
	}
}
