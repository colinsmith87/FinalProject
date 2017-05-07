package com.smithsiciliano.checkout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.smithsiciliano.dao.StoresDAO;
import com.smithsiciliano.dao.TransactionsDAO;
import com.smithsiciliano.models.Stores;
import com.smithsiciliano.models.Transactions;

public class CViewAllTransactions {
	
	private JFrame mainFrameRef = null;
	private CCheckout checkoutRef = null;
	private VViewAllTransactions viewRef = null;
	private TransactionsDAO transactionsDAO = null;
	private StoresDAO storesDAO = null;
	private double total = 0;
	
	public CViewAllTransactions(JFrame mainFrameRef, CCheckout checkoutRef) {
		this.mainFrameRef = mainFrameRef;
		this.checkoutRef = checkoutRef;
		init();
	}
	
	private void init() {
		transactionsDAO = new TransactionsDAO();
		storesDAO = new StoresDAO();
		viewRef = new VViewAllTransactions(this,mainFrameRef);
		viewRef.initUI();
		viewRef.initListeners();
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
		List<Transactions> transactions = transactionsDAO.selectByLocation(location);
		String retVal = "";
		for(Transactions transaction : transactions) {
			total = total + transaction.getPrice();
			String price = transaction.getPrice()+"";
			price = (price.substring(0, price.indexOf(".")).length()==2) ? price : "0"+price;
			price = (price.length()==5) ? price : price+"0";
			retVal = retVal+transaction.getFoodItem()+"\t"+price+"\n";
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
