package com.smithsiciliano.checkout;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.smithsiciliano.App;
import com.smithsiciliano.dao.FoodDAO;
import com.smithsiciliano.login.CLogin;
import com.smithsiciliano.models.Employee;
import com.smithsiciliano.models.Food;
import com.smithsiciliano.models.Transactions;
import com.smithsiciliano.register.CRegister;

public class CCheckout {
	
	private JFrame mainFrameRef = null;
	private VCheckout viewRef = null;
	private FoodDAO dao = null;
	private Employee employee = null;
	private ArrayList<Food> itemList = null;
	private double total = 0;
	
	private ArrayList<Transactions> transactions = null;
	
	public CCheckout(JFrame mainFrameRef,Employee employee) {
		this.mainFrameRef = mainFrameRef;
		this.employee = employee;
		init();
	}
	
	private void init() {
		dao = new FoodDAO();
		itemList = new ArrayList<Food>();
		viewRef = new VCheckout(this,mainFrameRef);
		viewRef.initUI();
		viewRef.initListeners();
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
	
	public void editProfile() {
		JFrame psuedoFrame = new JFrame("Grocery Store Management System");
		psuedoFrame.setPreferredSize(new Dimension(800,500));
		psuedoFrame.setLayout(new GridBagLayout());
    	CRegister editProfile = new CRegister(psuedoFrame,this);
    	psuedoFrame.setLocationRelativeTo(null);
    	psuedoFrame.setVisible(true);
    	editProfile.setEmployee(employee);
    	editProfile.fillInfo();
	}
	
	public String getFoodItemInfo(String itemName) {
		List<Food> food = dao.selectByItemName(itemName);
		itemList.add(food.get(0));
		String price = food.get(0).getPrice()+"";
		total = total+food.get(0).getPrice();
		price = (price.substring(0, price.indexOf(".")).length()==2) ? price : "0"+price;
		price = (price.length()==5) ? price : price+"0";
		return food.get(0).getItemName()+"\t"+price;
	}
	
	public String getTotal() {
		String totalString = total+"";
		totalString = (totalString.substring(totalString.indexOf(".")+1).length()==2) ? totalString : totalString+"0";
		return totalString;
	}
	
	public void createTransaction(String itemList) {
		//TODO
	}
}
