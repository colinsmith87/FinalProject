package com.smithsiciliano.checkout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.smithsiciliano.dao.FoodDAO;
import com.smithsiciliano.dao.StoresDAO;
import com.smithsiciliano.dao.TransactionsDAO;
import com.smithsiciliano.models.Food;
import com.smithsiciliano.models.Stores;
import com.smithsiciliano.models.Transactions;

public class CViewAllTransactions {
	
	private JFrame mainFrameRef = null;
	private CCheckout checkoutRef = null;
	private VViewAllTransactions viewRef = null;
	private FoodDAO foodDAO = null;
	private TransactionsDAO transactionsDAO = null;
	private StoresDAO storesDAO = null;
	private double total = 0;
	
	public CViewAllTransactions(JFrame mainFrameRef, CCheckout checkoutRef, boolean unpopular) {
		this.mainFrameRef = mainFrameRef;
		this.checkoutRef = checkoutRef;
		init(unpopular);
	}
	
	private void init(boolean unpopular) {
		transactionsDAO = new TransactionsDAO();
		storesDAO = new StoresDAO();
		foodDAO = new FoodDAO();
		viewRef = new VViewAllTransactions(this,mainFrameRef);
		viewRef.initUI();
		if(!unpopular) {
			viewRef.initListeners();
		}
		else {
			viewRef.initUnpopularListeners();
		}
	}
	
	public ArrayList<String> getStoresList() {
		List<Stores> storesList = storesDAO.select();
		ArrayList<String> storesNames = new ArrayList<String>();
		for(Stores store : storesList) {
			storesNames.add(store.getsLocation());
		}
		return storesNames;
	}
	
	public String getTransactionListByStore(String location) {
		List<Stores> stores = storesDAO.selectByLocation(location);
		List<Transactions> transactions = transactionsDAO.selectByLocation(stores.get(0));
		String retVal = "";
		for(Transactions transaction : transactions) {
			total = total + transaction.getPrice();
			String price = transaction.getPrice()+"";
			price = (price.substring(0, price.indexOf(".")).length()==2) ? price : "0"+price;
			price = (price.length()==5) ? price : price+"0";
			retVal = retVal+transaction.getFoodItem().getItemName()+"\t"+price+"\n";
		}
		return retVal;
	}
	
	public String getUnpopularItemsByStore(String location) {
		List<Stores> stores = storesDAO.selectByLocation(location);
		List<Food> items = foodDAO.selectFoodItemsWithoutTransactionByLocation(stores.get(0));
		String retVal = "";
		for(Food item : items) {
			total = total + item.getPrice();
			String price = item.getPrice()+"";
			price = (price.substring(0, price.indexOf(".")).length()==2) ? price : "0"+price;
			price = (price.length()==5) ? price : price+"0";
			retVal = retVal+item.getItemName()+"\t"+price+"\n";
		}
		return retVal;
	}
	
	public void clearTotal() {
		total = 0;
	}
	
	public String getTotal() {
		return total+"0";
	}
}
