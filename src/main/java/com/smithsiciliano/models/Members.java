package com.smithsiciliano.models;

import java.util.Date;

@SuppressWarnings("serial")
public class Members implements java.io.Serializable {
	
	private int memberId;
	private String fName;
	private String lName;
	private Date dateOfBirth;
	private long phone;
	private int points;
	private String storeLoc;
	
	
	public Members(int memberId, String fName, String lName, Date dateOfBirth, long phone, int points,
			String storeLoc) {
		this.memberId = memberId;
		this.fName = fName;
		this.lName = lName;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.points = points;
		this.storeLoc = storeLoc;
	}

	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getStoreLoc() {
		return storeLoc;
	}

	public void setStoreLoc(String storeLoc) {
		this.storeLoc = storeLoc;
	}
}