package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.interfaces.IAppointable;

import java.util.ArrayList;
import java.util.List;

public abstract class HealthcareEntity implements IAppointable {
	protected final String name;

	protected List<Patient> patients;
	protected CustomLinkedList<Doctor> doctors;
	protected List<Appointment> appointments;

	public HealthcareEntity(String name) {
		this.name = name;

		this.patients = new ArrayList<Patient>();
		this.doctors = new CustomLinkedList<Doctor>();
		this.appointments = new ArrayList<Appointment>();
	}

	public abstract void welcomeMessage();
}
