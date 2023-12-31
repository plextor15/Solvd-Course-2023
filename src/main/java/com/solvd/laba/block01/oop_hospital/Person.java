package com.solvd.laba.block01.oop_hospital;

public abstract class Person {
	protected final String name;
	protected final String surname;

	protected Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	@Override
	public String toString() {
		return this.name;
	}

	protected void creationInfo() {
		System.out.print(this.name + " created.");
	}
}
