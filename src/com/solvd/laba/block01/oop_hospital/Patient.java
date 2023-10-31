package com.solvd.laba.block01.oop_hospital;

import java.util.Random;

public class Patient {
	public final String name;
	public final String surname;
	public int age;
	private final int socialNumber;

	public Disease disease;
	public Treatment givenTreatment;

	public Patient(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.socialNumber = new Random().nextInt(100000, 999999); //id number of citizen (PESEL)
		this.disease = new Disease("not found");
	}

	public String printOut() {
		return this.name + " " + this.surname;
	}
}
