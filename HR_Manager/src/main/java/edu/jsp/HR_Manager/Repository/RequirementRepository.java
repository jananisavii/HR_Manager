package edu.jsp.HR_Manager.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import edu.jsp.HR_Manager.entity.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement,Long> {
	
	Optional<Requirement> findByBranchDealcode(String dealCode);
	
	Optional<Requirement> findByCompanyName(String cName);

	
	
	
}

