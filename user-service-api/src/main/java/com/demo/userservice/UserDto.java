package com.demo.userservice;

import java.io.Serializable;
import java.time.LocalDate;

public class UserDto implements Serializable{

	private static final long serialVersionUID = -8812910341257370577L;
	
	public LocalDate dateOfBirth;
	public String name;
	public String surname;
	public String idNo;

	public UserDto() {
	}
}
