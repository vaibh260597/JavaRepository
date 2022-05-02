package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.error.CourseNotFoundException;
import com.example.demo.error.StudentNotFoundException;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
@Service
public class CourseServiceImpl implements CourseService {
@Autowired
private CourseRepository courseRepository;

@Override
public Course saveCourse(Course course) {
	// TODO Auto-generated method stub
	return courseRepository.save(course);
}

@Override
public List<Course> fetchcourList() {
	// TODO Auto-generated method stub
	return courseRepository.findAll();
}

@Override
public Course fetchCourseById(Long did) throws CourseNotFoundException {
	// TODO Auto-generated method stub
	Optional<Course> course=courseRepository.findById(did);
	
	if(!course.isPresent()) {
		throw new CourseNotFoundException("This course id is not available");
	}
	
	else return course.get();

	
}

@Override
public void deleteCourseById(Long did) throws CourseNotFoundException {
	// TODO Auto-generated method stub
	Optional<Course> course=courseRepository.findById(did);
	
	if(course.isPresent()) {
		courseRepository.deleteById(did);
		
	}
	else
	{
		throw new CourseNotFoundException("Course id not available");
	}
	
	
}
	
}




	

	


