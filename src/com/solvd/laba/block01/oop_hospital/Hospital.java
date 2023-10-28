package com.solvd.laba.block01.oop_hospital;

import java.util.ArrayList;

public class Hospital {
	public final String hospitalName;
	public final int amountOfRooms;

	private ArrayList<Patient> patientsInHospital;
	private ArrayList<Doctor> doctors;
	private HospitalRoom[] hospitalRooms;

	public Hospital(String hospitalName, int amountOfRooms) {
		this.hospitalName = hospitalName;
		this.amountOfRooms = amountOfRooms;

		HospitalRoom[] rooms;
		for (int i = 0; i < amountOfRooms; i++) {

		}
	}
}
