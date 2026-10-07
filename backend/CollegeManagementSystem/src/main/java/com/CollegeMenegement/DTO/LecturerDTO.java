package com.CollegeMenegement.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LecturerDTO {
	@NotNull
	private Integer id;
	@NotBlank(message = "Name should not be empty")
	private String name;
	@NotBlank(message = "Need to be enter Subject")
	private String subject;
	@Email(message = "Enter the valid mail")
	private String mail;
}
