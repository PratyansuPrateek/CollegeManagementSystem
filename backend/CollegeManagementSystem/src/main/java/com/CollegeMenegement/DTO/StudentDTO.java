package com.CollegeMenegement.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentDTO {
	@NotNull
	private Integer id;
	@NotBlank(message = "Name Can't Be blank")
	private String name;
	@Min(value = 1, message = "Age must be greater then 1")
	private Integer age;
	@Email(message = "Insert proper email")
	private String mail;
	
}
