package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.exceptions.AmountOfPainBelowRangeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Symptoms {
	public String description;
	private int amountOfPain;
	private static final Logger LOGGER = LogManager.getLogger(Symptoms.class);

	public Symptoms(String description, int amountOfPain) {
		this.description = description;

		try {
			this.setAmountOfPain(amountOfPain);
		} catch (AmountOfPainBelowRangeException e) {
			LOGGER.warn(e.getMessage());
		}
	}

	public void setAmountOfPain(int amountOfPain) throws AmountOfPainBelowRangeException {
		if (amountOfPain < 1) {
			this.amountOfPain = 1;
			throw new AmountOfPainBelowRangeException("Specified amount of pain is out of range! Trimming to " + this.amountOfPain);
		}
		if (amountOfPain > 10) {
			this.amountOfPain = 10;
			throw new AmountOfPainBelowRangeException("Specified amount of pain is too high! Trimming to " + this.amountOfPain);
		}

		this.amountOfPain = amountOfPain;
	}

	public int getAmountOfPain() {
		return amountOfPain;
	}
}
