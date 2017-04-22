package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class Dependent implements java.io.Serializable {
	
	private int dependentId;
	
	public Dependent() {
		
	}
	
	public int getDependentId() {
		return dependentId;
	}
	
	public void setDependentId(int dependentId) {
		this.dependentId = dependentId;
	}
}