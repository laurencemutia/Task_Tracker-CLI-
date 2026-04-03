package taskTracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

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
		
		//add time when it created
		LocalDateTime createdtime = LocalDateTime.now();
		
		//Add new task in arrayList and in the record
		tasks.add(new Task(id, description, "todo", createdtime, createdtime));
		System.out.println("[OK] Task Added. \nID: " + id);
	}
	
	public void updateTask(int id, String desciption) {
		
	}
	
	public void deleteTask(int id) {
		
		Iterator<Task> it = tasks.iterator(); //Iterator for arrayList
		boolean isFound = false;
		
		//if there is more elements in the list
		while(it.hasNext()) {
			Task t = it.next(); //get the next element
			if(t.id() == id) { //check if the element ID is same with userInput ID
				isFound = true;
				it.remove(); //Delete that element in the list
				System.out.println("Task deleted successfully.");
				return;
			}
		}
		
		if(!isFound) System.out.println("Task not found.");
		
	}
	
	public void markTask(int id, String status) {
		
	}
	
	public void listTasks() {
		//check if task is empty
		if(tasks.isEmpty()) {
			System.out.println("No Tasks"); 
			return;
		}
		
		//list all existing tasks
		for(Task t: tasks) {
			System.out.println("ID: " + t.id());
			System.out.println("description: " + t.description());
			System.out.println("status: " + t.status());
		}
		
	}
	
	public void saveToFile() {
		
	}
	
	public void loadFromFile() {
		
	}

}
