package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Student;
import com.example.demo.error.StudentNotFoundException;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired  //propertybased
	private StudentService studentService;
//save
	@PostMapping("/students/")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	//get all students Record
	@GetMapping("/students/")
	public List<Student> fetchStudentList(){
		return studentService.fetchStudList();
	}
	
	//get student by id
	@GetMapping("/students/{id}")
	public Student fetchStudentById(@PathVariable("id") Long did) throws StudentNotFoundException { 
		return studentService.fetchStudentById(did);
	}
	
	//delete
	@DeleteMapping("/students/{id}")
	public String deleteStudentById(@PathVariable("id") Long did) throws StudentNotFoundException {
		studentService.deleteStudentById(did);
		return "Student deleted Successfully";
		
	}
	
	//update
	@PutMapping("/students/{id}")
	public Student updateStudent(@PathVariable("id") Long did,@RequestBody Student student) {
		return studentService.updateStudent(did,student);
	}
	
	//byname
	@GetMapping("/students/name/{name}")
	public Student fetchStudentByName(@PathVariable("name") String studentName) {
		return studentService.fetchStudentByName(studentName);
	}
	//byEmailaddress
	@GetMapping("/students/email/{email}")
	public Student fetchStudentByEmail(@PathVariable("email") String studentEmail) {
		return studentService.fetchStudentByEmail(studentEmail);
	}
	
}



