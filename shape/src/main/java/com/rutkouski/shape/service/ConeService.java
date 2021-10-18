package com.rutkouski.shape.service;

import com.rutkouski.shape.entity.Cone;
import com.rutkouski.shape.entity.Point;
import com.rutkouski.shape.exception.ConeException;

public interface ConeService {
	
	double calculateConeArea(Cone cone);
	
	double calculateConeVolume(Cone cone);
	
	double calculateVolumeRatio(Cone cone, Point planePoint) throws ConeException;
	
	boolean isBaseOnTheXYPlane(Cone cone);
}
