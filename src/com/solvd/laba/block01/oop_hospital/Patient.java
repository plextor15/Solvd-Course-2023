package com.solvd.laba.block01.oop_hospital;

import java.util.Random;

public class Patient extends Person {

	public int age;
	private final int socialNumber;

	public Symptoms symptoms;
	public Diagnosis diagnosis;
	public int assignedDoctor;
	public Prescription prescription;

	public Patient(String name, String surname, int age) {
		super(name, surname);

		this.age = age;
		this.socialNumber = new Random().nextInt(100000, 999999); //id number of citizen (PESEL)
	}

	@Override
	public String toString() {
		return "patient " + this.name + " " + this.surname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Patient patient = (Patient) o;

		return this.socialNumber == patient.socialNumber;
	}

	@Override
	public int hashCode() {
		return socialNumber;
	}

	public Treatment whatTreatment() {
		return this.diagnosis.treatment;
	}

	public int getSocialNumber() {
		//
		return socialNumber;
	}
}
