package com.smithsiciliano;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import com.smithsiciliano.dao.EmployeeDAO;
import com.smithsiciliano.dao.FoodDAO;
import com.smithsiciliano.login.CLogin;
import com.smithsiciliano.models.Employee;
import com.smithsiciliano.models.Food;

/**
 * Hello world!
 *
 */
public class App extends JFrame {
	public App() {
		super("Grocery Store Management System");
    	setPreferredSize(new Dimension(700,500));
		setLayout(new GridBagLayout());
		
    	CLogin startApplication = new CLogin(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
    public static void main( String[] args ) {
    	
    	App app = new App();
    	    	
//		Stores s = new Stores("Ipswich");
//		Employee em = new Employee(0000,"Colin","Smith",65000,9785005381L,"61 High Street","Ipswich",
//				"MA",01938,new Date(),"Ipswich");
//		Dependent d = new Dependent("Devin","Smith","Sister",5555555555L,0000);
//		Food f = new Food("Banana","Fruit",05.50,new Date());
//		InStock i = new InStock(0,"Ipswich","Banana");
//		Members m = new Members("Patricia","Smith",new Date(),4444444444L,0,"Ipswich");
//		Transactions t = new Transactions(05.50,"Banana","Ipswich");
    }
}
