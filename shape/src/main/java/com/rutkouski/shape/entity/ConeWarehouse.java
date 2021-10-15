package com.rutkouski.shape.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ConeWarehouse {
	
	private static ConeWarehouse instance;
	private Map<Integer, ConeParameters> coneMap = new HashMap<>();
	
	private ConeWarehouse() {}
	
	public static ConeWarehouse getInstance() {
		if (instance == null) {
			instance = new ConeWarehouse();
		}
		return instance;
	}
	
	public void put(Integer coneId, ConeParameters parameters) {
		coneMap.put(coneId, parameters);
	}

	public ConeParameters remove(Integer coneId) {
		return coneMap.remove(coneId);
	}
	
	public Optional<ConeParameters> get(Integer coneId) {
		Optional<ConeParameters> parameters = Optional.of(coneMap.get(coneId));
		return parameters;
	}
	
	public Map<Integer, ConeParameters> getConeMap() {
		return Map.copyOf(coneMap);
	}
}
