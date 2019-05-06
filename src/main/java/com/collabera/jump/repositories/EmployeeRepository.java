package com.collabera.jump.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.jump.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
	
	
	List<Employee> findByEmpID (int empID);
	
	
		
	 //Employee findByEmail(String email);
	 
//	 @Query("Select e From Employee e Where e.address.street = :street")
//	 Employee findByStreetOnAddress(String street);
//	
//
//	 @Query(value = "Select PHONE_NUMBER From Employee Where empID = ?1", nativeQuery= true)
//	 Integer findByPhoneNumberByEmpID(Integer id);
	

}
