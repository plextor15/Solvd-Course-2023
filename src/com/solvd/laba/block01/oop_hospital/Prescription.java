package com.solvd.laba.block01.oop_hospital;

import java.util.ArrayList;
import java.util.Random;

public class Prescription {
	public ArrayList<Medicine> medicines;
	public final int barCode;
	public final Doctor doc;
	public final int takeDays;
	public final int takePillsPerDay;


	public Prescription(Doctor doc, int days, int pills) {
		this.doc = doc;
		this.barCode = new Random().nextInt(1000, 9999);
		this.takeDays = days;
		this.takePillsPerDay = pills;

		medicines = new ArrayList<Medicine>();
	}
}
