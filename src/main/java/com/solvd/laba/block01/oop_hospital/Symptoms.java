package com.solvd.laba.block01.oop_hospital;

import com.solvd.laba.block01.oop_hospital.exceptions.AmountOfPainOutOfRangeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Symptoms {
	private final int MINPAIN = 1;
	private final int MAXPAIN = 10;

	private String description;
	private int amountOfPain;
	private static final Logger LOGGER = LogManager.getLogger(Symptoms.class);

	public Symptoms(String description, int amountOfPain) throws AmountOfPainOutOfRangeException {
		this.description = description;

		this.setAmountOfPain(amountOfPain);
//		try {
//			this.setAmountOfPain(amountOfPain);
//		} catch (AmountOfPainOutOfRangeException e) {
//			LOGGER.warn(e.getMessage());
//		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAmountOfPain(int amountOfPain) throws AmountOfPainOutOfRangeException {
		if (amountOfPain < MINPAIN) {
			this.amountOfPain = MINPAIN;
			throw new AmountOfPainOutOfRangeException("Specified amount of pain is out of range! Trimming to " + this.amountOfPain);
		}
		if (amountOfPain > MAXPAIN) {
			this.amountOfPain = MAXPAIN;
			throw new AmountOfPainOutOfRangeException("Specified amount of pain is too high! Trimming to " + this.amountOfPain);
		}

		this.amountOfPain = amountOfPain;
	}

	public int getAmountOfPain() {
		return amountOfPain;
	}
}
