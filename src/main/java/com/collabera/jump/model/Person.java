package com.collabera.jump.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@MappedSuperclass
public class Person implements Serializable {

	@NotNull
	@Size(min = 2, max = 50)
	private String firstName;

	@NotNull
	@Size(min = 2, max = 100)
	private String LastName;

	@NotNull
	@Column(unique = true)
	@ApiModelProperty(notes = "Must be an 9 digit number, and Unique for each Employee")
	private String ssn;

	@Valid
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Address address;

	@NotNull
	private String doB;

	private GENDER gender;

//	@Size(min = 2, max = 2)
	private int age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDoB() {
		return doB;
	}

	public void setDoB(String doB) {
		this.doB = doB;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public Person() {
		super();
	}

	

	public Person(@NotNull @Size(min = 2, max = 50) String firstName,
			@NotNull @Size(min = 2, max = 100) String lastName, @NotNull String ssn, @Valid Address address,
			@NotNull String doB, GENDER gender, int age) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.ssn = ssn;
		this.address = address;
		this.doB = doB;
		this.gender = gender;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", LastName=" + LastName + ", ssn=" + ssn + ", address=" + address
				+ ", doB=" + doB + ", gender=" + gender + ", age=" + age + "]";
	}

}
