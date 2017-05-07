package com.smithsiciliano.checkout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.smithsiciliano.dao.StoresDAO;
import com.smithsiciliano.dao.TransactionsDAO;
import com.smithsiciliano.models.Stores;

public class CViewAllTransactions {
	
	private JFrame mainFrameRef = null;
	private CCheckout checkoutRef = null;
	private VViewAllTransactions viewRef = null;
	private TransactionsDAO transactionsDAO = null;
	private StoresDAO storesDAO = null;
	
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
}
