package com.solvd.laba.block01.oop_hospital;

public class Doctor {
	public final String name;
	public final String surname;

	public Doctor(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String printOut() {
		return this.name + " " + this.surname;
	}

	public void diagnosePatient(Patient p) {
		Disease d = new Disease();
		d.name = "Flu"; //some disease
		p.disease = d;

		System.out.println(p.printOut() + " has been diagnosed with " + p.disease);
	}

	public void giveTreatment(Patient p) {
		Treatment t = new Treatment();
		t.setWhatTreatment(Treatment.TypeOfTreatment.APPOINTMENTS);
		p.givenTreatment = t;

		System.out.println("Treatment is: " + p.givenTreatment.printThisTreatment());
	}

	public void keepPatientInHospital(Patient p) {
		//TO DO
		System.out.println("Patient " + p.printOut() + " needs to stay in hospital.");
	}

	public void givePrescription(Patient p) {
		Prescription prescription = new Prescription(this);
		Medicine med = new Medicine("Gripex", 10, this);
		prescription.medicines.add(med);

		System.out.println("Doctor " + this.printOut() + " prescribed to " + p.printOut() + " :");
		for (Medicine m : prescription.medicines) {
			System.out.println("    - " + name);
		}
	}
}
