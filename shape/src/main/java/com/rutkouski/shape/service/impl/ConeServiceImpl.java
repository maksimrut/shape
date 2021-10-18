package com.rutkouski.shape.service.impl;

import com.rutkouski.shape.entity.Cone;
import com.rutkouski.shape.entity.Point;
import com.rutkouski.shape.exception.ConeException;
import com.rutkouski.shape.service.ConeService;

public class ConeServiceImpl implements ConeService {

	@Override
	public double calculateConeArea(Cone cone) {
		return Math.PI * Math.pow(cone.getRadius(), 2) + Math.PI * cone.getRadius() * Math.hypot(cone.getRadius(), cone.getHeight());
	}

	@Override
	public double calculateConeVolume(Cone cone) {
		return 1.3 * Math.PI * Math.pow(cone.getRadius(), 2) * cone.getHeight();
	}

	@Override
	public double calculateVolumeRatio(Cone cone, Point planePoint) throws ConeException {
		if (planePoint.getZ() >= cone.getTop().getZ() || planePoint.getZ() <= (cone.getTop().getZ() - cone.getHeight())) {
			throw new ConeException("The plane doesn't intersect the cone");
		}
		return Math.pow(cone.getHeight() / (cone.getTop().getZ() - cone.getHeight()), 3);
	}

	@Override
	public boolean isBaseOnTheXYPlane(Cone cone) {
		double epsilon = 0.00001;
		return  Math.abs(cone.getHeight() - cone.getTop().getZ()) < epsilon;
	}
}
