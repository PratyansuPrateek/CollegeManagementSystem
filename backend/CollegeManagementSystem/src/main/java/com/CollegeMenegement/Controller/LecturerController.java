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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CollegeMenegement.DTO.LecturerDTO;
import com.CollegeMenegement.Entity.Lecturer;
import com.CollegeMenegement.Service.LecturerService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/lecturer")
public class LecturerController {
	
	@Autowired
	private LecturerService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Lecturer>> getAll(){
		List<Lecturer> list = service.getLecturer();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/addLecturer")
	public ResponseEntity<Lecturer> addLecturer(@Valid @RequestBody LecturerDTO dto){
		Lecturer lecturer = service.addLecturer(dto);
		return ResponseEntity.status(201).body(lecturer);
	}
	
	@PatchMapping("/updateLecturer/{id}")
	public ResponseEntity<Lecturer> updateLecturer(@PathVariable Integer id, @RequestBody LecturerDTO dto){
		 Lecturer lecturer = service.updateLecture(id,dto);
		 return ResponseEntity.ok(lecturer);
	}
	
	@DeleteMapping("/deleteLecturer/{id}")
	public ResponseEntity<String> deleteLecturer(@PathVariable Integer id){
		service.deleteLecturer(id);
		return ResponseEntity.ok("Lecturer is deleted");
	}
}
