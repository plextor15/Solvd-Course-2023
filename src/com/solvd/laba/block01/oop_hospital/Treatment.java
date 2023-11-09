package com.solvd.laba.block01.oop_hospital;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Treatment implements AutoCloseable {
	public enum TypeOfTreatment {
		STAYINHOSPITAL,
		APPOINTMENTS
	}

	private TypeOfTreatment whatTreatment;
	private static final Logger LOGGER = LogManager.getLogger(Treatment.class);

	@Override
	public String toString() {
		if (this.whatTreatment == TypeOfTreatment.STAYINHOSPITAL) {
			return "stay in hospital";
		} else if (this.whatTreatment == TypeOfTreatment.APPOINTMENTS) {
			return "appointments";
		}
		return "unknown treatment";
	}

	@Override
	public void close() throws Exception {
		throw new Exception("Treatment needed to be closed, because of wrong name!");
	}

	public Treatment() {
	}

	public Treatment(TypeOfTreatment t) {
		this.whatTreatment = t;
	}

	public TypeOfTreatment getWhatTreatment() {
		return whatTreatment;
	}

	public static String printTreatmentType(TypeOfTreatment t) {
		if (t == TypeOfTreatment.STAYINHOSPITAL) {
			return "stay in hospital";
		} else if (t == TypeOfTreatment.APPOINTMENTS) {
			return "appointments";
		}
		return "unknown treatment";
	}

	public void setWhatTreatment(TypeOfTreatment whatTreatment) {
		try (Treatment t = new Treatment(whatTreatment)) {
			this.whatTreatment = t.whatTreatment;
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
	}

}
