package com.smithsiciliano.checkout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import com.smithsiciliano.dao.FoodDAO;
import com.smithsiciliano.dao.InStockDAO;
import com.smithsiciliano.dao.MembersDAO;
import com.smithsiciliano.dao.StoresDAO;
import com.smithsiciliano.models.Food;
import com.smithsiciliano.models.InStock;
import com.smithsiciliano.models.Members;
import com.smithsiciliano.models.Stores;

public class CAddMember {
	
	private JFrame mainFrameRef = null;
	private CCheckout checkoutRef = null;
	private VAddMember viewRef = null;
	private MembersDAO membersDAO = null;
	private StoresDAO storesDAO;
	
	
	public CAddMember(JFrame mainFrameRef, CCheckout checkoutRef) {
		this.mainFrameRef = mainFrameRef;
		this.checkoutRef = checkoutRef;
		init();
	}
	
	private void init() {
		membersDAO = new MembersDAO();
		viewRef = new VAddMember(this,mainFrameRef);
		storesDAO = new StoresDAO();
		setStoreLocations();
		viewRef.initUI();
		viewRef.initListeners();
	}
	
	public void setStoreLocations() {
		List<Stores> stores = storesDAO.select();
		String[] storeLocations = new String[stores.size()];
		for(int i = 0; i < storeLocations.length; i++) {
			storeLocations[i] = stores.get(i).getsLocation();
		}
		viewRef.setStoreLocations(storeLocations);
	}
		
	public boolean save(String fName, String lName, Date dateOfBirth, long phone,Stores storeLoc) {
		Members memberToAdd = new Members(fName,lName,dateOfBirth,phone,0,storeLoc);
		if(membersDAO.insert(memberToAdd)){
			viewRef.cleanup();
			checkoutRef.backToCategories();
			mainFrameRef.dispose();
			return true;
		}
		return false;
	}
}
