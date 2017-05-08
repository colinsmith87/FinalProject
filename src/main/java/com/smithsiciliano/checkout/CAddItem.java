package com.smithsiciliano.checkout;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;

import com.smithsiciliano.dao.FoodDAO;
import com.smithsiciliano.dao.InStockDAO;
import com.smithsiciliano.models.Food;
import com.smithsiciliano.models.InStock;
import com.smithsiciliano.models.Stores;

public class CAddItem {
	
	private JFrame mainFrameRef = null;
	private CCheckout checkoutRef = null;
	private VAddItem viewRef = null;
	private Stores location = null;
	private FoodDAO foodDAO = null;
	private InStockDAO inStockDAO = null;
	private ArrayList<Food> foodToAdd = null;
	private ArrayList<InStock> stocks = null;
	
	
	public CAddItem(JFrame mainFrameRef, CCheckout checkoutRef) {
		this.mainFrameRef = mainFrameRef;
		this.checkoutRef = checkoutRef;
		init();
	}
	
	private void init() {
		foodDAO = new FoodDAO();
		inStockDAO = new InStockDAO();
		foodToAdd = new ArrayList<Food>();
		stocks = new ArrayList<InStock>();
		viewRef = new VAddItem(this,mainFrameRef);
		viewRef.initUI();
		viewRef.initListeners();
	}
	
	public void setLocation(Stores location) {
		this.location = location;
	}

	public void addFoodItem(String itemName, String category, double price, Date sellByDate, int quantity) {
		Food food = new Food(itemName, price, sellByDate, category);
		InStock stock = new InStock(quantity, location, food);
		foodToAdd.add(food);
		stocks.add(stock);
	}
	
	public void save() {
		Food[] foodToInsert = new Food[foodToAdd.size()];
		InStock[] stockToInsert = new InStock[stocks.size()];
		for(int i = 0; i < foodToInsert.length; i++) {
			foodToInsert[i] = foodToAdd.get(i);
		}
		for(int i = 0; i < stockToInsert.length; i++) {
			stockToInsert[i] = stocks.get(i);
		}
		if(foodDAO.insert(foodToInsert)) {
			inStockDAO.insert(stockToInsert);
		}
		else {
			foodDAO.update(foodToInsert);
			if(!inStockDAO.insert(stockToInsert)) {
				inStockDAO.update(stockToInsert);
			}
		}
		checkoutRef.cleanupAfterCategories();
		checkoutRef.backToCategories();
		foodToAdd.clear();
		stocks.clear();
		mainFrameRef.dispose();
	}
}
