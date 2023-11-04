package com.solvd.laba.block01.oop_hospital;

import java.util.ArrayList;

public class Hospital {
	public final String hospitalName;
	public final int amountOfRooms;

	private ArrayList<Patient> patients;
	public ArrayList<Doctor> doctors;
	public ArrayList<Appointment> appointments;
	private HospitalRoom[] hospitalRooms;

	public Hospital(String hospitalName, int amountOfRooms) {
		this.hospitalName = hospitalName;
		this.amountOfRooms = amountOfRooms;

		HospitalRoom[] rooms = new HospitalRoom[amountOfRooms];
		for (int i = 0; i < amountOfRooms; i++) {
			HospitalRoom hospitalRoom = new HospitalRoom(i);
			rooms[i] = hospitalRoom;
		}
		this.hospitalRooms = rooms;
	}

	@Override
	public String toString() {
		return this.hospitalName;
	}

	public void welcomeMessage() {
		System.out.println("\nWelcome to " + this.toString() + "\n");
	}

	public Doctor assignDoctor(Patient p) {
		int i = 0;

		for (Doctor d : doctors) {
			if (d.isAvailable) {
				i = doctors.indexOf(d);
				d.assignedPatients.add(p.hashCode());
				p.assignedDoctor = d.hashCode();
			}
		}

		this.patients.add(p);
		return doctors.get(i);
	}

	private String whenDoctorAvailable(Doctor d) {
		//...
		return "20-11-2023";
	}

	public void makeAppointment(Patient p, Doctor doc) {
		String appointmentDate = whenDoctorAvailable(doc);
		Appointment ap = new Appointment(appointmentDate, doc);
		appointments.add(ap);
		System.out.println(doc.toString() + " has an appointment on " + ap.getDate() + " with " + p.toString());
	}

	public void keepPatientInHospital(Patient p) {
		for (HospitalRoom h : hospitalRooms) {
			if (h.getFreeBeds() > 0) {
				h.addPatient(p);

				System.out.println(p.toString() + " needs to stay in hospital. Patient is in room " + h.toString());
				break;
			}
		}
	}

	public void provideTreatment(Patient p) {
		if (p.diagnosis.treatment.getWhatTreatment() == Treatment.TypeOfTreatment.STAYINHOSPITAL) {
			this.keepPatientInHospital(p);
		} else {
			for (Doctor d : this.doctors) {
				if (p.assignedDoctor == d.hashCode()) {

					this.makeAppointment(p, d);
					d.givePrescription(p,);

					break;
				}
			}
		}
	}
}
