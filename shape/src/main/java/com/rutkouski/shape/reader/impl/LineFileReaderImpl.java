package com.rutkouski.shape.reader.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rutkouski.shape.exception.ConeException;
import com.rutkouski.shape.reader.LineFileReader;

public class LineFileReaderImpl implements LineFileReader {
	
	static Logger logger = LogManager.getLogger();
	
	public List<String> readFileLines(String filePath) throws ConeException {
		
		ClassLoader loader = getClass().getClassLoader();
		URL resourse = loader.getResource(filePath);
		String path = new File(resourse.getFile()).getAbsolutePath();
		
		if (filePath == null || Files.notExists(Paths.get(path))) {
			logger.error("File is not found " + filePath);
			throw new ConeException("File is not found " + filePath);
		}
		List<String> stringLines;
		try {
			stringLines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
			
		} catch (IOException e) {
			logger.error("Failed or interrupted I/O operations ", e);
			throw new ConeException("Failed or interrupted I/O operations", e);
		}
		logger.info("Reading file is successful");
		return stringLines;
	}
}
