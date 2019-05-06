package com.collabera.jump.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.jump.exceptions.ExceptionResponse;
import com.collabera.jump.model.Employee;
import com.collabera.jump.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

public class EmployeeController {

	@Autowired
	private EmployeeService helper;
	

	@CrossOrigin(origins="*")
	@ApiOperation(value= "Retrieves All employees")
	@ApiResponses({ @ApiResponse(code = 400, message = "Bad Request", response =ExceptionResponse.class) })
	@GetMapping(path = "ems", produces = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Iterable<Employee>> getEmployee() {
		

		return ResponseEntity.ok(helper.getEmployees());

	}
	
	@CrossOrigin(origins="*")
	@ApiOperation(value= "Retrieves An Employee by ID")
	@ApiResponses(value= { @ApiResponse(code = 400, message = "Bad Request", response =ExceptionResponse.class) })
	@GetMapping(path = "ems/{empID}", produces = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Iterable<Employee>> getEmployeeById(@PathVariable(name="empID", required = true) int empID) {
		return ResponseEntity.ok(helper.getEmployeeById(empID));
	}

	
	@CrossOrigin(origins="*")
	@ApiOperation(value= "Add an Employee")
	@ApiResponses({ @ApiResponse(code = 400, message = "Bad Request, Please Check to see your Json is configured correctly", response =ExceptionResponse.class) })
	@PostMapping(path = "ems", produces = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {

		if (helper.createEmployee(employee)) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.noContent().build();
		}

	}

	@CrossOrigin(origins="*")
	@ApiOperation(value= "Updates All Entries in an Employees")
	@ApiResponses({ @ApiResponse(code = 400, message = "Bad Request, Please Check to see your Json is configured correctly", response =ExceptionResponse.class) })
	@PutMapping(path = "ems/{empID}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> updateEmployee(@PathVariable(name = "empID", required = true) int empID,@RequestBody Employee employee) {
		

		helper.updateEmployee(empID, employee);
		
		return ResponseEntity.ok().build();
				
				

	}

	@CrossOrigin(origins="*")
	@ApiOperation(value= "Deletes an Employee by ID")
	@ApiResponses({ @ApiResponse(code = 400, message = "Bad Request", response =ExceptionResponse.class) })
	@DeleteMapping("ems/{empID}")
	public boolean deleteEmployee(@PathVariable(name = "empID", required = true) int empID) {
		return helper.deleteEmployee(empID);

		

	}

}
