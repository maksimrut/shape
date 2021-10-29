package com.rutkouski.shape.comparator;

import java.util.Comparator;
import java.util.function.ToDoubleFunction;

import com.rutkouski.shape.entity.Cone;
import com.rutkouski.shape.exception.ConeException;
import com.rutkouski.shape.service.impl.ConeServiceImpl;

public enum ConeComparator {
	ID, AREA, VOLUME, POINT_TOP;

	public Comparator<Cone> getComparator() throws ConeException {
		
		ConeServiceImpl coneServiceImpl = new ConeServiceImpl();
		
		return switch(this) {
		
			case ID -> Comparator.comparingInt(Cone :: getConeId);
			
			case AREA -> Comparator.comparingDouble((ToDoubleFunction<Cone>) coneServiceImpl::calculateConeArea);
					
			case VOLUME -> Comparator.comparingDouble((ToDoubleFunction<Cone>) coneServiceImpl::calculateConeVolume);
			
			case POINT_TOP -> Comparator.comparingDouble((ToDoubleFunction<Cone>) cone -> 
							cone.getTop().getX())
							.thenComparing(cone -> cone.getTop().getY())
							.thenComparing(cone -> cone.getTop().getZ());
			
			default -> throw new ConeException("There is no such enum case");
		};
	}
}
