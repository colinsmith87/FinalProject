package com.smithsiciliano.checkout;

import java.util.ArrayList;
import java.util.List;

import com.smithsiciliano.App;
import com.smithsiciliano.dao.FoodDAO;
import com.smithsiciliano.login.CLogin;
import com.smithsiciliano.models.Food;
import com.smithsiciliano.models.Transactions;

public class CCheckout {
	
	private App mainFrameRef = null;
	private VCheckout viewRef = null;
	private FoodDAO dao = null;
	
	private ArrayList<Transactions> transactions = null;
	
	public CCheckout(App mainFrameRef) {
		this.mainFrameRef = mainFrameRef;
		init();
	}
	
	private void init() {
		dao = new FoodDAO();
		viewRef = new VCheckout(this,mainFrameRef);
		viewRef.initUI();
		viewRef.initListeners();
	}
	
	public ArrayList<String> getCategories() {
		List<Object> categories = dao.selectAllCategories();
		ArrayList<String> retVal = new ArrayList<String>();
		for(Object obj : categories) {
			retVal.add(obj.toString());
		}
		return retVal;
	}
	
	public ArrayList<String> getItemsStringByCategory(String category) {
		List<Food> items = dao.selectByCategory(category);
		ArrayList<String> retVal = new ArrayList<String>();
		for(Food food : items) {
			retVal.add(food.getItemName());
		}
		return retVal;
	}
	
	public void launchLoginScreen() {
		viewRef.cleanup();
		CLogin login = new CLogin(mainFrameRef);
	}
	
	public void getFoodItemInfo(String itemName) {
		
	}
	
	public void createTransaction(String itemList) {
		
	}
}
