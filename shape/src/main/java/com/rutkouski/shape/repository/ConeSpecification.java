package com.rutkouski.shape.repository;

import com.rutkouski.shape.entity.Cone;

@FunctionalInterface
public interface ConeSpecification {
	
	boolean specify(Cone cone);
}
