package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class Transactions implements java.io.Serializable {
	
	private int transactionId;
	private double price;
	private String foodItem;
	private String storeLoc;
	
	public Transactions() {
		
	}

	public Transactions(double price, String foodItem, String storeLoc) {
		this.price = price;
		this.foodItem = foodItem;
		this.storeLoc = storeLoc;
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
	
	public int getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
}