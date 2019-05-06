package com.collabera.jump.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.jump.exceptions.DuplicateEntryException;
import com.collabera.jump.exceptions.EmployeeNotFoundException;
import com.collabera.jump.model.Employee;
import com.collabera.jump.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	public List<Employee> getEmployeeById(int id) {

		if (empRepo.existsById(id)) {
			return empRepo.findByEmpID(id);
		} else {
			throw new EmployeeNotFoundException("Employee Found!!");
		}

	}

	public Iterable<Employee> getEmployees() {
		return empRepo.findAll();
	}

	public boolean createEmployee(Employee employee) {

		Employee savedEmployee = empRepo.saveAndFlush(employee);
		if (savedEmployee != null) {
			return true;
		} else {
			throw new EmployeeNotFoundException("Employee Found!!");
		}

	}

	public boolean updateEmployee(int empID, Employee employee) {
//
//		try {
			if (empRepo.existsById(empID) && employee.getEmpID() == empID) {

				return createEmployee(employee);
			} else {
				throw new EmployeeNotFoundException("Employee Found!!");
			}
//		} catch (ConstraintViolationException e) {
//
//			throw new DuplicateEntryException("Check the 'Unique' fields in Employees for Duplicates");
//
//		}

	}

	public boolean deleteEmployee(int empID) {

		if (empRepo.existsById(empID)) {
			empRepo.deleteById(empID);
			return true;
		} else {
			throw new EmployeeNotFoundException("Employee Found!!");
		}

	}
//	public Employee getEmployeeByStreet(String street) {
//
//		return empRepo.findByStreetOnAddress(street);
//
//	}

//	public Integer getPhoneNumberByEmployeeID(Integer id) {
//
//		return empRepo.findByPhoneNumberByEmpID(id);
//
//	}

}
