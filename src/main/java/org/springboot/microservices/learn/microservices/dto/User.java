package org.springboot.microservices.learn.microservices.dto;

import java.io.IOException;
import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class User {
	
	private Integer id;
	
	@Size(min=3)
	private String name;
	
	@Past
	private Date dob;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	public User() {
		
	}

	public User(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	
		public static void main(String aap[]) throws JsonGenerationException, JsonMappingException, IOException {
			User u = new User(11, "sss", new Date());
			ObjectMapper m = new ObjectMapper();
			m.writeValue(System.out, u);
		}

}
