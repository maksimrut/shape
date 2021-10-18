package com.rutkouski.shape.factory;

import java.util.Arrays;

import com.rutkouski.shape.entity.Cone;
import com.rutkouski.shape.entity.Point;
import com.rutkouski.shape.exception.ConeException;
import com.rutkouski.shape.validator.ConeDataValidator;

public class ConeFactory {
	
	private static final int DATA_AMOUNT_FOR_CONE_CREATION = 5;
	
	private ConeFactory() {}
	
	public static Cone createCone(Point top, double radius, double height) throws ConeException {
		
		if (!(ConeDataValidator.isRadiusValid(radius) && ConeDataValidator.isHeightValid(height))) {
			throw new ConeException(String.format("Data is invalid: radius = %f, height = %f", radius, height));
		}
		return new Cone(top, radius, height);
	}
	
	public static Cone createCone(double x, double y, double z, double radius, double height) throws ConeException{
		
		if (!(ConeDataValidator.isRadiusValid(radius) && ConeDataValidator.isHeightValid(height))) {
			throw new ConeException(String.format("Data is invalid: radius = %f, height = %f", radius, height));
		}
		Point topCone = new Point(x, y, z);
		return new Cone(topCone, radius, height);
	}
	
	public static Cone createCone(double[] array) throws ConeException {
		
		if (array.length != DATA_AMOUNT_FOR_CONE_CREATION) {
			throw new ConeException(String.format("Parameters %s are invalid", Arrays.toString(array)));
		}
		Point top = new Point(array[0], array[1], array[2]);
		return new Cone(top, array[3], array[4]);
	}
}
