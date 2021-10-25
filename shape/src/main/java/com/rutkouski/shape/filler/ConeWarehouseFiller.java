package com.rutkouski.shape.filler;

import com.rutkouski.shape.entity.Cone;
import com.rutkouski.shape.entity.ConeParameters;
import com.rutkouski.shape.entity.ConeWarehouse;
import com.rutkouski.shape.service.impl.ConeServiceImpl;

public class ConeWarehouseFiller {
	
	public void putConeToWarehouse(Cone cone) {
		
		int coneId = cone.getConeId();
		ConeServiceImpl coneServiceImpl = new ConeServiceImpl();
		double surfaceArea = coneServiceImpl.calculateConeArea(cone);
		double volume = coneServiceImpl.calculateConeVolume(cone);
		ConeParameters parameters = new ConeParameters(surfaceArea, volume);
		ConeWarehouse coneWarehouse = ConeWarehouse.getInstance();
		coneWarehouse.put(coneId, parameters);
	}
}
