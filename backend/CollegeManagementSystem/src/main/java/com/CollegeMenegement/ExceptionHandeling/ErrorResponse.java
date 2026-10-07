package com.CollegeMenegement.ExceptionHandeling;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Data;

@Data
public class ErrorResponse {
	private LocalDateTime timeStamp;
	private Integer id;
	private String name;
	private Map<String, String> errors;
	
	public ErrorResponse(LocalDateTime timeStamp, Integer id, String name, Map<String, String> errors) {
		super();
		this.timeStamp = timeStamp;
		this.id = id;
		this.name = name;
		this.errors = errors;
	}
	
	
	
}
