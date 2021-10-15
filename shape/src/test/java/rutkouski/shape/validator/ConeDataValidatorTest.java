package rutkouski.shape.validator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.rutkouski.shape.validator.ConeDataValidator;

public class ConeDataValidatorTest {
	
	String strCorrect = "54.8   -43.6 25.4 26    3";
	String strIncorrect = "54.8 25.4 26    3";
	
	
  @Test
  public void validateDoubleCorrectTest() {
	  assertTrue(ConeDataValidator.validateDouble(strCorrect));
  }
  
  @Test
  public void validateDoubleIncorrectTest() {
	  assertFalse(ConeDataValidator.validateDouble(strIncorrect));
  }
}
