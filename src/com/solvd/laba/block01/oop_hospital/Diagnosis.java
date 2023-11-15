package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.interfaces.IPrintable;

public class Diagnosis implements IPrintable {
	private Disease disease;
	private Treatment treatment;

	public Diagnosis() {
		this.disease = new Disease("-", false);
		this.treatment = new Treatment();
	}

	@Override
	public String toString() {
		return disease.toString() + " - " + Treatment.printTreatmentType(this.treatment.getWhatTreatment());
	}

	@Override
	public String printOut() {
		return this.toString() + " is required";
	}

	public void setDisease(Disease d) {
		this.disease = d;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setTreatment(Treatment t) {
		this.treatment = t;
	}

	public Treatment getTreatment() {
		return treatment;
	}
}
