package com.rutkouski.shape.entity;

public class ConeParameters {
	
	private double surfaceArea;
	private double volume;
	
	public ConeParameters(double surfaceArea, double volume) {
		super();
		this.surfaceArea = surfaceArea;
		this.volume = volume;
	}

	public double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long bits = Double.doubleToLongBits(surfaceArea);
		result = prime * result + (int) (bits ^ (bits >>> 32));
		bits = Double.doubleToLongBits(volume);
		result = prime * result + (int) (bits ^ (bits >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		ConeParameters other = (ConeParameters) obj;
		return Double.doubleToLongBits(surfaceArea) == Double.doubleToLongBits(other.surfaceArea)
				&& Double.doubleToLongBits(volume) == Double.doubleToLongBits(other.volume);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("ConeParameters (surfaceArea = ").append(surfaceArea)
		.append(", volume = ").append(volume).append(")");
		return stringBuilder.toString();
	}
}
