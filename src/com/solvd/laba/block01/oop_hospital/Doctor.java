package com.solvd.laba.block01.oop_hospital;

import java.util.ArrayList;
import java.util.Objects;

public class Doctor extends Person {
	public final String speciality;
	public ArrayList<Integer> assignedPatients;
	public final boolean isAvailable = true;

	public Doctor(String name, String surname, String speciality) {
		super(name, surname);
		this.speciality = speciality;
		this.assignedPatients = new ArrayList<Integer>();
	}

	@Override
	public String toString() {
		return "doctor " + this.name + " " + this.surname;
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

	public void diagnosePatient(Patient p) {
		Diagnosis diagnose = new Diagnosis();
		Treatment treatment = new Treatment();

		final Disease flu = new Disease("Flu", false);
		final Disease unknkownDisease = new Disease("Unknown", true);

		switch (p.symptoms.description) {
			case "Throat ache":
				diagnose.disease = flu;
				break;
			case "Pain in chest":
				//...
				break;
			default:
				diagnose.disease = unknkownDisease;
		}
		p.diagnosis = diagnose;

		if (p.diagnosis.disease.isDangerous) {
			treatment.setWhatTreatment(Treatment.TypeOfTreatment.STAYINHOSPITAL);
		} else {
			treatment.setWhatTreatment(Treatment.TypeOfTreatment.APPOINTMENTS);
			this.givePrescription(p);
		}
		diagnose.treatment = treatment;

		p.diagnosis = diagnose;
		System.out.println(p.toString() + " has been diagnosed with " + p.diagnosis.toString());
	}

	public void givePrescription(Patient p) {
		//public void givePrescription(Patient p, int days, int pills) {
		int days = p.symptoms.amountOfPain;
		int pillsPerDay;// = p.symptoms.amountOfPain;
		Medicine med = new Medicine("-", -1); //So there is no warning
		Prescription prescription;

		switch (p.diagnosis.disease.name) {
			case "Flu":
				med = new Medicine("Gripex", 15);
				break;
			case "Tonsillitis":
				//...
				break;
		}

		prescription = new Prescription(this, days, med.pillsNumber / days);
		prescription.medicines.add(med);
		p.prescription = prescription;

		System.out.println(this.toString() + " prescribed to " + p.toString() + " :");
		for (Medicine m : prescription.medicines) {
			System.out.println("    - " + m.name);
		}
		System.out.println("Patient should take " + prescription.takePillsPerDay + " per day for the next " + prescription.takeDays + " days.");
	}
}
