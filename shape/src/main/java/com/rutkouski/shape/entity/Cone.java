package com.rutkouski.shape.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rutkouski.shape.exception.ConeException;
import com.rutkouski.shape.observer.ConeEvent;
import com.rutkouski.shape.observer.impl.ConeObserverImpl;
import com.rutkouski.shape.util.IdGenerator;

public class Cone {
	
	static Logger logger = LogManager.getLogger();
	private int coneId;
	private Point top;
	private double radius;
	private double height;
	private List<ConeObserverImpl> coneObservers = new ArrayList<>();
	
	public Cone(Point top, double radius, double height) {
		this.top = top;
		this.radius = radius;
		this.height = height;
		this.coneId = IdGenerator.generateConeId();
	}
	
	public int getConeId() {
		return coneId;
	}

	public Point getTop() {
		return top;
	}

	public void setTop(Point top) {
		this.top = top;
		notifyObservers();
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) throws ConeException {
		if (radius < 0) {
			logger.error("Radius can't be negative: {}", radius);
			throw new ConeException("Radius can't be negative: " + radius);
		}
		this.radius = radius;
		notifyObservers();
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) throws ConeException {
		if (height < 0) {
			logger.error("Height can't be negative: {}", height);
			throw new ConeException("Height can't be negative: " + height);
		}
		this.height = height;
		notifyObservers();
	}
	
	private void notifyObservers() {
		if (coneObservers == null) {
			logger.info("Observer is null");
			return;
		}
		ConeEvent coneEvent = new ConeEvent(this);
		coneObservers.forEach(o -> o.changeParameters(coneEvent));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long bits = Double.doubleToLongBits(height);
		result = prime * result + (int) (bits ^ (bits >>> 32));
		bits = Double.doubleToLongBits(radius);
		result = prime * result + (int) (bits ^ (bits >>> 32));
		bits = Double.doubleToLongBits(top.getX() + top.getY() + top.getZ());
		result = prime * result + (int) (bits ^ (bits >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass()) 
			return false;
		Cone other = (Cone) obj;
		return coneId == other.coneId && Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
				&& Double.doubleToLongBits(radius) == Double.doubleToLongBits(other.radius)
				&& top.equals(other.top);
	}
	
	public boolean equalsIgnoreId(Cone cone) {
		if (this == cone)
			return true;
		if (cone == null || getClass() != cone.getClass()) 
			return false;
		Cone other = cone;
		return Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
				&& Double.doubleToLongBits(radius) == Double.doubleToLongBits(other.radius)
				&& top.equals(other.top);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Cone (coneId = ").append(coneId)
		.append(", top = ").append(top)
		.append(", radius = ").append(radius)
		.append(", height = ").append(height).append(")");
		return stringBuilder.toString();
	}
}
