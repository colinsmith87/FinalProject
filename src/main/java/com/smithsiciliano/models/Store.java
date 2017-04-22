package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class Store implements java.io.Serializable {
	
	private int storeId;
	
	public Store() {
		
	}
	
	public int getStoreId() {
		return storeId;
	}
	
	public void getStoreId(int storeId) {
		this.storeId = storeId;
	}
}