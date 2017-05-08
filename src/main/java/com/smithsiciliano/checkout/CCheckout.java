package com.smithsiciliano.checkout;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.smithsiciliano.App;
import com.smithsiciliano.dao.DependentDAO;
import com.smithsiciliano.dao.EmployeeDAO;
import com.smithsiciliano.dao.FoodDAO;
import com.smithsiciliano.dao.InStockDAO;
import com.smithsiciliano.dao.StoresDAO;
import com.smithsiciliano.dao.TransactionsDAO;
import com.smithsiciliano.login.CLogin;
import com.smithsiciliano.models.Employee;
import com.smithsiciliano.models.Food;
import com.smithsiciliano.models.InStock;
import com.smithsiciliano.models.Stores;
import com.smithsiciliano.models.Transactions;
import com.smithsiciliano.register.CRegister;

public class CCheckout {
	
	private JFrame mainFrameRef = null;
	private VCheckout viewRef = null;
	private FoodDAO dao = null;
	private Employee employee = null;
	private Stores store = null;
	private TransactionsDAO transactionsDAO = null;
	private InStockDAO inStockDAO = null;
	private EmployeeDAO employeeDAO = null;
	private DependentDAO dependentDAO = null;
	private StoresDAO storesDAO = null;
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
		inStockDAO = new InStockDAO();
		employeeDAO = new EmployeeDAO();
		transactionsDAO = new TransactionsDAO();
		dependentDAO = new DependentDAO();
		storesDAO = new StoresDAO();
		itemList = new ArrayList<Food>();
		transactions = new ArrayList<Transactions>();
		store = storesDAO.selectByLocation(employee.getStoreLoc().getsLocation()).get(0);
		viewRef = new VCheckout(this,mainFrameRef);
		viewRef.initUI(employee.getStoreLoc().getsLocation());
		viewRef.initListeners();
	}
	
	public void removeLastItem() {
		total = total - itemList.get(itemList.size()-1).getPrice();
		itemList.remove(itemList.size()-1);
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public ArrayList<String> getCategories() {
		List<String> categories = dao.selectAllCategories(store);
		ArrayList<String> retVal = new ArrayList<String>();
		for(String obj : categories) {
			retVal.add(obj.toString());
		}
		return retVal;
	}
	
	public ArrayList<String> getItemsStringByCategory(String category) {
		List<Food> items = dao.selectByCategory(category, store);
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
	
	public void deleteEmployee() {
		dependentDAO.deleteByEmployeeId(employee);
		employeeDAO.delete(employee);
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
	
	public void addFoodItem() {
		JFrame psuedoFrame = new JFrame("Grocery Store Management System");
		psuedoFrame.setPreferredSize(new Dimension(800,500));
		psuedoFrame.setLayout(new GridBagLayout());
		CAddItem addItem = new CAddItem(psuedoFrame,this);
		psuedoFrame.setLocationRelativeTo(null);
		psuedoFrame.setVisible(true);
		addItem.setLocation(store);
	}
	
	public String getFoodItemInfo(String itemName) {
		List<Food> food = dao.selectByItemName(itemName);
		List<InStock> stock = inStockDAO.selectByFoodNameAndStoreLocation(food.get(0), employee.getStoreLoc());
		int count = 0;
		for(Food item : itemList) {
			if(item.getItemName().equals(itemName)) {
				count++;
			}
		}
		if(!stock.isEmpty() && count < stock.get(0).getQuantity()) {
			itemList.add(food.get(0));
			String price = food.get(0).getPrice()+"";
			total = total+food.get(0).getPrice();
			price = (price.substring(0, price.indexOf(".")).length()==2) ? price : "0"+price;
			price = (price.length()==5) ? price : price+"0";
			return food.get(0).getItemName()+"\t"+price+"\n";
		}
		else {	
			viewRef.showOutOfStockError();
			return "";
		}
	}
	
	public String getTotal() {
		String totalString = total+"";
		totalString = (totalString.substring(totalString.indexOf(".")+1).length()==2) ? totalString : totalString+"0";
		return totalString;
	}
	
	public void createTransaction() {
		for(Food food : itemList) {
			transactions.add(new Transactions(food.getPrice(),food,store));
		}
		Transactions[] transactionsArray = new Transactions[transactions.size()];
		for(int i = 0; i < transactionsArray.length; i++) {
			transactionsArray[i] = transactions.get(i);
		}
		transactionsDAO.insert(transactionsArray);
		transactions.clear();
		itemList.clear();
		total = 0;
	}
	
	public void viewAllTransactions() {
		JFrame psuedoFrame = new JFrame("Grocery Store Management System");
		psuedoFrame.setPreferredSize(new Dimension(800,500));
		psuedoFrame.setLayout(new GridBagLayout());
		CViewAllTransactions viewTransactions = new CViewAllTransactions(psuedoFrame,this,false);
		psuedoFrame.setLocationRelativeTo(null);
		psuedoFrame.setVisible(true);
	}
	
	public void viewUnpopularItems() {
		JFrame psuedoFrame = new JFrame("Grocery Store Management System");
		psuedoFrame.setPreferredSize(new Dimension(800,500));
		psuedoFrame.setLayout(new GridBagLayout());
		CViewAllTransactions viewTransactions = new CViewAllTransactions(psuedoFrame,this,true);
		psuedoFrame.setLocationRelativeTo(null);
		psuedoFrame.setVisible(true);
	}
	
	public void removeItemFromSystem() {
		
	}
	
	public void backToCategories() {
		viewRef.backToCategories(true);
	}
	
	public void cleanupAfterCategories() {
		viewRef.cleanupAfterCategory();
	}
	
	public void cancelTransaction() {
		itemList.clear();
		total = 0;
	}
}
