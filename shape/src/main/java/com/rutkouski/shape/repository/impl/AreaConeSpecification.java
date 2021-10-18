package com.rutkouski.shape.repository.impl;

import com.rutkouski.shape.entity.Cone;
import com.rutkouski.shape.repository.ConeSpecification;
import com.rutkouski.shape.service.impl.ConeServiceImpl;

public class AreaConeSpecification implements ConeSpecification {

	private double fromArea;
	private double toArea;
	
	public AreaConeSpecification(double fromArea, double toArea) {
		this.fromArea = fromArea;
		this.toArea = toArea;
	}
	
	@Override
	public boolean specify(Cone cone) {
		
		ConeServiceImpl coneServiceImpl = new ConeServiceImpl();
		boolean result = coneServiceImpl.calculateConeArea(cone) >= fromArea
						&& coneServiceImpl.calculateConeArea(cone) <= toArea;
		return	result;
	}
}
