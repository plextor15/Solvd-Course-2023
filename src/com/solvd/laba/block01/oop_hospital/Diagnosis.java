package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.interfaces.IPrintable;

public class Diagnosis implements IPrintable {
	public Disease disease;
	public Treatment treatment;

	@Override
	public String toString() {
		return disease.toString() + " - " + Treatment.printTreatmentType(this.treatment.getWhatTreatment());
	}

	@Override
	public String printOut() {
		return this + " is required";
	}
}
