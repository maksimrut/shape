package com.rutkouski.shape.util;

public class IdGenerator {

	private static int counter;
	
	private IdGenerator() {}
	
	public static int generateConeId() {
		return ++counter;
	}
}
