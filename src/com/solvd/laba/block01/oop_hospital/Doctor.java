package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.exceptions.StayInHospitalTooShortException;
import com.solvd.laba.block01.oop_hospital.exceptions.WrongTreatmentTypeException;
import com.solvd.laba.block01.oop_hospital.interfaces.IPrescribable;
import com.solvd.laba.block01.oop_hospital.interfaces.IPrintable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Doctor extends Person implements IPrintable, IPrescribable {
	public final String speciality;
	public List<Integer> assignedPatients;
	public final boolean isAvailable = true;

	private static final Logger LOGGER = LogManager.getLogger(Doctor.class);

	public Doctor(String name, String surname, String speciality) {
		super(name, surname);
		this.speciality = speciality;
		this.assignedPatients = new ArrayList<>();
	}

	@Override
	public String toString() {
		return this.name + " " + this.surname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Doctor doctor = (Doctor) o;
		return Objects.equals(this.name, doctor.name) && Objects.equals(this.surname, doctor.surname);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name, this.surname);
	}

	@Override
	public String printOut() {
		return "doctor " + this;
	}

	public void diagnosePatient(Patient p) {
		p.diagnosis = new Diagnosis();

		final Disease flu = new Disease("Flu", false);
		final Disease unknownDisease = new Disease("Unknown", true);

		switch (p.symptoms.description) {
			case "Throat ache":
				p.diagnosis.disease = flu;
				break;
			case "Pain in chest":
				//...
				break;
			default:
				p.diagnosis.disease = unknownDisease;
		}

		try {
			if (p.diagnosis.disease.isDangerous) {
				p.diagnosis.treatment.setWhatTreatment(Treatment.TypeOfTreatment.STAYINHOSPITAL);
				p.stayInHospital = new StayInHospital();
				p.stayInHospital.setAmountOfDays(p.symptoms.getAmountOfPain() * 2);
			} else {
				p.diagnosis.treatment.setWhatTreatment(Treatment.TypeOfTreatment.APPOINTMENTS);
				this.givePrescription(p);
			}
		} catch (WrongTreatmentTypeException | StayInHospitalTooShortException e) {
			LOGGER.warn(e.getMessage());
		}

		LOGGER.info(p.printOut() + " has been diagnosed with " + p.diagnosis.printOut());
	}

	@Override
	public void givePrescription(Patient p) {
		int days = p.symptoms.getAmountOfPain();
		Medicine med = new Medicine("", 0);
		Prescription prescription;

		final Medicine gripex = new Medicine("Gripex", 15);
		final Medicine unknown = new Medicine("Unknown", 0);

		switch (p.diagnosis.disease.name) {
			case "Flu":
				med = gripex;
				break;
			case "Tonsillitis":
				//...
				break;
			default:
				med = unknown;
		}

		prescription = new Prescription(this, days, med.pillsNumber / days);
		prescription.medicines.add(med);
		p.prescription = prescription;

		LOGGER.info(this.printOut() + " prescribed to " + p + " :");
		for (Medicine m : prescription.medicines) {
			LOGGER.info("    - " + m.name);
		}
		LOGGER.info("Patient should take " + prescription.takePillsPerDay + " per day for the next " + prescription.takeDays + " days.");
	}
}
