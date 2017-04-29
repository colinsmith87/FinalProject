package com.smithsiciliano.login;

import java.util.List;

import com.smithsiciliano.dao.EmployeeDAO;
import com.smithsiciliano.models.Employee;

public class CLogin {
	
	private VLogin viewRef = null;
	private EmployeeDAO dao = null;
	
	public CLogin() {
		init();
	}
	
	public void init() {
		dao = new EmployeeDAO();
		viewRef = new VLogin(this);
		viewRef.initUI();
		viewRef.initListeners();
	}
	
	public boolean login(int employeeId) {
		List<Employee> employee = dao.selectByEmployeeId(employeeId);
		if(employee.isEmpty()) {
			return false;
		}
		else {
			//launch new screen with this employee
			return true;
		}
	}
}