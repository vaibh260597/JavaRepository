package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository

public interface StudentRepository extends JpaRepository<Student, Long>{

	public Student findByStudentName(String studentName);

	public Student findByStudentEmail(String studentEmail);

	public Student findByUsername(String username); 

}
