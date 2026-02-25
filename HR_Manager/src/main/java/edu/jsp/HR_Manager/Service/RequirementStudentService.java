package edu.jsp.HR_Manager.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.HR_Manager.Repository.RequirementRepository;
import edu.jsp.HR_Manager.Repository.RequirementStudentRepository;
import edu.jsp.HR_Manager.Repository.StudentRepository;
import edu.jsp.HR_Manager.entity.Requirement;
import edu.jsp.HR_Manager.entity.RequirementStudent;
import edu.jsp.HR_Manager.entity.Student;

@Service
public class RequirementStudentService {

	@Autowired
	public RequirementRepository requirementRepo;
	
	
	@Autowired
	private  StudentRepository studentRepo;
	
	@Autowired
	private RequirementStudentRepository  requirementstudentRepo ;
	
	
	public String mapStudent(long reqId, long stdId) {
		Student s = studentRepo.findById(stdId).orElse(null);
		Requirement r = requirementRepo.findById(reqId).orElse(null);
		if(s != null && r != null) {
			RequirementStudent rs = new RequirementStudent();
			rs.setRequirement(r);
			rs.setStudent(s);
			requirementstudentRepo.save(rs);
			return "student mapped";		
			
		}
	  
	return " Data not Found";
}
	
	public String removeStudent(long reqId, long sid) {
		Optional<RequirementStudent> o = requirementstudentRepo.fetchRequirementStudent(reqId, sid);
		if (o.isPresent()) {
			requirementstudentRepo.delete(o.get());
			return "student removed";
		}
		return "Data not found";
	}  // run in browser 

	public List<Student> fetchStudentByReq(Long reqId) { 

		List<RequirementStudent> list = requirementstudentRepo.findByRequirementId(reqId);

		List<Student> students = new ArrayList<>();

		for (RequirementStudent rs : list) {
			students.add(rs.getStudent());
		}
		return students;
	}
	
	
		
	
}
