package com.demo.userservice;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class User implements Serializable{

	private static final long serialVersionUID = 350235943441382251L;

	private UUID uuid;
	private LocalDate dateOfBirth;
	private String name;
	private String surname;
	private String idNo;
	private Status status;

	public User() {}
	
	public User(UserDto userDto) {
		uuid = UUID.randomUUID();
		dateOfBirth = userDto.dateOfBirth;
		name = userDto.name;
		surname = userDto.surname;
		idNo = userDto.idNo;
	}

	public UUID getUuid() {
		return uuid;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getIdNo() {
		return idNo;
	}

	public int getAge() {
		return Period.between(dateOfBirth, LocalDate.now()).getYears();
	}

	public enum Status {
		NEW, OK, FRAUD
	}
}
