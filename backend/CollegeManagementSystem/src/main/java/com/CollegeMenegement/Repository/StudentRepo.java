package com.CollegeMenegement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CollegeMenegement.Entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
