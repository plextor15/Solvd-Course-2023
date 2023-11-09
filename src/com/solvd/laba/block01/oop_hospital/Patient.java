package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.interfaces.IPrintable;

import java.util.Random;

public class Patient extends Person implements IPrintable {

	public int age;
	private final int socialNumber;

	public Symptoms symptoms;
	public Diagnosis diagnosis;
	public int assignedDoctor;
	public Prescription prescription;

	public Patient(String name, String surname, int age) {
		super(name, surname);

		if (age < 0) {
			throw new RuntimeException("Age cannot be less than 0! Specified age=" + age);
		}
		
		this.age = age;
		this.socialNumber = new Random().nextInt(100000, 999999); //id number of citizen (PESEL)
	}

	@Override
	public String toString() {
		return this.name + " " + this.surname;
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

	@Override
	public String printOut() {
		return "patient " + this.toString();
	}

	public Treatment whatTreatment() {
		return this.diagnosis.treatment;
	}

	public int getSocialNumber() {
		return socialNumber;
	}
}
