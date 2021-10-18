package com.rutkouski.shape.comparator;

import java.util.Comparator;
import java.util.function.ToDoubleFunction;

import com.rutkouski.shape.entity.Cone;
import com.rutkouski.shape.entity.ConeWarehouse;
import com.rutkouski.shape.exception.ConeException;

public enum ConeComparator {
	ID, AREA, VOLUME, POINT_TOP;

	public Comparator<Cone> getComparator() throws ConeException {
		return switch(this) {
		
			case ID -> Comparator.comparingInt(Cone :: getConeId);
			
			case AREA -> Comparator.comparingDouble((ToDoubleFunction<Cone>) cone -> 
						ConeWarehouse.getInstance()
						.getParameters(cone.getConeId()).surfaceArea());
					
			case VOLUME -> Comparator.comparingDouble((ToDoubleFunction<Cone>) cone -> 
							ConeWarehouse.getInstance()
							.getParameters(cone.getConeId()).volume());
			
			case POINT_TOP -> Comparator.comparingDouble((ToDoubleFunction<Cone>) cone -> 
							cone.getTop().getX())
							.thenComparing(cone -> cone.getTop().getY())
							.thenComparing(cone -> cone.getTop().getZ());
			
			default -> throw new ConeException("There is no such enum case");
		};
	}
}
