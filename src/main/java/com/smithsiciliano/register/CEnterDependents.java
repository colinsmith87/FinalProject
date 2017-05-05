package com.smithsiciliano.register;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.smithsiciliano.App;
import com.smithsiciliano.checkout.CCheckout;
import com.smithsiciliano.dao.DependentDAO;
import com.smithsiciliano.models.Dependent;
import com.smithsiciliano.models.Employee;

public class CEnterDependents {

	private VEnterDependents viewRef = null;
	private JFrame mainFrameRef = null;
	private DependentDAO dependentDAO = null;
	private Employee employee = null;
	private ArrayList<Dependent> dependents = null;
	private boolean update = false;

	public CEnterDependents(JFrame mainFrameRef,boolean update) {
		this.mainFrameRef = mainFrameRef;
		this.update = update;
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
	
	public void fillInfo() {
		List<Dependent> dependentList = dependentDAO.selectByEmployeeId(employee.getEmployeeId());
		ArrayList<String> firstNames = new ArrayList<String>();
		ArrayList<String> lastNames = new ArrayList<String>();
		ArrayList<String> phones = new ArrayList<String>();
		ArrayList<String> relations = new ArrayList<String>();
		for(Dependent d : dependentList) {
			firstNames.add(d.getfName());
			lastNames.add(d.getlName());
			phones.add(d.getPhone()+"");
			relations.add(d.getRelation());
		}
		viewRef.fillInfo(firstNames,lastNames,relations,phones);
	}

	public void save() {
		if(!update) {
			Dependent[] dependentsToInsert = new Dependent[dependents.size()];
			for(int i = 0; i < dependents.size(); i++) {
				dependentsToInsert[i] = dependents.get(i);
			}
			if(dependentsToInsert.length > 0) {
				dependentDAO.insert(dependentsToInsert);
			}
			viewRef.cleanup();
			CCheckout checkout = new CCheckout(mainFrameRef,employee);
		}
		else {
			Dependent[] dependentsToUpdate = new Dependent[dependents.size()];
			for(int i = 0; i < dependents.size(); i++) {
				dependentsToUpdate[i] = dependents.get(i);
			}
			dependentDAO.updateAllByEmployeeId(dependentsToUpdate, employee.getEmployeeId());
			mainFrameRef.dispose();
		}
		dependents.clear();
	}
}