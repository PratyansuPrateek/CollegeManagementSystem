package com.CollegeMenegement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.CollegeMenegement.DTO.StudentDTO;
import com.CollegeMenegement.Entity.Student;
import com.CollegeMenegement.ExceptionHandeling.ResourceNotFoundException;
import com.CollegeMenegement.Repository.StudentRepo;

import jakarta.validation.Valid;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;

	public Student addStudent(@Valid StudentDTO dto) {
		
		Student student = new Student();
		student.setId(dto.getId());
		student.setName(dto.getName());
		student.setAge(dto.getAge());
		student.setMail(dto.getMail());
		
		return repo.save(student);
	}

	public List<Student> getAllStudent() {
		return repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Student updateStudent(Integer id, StudentDTO dto) {
		Student student = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student is not there with id: "+id));
		 if(dto.getName() != null) {
		        student.setName(dto.getName());
		    }

		    if(dto.getAge() != null) {
		        student.setAge(dto.getAge());
		    }

		    if(dto.getMail() != null) {
		        student.setMail(dto.getMail());
		    }
		return repo.save(student);
	}

	public void deleteStudent(Integer id) {
		if(!repo.existsById(id))
			throw new ResourceNotFoundException("Student is not there with id: "+id);
		 repo.deleteById(id);
	}

	public Student getById(Integer id) {
		return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student is not there with id: "+id));
	}
	
}
