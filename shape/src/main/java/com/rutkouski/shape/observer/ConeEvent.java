package com.rutkouski.shape.observer;

import java.util.EventObject;

import com.rutkouski.shape.entity.Cone;

public class ConeEvent extends EventObject {

	/**
	 * Constructs a prototypical Event 
	 * 
	 * @param source - the object in which the initialization event occurred
	 */
	public ConeEvent(Cone source) {
		super(source);
	}
	
	@Override
	public Cone getSource() {
		return (Cone) super.getSource();
	}
}
