package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class Transactions implements java.io.Serializable {
	
	private int transactionId;
	
	public Transactions() {
		
	}
	
	public int getTransactionId() {
		return transactionId;
	}
	
	public void getTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
}