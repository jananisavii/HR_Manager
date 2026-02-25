package edu.jsp.HR_Manager.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.jsp.HR_Manager.entity.RequirementStudent;

@Repository
public interface RequirementStudentRepository  extends JpaRepository<RequirementStudent, Long> { 

    @Query("select rs from RequirementStudent rs where rs.requirement.id = ?1 and rs.student.id = ?2")
    Optional<RequirementStudent> fetchRequirementStudent(Long reqid, Long stdid); 

    List<RequirementStudent> findByRequirementId(long id); 
}


//public interface RequirementStudentRepository  extends  JpaRepository< RequirementStudent ,Long>{
//	
//	@Query(value="select rs from RequirementStudent rs" + "where rs.requirement.id=?1 and rs.student.id=?2")
//	
//	Optional<RequirementStudent> fetchRequirementStudent(Long reqid,Long stdid);
//	
//	List<RequirementStudent> findByRequirementId(long id);
//	




