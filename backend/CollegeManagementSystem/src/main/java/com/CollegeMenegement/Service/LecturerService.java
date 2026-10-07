package com.CollegeMenegement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.CollegeMenegement.DTO.LecturerDTO;
import com.CollegeMenegement.Entity.Lecturer;
import com.CollegeMenegement.ExceptionHandeling.ResourceNotFoundException;
import com.CollegeMenegement.Repository.LecturerRepo;

import jakarta.validation.Valid;

@Service
public class LecturerService {
	
	@Autowired
	private LecturerRepo repo;

	public List<Lecturer> getLecturer() {
		return repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Lecturer addLecturer(@Valid LecturerDTO dto) {
		Lecturer lecturer = new Lecturer();
		lecturer.setId(dto.getId());
		lecturer.setName(dto.getName());
		lecturer.setSubject(dto.getSubject());
		lecturer.setMail(dto.getMail());
		
		return repo.save(lecturer); 
	}

	public Lecturer updateLecture(Integer id, LecturerDTO dto) {
		Lecturer lecturer = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Lecturer is not present with id: "+id));
				
		if(dto.getName()!=null) {
			lecturer.setName(dto.getName());
		}
		
		if(dto.getSubject()!=null) {
			lecturer.setSubject(dto.getSubject());
		}
		
		if(dto.getMail()!=null) {
			lecturer.setMail(dto.getMail());
		}
		
		return repo.save(lecturer);
	}

	public void deleteLecturer(Integer id) {
		if(!repo.existsById(id)) {
			throw new ResourceNotFoundException("Lecturer is not present with id: "+id);
		}
		repo.deleteById(id);
	}
}
