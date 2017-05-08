package com.smithsiciliano.register;

import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import com.smithsiciliano.App;
import com.smithsiciliano.checkout.CCheckout;
import com.smithsiciliano.dao.EmployeeDAO;
import com.smithsiciliano.dao.StoresDAO;
import com.smithsiciliano.login.CLogin;
import com.smithsiciliano.models.Employee;
import com.smithsiciliano.models.Stores;

public class CRegister {
	
	private VRegister viewRef = null;
	private JFrame mainFrameRef = null;
	private EmployeeDAO employeeDAO = null;
	private StoresDAO storesDAO = null;
	private boolean update = false;
	private Employee employee = null;
	private CCheckout checkoutRef = null;
	
	public CRegister(JFrame mainFrameRef, CCheckout checkoutRef) {
		this.mainFrameRef = mainFrameRef;
		this.checkoutRef = checkoutRef;
		if(checkoutRef!=null) {
			this.update = true;
		}
		init();
	}
	
	public void fillInfo() {
		viewRef.fillInfo(employee.getEmployeeId(),employee.getfName(),employee.getlName(),employee.getStreet(),
				employee.getCity(),employee.getAddState(),employee.getZip(),employee.getPhone(),employee.getDateOfBirth(),
				employee.getSalary(),employee.getStoreLoc().getsLocation());
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	private void init() {
		employeeDAO = new EmployeeDAO();
		storesDAO = new StoresDAO();
		viewRef = new VRegister(this,mainFrameRef);
		setStoreLocations();
		viewRef.initUI();
		if(update) {
			viewRef.setBackButtonVisible(false);
		}
		viewRef.initListeners();
	}
	
	public void launchLoginScreen() {
		viewRef.cleanup();
		CLogin login = new CLogin(mainFrameRef);
	}
	
	public void setStoreLocations() {
		List<Stores> stores = storesDAO.select();
		String[] storeLocations = new String[stores.size()];
		for(int i = 0; i < storeLocations.length; i++) {
			storeLocations[i] = stores.get(i).getsLocation();
		}
		viewRef.setStoreLocations(storeLocations);
	}
	
	public boolean save(int id, String fName, String lName, Date dob, long phone, String street, String city, 
			String state, int zip, int salary, String location) {
		Stores store = storesDAO.selectByLocation(location).get(0);
		Employee employee = new Employee(id,fName,lName,salary,phone,street,city,state,zip,dob,store);
		if(!update) {
			if(employeeDAO.insert(employee)) {
				viewRef.cleanup();
				CEnterDependents enterDependents = new CEnterDependents(mainFrameRef,update);
				enterDependents.setEmployee(employee);
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if(employeeDAO.update(this.employee, employee)) {
				viewRef.cleanup();
				checkoutRef.setEmployee(employee);
				CEnterDependents enterDependents = new CEnterDependents(mainFrameRef,update);
				enterDependents.setEmployee(employee);
				enterDependents.fillInfo();
				return true;
			}
			else {
				return false;
			}
		}
	}
}