package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.interfaces.IAppointable;

import java.util.ArrayList;
import java.util.List;

public abstract class HealthcareEntity implements IAppointable {
	public final String Name;

	protected List<Patient> patients;
	protected CustomLinkedList<Doctor> doctors;
	protected List<Appointment> appointments;

	public HealthcareEntity(String name) {
		this.Name = name;

		this.patients = new ArrayList<Patient>();
		this.doctors = new CustomLinkedList<Doctor>();
		this.appointments = new ArrayList<Appointment>();
	}

	public void welcomeMessage() {
		System.out.println("Welcome");
	}
}
