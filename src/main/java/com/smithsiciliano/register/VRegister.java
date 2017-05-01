package com.smithsiciliano.register;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.smithsiciliano.App;
import com.smithsiciliano.login.VLogin;

public class VRegister extends JPanel {
	
	private CRegister controllerRef = null;
	private App mainFrameRef = null;
	
	private JPanel panel = null;
	
	private JTextField idTF = null;
	private JTextField fNameTF = null;
	private JTextField lNameTF = null;
	private JTextField phoneTF = null;
	private JTextField streetTF = null;
	private JTextField cityTF = null;
	private JTextField zipTF = null;
	
	private JLabel idL= null;
	private JLabel fNameL = null;
	private JLabel lNameL = null;
	private JLabel phoneL = null;
	private JLabel streetL = null;
	private JLabel cityL = null;
	private JLabel zipL = null;
	private JLabel locationL = null;
	private JLabel stateL = null;
	private JLabel dateOfBirthL = null;
	
	private JComboBox<String> stateCB = null;
	private JComboBox<String> dayCB = null;
	private JComboBox<String> monthCB = null;
	private JComboBox<String> yearCB = null;
	private JComboBox<String> locationCB = null;
	
	private JButton nextButton = null;
	private JButton backButton = null;
	
	private ActionListener nextButtonListener = null;
	private ActionListener backButtonListener = null;
	private ActionListener yearCBListener = null;
	private ActionListener monthCBListener = null;
	
	private String[] stateList = new String[]{"AK","AL","AR","AZ","CA",
			"CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL",
			"IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO",
			"MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH",
			"OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT",
			"VA","VI","VT","WA","WI","WV","WY"};
	private String[] dayList31 = null;
	private String[] dayList30 = null;
	private String[] dayList29 = null;
	private String[] dayList28 = null;
	private String[] monthList = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
	private String[] yearList = null;
	private String[] storeList = null;
	
	public VRegister(CRegister controllerRef, App mainFrameRef) {
		this.controllerRef = controllerRef;
		this.mainFrameRef = mainFrameRef;
	}
	
	public void setStoreLocations(String[] storeLocations) {
		storeList = storeLocations;
	}
	
	public void initUI() {
		
		yearList = new String[88];
		for(int i = 1930; i < 2018; i++) {
			yearList[i-1930] = i+"";
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
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(350,350));
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Register"));
		GridBagConstraints panelGBC = new GridBagConstraints();
		panelGBC.gridx = 0;
		panelGBC.gridy = 0;
		panelGBC.anchor = GridBagConstraints.CENTER;
		
		idTF = new JTextField();
		idTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints idTFGBC = new GridBagConstraints();
		idTFGBC.gridx = 1;
		idTFGBC.gridy = 0;
		idTFGBC.insets = new Insets(5,0,0,0);
		idTFGBC.anchor = GridBagConstraints.WEST;
		panel.add(idTF,idTFGBC);
		
		idL = new JLabel("Employee ID:");
		GridBagConstraints idLGBC = new GridBagConstraints();
		idLGBC.gridx = 0;
		idLGBC.gridy = 0;
		idLGBC.insets = new Insets(5,0,0,5);
		idLGBC.anchor = GridBagConstraints.WEST;
		panel.add(idL,idLGBC);
		
		fNameTF = new JTextField();	
		fNameTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints fNameTFGBC = new GridBagConstraints();
		fNameTFGBC.gridx = 1;
		fNameTFGBC.gridy = 1;
		fNameTFGBC.insets = new Insets(5,0,0,0);
		fNameTFGBC.anchor = GridBagConstraints.WEST;
		panel.add(fNameTF,fNameTFGBC);
		
		fNameL = new JLabel("First Name:");
		GridBagConstraints fNameLGBC = new GridBagConstraints();
		fNameLGBC.gridx = 0;
		fNameLGBC.gridy = 1;
		fNameLGBC.insets = new Insets(5,0,0,5);
		fNameLGBC.anchor = GridBagConstraints.WEST;
		panel.add(fNameL,fNameLGBC);
		
		lNameTF = new JTextField();
		lNameTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints lNameTFGBC = new GridBagConstraints();
		lNameTFGBC.gridx = 1;
		lNameTFGBC.gridy = 2;
		lNameTFGBC.insets = new Insets(5,0,0,0);
		lNameTFGBC.anchor = GridBagConstraints.WEST;
		panel.add(lNameTF,lNameTFGBC);
		
		lNameL = new JLabel("Last Name:");
		GridBagConstraints lNameLGBC = new GridBagConstraints();
		lNameLGBC.gridx = 0;
		lNameLGBC.gridy = 2;
		lNameLGBC.insets = new Insets(5,0,0,5);
		lNameLGBC.anchor = GridBagConstraints.WEST;
		panel.add(lNameL,lNameLGBC);
		
		phoneTF = new JTextField();
		phoneTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints phoneTFGBC = new GridBagConstraints();
		phoneTFGBC.gridx = 1;
		phoneTFGBC.gridy = 4;
		phoneTFGBC.insets = new Insets(5,0,0,0);
		phoneTFGBC.anchor = GridBagConstraints.WEST;
		panel.add(phoneTF,phoneTFGBC);
		
		phoneL = new JLabel("Phone Number:");
		GridBagConstraints phoneLGBC = new GridBagConstraints();
		phoneLGBC.gridx = 0;
		phoneLGBC.gridy = 4;
		phoneLGBC.insets = new Insets(5,0,0,5);
		phoneLGBC.anchor = GridBagConstraints.WEST;
		panel.add(phoneL,phoneLGBC);
		
		streetTF = new JTextField();
		streetTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints streetTFGBC = new GridBagConstraints();
		streetTFGBC.gridx = 1;
		streetTFGBC.gridy = 5;
		streetTFGBC.insets = new Insets(5,0,0,0);
		streetTFGBC.anchor = GridBagConstraints.WEST;
		panel.add(streetTF,streetTFGBC);
		
		streetL = new JLabel("Street:");
		GridBagConstraints streetLGBC = new GridBagConstraints();
		streetLGBC.gridx = 0;
		streetLGBC.gridy = 5;
		streetLGBC.insets = new Insets(5,0,0,5);
		streetLGBC.anchor = GridBagConstraints.WEST;
		panel.add(streetL,streetLGBC);
		
		cityTF = new JTextField();
		cityTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints cityTFGBC = new GridBagConstraints();
		cityTFGBC.gridx = 1;
		cityTFGBC.gridy = 6;
		cityTFGBC.insets = new Insets(5,0,0,0);
		cityTFGBC.anchor = GridBagConstraints.WEST;
		panel.add(cityTF,cityTFGBC);
		
		cityL = new JLabel("City:");
		GridBagConstraints cityLGBC = new GridBagConstraints();
		cityLGBC.gridx = 0;
		cityLGBC.gridy = 6;
		cityLGBC.insets = new Insets(5,0,0,5);
		cityLGBC.anchor = GridBagConstraints.WEST;
		panel.add(cityL,cityLGBC);
		
		zipTF = new JTextField();
		zipTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints zipTFGBC = new GridBagConstraints();
		zipTFGBC.gridx = 1;
		zipTFGBC.gridy = 8;
		zipTFGBC.insets = new Insets(5,0,0,0);
		zipTFGBC.anchor = GridBagConstraints.WEST;
		panel.add(zipTF,zipTFGBC);
		
		zipL = new JLabel("Zipcode:");
		GridBagConstraints zipLGBC = new GridBagConstraints();
		zipLGBC.gridx = 0;
		zipLGBC.gridy = 8;
		zipLGBC.insets = new Insets(5,0,0,5);
		zipLGBC.anchor = GridBagConstraints.WEST;
		panel.add(zipL,zipLGBC);
		
		locationCB = new JComboBox<String>();
		locationCB.setPreferredSize(new Dimension(100,20));
		locationCB.setModel(new DefaultComboBoxModel<String>(storeList));
		locationCB.setSelectedIndex(0);
		GridBagConstraints locationCBGBC = new GridBagConstraints();
		locationCBGBC.gridx = 1;
		locationCBGBC.gridy = 9;
		locationCBGBC.insets = new Insets(5,0,0,0);
		locationCBGBC.anchor = GridBagConstraints.WEST;
		panel.add(locationCB,locationCBGBC);
		
		locationL = new JLabel("Store Location:");
		GridBagConstraints locationLGBC = new GridBagConstraints();
		locationLGBC.gridx = 0;
		locationLGBC.gridy = 9;
		locationLGBC.insets = new Insets(5,0,0,5);
		locationLGBC.anchor = GridBagConstraints.WEST;
		panel.add(locationL,locationLGBC);
		
		stateCB = new JComboBox<String>();
		stateCB.setPreferredSize(new Dimension(100,20));
		stateCB.setModel(new DefaultComboBoxModel<String>(stateList));
		stateCB.setSelectedIndex(0);
		GridBagConstraints stateCBGBC = new GridBagConstraints();
		stateCBGBC.gridx = 1;
		stateCBGBC.gridy = 7;
		stateCBGBC.insets = new Insets(5,0,0,0);
		stateCBGBC.anchor = GridBagConstraints.WEST;
		panel.add(stateCB,stateCBGBC);
		
		stateL = new JLabel("State:");
		GridBagConstraints stateLGBC = new GridBagConstraints();
		stateLGBC.gridx = 0;
		stateLGBC.gridy = 7;
		stateLGBC.insets = new Insets(5,0,0,5);
		stateLGBC.anchor = GridBagConstraints.WEST;
		panel.add(stateL,stateLGBC);
		
		dayCB = new JComboBox<String>();
		dayCB.setModel(new DefaultComboBoxModel<String>(dayList31));
		dayCB.setSelectedIndex(0);
		GridBagConstraints dayCBGBC = new GridBagConstraints();
		dayCBGBC.gridx = 1;
		dayCBGBC.gridy = 3;
		dayCBGBC.insets = new Insets(5,0,0,5);
		dayCBGBC.anchor = GridBagConstraints.EAST;
		panel.add(dayCB,dayCBGBC);
		
		monthCB = new JComboBox<String>();
		monthCB.setModel(new DefaultComboBoxModel<String>(monthList));
		monthCB.setSelectedIndex(0);
		GridBagConstraints monthCBGBC = new GridBagConstraints();
		monthCBGBC.gridx = 1;
		monthCBGBC.gridy = 3;
		monthCBGBC.insets = new Insets(5,0,0,5);
		monthCBGBC.anchor = GridBagConstraints.WEST;
		panel.add(monthCB,monthCBGBC);
		
		yearCB = new JComboBox<String>();
		yearCB.setModel(new DefaultComboBoxModel<String>(yearList));
		yearCB.setSelectedIndex(yearList.length-1);
		GridBagConstraints yearCBGBC = new GridBagConstraints();
		yearCBGBC.gridx = 2;
		yearCBGBC.gridy = 3;
		yearCBGBC.insets = new Insets(5,0,0,0);
		yearCBGBC.anchor = GridBagConstraints.WEST;
		panel.add(yearCB,yearCBGBC);
		
		dateOfBirthL = new JLabel("Date of Birth:");
		GridBagConstraints dateOfBirthLGBC = new GridBagConstraints();
		dateOfBirthLGBC.gridx = 0;
		dateOfBirthLGBC.gridy = 3;
		dateOfBirthLGBC.insets = new Insets(5,0,0,5);
		dateOfBirthLGBC.anchor = GridBagConstraints.WEST;
		panel.add(dateOfBirthL,dateOfBirthLGBC);
		
		nextButton = new JButton("Next");
		nextButton.setPreferredSize(new Dimension(100,20));
		GridBagConstraints saveButtonGBC = new GridBagConstraints();
		saveButtonGBC.gridx = 0;
		saveButtonGBC.gridy = 10;
		saveButtonGBC.gridwidth = 2;
		saveButtonGBC.insets = new Insets(25,0,0,45);
		saveButtonGBC.anchor = GridBagConstraints.CENTER;
		panel.add(nextButton,saveButtonGBC);
		
		backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension(100,20));
		GridBagConstraints backButtonGBC = new GridBagConstraints();
		backButtonGBC.gridx = 1;
		backButtonGBC.gridy = 10;
		backButtonGBC.gridwidth = 2;
		backButtonGBC.insets = new Insets(25,0,0,30);
		backButtonGBC.anchor = GridBagConstraints.EAST;
		panel.add(backButton,backButtonGBC);
		
		mainFrameRef.add(panel,panelGBC);
	}
	
	public void initListeners() {
		nextButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String idString = idTF.getText();
					if(idString.length()!=4) {
						throw new Exception("ID must be 4 digits");
					}
					int id = Integer.parseInt(idString);
					String fName = fNameTF.getText();
					String lName = lNameTF.getText();
					String day = (dayCB.getSelectedItem().toString().length()<2) ? "0"+dayCB.getSelectedItem().toString() : dayCB.getSelectedItem().toString();
					String month = (monthCB.getSelectedItem().toString().length()<2) ? "0"+monthCB.getSelectedItem().toString() : monthCB.getSelectedItem().toString();
					String year = yearCB.getSelectedItem().toString();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dob = sdf.parse(day+"/"+month+"/"+year);
					String phoneString = phoneTF.getText();
					if(phoneString.length()!=10) {
						throw new Exception("Phone must be 10 digits");
					}
					long phone = Long.parseLong(phoneString);
					String street = streetTF.getText();
					String city = cityTF.getText();
					String state = stateCB.getSelectedItem().toString();
					String zipString = zipTF.getText();
					if(zipString.length()!=5) {
						throw new Exception("Zip must be 5 digits");
					}
					int zip = Integer.parseInt(zipString);
					String location = locationCB.getSelectedItem().toString();
					if(fName.equals("") || lName.equals("") || street.equals("") || city.equals("")) {
						throw new Exception("All fields must be completed");
					}
					if(!controllerRef.save(id,fName,lName,dob,phone,street,city,state,zip,location)) {
						JOptionPane.showMessageDialog(VRegister.this, "Employee ID taken","Grocery Store Management System",JOptionPane.WARNING_MESSAGE);
					}
				}
				catch (Exception err) {
					System.out.println(err.getMessage());
					JOptionPane.showMessageDialog(VRegister.this, err.getMessage(),"Grocery Store Management System",JOptionPane.WARNING_MESSAGE);
				}
			}
		};
		nextButton.addActionListener(nextButtonListener);
		backButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerRef.launchLoginScreen();
			}
		};
		backButton.addActionListener(backButtonListener);
		yearCBListener = new ActionListener() {
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
		};
		yearCB.addActionListener(yearCBListener);
		monthCBListener = new ActionListener() {
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
		};
		monthCB.addActionListener(monthCBListener);
	}
	
	public void cleanup() {
		
		controllerRef = null;
		
		nextButton.removeActionListener(nextButtonListener);
		backButton.removeActionListener(backButtonListener);
		yearCB.removeActionListener(yearCBListener);
		monthCB.removeActionListener(monthCBListener);
		nextButtonListener = null;
		backButtonListener = null;
		yearCBListener = null;
		monthCBListener = null;
		
		stateList = null;
		dayList28 = null;
		dayList29 = null;
		dayList30 = null;
		dayList31 = null;
		monthList = null;
		yearList = null;
		storeList = null;
		
		idTF.setVisible(false);
		idL.setVisible(false);
		fNameTF.setVisible(false);
		fNameL.setVisible(false);
		lNameTF.setVisible(false);
		lNameL.setVisible(false);
		phoneTF.setVisible(false);
		phoneL.setVisible(false);
		streetTF.setVisible(false);
		streetL.setVisible(false);
		cityTF.setVisible(false);
		cityL.setVisible(false);
		zipTF.setVisible(false);
		zipL.setVisible(false);
		locationCB.setVisible(false);
		locationL.setVisible(false);
		stateCB.setVisible(false);
		stateL.setVisible(false);
		dayCB.setVisible(false);
		monthCB.setVisible(false);
		yearCB.setVisible(false);
		dateOfBirthL.setVisible(false);	
		nextButton.setVisible(false);
		backButton.setVisible(false);
		panel.setVisible(false);
		
		idTF = null;
		idL = null;
		fNameTF = null;
		fNameL = null;
		lNameTF = null;
		lNameL = null;
		phoneTF = null;
		phoneL = null;
		streetTF = null;
		streetL = null;
		cityTF = null;
		cityL = null;
		zipTF = null;
		zipL = null;
		locationCB = null;
		locationL = null;
		stateCB = null;
		stateL = null;
		dayCB = null;
		monthCB = null;
		yearCB = null;
		dateOfBirthL = null;
		nextButton = null;
		backButton = null;
		panel = null;
		
		mainFrameRef = null;
	}
}