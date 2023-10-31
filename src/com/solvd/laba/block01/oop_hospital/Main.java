/*

Create a class hierarchy. Topic will be assigned personally
Requirements:
- At least 10 classes
- All classes must contain properties (minimum 1)
- At least 5 private properties (in total, in any classes)
- All private variables must have getters and setters.
- All classes should have at least one custom constructor
- Create separate class with main() which will instantiate objects of implemented classes.
- Topic assignments:

Hospital
give the patient a diagnosis and prescribe treatment
	(put in a hospital or write a prescription and make an appointment)
*/


/* -- Classes list --
01 Doctor
02 Patient
03 Prescription
04 Hospital
05 Appointment
06 Disease
07 StayInHospital
08 Treatment
09 Medicine
10 HospitalRoom
*/

package com.solvd.laba.block01.oop_hospital;


public class Main {
	public static void main(String[] args) {
		Hospital hospital = new Hospital("UCLA Medical Center", 10);
		Patient sickPatient = new Patient("Andrew", "Kowalsky", 30);
		Doctor doctor = new Doctor("John", "Mitchell");

		System.out.println("\n\nWelcome to " + hospital.hospitalName);

		doctor.diagnosePatient(sickPatient);
		doctor.giveTreatment(sickPatient);
		if (sickPatient.givenTreatment.getWhatTreatment() == Treatment.TypeOfTreatment.STAYINHOSPITAL) {
			doctor.keepPatientInHospital(sickPatient);
		} else {
			doctor.givePrescription(sickPatient, 7, 1);
			doctor.makeApointment(sickPatient, "10-11-2023");
		}

		System.out.println("-- FINISH --\n\n");
	}
}
