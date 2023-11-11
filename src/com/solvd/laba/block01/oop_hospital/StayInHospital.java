package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.exceptions.StayInHospitalTooShortException;
import com.solvd.laba.block01.oop_hospital.exceptions.WrongRoomNumberException;

public class StayInHospital {
	private int amountOfDays;
	private int roomNumber;

	public int getAmountOfDays() {
		return amountOfDays;
	}

	public void setAmountOfDays(int amountOfDays) throws Exception {
		if (amountOfDays < 1) {
			throw new StayInHospitalTooShortException("Stay in hospital must last at least 1 day!");
		}
		this.amountOfDays = amountOfDays;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) throws Exception {
		if (roomNumber > 0) {
			this.roomNumber = roomNumber;
		} else {
			throw new WrongRoomNumberException("Room number must be greater than 0!");
		}
	}
}
