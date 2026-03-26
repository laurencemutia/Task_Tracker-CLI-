package taskTracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import model.Task;

public class Main {

	public static void main(String[] args) {
		Gson gson = new Gson();
		StringBuilder taskJson = new StringBuilder();
		ArrayList<Task> tasks = new ArrayList<>();
		
		//load json file and read each line 
		try(BufferedReader reader = new BufferedReader(new FileReader("task.json"))) {
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
		for(int i = 0; i < arrayOfTask.length; i++) {
			tasks.add(arrayOfTask[i]); 
		}
		
	}
}
