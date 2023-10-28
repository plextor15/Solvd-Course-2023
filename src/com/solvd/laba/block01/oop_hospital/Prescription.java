package com.solvd.laba.block01.oop_hospital;

import java.util.ArrayList;
import java.util.Random;

public class Prescription {
	public ArrayList<Medicine> medicines;
	public final int barCode;
	public final Doctor doc;


	public Prescription(Doctor doc) {
		this.doc = doc;
		this.barCode = new Random().nextInt(1000, 9999);
	}
}
