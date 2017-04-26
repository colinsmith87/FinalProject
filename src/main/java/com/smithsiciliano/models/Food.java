package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class Food implements java.io.Serializable {
	
	private int foodId;
	private String itemName;
	private double price;
	private String sellBy;
	
	public Food() {
		
	}
	
	public int getFoodId() {
		return foodId;
	}
	
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSellBy() {
		return sellBy;
	}

	public void setSellBy(String sellBy) {
		this.sellBy = sellBy;
	}
}