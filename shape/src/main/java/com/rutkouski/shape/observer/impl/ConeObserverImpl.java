package com.rutkouski.shape.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rutkouski.shape.entity.Cone;
import com.rutkouski.shape.entity.ConeParameters;
import com.rutkouski.shape.entity.ConeWarehouse;
import com.rutkouski.shape.observer.ConeEvent;
import com.rutkouski.shape.observer.ConeObserver;
import com.rutkouski.shape.service.impl.ConeServiceImpl;

public class ConeObserverImpl implements ConeObserver {

	static Logger logger = LogManager.getLogger();
	
	@Override
	public void changeParameters(ConeEvent event) {
		
		ConeWarehouse coneWarehouse = ConeWarehouse.getInstance();
		ConeServiceImpl coneServiceImpl = new ConeServiceImpl();
		Cone cone = event.getSource();
		
		double area = coneServiceImpl.calculateConeArea(cone);
		double volume = coneServiceImpl.calculateConeVolume(cone);
		ConeParameters coneParameters = new ConeParameters(area, volume);
		int id = cone.getConeId();
		coneWarehouse.put(id, coneParameters);
		
		logger.info("Parameters of the cone #{} were updated", id);
	}
}
