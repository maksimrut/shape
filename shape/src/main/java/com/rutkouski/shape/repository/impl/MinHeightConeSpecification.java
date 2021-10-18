package com.rutkouski.shape.repository.impl;

import com.rutkouski.shape.entity.Cone;
import com.rutkouski.shape.repository.ConeSpecification;

public class MinHeightConeSpecification implements ConeSpecification {

	private double minHeight;
	
	public MinHeightConeSpecification(double minHeight) {
		super();
		this.minHeight = minHeight;
	}

	@Override
	public boolean specify(Cone cone) {
		return cone.getHeight() >= minHeight;
	}
}
