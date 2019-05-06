package com.collabera.jump.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Employee extends Person{

	@Id
	@GeneratedValue
	@ApiModelProperty(notes= "Abritrary in POST method, needed for PUT")
	private int empID;

	@NotNull
	@Positive
	@Digits(integer = 11, fraction =0, message="Must be an 11 digit number: 1 123 543 6789" )
	@Column(unique = true)
	@ApiModelProperty(notes= "Must be an 11 digit number, and Unique for each Employee")
	private BigInteger phoneNumber;


	private DEPARTMENT department;

	@NotNull
	@Column(unique = true)
	@Email(message = "This must be proper email format: abc@def.com")
	@ApiModelProperty(notes= "Must be in proper email format: abc@def.something , and Unique for each Employee")
	private String email;

	
	private JOBTITLE jobTitle;

	
	private int manager;

	@NotNull
	private int salary;

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	

	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public DEPARTMENT getDepartment() {
		return department;
	}

	public void setDepartment(DEPARTMENT department) {
		this.department = department;
	}

	public JOBTITLE getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JOBTITLE jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Employee() {
		super();
	}

	
	public Employee(int empID, @NotNull @Positive @Digits(integer = 11, fraction = 0) BigInteger phoneNumber,
			@NotNull DEPARTMENT department,
			@NotNull @Email(message = "This must be proper email format: abc@def.com") String email,
			@NotNull JOBTITLE jobTitle, @NotNull int manager, @NotNull int salary) {
		super();
		this.empID = empID;
		this.phoneNumber = phoneNumber;
		this.department = department;
		this.email = email;
		this.jobTitle = jobTitle;
		this.manager = manager;
		this.salary = salary;
	}

	public Employee(int empID) {
		// TODO Auto-generated constructor stub
		this.empID =empID;
	
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", phoneNumber=" + phoneNumber + ", department=" + department + ", email="
				+ email + ", jobTitle=" + jobTitle + ", manager=" + manager + ", salary=" + salary + "]";
	}

}
