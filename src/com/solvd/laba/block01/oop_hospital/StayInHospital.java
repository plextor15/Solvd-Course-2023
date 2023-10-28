package com.solvd.laba.block01.oop_hospital;

public class StayInHospital {
	private int amountOfDays;
	private int roomNumber;

	public int getAmountOfDays() {
		return amountOfDays;
	}

	public void setAmountOfDays(int amountOfDays) {
		this.amountOfDays = amountOfDays;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		if (roomNumber > 0) {
			this.roomNumber = roomNumber;
		}
	}
}
