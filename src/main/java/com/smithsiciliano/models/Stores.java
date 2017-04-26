package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class Stores implements java.io.Serializable {
	
	private int storeId;
	private String sLocation;
	
	public Stores() {
		
	}
	
	public int getStoreId() {
		return storeId;
	}
	
	public void getStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getsLocation() {
		return sLocation;
	}

	public void setsLocation(String sLocation) {
		this.sLocation = sLocation;
	}
}