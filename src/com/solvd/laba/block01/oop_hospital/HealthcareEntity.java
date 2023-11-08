package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.interfaces.IAppointable;

import java.util.ArrayList;

public abstract class HealthcareEntity implements IAppointable {
	public final String Name;

	protected ArrayList<Patient> patients;
	protected ArrayList<Doctor> doctors;
	public ArrayList<Appointment> appointments;

	public HealthcareEntity(String name) {
		this.Name = name;

		this.patients = new ArrayList<Patient>();
		this.doctors = new ArrayList<Doctor>();
		this.appointments = new ArrayList<Appointment>();
	}

	public void welcomeMessage() {
		System.out.println("Welcome");
	}
}
