/*
Create a class hierarchy: Hospital
give the patient a diagnosis and prescribe treatment (put in a hospital or write a prescription and make an appointment)

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

- Add 5 interfaces to the existing hierarchy.
- Use polymorphism with the abstract class and interface from the hierarchy.
- Create final class, method, variable.
- Create a static block, method, variable.

- Create 5 custom exceptions. Some of them should be Runtime exceptions
- Handle exceptions in 2 ways: with throws and try/catch
- Use try-catch with resources.
- Add Logger usage. Log messages to the console and file file. Replace System.out calls with Loggers across entire project

- Add 5 collections to the hierarchy.
- Create custom LinkedList with generic and apply it in your classes structure.
*/

package com.solvd.laba.block01.oop_hospital;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	static {
		System.setProperty("log4j.configurationFile", "log4j.xml");
	}

	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		Hospital hospital = new Hospital("UCLA Medical Center", 10);
		Doctor doc = new Doctor("John", "Mitchell", "laryngologist", "27-11-2023", true);
		hospital.doctors.add(doc);

		Patient sickPatient = new Patient("Andrew", "Kowalsky", 30);
		sickPatient.symptoms = new Symptoms("Throat ache", 4);


		hospital.welcomeMessage();
		hospital.assignDoctor(sickPatient).diagnosePatient(sickPatient);
		hospital.provideTreatment(sickPatient);

		LOGGER.info("\n-- FINISH --");
	}
}
