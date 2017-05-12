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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.smithsiciliano.models.Stores;
import com.smithsiciliano.register.VRegister;

public class VAddMember extends JPanel {

	private JFrame mainFrameRef = null;
	private CAddMember controllerRef = null;

	JPanel titlePanel = null;
	JPanel buttonPanel = null;

	JButton saveButton = null;
	JButton newRowButton = null;

	JLabel memberIdLabel = null;

	JTextField memberIdField = null;

	ActionListener saveButtonListener = null;
	ActionListener newRowButtonListener = null;
	private JTextField fNameTF;
	private JTextField lNameTF;
	private JLabel lNameL;
	private JTextField phoneTF;
	private JLabel phoneL;
	private JComboBox<String> dayCB;
	private JComboBox<String> monthCB;
	private JComboBox<String> yearCB;
	private JLabel dateOfBirthL;
	private JComboBox<String> locationCB;
	private JLabel locationL;
	private String[] yearList;
	private String[] dayList31;
	private String[] dayList30;
	private String[] dayList29;
	private String[] dayList28;
	private String[] monthList = new String[] { "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "10", "11", "12" };
	private String[] storeList;
	private ActionListener yearCBListener;
	private ActionListener monthCBListener;
	private JLabel fNameL;

	public VAddMember(CAddMember controllerRef, JFrame mainFrameRef) {
		this.controllerRef = controllerRef;
		this.mainFrameRef = mainFrameRef;
	}

	public void setStoreLocations(String[] storeLocations) {
		storeList = storeLocations;
	}

	public void initUI() {

		yearList = new String[88];
		for (int i = 1930; i < 2018; i++) {
			yearList[i - 1930] = i + "";
		}
		dayList31 = new String[31];
		for (int i = 1; i < 32; i++) {
			dayList31[i - 1] = i + "";
		}
		dayList30 = new String[30];
		for (int i = 1; i < 31; i++) {
			dayList30[i - 1] = i + "";
		}
		dayList29 = new String[29];
		for (int i = 1; i < 30; i++) {
			dayList29[i - 1] = i + "";
		}
		dayList28 = new String[28];
		for (int i = 1; i < 29; i++) {
			dayList28[i - 1] = i + "";
		}

		setPreferredSize(new Dimension(630, 200));
		setLayout(new GridBagLayout());
		Border border = BorderFactory.createEtchedBorder();
		setBorder(BorderFactory.createTitledBorder(border, "Add Member"));
		GridBagConstraints panelGBC = new GridBagConstraints();
		panelGBC.gridx = 0;
		panelGBC.gridy = 0;
		panelGBC.anchor = GridBagConstraints.CENTER;

		titlePanel = new JPanel();
		titlePanel.setLayout(new GridBagLayout());
		GridBagConstraints titlePanelGBC = new GridBagConstraints();
		titlePanelGBC.gridx = 0;
		titlePanelGBC.gridy = 0;
		titlePanelGBC.insets = new Insets(0, 0, 5, 0);
		add(titlePanel, titlePanelGBC);

		/*
		 * private String fName; private String lName; private Date dateOfBirth;
		 * private long phone; private int points; private Stores storeLoc;
		 */

		fNameTF = new JTextField();
		fNameTF.setPreferredSize(new Dimension(100, 20));
		GridBagConstraints fNameTFGBC = new GridBagConstraints();
		fNameTFGBC.gridx = 1;
		fNameTFGBC.gridy = 1;
		fNameTFGBC.insets = new Insets(5, 0, 0, 0);
		fNameTFGBC.anchor = GridBagConstraints.WEST;
		titlePanel.add(fNameTF, fNameTFGBC);

		fNameL = new JLabel("First Name:");
		GridBagConstraints fNameLGBC = new GridBagConstraints();
		fNameLGBC.gridx = 0;
		fNameLGBC.gridy = 1;
		fNameLGBC.insets = new Insets(5, 0, 0, 5);
		fNameLGBC.anchor = GridBagConstraints.WEST;
		titlePanel.add(fNameL, fNameLGBC);

		lNameTF = new JTextField();
		lNameTF.setPreferredSize(new Dimension(100, 20));
		GridBagConstraints lNameTFGBC = new GridBagConstraints();
		lNameTFGBC.gridx = 1;
		lNameTFGBC.gridy = 2;
		lNameTFGBC.insets = new Insets(5, 0, 0, 0);
		lNameTFGBC.anchor = GridBagConstraints.WEST;
		titlePanel.add(lNameTF, lNameTFGBC);

		lNameL = new JLabel("Last Name:");
		GridBagConstraints lNameLGBC = new GridBagConstraints();
		lNameLGBC.gridx = 0;
		lNameLGBC.gridy = 2;
		lNameLGBC.insets = new Insets(5, 0, 0, 5);
		lNameLGBC.anchor = GridBagConstraints.WEST;
		titlePanel.add(lNameL, lNameLGBC);

		phoneTF = new JTextField();
		phoneTF.setPreferredSize(new Dimension(100, 20));
		GridBagConstraints phoneTFGBC = new GridBagConstraints();
		phoneTFGBC.gridx = 1;
		phoneTFGBC.gridy = 4;
		phoneTFGBC.insets = new Insets(5, 0, 0, 0);
		phoneTFGBC.anchor = GridBagConstraints.WEST;
		titlePanel.add(phoneTF, phoneTFGBC);

		dayCB = new JComboBox<String>();
		dayCB.setModel(new DefaultComboBoxModel<String>(dayList31));
		dayCB.setSelectedIndex(0);
		GridBagConstraints dayCBGBC = new GridBagConstraints();
		dayCBGBC.gridx = 1;
		dayCBGBC.gridy = 3;
		dayCBGBC.insets = new Insets(5, 0, 0, 5);
		dayCBGBC.anchor = GridBagConstraints.EAST;
		titlePanel.add(dayCB, dayCBGBC);

		monthCB = new JComboBox<String>();
		monthCB.setModel(new DefaultComboBoxModel<String>(monthList));
		monthCB.setSelectedIndex(0);
		GridBagConstraints monthCBGBC = new GridBagConstraints();
		monthCBGBC.gridx = 1;
		monthCBGBC.gridy = 3;
		monthCBGBC.insets = new Insets(5, 0, 0, 5);
		monthCBGBC.anchor = GridBagConstraints.WEST;
		titlePanel.add(monthCB, monthCBGBC);

		yearCB = new JComboBox<String>();
		yearCB.setModel(new DefaultComboBoxModel<String>(yearList));
		yearCB.setSelectedIndex(yearList.length - 1);
		GridBagConstraints yearCBGBC = new GridBagConstraints();
		yearCBGBC.gridx = 2;
		yearCBGBC.gridy = 3;
		yearCBGBC.insets = new Insets(5, 0, 0, 0);
		yearCBGBC.anchor = GridBagConstraints.WEST;
		titlePanel.add(yearCB, yearCBGBC);

		dateOfBirthL = new JLabel("Date of Birth:");
		GridBagConstraints dateOfBirthLGBC = new GridBagConstraints();
		dateOfBirthLGBC.gridx = 0;
		dateOfBirthLGBC.gridy = 3;
		dateOfBirthLGBC.insets = new Insets(5, 0, 0, 5);
		dateOfBirthLGBC.anchor = GridBagConstraints.WEST;
		titlePanel.add(dateOfBirthL, dateOfBirthLGBC);

		phoneL = new JLabel("Phone Number:");
		GridBagConstraints phoneLGBC = new GridBagConstraints();
		phoneLGBC.gridx = 0;
		phoneLGBC.gridy = 4;
		phoneLGBC.insets = new Insets(5, 0, 0, 5);
		phoneLGBC.anchor = GridBagConstraints.WEST;
		titlePanel.add(phoneL, phoneLGBC);

		locationCB = new JComboBox<String>();
		locationCB.setPreferredSize(new Dimension(100, 20));
		locationCB.setModel(new DefaultComboBoxModel<String>(storeList));
		locationCB.setSelectedIndex(0);
		GridBagConstraints locationCBGBC = new GridBagConstraints();
		locationCBGBC.gridx = 1;
		locationCBGBC.gridy = 10;
		locationCBGBC.insets = new Insets(5, 0, 0, 0);
		locationCBGBC.anchor = GridBagConstraints.WEST;
		titlePanel.add(locationCB, locationCBGBC);

		locationL = new JLabel("Store Location:");
		GridBagConstraints locationLGBC = new GridBagConstraints();
		locationLGBC.gridx = 0;
		locationLGBC.gridy = 10;
		locationLGBC.insets = new Insets(5, 0, 0, 5);
		locationLGBC.anchor = GridBagConstraints.WEST;
		titlePanel.add(locationL, locationLGBC);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		GridBagConstraints buttonPanelGBC = new GridBagConstraints();
		buttonPanelGBC.gridx = 0;
		buttonPanelGBC.gridy = 2;
		buttonPanelGBC.insets = new Insets(15, 0, 0, 0);
		add(buttonPanel, buttonPanelGBC);

		saveButton = new JButton("Save");
		saveButton.setPreferredSize(new Dimension(100, 20));
		GridBagConstraints saveButtonGBC = new GridBagConstraints();
		saveButtonGBC.gridx = 0;
		saveButtonGBC.gridy = 0;
		saveButtonGBC.insets = new Insets(0, 0, 0, 5);
		buttonPanel.add(saveButton, saveButtonGBC);

		mainFrameRef.add(this, panelGBC);
		mainFrameRef.pack();
	}

	public void initListeners() {
		saveButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String fName = fNameTF.getText();
					String lName = lNameTF.getText();
					String day = (dayCB.getSelectedItem().toString().length() < 2) ? "0"
							+ dayCB.getSelectedItem().toString()
							: dayCB.getSelectedItem().toString();
					String month = (monthCB.getSelectedItem().toString()
							.length() < 2) ? "0"
							+ monthCB.getSelectedItem().toString() : monthCB
							.getSelectedItem().toString();
					String year = yearCB.getSelectedItem().toString();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dob = sdf.parse(day + "/" + month + "/" + year);
					String phoneString = phoneTF.getText();
					if (phoneString.length() != 10) {
						throw new Exception("Phone must be 10 digits");
					}
					long phone = Long.parseLong(phoneString);
					String location = locationCB.getSelectedItem().toString();
					Stores storLoc = new Stores(location);
					if (fName.equals("") || lName.equals("")) {
						throw new Exception("All fields must be completed");
					}
					if (!controllerRef.save(fName, lName, dob, phone, storLoc)) {
						JOptionPane.showMessageDialog(VAddMember.this,
								"Employee ID taken",
								"Grocery Store Management System",
								JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception err) {
					JOptionPane.showMessageDialog(VAddMember.this,
							err.getMessage(),
							"Grocery Store Management System",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		};
		saveButton.addActionListener(saveButtonListener);
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
		yearCB.removeActionListener(yearCBListener);
		monthCB.removeActionListener(monthCBListener);
		fNameTF.setVisible(false);
		fNameL.setVisible(false);
		lNameTF.setVisible(false);
		lNameL.setVisible(false);
		phoneTF.setVisible(false);
		phoneL.setVisible(false);
		locationCB.setVisible(false);
		locationL.setVisible(false);
		dayCB.setVisible(false);
		monthCB.setVisible(false);
		yearCB.setVisible(false);
		dateOfBirthL.setVisible(false);	
		this.setVisible(false);
		
		mainFrameRef.remove(this);
	}
		
	

}
