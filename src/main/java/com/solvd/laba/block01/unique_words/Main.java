package com.solvd.laba.block01.unique_words;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class Main {
	static {
		System.setProperty("log4j.configurationFile", "log4j.xml");
	}

	private static final Logger LOGGER = LogManager.getLogger(com.solvd.laba.block01.oop_hospital.Main.class);

	public static void main(String[] args) {
		//final String filePath = args[0];
		String inputFilePath = "src/main/resources/unique_words/wolf.txt";
		String outputFilePath = "src/main/resources/unique_words/out.txt";
		String fileContent;


		try {
			fileContent = FileUtils.readFileToString(new File(inputFilePath), "UTF-8");

			WordsCounter wc = new WordsCounter(fileContent);
			LOGGER.info(wc.toString());

			try {
				File outputFile = new File(outputFilePath);
				FileUtils.touch(outputFile);
				FileUtils.writeStringToFile(outputFile, wc.toString(), "UTF-8");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		LOGGER.info("\n-- FINISH --");
	}
}
