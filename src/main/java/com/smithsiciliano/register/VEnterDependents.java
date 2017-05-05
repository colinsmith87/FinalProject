package com.smithsiciliano.register;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.smithsiciliano.App;

public class VEnterDependents extends JPanel {
	
	CEnterDependents controllerRef = null;
	JFrame mainFrameRef = null;
	
	JPanel titlePanel = null;
	JPanel rowsPanel = null;
	JPanel buttonPanel = null;
	
	JScrollPane rowsScrollPane = null;
	
	ArrayList<JPanel> rows = null;
	
	ArrayList<JTextField> firstNames = null;
	ArrayList<JTextField> lastNames = null;
	ArrayList<JTextField> relations = null;
	ArrayList<JTextField> phones = null;
	
	JLabel firstNameL = null;
	JLabel lastNameL = null;
	JLabel relationL = null;
	JLabel phoneL = null;
	
	JButton saveButton = null;
	JButton newRowButton = null;
	
	ActionListener saveButtonListener = null;
	ActionListener newRowButtonListener = null;
	
	public VEnterDependents(CEnterDependents controllerRef, JFrame mainFrameRef) {
		this.controllerRef = controllerRef;
		this.mainFrameRef = mainFrameRef;
	}
	
	public void fillInfo(ArrayList<String> fNames, ArrayList<String> lNames, ArrayList<String> relations, ArrayList<String> phones) {
		for(int i = 0; i < fNames.size(); i++) {
			firstNames.get(i).setText(fNames.get(i));
			lastNames.get(i).setText(lNames.get(i));
			this.relations.get(i).setText(relations.get(i));
			this.phones.get(i).setText(phones.get(i));
			addRow();
		}
	}
	
	public void initUI() {
		
		setPreferredSize(new Dimension(460,200));
		setLayout(new GridBagLayout());
		Border border = BorderFactory.createEtchedBorder();
		setBorder(BorderFactory.createTitledBorder(border,"Enter Dependents"));
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
		
		firstNameL = new JLabel("First Name");
		firstNameL.setPreferredSize(new Dimension(100,20));
		GridBagConstraints firstNameLGBC = new GridBagConstraints();
		firstNameLGBC.gridx = 0;
		firstNameLGBC.gridy = 0;
		firstNameLGBC.insets = new Insets(0,0,0,5);
		titlePanel.add(firstNameL, firstNameLGBC);
		
		lastNameL = new JLabel("Last Name");
		lastNameL.setPreferredSize(new Dimension(100,20));
		GridBagConstraints lastNameLGBC = new GridBagConstraints();
		lastNameLGBC.gridx = 1;
		lastNameLGBC.gridy = 0;
		lastNameLGBC.insets = new Insets(0,0,0,5);
		titlePanel.add(lastNameL, lastNameLGBC);
		
		relationL = new JLabel("Relation");
		relationL.setPreferredSize(new Dimension(100,20));
		GridBagConstraints relationLGBC = new GridBagConstraints();
		relationLGBC.gridx = 2;
		relationLGBC.gridy = 0;
		relationLGBC.insets = new Insets(0,0,0,5);
		titlePanel.add(relationL, relationLGBC);
		
		phoneL = new JLabel("Phone");
		phoneL.setPreferredSize(new Dimension(100,20));
		GridBagConstraints phoneLGBC = new GridBagConstraints();
		phoneLGBC.gridx = 3;
		phoneLGBC.gridy = 0;
		phoneLGBC.insets = new Insets(0,0,0,0);
		titlePanel.add(phoneL, phoneLGBC);
		
		rowsPanel = new JPanel();
		rowsPanel.setLayout(new GridBagLayout());
		GridBagConstraints rowsPanelGBC = new GridBagConstraints();
		rowsPanelGBC.gridx = 0;
		rowsPanelGBC.gridy = 1;
		rowsScrollPane = new JScrollPane(rowsPanel);
		rowsScrollPane.setMaximumSize(new Dimension(438,100));
		rowsScrollPane.setPreferredSize(new Dimension(438,100));
		rowsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(rowsScrollPane, rowsPanelGBC);
		
		rows = new ArrayList<JPanel>();
		firstNames = new ArrayList<JTextField>();
		lastNames = new ArrayList<JTextField>();
		relations = new ArrayList<JTextField>();
		phones = new ArrayList<JTextField>();
		
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
	
	private void addRow() {
		
		JPanel row = new JPanel();
		row.setLayout(new GridBagLayout());
		GridBagConstraints rowGBC = new GridBagConstraints();
		rowGBC.gridx = 0;
		rowGBC.gridy = rows.size();
		rowGBC.insets = new Insets(5,0,0,0);
		rows.add(row);
		
		JTextField firstNameTF = new JTextField();
		firstNameTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints firstNameTFGBC = new GridBagConstraints();
		firstNameTFGBC.gridx = 0;
		firstNameTFGBC.gridy = 0;
		firstNameTFGBC.insets = new Insets(0,0,0,5);
		firstNames.add(firstNameTF);
		row.add(firstNameTF, firstNameTFGBC);
		
		JTextField lastNameTF = new JTextField();
		lastNameTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints lastNameTFGBC = new GridBagConstraints();
		lastNameTFGBC.gridx = 1;
		lastNameTFGBC.gridy = 0;
		lastNameTFGBC.insets = new Insets(0,0,0,5);
		lastNames.add(lastNameTF);
		row.add(lastNameTF, lastNameTFGBC);
		
		JTextField relationTF = new JTextField();
		relationTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints relationTFGBC = new GridBagConstraints();
		relationTFGBC.gridx = 2;
		relationTFGBC.gridy = 0;
		relationTFGBC.insets = new Insets(0,0,0,5);
		relations.add(relationTF);
		row.add(relationTF, relationTFGBC);
		
		JTextField phoneTF = new JTextField();
		phoneTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints phoneTFGBC = new GridBagConstraints();
		phoneTFGBC.gridx = 3;
		phoneTFGBC.gridy = 0;
		phoneTFGBC.insets = new Insets(0,0,0,0);
		phones.add(phoneTF);
		row.add(phoneTF, phoneTFGBC);
		
		rowsPanel.add(row, rowGBC);
		mainFrameRef.pack();
	}

	public void initListeners() {
		saveButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean update = true;
					for(int i = 0; i < rows.size(); i++) {
						String fName = firstNames.get(i).getText();
						String lName = lastNames.get(i).getText();
						String relation = relations.get(i).getText();
						String phone = phones.get(i).getText();
						if(!fName.equals("")) {
							if(!lName.equals("")
									&& !relation.equals("")
									&& !phone.equals("")
									&& phone.length()==10) {
								controllerRef.addDependent(fName, lName, relation, Long.parseLong(phone));
							}
							else {
								JOptionPane.showMessageDialog(VEnterDependents.this, "All fields must be complete and phone must have 10 digits","Grocery Store Management System",JOptionPane.WARNING_MESSAGE);
								update = false;
							}
						}
					}
					if(update) {
						controllerRef.save();
					}
				}
				catch (Exception err) {
					JOptionPane.showMessageDialog(VEnterDependents.this,err.getMessage(),"Grocery Store Management System",JOptionPane.WARNING_MESSAGE);
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
	
	public void cleanup() {
				
		saveButton.removeActionListener(saveButtonListener);
		newRowButton.removeActionListener(newRowButtonListener);
		
		saveButton.setVisible(false);
		newRowButton.setVisible(false);
		for(int i = 0; i < rows.size(); i++) {
			firstNames.get(i).setVisible(false);
			lastNames.get(i).setVisible(false);
			relations.get(i).setVisible(false);
			phones.get(i).setVisible(false);
			rows.get(i).setVisible(false);
		}
		firstNameL.setVisible(false);
		lastNameL.setVisible(false);
		relationL.setVisible(false);
		phoneL.setVisible(false);
		rowsPanel.setVisible(false);
		rowsScrollPane.setVisible(false);
		titlePanel.setVisible(false);
		buttonPanel.setVisible(false);
		this.setVisible(false);
		
		mainFrameRef.remove(this);
	}
}