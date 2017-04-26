package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class Dependent implements java.io.Serializable {
	
	private String fName;
	private String lName;
	private String relation;
	private long phone;
	private int empId;
	
	public Dependent(String fName, String lName, String relation, long phone, int empId) {
		this.fName = fName;
		this.lName = lName;
		this.relation = relation;
		this.phone = phone;
		this.empId = empId;
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

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
}