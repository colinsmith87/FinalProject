package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class InStock implements java.io.Serializable {
	
	private int quantity;
	private Stores storeLoc;
	private Food foodName;
	
	public InStock() {
		
	}

	public InStock(int quantity, Stores storeLoc, Food foodName) {
		this.quantity = quantity;
		this.storeLoc = storeLoc;
		this.foodName = foodName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Stores getStoreLoc() {
		return storeLoc;
	}

	public void setStoreLoc(Stores storeLoc) {
		this.storeLoc = storeLoc;
	}

	public Food getFoodName() {
		return foodName;
	}

	public void setFoodName(Food foodName) {
		this.foodName = foodName;
	}
}