package com.smithsiciliano.models;

import java.util.Date;

@SuppressWarnings("serial")
public class Employee implements java.io.Serializable {
	

	private int employeeId;
	private String fName;
	private String lName;
	private int salary;
	private long phone;
	private String street;
	private String city;
	private String addState;
	private int zip;
	private Date dateOfBirth;
	private Stores storeLoc;
	
	public Employee() {
		
	}

	public Employee(int employeeId, String fName, String lName, int salary, long phone, String street, String city,
			String addState, int zip, Date dateOfBirth, Stores storeLoc) {
		this.employeeId = employeeId;
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
		this.phone = phone;
		this.street = street;
		this.city = city;
		this.addState = addState;
		this.zip = zip;
		this.dateOfBirth = dateOfBirth;
		this.storeLoc = storeLoc;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddState() {
		return addState;
	}

	public void setAddState(String addState) {
		this.addState = addState;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public Stores getStoreLoc() {
		return storeLoc;
	}

	public void setStoreLoc(Stores storeLoc) {
		this.storeLoc = storeLoc;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}