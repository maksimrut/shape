package rutkouski.shape.parser;

import org.testng.annotations.Test;

import com.rutkouski.shape.exception.ConeException;
import com.rutkouski.shape.parser.impl.StringToDoubleParserImpl;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.AfterMethod;

public class StringToDoubleParserTest {
  
	List<String> listStringCorrect = new ArrayList<String>(Arrays.asList("54.8   -43.6 25.4 26    3", "23  234 0. 2331 2"));
	List<String> listStringIncorrect = new ArrayList<String>(Arrays.asList("54 rt -43 25 22"));
	StringToDoubleParserImpl stringToDoubleParserImpl;
	
	@BeforeMethod
	public void setUp() {
		stringToDoubleParserImpl = new StringToDoubleParserImpl();
	}

	@AfterMethod
	public void tearDown() {
		stringToDoubleParserImpl = null;
	}
	
	@Test (expectedExceptions = ConeException.class, expectedExceptionsMessageRegExp = "String list for parsing is null")
	public void parseToDoubleNullPointerExceptionTest() throws ConeException {
		stringToDoubleParserImpl.parseToDouble(null);
	}

	@Test
	public void parseToDoubleCorrectTest() throws ConeException {
		String actual = stringToDoubleParserImpl.parseToDouble(listStringCorrect).toString();
		String expected = "[54.8, -43.6, 25.4, 26.0, 3.0, 23.0, 234.0, 0.0, 2331.0, 2.0]";
 		assertEquals(actual, expected);
	}
	
	@Test
	public void parseToDoubleIncorrectTest() throws ConeException {
		String actual = stringToDoubleParserImpl.parseToDouble(listStringIncorrect).toString();
		String expected = "[]";
 		assertEquals(actual, expected);
	}
}
