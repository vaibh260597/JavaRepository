package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.error.CourseNotFoundException;
import com.example.demo.error.StudentNotFoundException;

public interface CourseService {

	//Course saveCourse(Course course);

	//List<Course> fetchcourList();

	Course saveCourse(Course course);

	List<Course> fetchcourList();

	Course fetchCourseById(Long did) throws CourseNotFoundException;

	void deleteCourseById(Long did) throws CourseNotFoundException;

}
