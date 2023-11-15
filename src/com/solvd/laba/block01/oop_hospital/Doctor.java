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
	private final String speciality;
	private List<Integer> assignedPatients;
	private final boolean isAvailable;
	private String availableDate;

	private static final Logger LOGGER = LogManager.getLogger(Doctor.class);

	public Doctor(String name, String surname, String speciality, String availableDate, boolean isAvailable) {
		super(name, surname);
		this.speciality = speciality;
		this.assignedPatients = new ArrayList<>();
		this.availableDate = availableDate;
		this.isAvailable = isAvailable;
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

	public String getSpeciality() {
		return speciality;
	}

	public void addToAssignedPatients(Patient p) {
		this.assignedPatients.add(p.hashCode());
	}

	public boolean getAvailability() {
		return this.isAvailable;
	}

	public String getAvailableDay() {
		return availableDate;
	}

	public void diagnosePatient(Patient p) {
		p.diagnosis = new Diagnosis();

		final Disease flu = new Disease("Flu", false);
		final Disease unknownDisease = new Disease("Unknown", true);

		switch (p.symptoms.getDescription()) {
			case "Throat ache":
				p.diagnosis.setDisease(flu);
				break;
			case "Pain in chest":
				//...
				break;
			default:
				p.diagnosis.setDisease(unknownDisease);
		}

		try {
			if (p.diagnosis.getDisease().isDangerous()) {
				p.diagnosis.getTreatment().setWhatTreatment(Treatment.TypeOfTreatment.STAYINHOSPITAL);
				p.stayInHospital = new StayInHospital();
				p.stayInHospital.setAmountOfDays(p.symptoms.getAmountOfPain() * 2);
			} else {
				p.diagnosis.getTreatment().setWhatTreatment(Treatment.TypeOfTreatment.APPOINTMENTS);
				this.givePrescription(p);
			}
		} catch (WrongTreatmentTypeException | StayInHospitalTooShortException e) {
			LOGGER.warn(e.getMessage());
		}

		LOGGER.info(p.printOut() + " has been diagnosed with " + p.diagnosis.printOut());
		LOGGER.info(p.prescription.printOut(p));
	}

	@Override
	public void givePrescription(Patient p) {
		int days = p.symptoms.getAmountOfPain();
		Medicine med = new Medicine("", 0);
		Prescription prescription;

		final Medicine gripex = new Medicine("Gripex", 15);
		final Medicine unknown = new Medicine("Unknown", 0);

		switch (p.diagnosis.getDisease().getName()) {
			case "Flu":
				med = gripex;
				break;
			case "Tonsillitis":
				//...
				break;
			default:
				med = unknown;
		}

		prescription = new Prescription(this, days, med.getPillsNumber() / days);
		prescription.addMedicines(med);
		p.prescription = prescription;
	}
}
