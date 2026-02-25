package edu.jsp.HR_Manager.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity 
public class Requirement {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 
	 private Long id;
	 private String branchDealcode;
	 private String companyName;
	 private String jobTitie;
	 private String destination;
	 private String jobLocation;
	 private String skilReqiured;
	 
	 private String noOfVacantPosition;
	 private String noOfCandidatesRequired;
	 
	 private LocalDate interviewDate;  // http 
	 
	 
	 private String genderSpecification;
	 private String modeOfInterview;
	 
	 
	 private Double tenthPercentageMin;
	 private Double twelthPercentageMin;
	 private Double degreePercentageMin;
	 private String qualificationType;
	 
	 
	 
	 @OneToMany(mappedBy = "requirement")
	 private List<RequirementStudent> requirementstudents; 
	 
	 
	 // getter and setter
	 
	 public List<RequirementStudent> getRequirementStudent(){
		 return requirementstudents;
	 }
	 
	 
	 public List<RequirementStudent> getRequirementstudents() {
		return requirementstudents;
	}

	 public void setRequirementstudents(List<RequirementStudent> requirementstudents) {
		 this.requirementstudents = requirementstudents; 
	 }

	 public Long getId() {
		 return id;
	 }
	 public void setId(Long id) {
		 this.id = id;
	 }
	 public String getBranchDealcode() {
		 return branchDealcode;
	 }
	 public void setBranchDealcode(String branchDealcode) {
		 this.branchDealcode = branchDealcode;
	 }
	 public String getCompanyName() {
		 return companyName;
	 }
	 public void setCompanyName(String companyName) {
		 this.companyName = companyName;
	 }
	 public String getJobTitie() {
		 return jobTitie;
	 }
	 public void setJobTitie(String jobTitie) {
		 this.jobTitie = jobTitie;
	 }
	 public String getDestination() {
		 return destination;
	 }
	 public void setDestination(String destination) {
		 this.destination = destination;
	 }
	 public String getJobLocation() {
		 return jobLocation;
	 }
	 public void setJobLocation(String jobLocation) {
		 this.jobLocation = jobLocation;
	 }
	 public String getSkilReqiured() {
		 return skilReqiured;
	 }
	 public void setSkilReqiured(String skilReqiured) {
		 this.skilReqiured = skilReqiured;
	 }
	 public String getNoOfVacantPosition() {
		 return noOfVacantPosition;
	 }
	 public void setNoOfVacantPosition(String noOfVacantPosition) {
		 this.noOfVacantPosition = noOfVacantPosition;
	 }
	 public String getNoOfCandidatesRequired() {
		 return noOfCandidatesRequired;
	 }
	 public void setNoOfCandidatesRequired(String noOfCandidatesRequired) {
		 this.noOfCandidatesRequired = noOfCandidatesRequired;
	 }
	 public LocalDate getInterviewDate() {
		 return interviewDate;
	 }
	 public void setInterviewDate(LocalDate interviewDate) {
		 this.interviewDate = interviewDate;
	 }
	 public String getGenderSpecification() {
		 return genderSpecification;
	 }
	 public void setGenderSpecification(String genderSpecification) {
		 this.genderSpecification = genderSpecification;
	 }
	 public String getModeOfInterview() {
		 return modeOfInterview;
	 }
	 public void setModeOfInterview(String modeOfInterview) {
		 this.modeOfInterview = modeOfInterview;
	 }
	 public Double getTenthPercentageMin() {
		 return tenthPercentageMin;
	 }
	 public void setTenthPercentageMin(Double tenthPercentageMin) {
		 this.tenthPercentageMin = tenthPercentageMin;
	 }
	 public Double getTwelthPercentageMin() {
		 return twelthPercentageMin;
	 }
	 public void setTwelthPercentageMin(Double twelthPercentageMin) {
		 this.twelthPercentageMin = twelthPercentageMin;
	 }
	 public Double getDegreePercentageMin() {
		 return degreePercentageMin;
	 }
	 public void setDegreePercentageMin(Double degreePercentageMin) {
		 this.degreePercentageMin = degreePercentageMin;
	 }
	 public String getQualificationType() {
		 return qualificationType;
	 }
	 public void setQualificationType(String qualificationType) {
		 this.qualificationType = qualificationType;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
 	

}
