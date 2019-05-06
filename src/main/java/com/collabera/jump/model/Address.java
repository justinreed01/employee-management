package com.collabera.jump.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Address implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	@NotNull
	private int streetNumber;

	@NotNull
	private String streetName;

	@NotNull
	private String city;

	@NotNull
	private String State;

	@NotNull
	@Size(min=5, max=5)
	@ApiModelProperty(notes = "Must be an 5 digit number")
	private String zipcode;

	@NotNull
	private String country;

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address() {
		super();
	}

	
	public Address(Integer id, @NotNull int streetNumber, @NotNull String streetName, @NotNull String city,
			@NotNull String state, @NotNull @Size(min = 5, max = 5) String zipcode, @NotNull String country) {
		super();
		this.id = id;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		State = state;
		this.zipcode = zipcode;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city + ", State="
				+ State + ", zipcode=" + zipcode + ", country=" + country + "]";
	}

}
