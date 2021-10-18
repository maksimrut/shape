package com.rutkouski.shape.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.rutkouski.shape.entity.Cone;

public class ConeRepository {
	
	private static final ConeRepository instance = new ConeRepository();
	private final List<Cone> cones = new ArrayList<>();

	private ConeRepository() {
	}
	
	public static ConeRepository getInstance() {
		return instance;
	}
	
	public int size() {
		return cones.size();
	}

	public boolean contains(Cone cone) {
		return cones.contains(cone);
	}

	public boolean add(Cone cone) {
		return cones.add(cone);
	}

	public boolean remove(Cone cone) {
		return cones.remove(cone);
	}

	public void clear() {
		cones.clear();
	}
		
	public Cone get(int index) {
		return cones.get(index);
	}

	public Cone set(int index, Cone cone) {
		return cones.set(index, cone);
	}
	
	public List<Cone> sort(Comparator<? super Cone> comparator) {
		List<Cone> conesClone = new ArrayList<>(cones);
		conesClone.sort(comparator);
		return conesClone;
	}

	public List<Cone> query(ConeSpecification coneSpecification) {
		return cones.stream().filter(coneSpecification :: specify).toList();
	}

	public boolean equals(Object o) {
		return cones.equals(o);
	}

	public int hashCode() {
		return cones.hashCode();
	}

	@Override
	public String toString() {
		return String.format("ConeRepository [cones=%s]", cones);
	}
}
