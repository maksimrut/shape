package com.rutkouski.shape.entity;

public class Point {

	private double x;
	private double y;
	private double z;
	
	public Point() {
		super();
	}
	
	public Point(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Point other = (Point) obj;
		return Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)
						&& Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)
						&& Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Point (x, y, z) = (")
					.append(x).append(", ")
					.append(y).append(", ")
					.append(z).append(")");
		return stringBuilder.toString();
	}
}
