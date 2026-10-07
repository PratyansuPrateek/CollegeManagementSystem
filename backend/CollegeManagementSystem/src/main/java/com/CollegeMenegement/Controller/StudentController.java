package com.CollegeMenegement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CollegeMenegement.DTO.StudentDTO;
import com.CollegeMenegement.Entity.Student;
import com.CollegeMenegement.Service.StudentService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/getAllStudent")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> student = service.getAllStudent();
		return ResponseEntity.ok(student);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Student> getById(@PathVariable Integer id) {
		Student student = service.getById(id);
		return ResponseEntity.ok(student); 
	}
	
	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@Valid @RequestBody StudentDTO dto){
		Student student=service.addStudent(dto);
		return ResponseEntity.status(201).body(student);
	}
	
	@PatchMapping("/UpdateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody StudentDTO dto){
		Student student = service.updateStudent(id,dto);
		return ResponseEntity.ok(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
		service.deleteStudent(id);
		return ResponseEntity.ok("Studnet deleted successfully");
	}
}
