package com.smithsiciliano.checkout;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.smithsiciliano.dao.FoodDAO;
import com.smithsiciliano.dao.InStockDAO;

public class CDeleteItem {

	private JFrame mainFrameRef = null;
	private CCheckout checkoutRef = null;
	private VDeleteItem viewRef = null;
	private FoodDAO foodDAO = null;
	private InStockDAO inStockDAO = null;
	
	
	public CDeleteItem(JFrame mainFrameRef, CCheckout checkoutRef) {
		this.mainFrameRef = mainFrameRef;
		this.checkoutRef = checkoutRef;
		init();
	}
	
	private void init() {
		foodDAO = new FoodDAO();
		inStockDAO = new InStockDAO();
		viewRef = new VDeleteItem(this,mainFrameRef);
		viewRef.initUI();
		viewRef.initListeners();
	}
	
	public void deleteItem(String itemName) {
		
	}
	
	public String[] getItems() {
		return new String[]{"HELLO"};
	}
}
