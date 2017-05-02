package com.smithsiciliano.register;

import java.util.ArrayList;

import com.smithsiciliano.App;
import com.smithsiciliano.dao.DependentDAO;
import com.smithsiciliano.models.Dependent;
import com.smithsiciliano.models.Employee;

public class CEnterDependents {
	
	private VEnterDependents viewRef = null;
	private App mainFrameRef = null;
	private DependentDAO dependentDAO = null;
	private Employee employee = null;
	private ArrayList<Dependent> dependents = null;
	
	public CEnterDependents(App mainFrameRef) {
		this.mainFrameRef = mainFrameRef;
		init();
	}
	
	private void init() {
		dependentDAO = new DependentDAO();
		dependents = new ArrayList<Dependent>();
		viewRef = new VEnterDependents(this,mainFrameRef);
		viewRef.initUI();
		viewRef.initListeners();
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void addDependent(String fName, String lName, String relation, long phone) {
		Dependent dependent = new Dependent(fName,lName,relation,phone,employee.getEmployeeId());
		dependents.add(dependent);
	}
	
	public void save() {
		Dependent[] dependentsToInsert = new Dependent[dependents.size()];
		for(int i = 0; i < dependents.size(); i++) {
			dependentsToInsert[i] = dependents.get(i);
		}
		if(dependentsToInsert.length > 0) {
			dependentDAO.insert(dependentsToInsert);
		}
		viewRef.cleanup();
		//launch next screen
	}
}