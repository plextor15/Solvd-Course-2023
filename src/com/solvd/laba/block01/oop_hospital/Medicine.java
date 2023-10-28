package com.solvd.laba.block01.oop_hospital;

public class Medicine {
	private String name;
	private int pillsNumber;

	public Medicine(String name, int pillsNumber) {
		this.name = name;
		this.pillsNumber = pillsNumber;
	}

	public String getName() {
		return name;
	}

	public int getPillsNumber() {
		return pillsNumber;
	}
}
