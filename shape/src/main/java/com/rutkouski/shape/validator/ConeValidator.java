package com.rutkouski.shape.validator;

public class ConeValidator {
	
	private ConeValidator() {}
	
	private static final String CONE_STRING_LINE_REGEX = "^(-?\\d+\\.?\\d*){1}(\\s+(-?\\d+\\.?\\d*)){2}(\\s+(\\d+\\.?\\d*)){2}$";
	
	public static boolean validateIsCone(String lineOfFiveNumbers) {
		return lineOfFiveNumbers != null && lineOfFiveNumbers.matches(CONE_STRING_LINE_REGEX);
	}
}
