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
		if(id <= 0) {
			throw new IllegalArgumentException("ID cannot be zero or negative.");
		}
		
		// validate description
		if(description == null || description.trim().isEmpty()) {
			throw new IllegalArgumentException("description cannot be empty.");
		}
		
		// validate status
		if(status == null || status.trim().isEmpty()) {
			throw new IllegalArgumentException("status cannot be empty.");
		}
	}
}
