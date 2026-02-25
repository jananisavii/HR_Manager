package edu.jsp.HR_Manager.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.HR_Manager.Repository.StudentRepository;
import edu.jsp.HR_Manager.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	private  StudentRepository studentRepo;
	
	public Student createStudent(Student s) {
		return studentRepo.save(s);
	}
	
	public Student getStudentById(long id) {
		Optional<Student> o = studentRepo.findById(id);
		return o.isPresent() ? o.get() : null; //  --------->  Ternary Operator
	}
	
	public Student getStudentByContactNumber(long phone) {
		Optional<Student> o = studentRepo.findByContactNumber(phone);
		return o.isPresent() ? o.get() : null;	
	}
	
	public  Student getStudentByEmail(String email) {
		Optional<Student> o = studentRepo.findByEmail(email);
		return o.isPresent() ? o.get() : null;
	}
	
	public List<Student> getAllStudent(){
		return studentRepo.findAll();
	}
	
	public String deleteStudent(long id) {
		Optional<Student> o = studentRepo.findById(id);
		if(o.isPresent()) {
			studentRepo.deleteById(id);
			return "data deleted";
		}
		return "ID not found";
		
	}
	
	
	
	

}
