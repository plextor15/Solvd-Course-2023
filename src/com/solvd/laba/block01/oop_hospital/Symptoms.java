package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.exceptions.AmountOfPainOutOfRangeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Symptoms {
	private String description;
	private int amountOfPain;
	private static final Logger LOGGER = LogManager.getLogger(Symptoms.class);

	public Symptoms(String description, int amountOfPain) {
		this.description = description;

		try {
			this.setAmountOfPain(amountOfPain);
		} catch (AmountOfPainOutOfRangeException e) {
			LOGGER.warn(e.getMessage());
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAmountOfPain(int amountOfPain) throws AmountOfPainOutOfRangeException {
		if (amountOfPain < 1) {
			this.amountOfPain = 1;
			throw new AmountOfPainOutOfRangeException("Specified amount of pain is out of range! Trimming to " + this.amountOfPain);
		}
		if (amountOfPain > 10) {
			this.amountOfPain = 10;
			throw new AmountOfPainOutOfRangeException("Specified amount of pain is too high! Trimming to " + this.amountOfPain);
		}

		this.amountOfPain = amountOfPain;
	}

	public int getAmountOfPain() {
		return amountOfPain;
	}
}
