package com.smithsiciliano.models;

@SuppressWarnings("serial")
public class Employee implements java.io.Serializable {
	
	private int employeeId;
	
	public Employee() {
		
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void getEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
}