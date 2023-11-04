package com.solvd.laba.block01.oop_hospital;

import java.util.ArrayList;

public class HospitalRoom {
	private final int number;
	private final int maxBeds = 6;
	private int freeBeds;
	private ArrayList<Patient> patientsInRoom;

	public HospitalRoom(int number) {
		this.number = number;
		this.freeBeds = maxBeds;
	}

	@Override
	public String toString() {
		return "A0" + number;
	}

	public int getNumber() {
		return number;
	}

	public int getMaxBeds() {
		return maxBeds;
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
			System.out.println(p.toString() + " is not in this room");
		}
	}
}
