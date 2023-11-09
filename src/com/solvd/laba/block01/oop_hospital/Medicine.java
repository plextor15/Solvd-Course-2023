package com.solvd.laba.block01.oop_hospital;

public class Medicine {
	public final String name;
	public final int pillsNumber;

	public Medicine(String name, int pillsNumber) {
		this.name = name;
		this.pillsNumber = pillsNumber;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Medicine medicine = (Medicine) o;

		if (pillsNumber != medicine.pillsNumber) {
			return false;
		}
		return name.equals(medicine.name);
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + pillsNumber;
		return result;
	}
}
