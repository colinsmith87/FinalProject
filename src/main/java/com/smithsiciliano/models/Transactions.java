package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class Transactions implements java.io.Serializable {
	
	private int transactionId;
	private double price;
	private Food foodItem;
	private Stores storeLoc;
	
	public Transactions() {
		
	}

	public Transactions(double price, Food foodItem, Stores storeLoc) {
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

	public Food getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(Food foodItem) {
		this.foodItem = foodItem;
	}

	public Stores getStoreLoc() {
		return storeLoc;
	}

	public void setStoreLoc(Stores storeLoc) {
		this.storeLoc = storeLoc;
	}
	
	public int getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
}