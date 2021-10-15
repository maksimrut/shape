package com.rutkouski.shape.entity;

public class Point {

	private int x;
	private int y;
	private int z;
	
	public Point() {
		super();
	}
	
	public Point(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Point other = (Point) obj;
		return (x == other.x && y == other.y && z == other.z);
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
