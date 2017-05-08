package com.smithsiciliano.checkout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.smithsiciliano.dao.FoodDAO;
import com.smithsiciliano.dao.InStockDAO;
import com.smithsiciliano.models.Food;
import com.smithsiciliano.models.InStock;
import com.smithsiciliano.models.Stores;

public class CDeleteItem {

	private JFrame mainFrameRef = null;
	private CCheckout checkoutRef = null;
	private VDeleteItem viewRef = null;
	private FoodDAO foodDAO = null;
	private InStockDAO inStockDAO = null;
	private Stores store = null;
	
	
	public CDeleteItem(JFrame mainFrameRef, CCheckout checkoutRef, Stores store) {
		this.mainFrameRef = mainFrameRef;
		this.checkoutRef = checkoutRef;
		this.store = store;
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
		Food food = foodDAO.selectByItemName(itemName).get(0);
		InStock stock = inStockDAO.selectByFoodNameAndStoreLocation(food, store).get(0);
		inStockDAO.delete(stock);
		if(inStockDAO.selectByFoodName(food).size() == 0) {
			foodDAO.delete(food);
		}
		checkoutRef.backToCategories();
	}
	
	public String[] getItems() {
		List<Food> foods = foodDAO.selectByLocation(store);
		String[] foodItems = new String[foods.size()];
		for(int i = 0; i < foods.size(); i++) {
			foodItems[i] = foods.get(i).getItemName();
		}
		return foodItems;
	}
}
