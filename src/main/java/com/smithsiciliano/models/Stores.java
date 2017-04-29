package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class Stores implements java.io.Serializable {
	
	private String sLocation;
	
	public Stores() {
		
	}
	
	public Stores(String sLocation) {
		this.sLocation = sLocation;
	}

	public String getsLocation() {
		return sLocation;
	}

	public void setsLocation(String sLocation) {
		this.sLocation = sLocation;
	}
}