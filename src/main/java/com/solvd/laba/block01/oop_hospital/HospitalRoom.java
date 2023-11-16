package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.interfaces.IRoomOccupiable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class HospitalRoom implements IRoomOccupiable {
	private final int number;
	private final int maxBeds = 6;
	private int freeBeds;
	private List<Patient> patientsInRoom;

	private static final Logger LOGGER = LogManager.getLogger(Doctor.class);

	public HospitalRoom(int number) {
		this.number = number;
		this.freeBeds = maxBeds;
		this.patientsInRoom = new ArrayList<Patient>();
	}

	@Override
	public String toString() {
		return "A0" + number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		HospitalRoom that = (HospitalRoom) o;

		return number == that.number;
	}

	@Override
	public int hashCode() {
		return number;
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

	@Override
	public void addPatient(Patient p) {
		if (freeBeds > 0) {
			freeBeds--;
			patientsInRoom.add(p);
		} else {
			LOGGER.warn("No free beds in room " + number);
		}
	}

	@Override
	public void removePatient(Patient p) {
		if (patientsInRoom.contains(p)) {
			patientsInRoom.remove(p);
			freeBeds++;
		} else {
			LOGGER.warn(p.toString() + " is not in this room");
		}
	}
}
