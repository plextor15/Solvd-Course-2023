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
		Disease flu = new Disease("Flu", false);
		Disease unknkownDisease = new Disease("Unknown", true);

		Diagnosis diagnose = new Diagnosis();
		Treatment treatment = new Treatment();

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

		if (p.diagnosis.disease.isDangerous) {
			treatment.setWhatTreatment(Treatment.TypeOfTreatment.STAYINHOSPITAL);
		} else {
			treatment.setWhatTreatment(Treatment.TypeOfTreatment.APPOINTMENTS);
		}
		diagnose.treatment = treatment;

		p.diagnosis = diagnose;
	}

	public void keepPatientInHospital(Patient p) {

		System.out.println(p.toString() + " needs to stay in hospital.");
	}

	public void givePrescription(Patient p, int days, int pills) {
		Prescription prescription = new Prescription(this, days, pills);
		Medicine med = new Medicine("Gripex", 10, this); //Hardcoded for now
		prescription.medicines.add(med);

		System.out.println("Doctor " + this.toString() + " prescribed to " + p.toString() + " :");
		for (Medicine m : prescription.medicines) {
			System.out.println("    - " + m.name);
		}
		System.out.println("Patient should take " + prescription.takePillsPerDay + " per day for the next " + prescription.takeDays + " days.");
	}

//	public void makeApointment(Patient p, String date) {
//		Appointment ap = new Appointment(date, this);
//		System.out.println(this.toString() + " has an apointment on " + ap.getDate() + " with " + p.toString());
//	}
}
