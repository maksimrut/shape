package com.rutkouski.shape.validator;

public class ConeDataValidator {
	
	private ConeDataValidator() {}
	
	private static final String CONE_DATA_REGEX = "^(-?\\d+\\.?\\d*){1}(\\s+(-?\\d+\\.?\\d*)){2}(\\s+(\\d+\\.?\\d*)){2}$";
	
	public static boolean validateDouble(String lineOfFiveNumbers) {
		
		return lineOfFiveNumbers != null? lineOfFiveNumbers.matches(CONE_DATA_REGEX) : false;
	}
}
