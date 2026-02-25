package edu.jsp.HR_Manager.controller;

import org.hibernate.annotations.ValueGenerationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.HR_Manager.Service.StudentService;
import edu.jsp.HR_Manager.entity.Student;

@RestController
@RequestMapping("/api/student") //  Root url 
public class Studentcontroller {

	
	@Autowired 
	public StudentService StudentSer;
	
	@PostMapping         // Save : http://localhost:8080/api/student
	public Student createStudent(@RequestBody Student s) {
		return StudentSer.createStudent(s);
	}
	
	@GetMapping("/getById/{id}")
	public Student getStudentById(@PathVariable long id) {
		return StudentSer.getStudentById(id);
		
	}
	
	@GetMapping("/{email}")
	public Student getStudentByEmail(@PathVariable String email) {
		return StudentSer.getStudentByEmail(email);
	}
	
	@GetMapping("/{phone}")
	public Student getStudentByContactNumber(@PathVariable long phone) {
		return StudentSer.getStudentByContactNumber(phone);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(long id) {
		return StudentSer.deleteStudent(id);
	}
	
	
}

