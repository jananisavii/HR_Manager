package edu.jsp.HR_Manager.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.HR_Manager.Repository.RequirementRepository;
import edu.jsp.HR_Manager.entity.Requirement;
import edu.jsp.HR_Manager.entity.Student;

@Service
public class RequirementService {
	
	@Autowired
	
	public RequirementRepository requirementRepo;
	
	
	public  Requirement createRequirement( Requirement requirement ) { 
		return requirementRepo.save(requirement );
	}
	
	public Requirement  fetchById(Long id) {
		return requirementRepo.findById(id).orElse(null);
		
	}
	
	public Requirement  fetchByBranchDealcode(String dealCode){
		
		return requirementRepo.findByBranchDealcode(dealCode).orElse(null);
	}
	
	public Requirement fetchCompanyName(String cname) {
		
		return requirementRepo.findByCompanyName(cname).orElse(null);
	}
	
	public List<Requirement> fetchAllRequirement(){ 
	
		return requirementRepo.findAll();
	}
	
	public String deleteRequirement(long id) {
		Optional<Requirement> o = requirementRepo.findById(id);
		if(o.isPresent()) {
			requirementRepo.deleteById(id);
			return "Requirement deleted";
		}
		return "Requirement not found";
	
	}
	
}
