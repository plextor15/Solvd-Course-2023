package com.solvd.laba.block01.oop_hospital;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Appointment {
	private String date;
	private Doctor doc;

	private static final Logger LOGGER = LogManager.getLogger(Appointment.class);

	public Appointment() {
	}

	public Appointment(String date, Doctor doc) {
		this.date = date;
		this.doc = doc;

		LOGGER.info("Appointment with " + this.doc.toString() + " has been set to: " + this.date);
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
