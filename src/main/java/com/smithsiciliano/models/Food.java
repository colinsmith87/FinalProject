package com.smithsiciliano.models;

import java.util.Date;

@SuppressWarnings("serial")
public class Food implements java.io.Serializable {
	
	private String itemName;
	private double price;
	private Date sellBy;
	
	public Food(String itemName, double price, Date sellBy) {
		this.itemName = itemName;
		this.price = price;
		this.sellBy = sellBy;
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
}