package com.solvd.laba.block01.oop_hospital;

import java.util.ArrayList;

public class HospitalRoom {
	private final int number;
	private int maxBeds;
	private int freeBeds;
	private ArrayList<Patient> patientsInRoom;

	public HospitalRoom(int number, int maxBeds) {
		this.number = number;
		this.maxBeds = maxBeds;
		this.freeBeds = maxBeds;
	}

	public int getNumber() {
		return number;
	}

	public int getMaxBeds() {
		return maxBeds;
	}

	public void setMaxBeds(int maxBeds) {
		if (maxBeds < patientsInRoom.size()) {
			System.out.println("Too many patients in this room.");
			return;
		}

		this.maxBeds = maxBeds;
		this.freeBeds = maxBeds - patientsInRoom.size();
	}

	public int getFreeBeds() {
		return freeBeds;
	}

	public void addPatient(Patient p) {
		if (freeBeds > 0) {
			freeBeds--;
			patientsInRoom.add(p);
		} else {
			System.out.println("No free beds in room " + number);
		}
	}

	public void dischargePatient(Patient p) {
		if (patientsInRoom.contains(p)) {
			patientsInRoom.remove(p);
			freeBeds++;
		} else {
			System.out.println(p.printOut() + " is not in this room");
		}
	}
}
