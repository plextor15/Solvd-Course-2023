package com.solvd.laba.block01.oop_hospital;

abstract class Person {
	public final String name;
	public final String surname;

	protected Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	@Override
	public String toString() {
		return name + " " + surname;
	}
}
