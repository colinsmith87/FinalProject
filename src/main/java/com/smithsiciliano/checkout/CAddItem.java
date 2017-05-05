package com.smithsiciliano.checkout;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.smithsiciliano.dao.FoodDAO;
import com.smithsiciliano.dao.InStockDAO;
import com.smithsiciliano.models.Food;

public class CAddItem {
	
	private JFrame mainFrameRef = null;
	private CCheckout checkoutRef = null;
	private VAddItem viewRef = null;
	private String location = null;
	private FoodDAO foodDAO = null;
	private InStockDAO inStockDAO = null;
	
	public CAddItem(JFrame mainFrameRef, CCheckout checkoutRef) {
		this.mainFrameRef = mainFrameRef;
		this.checkoutRef = checkoutRef;
		init();
	}
	
	private void init() {
		foodDAO = new FoodDAO();
		inStockDAO = new InStockDAO();
		viewRef = new VAddItem(this,mainFrameRef);
		viewRef.initUI();
		viewRef.initListeners();
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

}
