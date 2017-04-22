package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class Members implements java.io.Serializable {
	
	private int memberId;
	
	public Members() {
		
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
}