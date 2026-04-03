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

        // Load JSON file
        try (BufferedReader reader = new BufferedReader(new FileReader("task.json"))) {
            System.out.println("Loading tasks from a file...");
            String line;
            while ((line = reader.readLine()) != null) {
                taskJson.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert JSON → objects
        String taskToString = taskJson.toString();
        Task[] arrayOfTask = gson.fromJson(taskToString, Task[].class);

        // Transfer to ArrayList
        if (arrayOfTask != null && arrayOfTask.length > 0) {
            System.out.println("\n[OK] " + arrayOfTask.length + " tasks loaded.");
            for (Task t : arrayOfTask) {
                tasks.add(t);
            }
        } else {
            System.out.println("\n[OK] No current tasks loaded.");
        }

        System.out.println("\nType 'help' to see available commands");
        boolean isExit = false;

        TaskService taskService = new TaskService(tasks);

        // Program loop
        do {
            System.out.print("\n> ");
            String userInput = scan.nextLine().trim();

            // Prevent empty input
            if (userInput.isEmpty()) {
                System.out.println("Error! Command is Empty.");
                continue;
            }

            String[] commandArray = userInput.split("\\s+");
            String command = commandArray[0].toLowerCase();

            switch (command) {

                case "help":
                    taskService.help();
                    break;

                case "add":
                    if (commandArray.length < 2) {
                        System.out.println("Please provide description.");
                        break;
                    }

                    String addDesc = getDescription(commandArray);

                    // Prevent empty description
                    if (addDesc.isEmpty()) {
                        System.out.println("Description cannot be empty.");
                        break;
                    }

                    taskService.addTask(addDesc);
                    break;

                case "update":
                    if (commandArray.length < 3) {
                        System.out.println("Provide ID and description.");
                        break;
                    }

                    int idUpdate;
                    try {
                        idUpdate = Integer.parseInt(commandArray[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                        break;
                    }

                    String updateDesc = getDescription(commandArray);

                    // Prevent empty description
                    if (updateDesc.isEmpty()) {
                        System.out.println("Description cannot be empty.");
                        break;
                    }

                    taskService.updateTask(idUpdate, updateDesc);
                    break;

                case "delete":
                    if (commandArray.length < 2) {
                        System.out.println("Provide ID.");
                        break;
                    }

                    int idDelete;
                    try {
                        idDelete = Integer.parseInt(commandArray[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                        break;
                    }

                    taskService.deleteTask(idDelete);
                    break;

                case "mark-in-progress":
                    System.out.println("mark in progress");
                    break;

                case "mark-done":
                    System.out.println("mark done");
                    break;

                case "list":
                    taskService.listTasks();
                    break;

                case "exit":
                    isExit = true;
                    break;

                default:
                    System.out.println("Command not found. Type 'help'.");
            }

        } while (!isExit);

        scan.close();
    }

    // Build description from index 2 onward
    public static String getDescription(String[] commandArray) {
        StringBuilder description = new StringBuilder();

        for (int i = 2; i < commandArray.length; i++) {
            description.append(commandArray[i]).append(" ");
        }

        return description.toString().trim();
    }
}