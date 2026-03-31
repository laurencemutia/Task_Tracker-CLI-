package taskTracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

import model.Task;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Gson gson = new Gson();
		StringBuilder taskJson = new StringBuilder();
		ArrayList<Task> tasks = new ArrayList<>();
		
		System.out.println("====================================");
		System.out.println("\tTASK TRACKER SYSTEM");
		System.out.println("====================================");
		
		//load json file and read each line 
		try(BufferedReader reader = new BufferedReader(new FileReader("task.json"))) {
			System.out.println("Loading tasks from a file...");
			String line;
			while((line = reader.readLine()) != null) {
				taskJson.append(line); //append to stringbuilder to convert as java object
			}
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		String taskToString = taskJson.toString();// convert to string 
		Task[] arrayOfTask = gson.fromJson(taskToString, Task[].class); //convert json to object
		
		//transfer objects into arraylist
		if(!(arrayOfTask == null || arrayOfTask.length == 0)) {
			System.out.println("\n[OK] " + arrayOfTask.length + " tasks loaded.");
			for(int i = 0; i < arrayOfTask.length; i++) {
				tasks.add(arrayOfTask[i]); 
			}
		}
		else {
			System.out.println("\n[OK] No current tasks loaded.");
		}
		
		System.out.println("\nType 'help' to see available commands");
		boolean isExit = false;
		
		TaskService taskService = new TaskService(tasks);
		
		//Program Loop
		do {
			System.out.print("\n> ");
			String userInput = scan.nextLine().trim(); //user input and trim spaces after
			String regex = "[\s]";
			String[] commandArray = userInput.split("[\s]"); //split words using spaces
			String firstWord = commandArray[0].toLowerCase();//get first word in command array
			
			//check if first word is not empty
			if(!firstWord.isEmpty()) {
				switch(firstWord) {
				case "help": taskService.help();
					break;
				case "add": System.out.println("add"); //just testing 
					break;
				case "update": System.out.println("update");
					break;
				case "delete": System.out.println("delete");
					break;
				case "mark-in-progress": System.out.println("mark in progress");
					break;
				case "mark-done": System.out.println("mark-done");
					break;
				case "list": System.out.println("list");
					break;
				case "exit": isExit = true;
					break;
				default: System.out.println("Command not Found! Please see the available commands again using 'help'");
				}
			}
			else {
				System.out.println("Error! Command is Empty. See the available commands using 'help'");
			}
		} while(!isExit);
		
		
		
		scan.close();
	}
}
