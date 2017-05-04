package com.smithsiciliano.login;

import java.util.List;

import javax.swing.JFrame;

import com.smithsiciliano.App;
import com.smithsiciliano.checkout.CCheckout;
import com.smithsiciliano.dao.EmployeeDAO;
import com.smithsiciliano.models.Employee;
import com.smithsiciliano.register.CRegister;

public class CLogin {
	
	private VLogin viewRef = null;
	private EmployeeDAO dao = null;
	private JFrame mainFrameRef = null;
	
	public CLogin(JFrame mainFrameRef) {
		this.mainFrameRef = mainFrameRef;
		init();
	}
	
	private void init() {
		dao = new EmployeeDAO();
		viewRef = new VLogin(this,mainFrameRef);
		viewRef.initUI();
		viewRef.initListeners();
	}
	
	public boolean login(int employeeId) {
		List<Employee> employee = dao.selectByEmployeeId(employeeId);
		if(employee.isEmpty()) {
			return false;
		}
		else {
			viewRef.cleanup();
			CCheckout checkout = new CCheckout(mainFrameRef,employee.get(0));
			return true;
		}
	}
	
	public void register() {
		viewRef.cleanup();
		CRegister registerPage = new CRegister(mainFrameRef,null);
	}
}