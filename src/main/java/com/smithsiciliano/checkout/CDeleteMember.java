package com.smithsiciliano.checkout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.smithsiciliano.dao.FoodDAO;
import com.smithsiciliano.dao.InStockDAO;
import com.smithsiciliano.dao.MembersDAO;
import com.smithsiciliano.models.Food;
import com.smithsiciliano.models.InStock;
import com.smithsiciliano.models.Members;
import com.smithsiciliano.models.Stores;

public class CDeleteMember {

	private JFrame mainFrameRef = null;
	private CCheckout checkoutRef = null;
	private VDeleteMember viewRef = null;
	private Stores store = null;
	private MembersDAO membersDAO;
	
	
	public CDeleteMember(JFrame mainFrameRef, CCheckout checkoutRef, Stores store) {
		this.mainFrameRef = mainFrameRef;
		this.checkoutRef = checkoutRef;
		this.store = store;
		init();
	}
	
	private void init() {
		membersDAO = new MembersDAO();
		viewRef = new VDeleteMember(this,mainFrameRef);
		viewRef.initUI();
		viewRef.initListeners();
	}
	
	public void deleteMember(Members member) {
		membersDAO.delete(member);
		checkoutRef.backToCategories();
	}
}
