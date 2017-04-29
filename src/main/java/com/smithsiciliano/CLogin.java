package com.smithsiciliano;

import com.smithsiciliano.dao.EmployeeDAO;

public class CLogin {
	
	private VLogin viewRef = null;
	private EmployeeDAO dao = null;
	
	public CLogin() {
		init();
	}
	
	public void init() {
		dao = new EmployeeDAO();
		viewRef = new VLogin(this);
		viewRef.initListeners();
		viewRef.initUI();
	}
}