package com.smithsiciliano.register;

import java.util.Date;
import java.util.List;

import com.smithsiciliano.App;
import com.smithsiciliano.dao.EmployeeDAO;
import com.smithsiciliano.dao.StoresDAO;
import com.smithsiciliano.login.CLogin;
import com.smithsiciliano.models.Employee;
import com.smithsiciliano.models.Stores;

public class CRegister {
	
	private VRegister viewRef = null;
	private App mainFrameRef = null;
	private EmployeeDAO employeeDAO = null;
	private StoresDAO storesDAO = null;
	
	public CRegister(App mainFrameRef) {
		this.mainFrameRef = mainFrameRef;
		init();
	}
	
	private void init() {
		employeeDAO = new EmployeeDAO();
		storesDAO = new StoresDAO();
		viewRef = new VRegister(this,mainFrameRef);
		setStoreLocations();
		viewRef.initUI();
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
			String state, int zip, String location) {
		Employee employee = new Employee(id,fName,lName,30000,phone,street,city,state,zip,dob,location);
		if(employeeDAO.insert(employee)) {
			viewRef.cleanup();
			//launch main screen
			return true;
		}
		else {
			return false;
		}
	}
}