package rutkouski.shape.reader;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rutkouski.shape.exception.ConeException;
import com.rutkouski.shape.reader.impl.LineFileReaderImpl;

public class LineFileReaderTest {
	
	LineFileReaderImpl lineFileReaderImpl;
	String noExistingFilePath = "testFiles\\conesList2.txt";
	String correctFilePath = "src\\test\\resources\\testFiles\\conesList.txt";

	@BeforeMethod
	public void setUp() {
		lineFileReaderImpl = new LineFileReaderImpl();
	}
	
	@Test (expectedExceptions = ConeException.class)
	public void readFileLinesFileNotExistsTest() throws ConeException{
		lineFileReaderImpl.readFileLines(noExistingFilePath);
	}
	
	@Test (expectedExceptions = ConeException.class)
	public void readFileLinesNullPointerTest() throws ConeException{
		lineFileReaderImpl.readFileLines(null);
	}
	
	@Test
	public void readFileLinesCorrectTest() throws ConeException {
		String actual = lineFileReaderImpl.readFileLines(correctFilePath).toString();
		String expected = "[34    354 34 77 0.1, ge 56.0  0.0 hi]";
 		assertEquals(actual, expected);
	}
	
	@AfterMethod
	public void tearDown() {
		lineFileReaderImpl = null;
	}
}
