package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class Food implements java.io.Serializable {
	
	private int foodId;
	
	public Food() {
		
	}
	
	public int getFoodId() {
		return foodId;
	}
	
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
}