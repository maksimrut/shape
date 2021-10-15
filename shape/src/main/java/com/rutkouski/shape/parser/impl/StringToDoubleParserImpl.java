package com.rutkouski.shape.parser.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rutkouski.shape.exception.ConeException;
import com.rutkouski.shape.parser.StringToDoubleParser;
import com.rutkouski.shape.validator.ConeDataValidator;

public class StringToDoubleParserImpl implements StringToDoubleParser {
	
	static Logger logger = LogManager.getLogger();
	
	public static final String DELIMITER_REGEX = "\\s+";

	public List<Double> parseToDouble(List<String> stringNumbersList) throws ConeException {
		
		if (stringNumbersList == null) {
			logger.error("String list for parsing is null");
			throw new ConeException("String list for parsing is null");
		}
		List<Double> listDouble = new ArrayList<Double>();
		
		stringNumbersList.stream().filter(s -> ConeDataValidator.validateDouble(s))
							.peek(s -> logger.debug(s))
							.flatMap(s -> Arrays.stream(s.split(DELIMITER_REGEX)))
							.forEach(s -> listDouble.add(Double.parseDouble(s)));
		return listDouble;
	}
}
