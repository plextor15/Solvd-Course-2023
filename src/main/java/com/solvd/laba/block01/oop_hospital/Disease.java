package com.solvd.laba.block01.oop_hospital;

import java.util.Objects;

public class Disease {
	private final String name;
	private boolean isDangerous;

	public Disease(String illness, boolean isDangerous) {
		this.name = illness;
		this.isDangerous = isDangerous;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Disease disease = (Disease) o;

		if (isDangerous != disease.isDangerous) return false;
		return Objects.equals(name, disease.name);
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (isDangerous ? 1 : 0);
		return result;
	}

	public String getName() {
		return name;
	}

	public boolean isDangerous() {
		return isDangerous;
	}

	public void setDangerous(boolean dangerous) {
		isDangerous = dangerous;
	}
}
