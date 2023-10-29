package com.solvd.laba.block01.oop_hospital;

public class Appointment {
	private String date;
	private Doctor doc;

	public Appointment() {
	}

	public Appointment(String date, Doctor doc) {
		this.date = date;
		this.doc = doc;

		System.out.println("Appointment with doctor " + this.doc.printOut() + " has been set to: " + this.date);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDoc(Doctor doc) {
		this.doc = doc;
	}

	public Doctor getDoc() {
		return doc;
	}
}
