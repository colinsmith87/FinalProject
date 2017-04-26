package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class Transactions implements java.io.Serializable {
	
	private double price;
	private String foodItem;
	private String storeLoc;
	
	public Transactions() {
		
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}

	public String getStoreLoc() {
		return storeLoc;
	}

	public void setStoreLoc(String storeLoc) {
		this.storeLoc = storeLoc;
	}
}