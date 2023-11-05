/*
Create a class hierarchy. Topic will be assigned personally
Requirements:
- At least 10 classes
- All classes must contain properties (minimum 1)
- At least 5 private properties (in total, in any classes)
- All private variables must have getters and setters.
- All classes should have at least one custom constructor
- Create separate class with main() which will instantiate objects of implemented classes.

- Use polymorphism with at least one abstract class.
- Create and override at least one abstract method.
- Use protected modifier at least 5 times
- Override methods from class Object (toString(), hashcode(), equals()) for at least 3 classes from the hierarchy

- Topic assignments:

Hospital
give the patient a diagnosis and prescribe treatment
	(put in a hospital or write a prescription and make an appointment)
*/

package com.solvd.laba.block01.oop_hospital;


public class Main {
	public static void main(String[] args) {
		Hospital hospital = new Hospital("UCLA Medical Center", 10);
		Doctor doc = new Doctor("John", "Mitchell", "laryngologist");
		hospital.doctors.add(doc);

		Patient sickPatient = new Patient("Andrew", "Kowalsky", 30);
		sickPatient.symptoms = new Symptoms("Throat ache", 4);


		hospital.welcomeMessage();
		Doctor doctor = hospital.assignDoctor(sickPatient);

		doctor.diagnosePatient(sickPatient);
		hospital.provideTreatment(sickPatient);

//		if (sickPatient.givenTreatment.getWhatTreatment() == Treatment.TypeOfTreatment.STAYINHOSPITAL) {
//			doctor.keepPatientInHospital(sickPatient);
//		} else {
//			doctor.givePrescription(sickPatient, 7, 1);
//			doctor.makeApointment(sickPatient, "10-11-2023");
//		}

		System.out.println("-- FINISH --\n\n");
	}
}
