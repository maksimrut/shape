package com.rutkouski.shape.parser;

import java.util.List;
import com.rutkouski.shape.exception.ConeException;

public interface StringToDoubleParser {
	
	List<Double> parseToDouble(List<String> stringNumbersList) throws ConeException;
}
