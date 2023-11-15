package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.exceptions.NoAvailableDoctorException;
import com.solvd.laba.block01.oop_hospital.interfaces.IAppointable;
import com.solvd.laba.block01.oop_hospital.interfaces.ITreatable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;

public final class Hospital extends HealthcareEntity implements ITreatable, IAppointable {
	private final int amountOfRooms;
	private HashSet<HospitalRoom> hospitalRooms;
	private static int howManyHospitals = 0;

	private static final Logger LOGGER = LogManager.getLogger(Hospital.class);

	static {
		LOGGER.info("Hospital no." + (++howManyHospitals) + " successfully created.\n");
	}

	public Hospital(String hospitalName, int amountOfRooms) {
		super(hospitalName);
		this.amountOfRooms = amountOfRooms;

		this.hospitalRooms = new HashSet<HospitalRoom>();
		for (int i = 0; i < amountOfRooms; i++) {
			HospitalRoom hospitalRoom = new HospitalRoom(i);
			hospitalRooms.add(hospitalRoom);
		}
	}

	@Override
	public String toString() {
		return this.Name;
	}

	public int getAmountOfRooms() {
		return amountOfRooms;
	}

	@Override
	public void welcomeMessage() {
		LOGGER.info("\nWelcome to " + this.toString());
	}

	public Doctor assignDoctor(Patient p) {
		int i;

		for (i = 0; i < doctors.size(); i++) {
			if (doctors.get(i).getAvailability()) {
				doctors.get(i).addToAssignedPatients(p);
				p.assignedDoctor = doctors.get(i).hashCode();
				this.patients.add(p);

				LOGGER.info(doctors.get(i).printOut() + "has been assigned to " + p.printOut());
				break;
			} else {
				if (i == (doctors.size() - 1)) {
					throw new NoAvailableDoctorException("There is no doctor available!");
				}
			}
		}

		return doctors.get(i);
	}

	private String whenDoctorAvailable(Doctor d) {
		final String appointmentDate = d.getAvailableDay();
		return appointmentDate;
	}

	@Override
	public void makeAppointment(Patient p, Doctor doc) {
		String appointmentDate = whenDoctorAvailable(doc);
		Appointment ap = new Appointment(appointmentDate, doc);
		appointments.add(ap);
		LOGGER.info(doc.toString() + " has an appointment on " + ap.getDate() + " with " + p.toString());
	}

	public void keepPatientInHospital(Patient p) {
		for (HospitalRoom h : hospitalRooms) {
			if (h.getFreeBeds() > 0) {
				h.addPatient(p);

				LOGGER.info(p.toString() + " needs to stay in hospital. Patient is in room " + h);
				break;
			}
		}
	}

	@Override
	public void provideTreatment(Patient p) {
		if (p.diagnosis.getTreatment().getWhatTreatment() == Treatment.TypeOfTreatment.STAYINHOSPITAL) {
			this.keepPatientInHospital(p);
		} else {
			for (int i = 0; i < this.doctors.size(); i++) {
				if (p.assignedDoctor == this.doctors.get(i).hashCode()) {
					this.makeAppointment(p, this.doctors.get(i));
					break;
				}
			}
		}
	}
}
