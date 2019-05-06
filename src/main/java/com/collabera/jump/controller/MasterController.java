package com.collabera.jump.controller;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.jump.model.DEPARTMENT;
import com.collabera.jump.model.GENDER;
import com.collabera.jump.model.JOBTITLE;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("master")
public class MasterController {
	@ApiOperation(value= "Retrieves All Available Job Titles")
	@GetMapping("jobtitles")
	public ResponseEntity<JOBTITLE[]> getJobTitles(){
		return ResponseEntity.ok(JOBTITLE.values());
	}
	@ApiOperation(value= "Retrieves All Available Departments")
	@GetMapping("departments")
	public ResponseEntity<DEPARTMENT[]> getDepartments(){
		return ResponseEntity.ok(DEPARTMENT.values());
	}
	@ApiOperation(value= "Retrieves All Available Genders")
	@GetMapping("gender")
	public ResponseEntity<GENDER[]> getGenders(){
		return ResponseEntity.ok(GENDER.values());
	}
	@ApiOperation(value= "Retrieves All Available Enumerations")
	@GetMapping("all")
	public ResponseEntity<?> getAll(){
		HashMap<String, Object> allEnums = new HashMap<String, Object>();
		allEnums.put("department", DEPARTMENT.values());
		allEnums.put("gender", GENDER.values());
		allEnums.put("jobtitles", JOBTITLE.values());
		return ResponseEntity.ok(allEnums);
		
	}

}
