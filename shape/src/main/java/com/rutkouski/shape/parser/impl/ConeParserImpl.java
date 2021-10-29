package com.rutkouski.shape.parser.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rutkouski.shape.exception.ConeException;
import com.rutkouski.shape.parser.ConeParser;
import com.rutkouski.shape.validator.ConeValidator;

public class ConeParserImpl implements ConeParser {
	
	static Logger logger = LogManager.getLogger();
	
	private static final String DELIMITER_REGEX = "\\s+";

	public List<Double> parseCone(List<String> stringNumbersList) throws ConeException {
		
		if (stringNumbersList == null) {
			logger.error("String list for parsing is null");
			throw new ConeException("String list for parsing is null");
		}
		List<Double> listDouble = new ArrayList<>();
		
		stringNumbersList.stream().filter(ConeValidator::validateIsCone)
							.peek(s -> logger.debug(s))
							.flatMap(s -> Arrays.stream(s.split(DELIMITER_REGEX)))
							.forEach(s -> listDouble.add(Double.parseDouble(s)));
		logger.info("Parsing data is successful");
		return listDouble;
	}
}
