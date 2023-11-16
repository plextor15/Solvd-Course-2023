package com.solvd.laba.block01.oop_hospital.interfaces;

import com.solvd.laba.block01.oop_hospital.Doctor;
import com.solvd.laba.block01.oop_hospital.Patient;

public interface IAppointable {
	void makeAppointment(Patient p, Doctor doc);
}
