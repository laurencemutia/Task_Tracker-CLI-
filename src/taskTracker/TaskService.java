package taskTracker;

import java.util.ArrayList;

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
		
	}
	
	public void updateTask(int id, String desciption) {
		
	}
	
	public void deleteTask(String id) {
		
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
