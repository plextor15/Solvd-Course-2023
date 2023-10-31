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

	public static String printTreatment(TypeOfTreatment t) {
		if (t == TypeOfTreatment.STAYINHOSPITAL) {
			return "stay in hospital";
		} else if (t == TypeOfTreatment.APPOINTMENTS) {
			return "appointments";
		}
		return "unknown treatment";
	}

	public String printThisTreatment() {
		if (this.whatTreatment == TypeOfTreatment.STAYINHOSPITAL) {
			return "stay in hospital";
		} else if (this.whatTreatment == TypeOfTreatment.APPOINTMENTS) {
			return "appontments";
		}
		return "unknown treatment";
	}

	public void setWhatTreatment(TypeOfTreatment whatTreatment) {
		this.whatTreatment = whatTreatment;
	}

}
