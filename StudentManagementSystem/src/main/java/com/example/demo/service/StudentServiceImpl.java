package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;
import com.example.demo.error.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService,UserDetailsService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public List<Student> fetchStudList() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student fetchStudentById(Long did) throws StudentNotFoundException {
		// TODO Auto-generated method stub
Optional<Student> student=studentRepository.findById(did);
		
		if(!student.isPresent()) {
			throw new StudentNotFoundException("Student not available");
		}
		
		else return student.get();

		
	}

	

	@Override
	public void deleteStudentById(Long did) throws StudentNotFoundException {
		// TODO Auto-generated method stub
Optional<Student> student=studentRepository.findById(did);
		
		if(student.isPresent()) {
			studentRepository.deleteById(did);
			
		}
		else
		{
			throw new StudentNotFoundException("Student id not available");
		}
		
		
	}

	@Override
	public Student updateStudent(Long did, Student student) {
		// TODO Auto-generated method stub
		Student stdDB=studentRepository.findById(did).get();
		if(Objects.nonNull(student.getStudentName()) && !"".equalsIgnoreCase(student.getStudentName())) {
			stdDB.setStudentName(student.getStudentName());
			
		}
		if(Objects.nonNull(student.getStudentEmail()) && !"".equalsIgnoreCase(student.getStudentEmail())) {
			stdDB.setStudentEmail(student.getStudentEmail());
			System.out.println(student.getStudentEmail());
		}
		return studentRepository.save(stdDB);
	}
	

	@Override
	public Student fetchStudentByName(String studentName) {
		// TODO Auto-generated method stub
		return studentRepository.findByStudentName(studentName);
	}

	@Override
	public Student fetchStudentByEmail(String studentEmail) {
		// TODO Auto-generated method stub
		return studentRepository.findByStudentEmail(studentEmail);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Student std=studentRepository.findByUsername(username);
		if(std==null)
		{
			throw new UsernameNotFoundException("user not found");
		}
		return new StudentPrincipal(std);
	}


	

}
