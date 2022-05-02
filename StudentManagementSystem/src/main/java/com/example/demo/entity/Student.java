package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentId;
	private String studentName;
	@Length(min=5,message="Enter at least 5 character")
	private String studentEmail;
	private Long studentFees;
	@Column(unique=true)
	private String username;
	private String password;
	@JsonIgnore
	//@OneToMany(mappedBy = "st")  //one student will have multiple course
	@OneToMany(cascade = CascadeType.ALL)
	List<Course> lp=new ArrayList<Course>();
	
	
	public List<Course> getLp() {
		return lp;
	}
	public void setLp(List<Course> lp) {
		this.lp = lp;
	}
	public Student(Long studentId, String studentName, String studentEmail, Long studentFees, String username,
			String password, List<Course> lp) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentFees = studentFees;
		this.username = username;
		this.password = password;
		this.lp = lp;
	}
	public Student() {
		super();
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public Long getStudentFees() {
		return studentFees;
	}
	public void setStudentFees(Long studentFees) {
		this.studentFees = studentFees;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", studentFees=" + studentFees + ", username=" + username + ", password=" + password + ", lp=" + lp
				+ "]";
	}
	
	
}
