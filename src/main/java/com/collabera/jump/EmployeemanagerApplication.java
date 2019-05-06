package com.collabera.jump;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmployeemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagerApplication.class, args);
		
//		RestTemplate restTemplate = new RestTemplate();
//		String response = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", String.class);
		
	}

}
