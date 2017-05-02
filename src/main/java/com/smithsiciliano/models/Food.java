package com.smithsiciliano.models;

import java.util.Date;

@SuppressWarnings("serial")
public class Food implements java.io.Serializable {
	
	private String itemName;
	private double price;
	private Date sellBy;
	private String itemCategory;
	
	public Food() {
		
	}
	
	public Food(String itemName, double price, Date sellBy, String itemCategory) {
		this.itemName = itemName;
		this.price = price;
		this.sellBy = sellBy;
		this.itemCategory = itemCategory;
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

	public Date getSellBy() {
		return sellBy;
	}

	public void setSellBy(Date sellBy) {
		this.sellBy = sellBy;
	}
	
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	
	public String getItemCategory() {
		return itemCategory;
	}
}