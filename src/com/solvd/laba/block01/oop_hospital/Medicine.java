package com.solvd.laba.block01.oop_hospital;

public class Medicine {
	public final String name;
	public final int pillsNumber;
	private Doctor doc;

	public Medicine(String name, int pillsNumber, Doctor d) {
		this.name = name;
		this.pillsNumber = pillsNumber;
		this.doc = d;
	}

	public Doctor getDoc() {
		return doc;
	}

	public void setDoc(Doctor doc) {
		this.doc = doc;
	}
}
