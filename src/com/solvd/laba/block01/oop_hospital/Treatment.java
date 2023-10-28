package com.solvd.laba.block01.oop_hospital;


public class Treatment {
	public enum TypeOfTreatment {
		STAYINHOSPITAL,
		APPOINTMENTS
	}

	private TypeOfTreatment whatTreatment;

	public TypeOfTreatment getWhatTreatment() {
		return whatTreatment;
	}

	public void setWhatTreatment(TypeOfTreatment whatTreatment) {
		this.whatTreatment = whatTreatment;
	}
}
