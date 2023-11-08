package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.interfaces.IPrescribable;
import com.solvd.laba.block01.oop_hospital.interfaces.IPrintable;

import java.util.ArrayList;
import java.util.Objects;

public class Doctor extends Person implements IPrintable, IPrescribable {
	public final String speciality;
	public ArrayList<Integer> assignedPatients;
	public final boolean isAvailable = true;

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
		System.out.println(p.printOut() + " has been diagnosed with " + p.diagnosis.printOut());
	}

	@Override
	public void givePrescription(Patient p) {
		int days = p.symptoms.amountOfPain;
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

		System.out.println(this.printOut() + " prescribed to " + p + " :");
		for (Medicine m : prescription.medicines) {
			System.out.println("    - " + m.name);
		}
		System.out.println("Patient should take " + prescription.takePillsPerDay + " per day for the next " + prescription.takeDays + " days.");
	}
}
