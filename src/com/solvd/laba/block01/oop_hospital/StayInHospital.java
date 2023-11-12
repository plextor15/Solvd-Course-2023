package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.exceptions.StayInHospitalTooShortException;
import com.solvd.laba.block01.oop_hospital.exceptions.WrongRoomNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StayInHospital {
	private int amountOfDays;
	private int roomNumber;
	private static final Logger LOGGER = LogManager.getLogger(StayInHospital.class);

	public StayInHospital(int amountOfDays, int roomNumber) {
		try {
			this.setAmountOfDays(amountOfDays);
		} catch (StayInHospitalTooShortException e) {
			LOGGER.warn(e.getMessage());
		}

		try {
			this.setRoomNumber(roomNumber);
		} catch (WrongRoomNumberException e) {
			LOGGER.warn(e.getMessage());
		}
	}

	public StayInHospital() {

	}

	public int getAmountOfDays() {
		return amountOfDays;
	}

	public void setAmountOfDays(int amountOfDays) throws StayInHospitalTooShortException {
		if (amountOfDays < 1) {
			this.amountOfDays = 1;
			throw new StayInHospitalTooShortException("Stay in hospital must last at least 1 day!");
		}
		this.amountOfDays = amountOfDays;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) throws WrongRoomNumberException {
		if (roomNumber > 0) {
			this.roomNumber = roomNumber;
		} else {
			this.roomNumber = 0;
			throw new WrongRoomNumberException("Room number must be greater than 0!");
		}
	}
}
