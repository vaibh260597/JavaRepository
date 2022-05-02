package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{ 

}
