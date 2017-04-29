package com.smithsiciliano;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VLogin extends JFrame{
	
	private CLogin controllerRef = null;
	
	private JPanel panel = null;
	
	private JTextField employeeIdTF = null;
	
	private JLabel employeeIdLabel = null;
	
	private JButton loginButton = null;
	private JButton newEmployeeButton = null;
	
	private ActionListener loginButtonListener = null;
	private ActionListener newEmployeeButtonListener = null;
	
	public VLogin(CLogin controllerRef) {
		super("Login");
		this.controllerRef = controllerRef;
	}
	
	public void initListeners() {
		loginButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		loginButton.addActionListener(loginButtonListener);
		
		newEmployeeButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		newEmployeeButton.addActionListener(newEmployeeButtonListener);
	}
	
	public void initUI() {
		setPreferredSize(new Dimension(700,500));
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Login"));
		
		employeeIdLabel = new JLabel("Employee ID: ");
		GridBagConstraints employeeIdLabelGBC = new GridBagConstraints();
		employeeIdLabelGBC.gridx = 0;
		employeeIdLabelGBC.gridy = 0;
		employeeIdLabelGBC.anchor = GridBagConstraints.WEST;
		panel.add(employeeIdLabel,employeeIdLabelGBC);
		
		employeeIdTF = new JTextField();
		employeeIdTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints employeeIdTFGBC = new GridBagConstraints();
		employeeIdTFGBC.gridx = 1;
		employeeIdTFGBC.gridy = 0;
		employeeIdTFGBC.anchor = GridBagConstraints.WEST;
		panel.add(employeeIdTF,employeeIdTFGBC);
		
		loginButton = new JButton("Login");
		loginButton.setPreferredSize(new Dimension(100,20));
		GridBagConstraints loginButtonGBC = new GridBagConstraints();
		loginButtonGBC.gridx = 0;
		loginButtonGBC.gridy = 1;
		loginButtonGBC.anchor = GridBagConstraints.WEST;
		panel.add(loginButton,loginButtonGBC);
		
		newEmployeeButton = new JButton("New Employee");
		newEmployeeButton.setPreferredSize(new Dimension(100,20));
		GridBagConstraints newEmployeeButtonGBC = new GridBagConstraints();
		newEmployeeButtonGBC.gridx = 1;
		newEmployeeButtonGBC.gridy = 1;
		newEmployeeButtonGBC.anchor = GridBagConstraints.WEST;
		panel.add(newEmployeeButton,newEmployeeButtonGBC);
		
		add(panel,BorderLayout.CENTER);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}