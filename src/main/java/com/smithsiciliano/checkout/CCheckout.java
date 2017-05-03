package com.smithsiciliano.checkout;

import java.util.ArrayList;
import java.util.List;

import com.smithsiciliano.App;
import com.smithsiciliano.dao.FoodDAO;

public class CCheckout {
	
	private App mainFrameRef = null;
	private VCheckout viewRef = null;
	private FoodDAO dao = null;
	
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
}
