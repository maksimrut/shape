package com.rutkouski.shape.repository.impl;

import com.rutkouski.shape.entity.Cone;
import com.rutkouski.shape.repository.ConeSpecification;

public class IdConeSpecification implements ConeSpecification {

	private int fromId;
	private int toId;
	
	public IdConeSpecification(int fromId, int toId) {
		this.fromId = fromId;
		this.toId = toId;
	}
	
	@Override
	public boolean specify(Cone cone) {
		return cone.getConeId() >= fromId && cone.getConeId() <= toId;
	}
}
