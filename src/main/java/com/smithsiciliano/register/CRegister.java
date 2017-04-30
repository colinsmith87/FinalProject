package com.smithsiciliano.register;

import com.smithsiciliano.App;
import com.smithsiciliano.dao.EmployeeDAO;
import com.smithsiciliano.login.CLogin;
import com.smithsiciliano.login.VLogin;

public class CRegister {
	
	private CLogin loginControllerRef = null;
	private VRegister viewRef = null;
	private App mainFrameRef = null;
	private EmployeeDAO dao = null;
	
	public CRegister(CLogin loginControllerRef, App mainFrameRef) {
		this.loginControllerRef = loginControllerRef;
		this.mainFrameRef = mainFrameRef;
		init();
	}
	
	private void init() {
		dao = new EmployeeDAO();
		viewRef = new VRegister(this,mainFrameRef);
		viewRef.initUI();
		viewRef.initListeners();
	}
}