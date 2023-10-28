package com.solvd.laba.block01.oop_hospital;

public class Patient {
	private String name;
	private String surname;
	private int age;

	public Patient(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getAge() {
		return age;
	}
}
