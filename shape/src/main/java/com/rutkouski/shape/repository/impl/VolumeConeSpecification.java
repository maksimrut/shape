package com.rutkouski.shape.repository.impl;

import com.rutkouski.shape.entity.Cone;
import com.rutkouski.shape.repository.ConeSpecification;
import com.rutkouski.shape.service.impl.ConeServiceImpl;

public class VolumeConeSpecification implements ConeSpecification {
	
	private double fromVolume;
	private double toVolume;
	
	public VolumeConeSpecification(double fromVolume, double toVolume) {
		this.fromVolume = fromVolume;
		this.toVolume = toVolume;
	}
	
	@Override
	public boolean specify(Cone cone) {

		ConeServiceImpl coneServiceImpl = new ConeServiceImpl();
		return coneServiceImpl.calculateConeVolume(cone) >= fromVolume
						&& coneServiceImpl.calculateConeVolume(cone) <= toVolume;
	}
}
