package com.solvd.laba.block01.oop_hospital;

public class Diagnosis {
	public Disease disease;
	public Treatment treatment;

	@Override
	public String toString() {
		return disease.toString() + " (" + treatment.toString() + " required)";
	}
}
