package com.smithsiciliano.checkout;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.smithsiciliano.register.VEnterDependents;

public class VAddItem extends JPanel {
	
	private JFrame mainFrameRef = null;
	private CAddItem controllerRef = null;
	
	JPanel titlePanel = null;
	JPanel rowsPanel = null;
	JPanel buttonPanel = null;
	
	JScrollPane rowsScrollPane = null;
	
	ArrayList<JPanel> rows = null;
	
	ArrayList<JTextField> itemNames = null;
	ArrayList<JTextField> categories = null;
	ArrayList<JTextField> prices = null;
	ArrayList<JComboBox<String>> days = null;
	ArrayList<JComboBox<String>> months = null;
	ArrayList<JComboBox<String>> years = null;
	ArrayList<JTextField> quantities = null;
		
	JLabel itemNameL = null;
	JLabel categoryL = null;
	JLabel priceL = null;
	JLabel sellByL = null;
	JLabel quantityL = null;
	
	JButton saveButton = null;
	JButton newRowButton = null;
	
	ActionListener saveButtonListener = null;
	ActionListener newRowButtonListener = null;
	
	private String[] dayList31 = null;
	private String[] dayList30 = null;
	private String[] dayList29 = null;
	private String[] dayList28 = null;
	private String[] monthList = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
	private String[] yearList = null;
	
	public VAddItem(CAddItem controllerRef, JFrame mainFrameRef) {
		this.controllerRef = controllerRef;
		this.mainFrameRef = mainFrameRef;
	}
	
	public void initUI() {
		
		yearList = new String[14];
		for(int i = 2017; i < 2031; i++) {
			yearList[i-2017] = i+"";
		}
		dayList31 = new String[31];
		for(int i = 1; i < 32; i++) {
			dayList31[i-1] = i+"";
		}
		dayList30 = new String[30];
		for(int i = 1; i < 31; i++) {
			dayList30[i-1] = i+"";
		}
		dayList29 = new String[29];
		for(int i = 1; i < 30; i++) {
			dayList29[i-1] = i+"";
		}
		dayList28 = new String[28];
		for(int i = 1; i < 29; i++) {
			dayList28[i-1] = i+"";
		}
		
		setPreferredSize(new Dimension(630,200));
		setLayout(new GridBagLayout());
		Border border = BorderFactory.createEtchedBorder();
		setBorder(BorderFactory.createTitledBorder(border,"Add Item"));
		GridBagConstraints panelGBC = new GridBagConstraints();
		panelGBC.gridx = 0;
		panelGBC.gridy = 0;
		panelGBC.anchor = GridBagConstraints.CENTER;
		
		titlePanel = new JPanel();
		titlePanel.setLayout(new GridBagLayout());
		GridBagConstraints titlePanelGBC = new GridBagConstraints();
		titlePanelGBC.gridx = 0;
		titlePanelGBC.gridy = 0;
		titlePanelGBC.insets = new Insets(0,0,5,0);
		add(titlePanel, titlePanelGBC);
		
		itemNameL = new JLabel("Item Name");
		itemNameL.setPreferredSize(new Dimension(100,20));
		GridBagConstraints itemNameLGBC = new GridBagConstraints();
		itemNameLGBC.gridx = 0;
		itemNameLGBC.gridy = 0;
		itemNameLGBC.insets = new Insets(0,0,0,5);
		titlePanel.add(itemNameL, itemNameLGBC);
		
		categoryL = new JLabel("Category");
		categoryL.setPreferredSize(new Dimension(100,20));
		GridBagConstraints categoryLGBC = new GridBagConstraints();
		categoryLGBC.gridx = 1;
		categoryLGBC.gridy = 0;
		categoryLGBC.insets = new Insets(0,0,0,5);
		titlePanel.add(categoryL, categoryLGBC);
		
		priceL = new JLabel("Price");
		priceL.setPreferredSize(new Dimension(100,20));
		GridBagConstraints priceLGBC = new GridBagConstraints();
		priceLGBC.gridx = 2;
		priceLGBC.gridy = 0;
		priceLGBC.insets = new Insets(0,0,0,5);
		titlePanel.add(priceL, priceLGBC);
		
		sellByL = new JLabel("Sell By Date");
		sellByL.setPreferredSize(new Dimension(150,20));
		GridBagConstraints sellByLGBC = new GridBagConstraints();
		sellByLGBC.gridx = 3;
		sellByLGBC.gridy = 0;
		sellByLGBC.insets = new Insets(0,0,0,0);
		titlePanel.add(sellByL, sellByLGBC);
		
		quantityL = new JLabel("Quantity");
		quantityL.setPreferredSize(new Dimension(100,20));
		GridBagConstraints quantityLGBC = new GridBagConstraints();
		quantityLGBC.gridx = 4;
		quantityLGBC.gridy = 0;
		quantityLGBC.insets = new Insets(0,0,0,0);
		titlePanel.add(quantityL, quantityLGBC);
		
		rowsPanel = new JPanel();
		rowsPanel.setLayout(new GridBagLayout());
		GridBagConstraints rowsPanelGBC = new GridBagConstraints();
		rowsPanelGBC.gridx = 0;
		rowsPanelGBC.gridy = 1;
		rowsPanelGBC.anchor = GridBagConstraints.WEST;
		rowsScrollPane = new JScrollPane(rowsPanel);
		rowsScrollPane.setMaximumSize(new Dimension(610,100));
		rowsScrollPane.setPreferredSize(new Dimension(610,100));
		rowsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(rowsScrollPane, rowsPanelGBC);
		
		rows = new ArrayList<JPanel>();
		itemNames = new ArrayList<JTextField>();
		categories = new ArrayList<JTextField>();
		prices = new ArrayList<JTextField>();
		days = new ArrayList<JComboBox<String>>();
		months = new ArrayList<JComboBox<String>>();
		years = new ArrayList<JComboBox<String>>();
		quantities = new ArrayList<JTextField>();
		
		addRow();
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		GridBagConstraints buttonPanelGBC = new GridBagConstraints();
		buttonPanelGBC.gridx = 0;
		buttonPanelGBC.gridy = 2;
		buttonPanelGBC.insets = new Insets(15,0,0,0);
		add(buttonPanel, buttonPanelGBC);
		
		newRowButton = new JButton("Add");
		newRowButton.setPreferredSize(new Dimension(100,20));
		GridBagConstraints newRowButtonGBC = new GridBagConstraints();
		newRowButtonGBC.gridx = 0;
		newRowButtonGBC.gridy = 0;
		newRowButtonGBC.insets = new Insets(0,0,0,5);
		buttonPanel.add(newRowButton, newRowButtonGBC);
		
		saveButton = new JButton("Save");
		saveButton.setPreferredSize(new Dimension(100,20));
		GridBagConstraints saveButtonGBC = new GridBagConstraints();
		saveButtonGBC.gridx = 1;
		saveButtonGBC.gridy = 0;
		saveButtonGBC.insets = new Insets(0,0,0,5);
		buttonPanel.add(saveButton, saveButtonGBC);
		
		mainFrameRef.add(this,panelGBC);
		mainFrameRef.pack();
	}
	
	public void addRow() {
		JPanel row = new JPanel();
		row.setLayout(new GridBagLayout());
		GridBagConstraints rowGBC = new GridBagConstraints();
		rowGBC.gridx = 0;
		rowGBC.gridy = rows.size();
		rowGBC.insets = new Insets(5,0,0,0);
		rowGBC.anchor = GridBagConstraints.WEST;
		rows.add(row);
		
		JTextField itemNameTF = new JTextField();
		itemNameTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints itemNameTFGBC = new GridBagConstraints();
		itemNameTFGBC.gridx = 0;
		itemNameTFGBC.gridy = 0;
		itemNameTFGBC.insets = new Insets(0,0,0,5);
		itemNameTFGBC.anchor = GridBagConstraints.WEST;
		itemNames.add(itemNameTF);
		row.add(itemNameTF, itemNameTFGBC);
		
		JTextField categoryTF = new JTextField();
		categoryTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints categoryTFGBC = new GridBagConstraints();
		categoryTFGBC.gridx = 1;
		categoryTFGBC.gridy = 0;
		categoryTFGBC.insets = new Insets(0,0,0,5);
		categoryTFGBC.anchor = GridBagConstraints.WEST;
		categories.add(categoryTF);
		row.add(categoryTF, categoryTFGBC);
		
		JTextField priceTF = new JTextField();
		priceTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints priceTFGBC = new GridBagConstraints();
		priceTFGBC.gridx = 2;
		priceTFGBC.gridy = 0;
		priceTFGBC.insets = new Insets(0,0,0,5);
		priceTFGBC.anchor = GridBagConstraints.WEST;
		prices.add(priceTF);
		row.add(priceTF, priceTFGBC);
		
		JComboBox<String> dayCB = new JComboBox<String>();
		dayCB.setModel(new DefaultComboBoxModel<String>(dayList31));
		GridBagConstraints dayCBGBC = new GridBagConstraints();
		dayCBGBC.gridx = 4;
		dayCBGBC.gridy = 0;
		dayCBGBC.insets = new Insets(0,0,0,0);
		dayCBGBC.anchor = GridBagConstraints.WEST;
		days.add(dayCB);
		row.add(dayCB, dayCBGBC);
		
		JComboBox<String> monthCB = new JComboBox<String>();
		monthCB.setModel(new DefaultComboBoxModel<String>(monthList));
		GridBagConstraints monthCBGBC = new GridBagConstraints();
		monthCBGBC.gridx = 3;
		monthCBGBC.gridy = 0;
		monthCBGBC.insets = new Insets(0,0,0,0);
		monthCBGBC.anchor = GridBagConstraints.WEST;
		months.add(monthCB);
		row.add(monthCB, monthCBGBC);
		
		JComboBox<String> yearCB = new JComboBox<String>();
		yearCB.setModel(new DefaultComboBoxModel<String>(yearList));
		GridBagConstraints yearCBGBC = new GridBagConstraints();
		yearCBGBC.gridx = 5;
		yearCBGBC.gridy = 0;
		yearCBGBC.insets = new Insets(0,0,0,0);
		yearCBGBC.anchor = GridBagConstraints.WEST;
		years.add(dayCB);
		row.add(yearCB, yearCBGBC);
		
		JTextField quantityTF = new JTextField();
		quantityTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints quantityTFGBC = new GridBagConstraints();
		quantityTFGBC.gridx = 6;
		quantityTFGBC.gridy = 0;
		quantityTFGBC.insets = new Insets(0,5,0,5);
		quantityTFGBC.anchor = GridBagConstraints.WEST;
		quantities.add(quantityTF);
		row.add(quantityTF, quantityTFGBC);
		
		initCBListeners(dayCB,monthCB,yearCB);

				
		rowsPanel.add(row, rowGBC);
		mainFrameRef.pack();
	}
	
	public void initListeners() {
		saveButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean update = true;
					for(int i = 0; i < rows.size(); i++) {
						String itemName = itemNames.get(i).getText();
						String category = categories.get(i).getText();
						String price = prices.get(i).getText();
						String quantity = quantities.get(i).getText();
						String day = (days.get(i).getSelectedItem().toString().length()<2) ? "0"+days.get(i).getSelectedItem().toString() : days.get(i).getSelectedItem().toString();
						String month = (months.get(i).getSelectedItem().toString().length()<2) ? "0"+months.get(i).getSelectedItem().toString() : months.get(i).getSelectedItem().toString();
						String year = years.get(i).getSelectedItem().toString();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						Date sellByDate = sdf.parse(day+"/"+month+"/"+year);
						if(!itemName.equals("")) {
							if(!category.equals("")
									&& !price.equals("")
									&& !quantity.equals("")) {
								controllerRef.addFoodItem(itemName, category, Double.parseDouble(price),sellByDate, Integer.parseInt(quantity));
							}
							else {
								JOptionPane.showMessageDialog(VAddItem.this, "All fields must be complete","Grocery Store Management System",JOptionPane.WARNING_MESSAGE);
								update = false;
							}
						}
					}
					if(update) {
						controllerRef.save();
					}
				}
				catch (Exception err) {
					JOptionPane.showMessageDialog(VAddItem.this, err.getMessage(),"Grocery Store Management System",JOptionPane.WARNING_MESSAGE);
				}
			}
		};
		saveButton.addActionListener(saveButtonListener);
		newRowButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRow();
			}
		};
		newRowButton.addActionListener(newRowButtonListener);
	}
	
	public void initCBListeners(final JComboBox<String> dayCB, final JComboBox<String> monthCB, final JComboBox<String> yearCB) {
		yearCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt((String)((JComboBox<String>)e.getSource()).getSelectedItem())%4==0 
						&& ((String)monthCB.getSelectedItem()).equals("2")) {
					dayCB.setModel(new DefaultComboBoxModel(dayList29));
					dayCB.setSelectedIndex(0);
				}
				else if(Integer.parseInt((String)((JComboBox<String>)e.getSource()).getSelectedItem())%4!=0 
						&& ((String)monthCB.getSelectedItem()).equals("2")) {
					dayCB.setModel(new DefaultComboBoxModel(dayList28));
					dayCB.setSelectedIndex(0);
				}
			}
		});
		monthCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((JComboBox<String>)e.getSource()).getSelectedIndex()==0
						||((JComboBox<String>)e.getSource()).getSelectedIndex()==2
						||((JComboBox<String>)e.getSource()).getSelectedIndex()==4
						||((JComboBox<String>)e.getSource()).getSelectedIndex()==6
						||((JComboBox<String>)e.getSource()).getSelectedIndex()==7
						||((JComboBox<String>)e.getSource()).getSelectedIndex()==9
						||((JComboBox<String>)e.getSource()).getSelectedIndex()==11) {
					dayCB.setModel(new DefaultComboBoxModel(dayList31));
					dayCB.setSelectedIndex(0);
				}
				else if(((JComboBox<String>)e.getSource()).getSelectedIndex()==3
						|| ((JComboBox<String>)e.getSource()).getSelectedIndex()==5
						|| ((JComboBox<String>)e.getSource()).getSelectedIndex()==8
						|| ((JComboBox<String>)e.getSource()).getSelectedIndex()==10) {
					dayCB.setModel(new DefaultComboBoxModel(dayList30));
					dayCB.setSelectedIndex(0);
				}
				else if(((JComboBox<String>)e.getSource()).getSelectedIndex()==1 
						&& Integer.parseInt((String)yearCB.getSelectedItem())%4==0) {
					dayCB.setModel(new DefaultComboBoxModel(dayList29));
					dayCB.setSelectedIndex(0);
				}
				else if(((JComboBox<String>)e.getSource()).getSelectedIndex()==1 
						&& Integer.parseInt((String)yearCB.getSelectedItem())%4!=0) {
					dayCB.setModel(new DefaultComboBoxModel(dayList28));
					dayCB.setSelectedIndex(0);
				}
			}
		});
	}
}
