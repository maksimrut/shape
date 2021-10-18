package com.rutkouski.shape.parser;

import java.util.List;
import com.rutkouski.shape.exception.ConeException;

public interface ConeParser {
	
	List<Double> parseCone(List<String> stringNumbersList) throws ConeException;
}
