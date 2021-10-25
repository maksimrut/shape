package rutkouski.shape.service;

import org.testng.annotations.Test;

import com.rutkouski.shape.entity.Cone;
import com.rutkouski.shape.entity.Point;
import com.rutkouski.shape.exception.ConeException;
import com.rutkouski.shape.service.impl.ConeServiceImpl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;

public class ConeServiceTest {
	
  ConeServiceImpl �oneServiceImpl = new ConeServiceImpl();
  Cone cone = new Cone(new Point(2.5, 4, 3.0), 4, 3);

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      {new Point(2.4, .6, 0.5), Math.pow(3 / 2.5, 3)},
      {new Point(2.8, 1.6, 2), 27},
      {new Point(0.9, 11.6, 1), 27.0 / 8}
    };
  }
  
  @Test(dataProvider = "dp")
  public void calculateVolumeRatioTest(Point point, double expected) throws ConeException {
	  double actual = �oneServiceImpl.calculateVolumeRatio(cone, point);
	  assertEquals(actual, expected);
  }

  @Test (expectedExceptions = ConeException.class, expectedExceptionsMessageRegExp = "The plane doesn't intersect the cone")
  public void calculateVolumeRatioTest() throws ConeException {
	  �oneServiceImpl.calculateVolumeRatio(cone, new Point(2.3, 3.6, 0));
  }  
  
  @Test
  public void calculateConeAreaTest() {
	  double actual = �oneServiceImpl.calculateConeArea(cone);
	  double expected = Math.PI * 36;
	  assertEquals(actual, expected);
  }

  @Test
  public void calculateConeVolumeTest() {
	  double actual = �oneServiceImpl.calculateConeVolume(cone);
	  double expected = Math.PI * 62.4;
	  assertEquals(actual, expected);
  }

  @Test
  public void isBaseOnTheXYPlaneTest() {
	  boolean condition = �oneServiceImpl.isBaseOnTheXYPlane(cone);
	  assertTrue(condition);
  }
}
