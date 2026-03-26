package model;

import java.time.LocalDateTime;

public record Task(
		int id, 
		String description, 
		String status, 
		LocalDateTime createAt,
		LocalDateTime updateAt
		) 
{

	public Task{
		
		// validate ID
		if(id <= 0) { throw new IllegalArgumentException("ID cannot be zero or negative.");}
		
		// validate description
		if(description == null || description.trim().isEmpty()) { throw new IllegalArgumentException("description cannot be empty.");}
		
		// validate status
		if(status == null || status.trim().isEmpty()) { throw new IllegalArgumentException("status cannot be empty.");}
				
		status = status.trim().toLowerCase(); //trim and convert to lowerCase before validating		
		String[] allowedStatus = {"todo", "in-progress", "done"};
		boolean isValidStatus = false;
		
		//loop through array, if user input to status is in the allowedStatus
		for(String s: allowedStatus) {
			if((status.equals(s))) {
				isValidStatus = true;
				break;
			}
		}
		
		//check if isValidStatus is still false 
		if(!isValidStatus) { throw new IllegalArgumentException("Status must only be todo, in-progress, done");}

	}
}
