package edu.jsp.HR_Manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.HR_Manager.Service.RequirementService;
import edu.jsp.HR_Manager.Service.RequirementStudentService;
import edu.jsp.HR_Manager.entity.Requirement;
import edu.jsp.HR_Manager.entity.Student;

@RestController
@RequestMapping("/api/Requirement")
public class Requirementcontroller {
//  optional means @Requestparam ||  searching, filtering means @Pathvariable
	
	@Autowired
	public RequirementService requirementSer;
	
	@Autowired
	public RequirementStudentService requirementStudentSer;
	
	@PostMapping
	public Requirement createRequirement(@RequestBody Requirement requirement) {
		
		return requirementSer.createRequirement(requirement);
	}
	
	@GetMapping("id")
	public Requirement  fetchById(@RequestParam Long id) {
		
		return requirementSer.fetchById(id);
	}
	
	@GetMapping("/branch/{dealCode}")             // http://localhost:8080/api/Requirement/branch/BR002
	public Requirement fetchByBranchCode(@PathVariable String dealCode) {
		
		return  requirementSer.fetchByBranchDealcode(dealCode); 
	}
	
	@GetMapping       // http://localhost:8080/api/Requirement
	public List<Requirement> fetchAllRequirements(){
		
		return requirementSer.fetchAllRequirement();
	}
	
	@DeleteMapping("/{id}")
	public String deleteRequirement(@PathVariable long id) {
		
		
		return requirementSer.deleteRequirement(id);
	}
	
	
	@PostMapping("/mapstd")  // http://localhost:8080/api/Requirement/mapstd?rid=1&sid=1,id=1&sid=2,id=1&sid=3,id=1&sid=4
	public String mapStudent(@RequestParam long rid,@RequestParam long sid) {
		return requirementStudentSer.mapStudent(rid,sid);
		
		
	}
	
	@DeleteMapping("/removeStd")    // http://localhost:8080/api/Requirement/removeStd?reqId=1&sid=2
	public String removeStudent(@RequestParam long reqId,@RequestParam long sid) {
		return requirementStudentSer.removeStudent(reqId,sid); 
	}
	
	@GetMapping("/getStudent/{reqId}")
	public List<Student> fetchStudentByReq(@PathVariable Long reqId) {
	return  requirementStudentSer.fetchStudentByReq(reqId);	
	}
	
	
}


// output: 
//You are calling the **same API multiple times** with **different student IDs** for the **same requirement (rid = 1)**.
//Let’s clearly show **what happens and the final output**.


//## 🔗 API Calls You Made


///mapstd?rid=1&sid=1
///mapstd?rid=1&sid=2
///mapstd?rid=1&sid=3
///mapstd?rid=1&sid=4


//👉 Meaning:
//**Students 1, 2, 3, and 4 are all mapped to Requirement 1**


//## 📋 Final Output


//### **RequirementStudent (Mapped Table)**


//| id | r_id | s_id |
//| -- | ---- | ---- |
//| 1  | 1    | 1    |
//| 2  | 1    | 2    |
//| 3  | 1    | 3    |
//| 4  | 1    | 4    |


//*(Assuming the table was empty before these calls)*


//## 🧩 Explanation (Row by Row)

//### 🔹 `1 | 1 | 1`

//* Student **1** applied for Requirement **1**

//### 🔹 `2 | 1 | 2`

//* Student **2** applied for Requirement **1**

//### 🔹 `3 | 1 | 3`

//* Student **3** applied for Requirement **1**

//### 🔹 `4 | 1 | 4`

//* Student **4** applied for Requirement **1**



//## 🔁 Relationship Result   
//   Requirement id = 1

//➡️ Applied Students: **1, 2, 3, 4**

//✔️ One requirement → **many students**

//### Each Student

//➡️ Can apply to **many requirements** (future scope)

//✔️ Many students → one requirement

//👉 This confirms your **Many-to-Many mapping** using the `RequirementStudent` table is **working correctly**.

//## ⚠️ Important Note (Best Practice)

//To avoid **duplicate applications**, add a unique constraint:

//```java
//@UniqueConstraint(columnNames = {"r_id", "s_id"}).




// DELETE : 

// Why the 405 happens
// With your current code:

// /api/Requirement/{id} is mapped only for DELETE because of:

// @DeleteMapping("/{id}")public String deleteRequirement    (@PathVariable long id) { ... }
// There is no GET for that same path, because:

// @GetMapping("/id")
// maps to the literal URL /api/Requirement/id, not /api/Requirement/1.

// So Spring says:

// “I know /api/Requirement/1, but only for DELETE → GET is not supported” → 405.
//Once you change to @GetMapping("/{id}"), Spring has both:

// GET /api/Requirement/{id}
// DELETE /api/Requirement/{id}
// and the error will disappear. 

 