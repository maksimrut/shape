package com.rutkouski.shape.service;

import com.rutkouski.shape.entity.Cone;
import com.rutkouski.shape.entity.Point;

public interface ConeService {
	
	double calculateConeArea(Cone cone);
	
	double calculateConeVolume(Cone cone);
	
	double calculateVolumeRatio(Cone cone, Point planePoint);
	
	boolean isCone(Point top, double radius, double height);
	
	boolean isBaseOnTheXYPlane(Cone cone);
}
