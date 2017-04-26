package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class InStock implements java.io.Serializable {
	
	private int quantity;
	private String storeLoc;
	private String foodName;
	
	public InStock() {
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStoreLoc() {
		return storeLoc;
	}

	public void setStoreLoc(String storeLoc) {
		this.storeLoc = storeLoc;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
}