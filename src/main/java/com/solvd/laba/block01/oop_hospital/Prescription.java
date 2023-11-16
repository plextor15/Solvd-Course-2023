package com.solvd.laba.block01.oop_hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Prescription {
	private List<Medicine> medicines;
	private final int barCode;
	private final Doctor doc;
	private final int takeDays;
	private final int takePillsPerDay;


	public Prescription(Doctor doc, int days, int pills) {
		this.doc = doc;
		this.barCode = new Random().nextInt(9999);
		this.takeDays = days;
		this.takePillsPerDay = pills;

		medicines = new ArrayList<Medicine>();
	}

	public void addMedicines(Medicine m) {
		this.medicines.add(m);
	}

	public String printOut(Patient p) {
		String print = new String(this.doc.printOut() + " prescribed to " + p + " :\n");
		for (Medicine m : this.medicines) {
			print += "    - " + m.getName() + "\n";
		}
		print += "Patient should take " + this.takePillsPerDay + " per day for the next " + this.takeDays + " days.";
		return print;
	}
}
