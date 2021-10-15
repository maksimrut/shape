package com.rutkouski.shape.util;

public class idGenerator {

	private static int counter;
	
	private idGenerator() {}
	
	static int generateConeId() {
		return ++counter;
	}
}
