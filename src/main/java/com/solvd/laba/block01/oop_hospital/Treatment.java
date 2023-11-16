package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.exceptions.WrongTreatmentTypeException;
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
	public void close() {
		LOGGER.info("Current treatment is set to " + this.toString());
	}

	public Treatment() {
	}

	public Treatment(TypeOfTreatment t) {
		try (Treatment treat = new Treatment(t)) {
			this.setWhatTreatment(treat.whatTreatment);
		} catch (WrongTreatmentTypeException e) {
			LOGGER.warn(e.getMessage());
		}
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
		return "[unknown treatment]";
	}

	public void setWhatTreatment(TypeOfTreatment whatTreatment) throws WrongTreatmentTypeException {
		if (whatTreatment != TypeOfTreatment.STAYINHOSPITAL
				&& whatTreatment != TypeOfTreatment.APPOINTMENTS) {
			this.whatTreatment = TypeOfTreatment.STAYINHOSPITAL;
			throw new WrongTreatmentTypeException("Wrong type of treatment! Setting type to " + this.toString());
		}
		this.whatTreatment = whatTreatment;
	}
}
