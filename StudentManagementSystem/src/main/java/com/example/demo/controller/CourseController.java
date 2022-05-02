package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.error.CourseNotFoundException;
import com.example.demo.error.StudentNotFoundException;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	      //save
		@PostMapping("/courses/")
		public Course saveCourse(@RequestBody Course course) {
			return courseService.saveCourse(course);
		}
		//get all Course Record
		@GetMapping("/courses/")
		public List<Course> fetchCourseList(){
			return courseService.fetchcourList();
		}
		
		@GetMapping("/courses/{id}")
		public Course fetchCourseById(@PathVariable("id") Long did) throws CourseNotFoundException { 
			return courseService.fetchCourseById(did);
		}
		@DeleteMapping("/courses/{id}")
		public String deleteCourseById(@PathVariable("id") Long did) throws CourseNotFoundException {
			courseService.deleteCourseById(did);
			return "Course deleted Successfully";
		}
}
