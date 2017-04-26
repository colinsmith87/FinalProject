package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class Dependent implements java.io.Serializable {
	
	private int dependentId;
	private String fName;
	private String lName;
	private String relation;
	private int phone;
	private int empId;
	
	public Dependent() {
		
	}
	
	public int getDependentId() {
		return dependentId;
	}
	
	public void setDependentId(int dependentId) {
		this.dependentId = dependentId;
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
}