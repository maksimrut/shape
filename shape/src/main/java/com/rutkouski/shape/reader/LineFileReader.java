package com.rutkouski.shape.reader;

import java.util.List;

import com.rutkouski.shape.exception.ConeException;

public interface LineFileReader {
	
	List<String> readFileLines(String filePath) throws ConeException;
}
