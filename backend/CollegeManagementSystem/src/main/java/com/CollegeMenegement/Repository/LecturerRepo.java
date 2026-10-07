package com.CollegeMenegement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CollegeMenegement.Entity.Lecturer;

@Repository
public interface LecturerRepo extends JpaRepository<Lecturer, Integer>{

}
