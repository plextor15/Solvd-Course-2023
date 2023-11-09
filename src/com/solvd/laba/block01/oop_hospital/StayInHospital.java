package com.solvd.laba.block01.oop_hospital;

public class StayInHospital {
	private int amountOfDays;
	private int roomNumber;

	public int getAmountOfDays() {
		return amountOfDays;
	}

	public void setAmountOfDays(int amountOfDays) throws Exception {
		if (amountOfDays < 1) {
			throw new Exception("Stay in hospital must last at least 1 day!");
		}
		this.amountOfDays = amountOfDays;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		if (roomNumber > 0) {
			this.roomNumber = roomNumber;
		} else {
			throw new RuntimeException("Room number must be greater than 0!");
		}
	}
}
