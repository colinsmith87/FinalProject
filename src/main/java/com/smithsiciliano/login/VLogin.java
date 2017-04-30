package com.smithsiciliano.login;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.smithsiciliano.App;

public class VLogin extends JPanel{
	
	private CLogin controllerRef = null;
	private App mainFrameRef = null;
	
	private JPanel panel = null;
	
	private JTextField employeeIdTF = null;
	
	private JLabel employeeIdLabel = null;
	
	private JButton loginButton = null;
	private JButton newEmployeeButton = null;
	
	private ActionListener loginButtonListener = null;
	private ActionListener newEmployeeButtonListener = null;
	
	public VLogin(CLogin controllerRef, App mainFrameRef) {
		this.controllerRef = controllerRef;
		this.mainFrameRef = mainFrameRef;
	}
	
	public void initListeners() {
		loginButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int employeeId = -1;
				try {
					employeeId = Integer.parseInt(employeeIdTF.getText());
					if(!controllerRef.login(employeeId)) {
						JOptionPane.showMessageDialog(VLogin.this, "Please enter a valid employee ID","Grocery Store Management System",JOptionPane.WARNING_MESSAGE);
					}
				}
				catch (Exception err) {
					System.out.println(err.getMessage());
					JOptionPane.showMessageDialog(VLogin.this, "Please enter a valid employee ID","Grocery Store Management System",JOptionPane.WARNING_MESSAGE);
				}
			}
		};
		loginButton.addActionListener(loginButtonListener);
		
		newEmployeeButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerRef.register();
			}
		};
		newEmployeeButton.addActionListener(newEmployeeButtonListener);
	}
	
	public void initUI() {
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(350,250));
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Login"));
		GridBagConstraints panelGBC = new GridBagConstraints();
		panelGBC.gridx = 0;
		panelGBC.gridy = 0;
		panelGBC.anchor = GridBagConstraints.CENTER;
		
		employeeIdLabel = new JLabel("Employee ID:");
		GridBagConstraints employeeIdLabelGBC = new GridBagConstraints();
		employeeIdLabelGBC.gridx = 0;
		employeeIdLabelGBC.gridy = 0;
		employeeIdLabelGBC.insets = new Insets(0,0,0,5);
		employeeIdLabelGBC.anchor = GridBagConstraints.WEST;
		panel.add(employeeIdLabel,employeeIdLabelGBC);
		
		employeeIdTF = new JTextField();
		employeeIdTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints employeeIdTFGBC = new GridBagConstraints();
		employeeIdTFGBC.gridx = 1;
		employeeIdTFGBC.gridy = 0;
		employeeIdTFGBC.insets = new Insets(0,0,0,0);
		employeeIdTFGBC.anchor = GridBagConstraints.WEST;
		panel.add(employeeIdTF,employeeIdTFGBC);
		
		loginButton = new JButton("Login");
		loginButton.setPreferredSize(new Dimension(100,20));
		GridBagConstraints loginButtonGBC = new GridBagConstraints();
		loginButtonGBC.gridx = 0;
		loginButtonGBC.gridy = 1;
		loginButtonGBC.gridwidth = 2;
		loginButtonGBC.insets = new Insets(5,0,0,0);
		loginButtonGBC.anchor = GridBagConstraints.CENTER;
		panel.add(loginButton,loginButtonGBC);
		
		newEmployeeButton = new JButton("New Employee");
		newEmployeeButton.setPreferredSize(new Dimension(150,20));
		GridBagConstraints newEmployeeButtonGBC = new GridBagConstraints();
		newEmployeeButtonGBC.gridx = 0;
		newEmployeeButtonGBC.gridy = 2;
		newEmployeeButtonGBC.gridwidth = 2;
		newEmployeeButtonGBC.insets = new Insets(5,0,0,0);
		newEmployeeButtonGBC.anchor = GridBagConstraints.CENTER;
		panel.add(newEmployeeButton,newEmployeeButtonGBC);
		
		mainFrameRef.add(panel,panelGBC);
	}
	
	public void cleanup() {
		controllerRef = null;
		
		loginButton.removeActionListener(loginButtonListener);
		newEmployeeButton.removeActionListener(newEmployeeButtonListener);
		loginButtonListener = null;
		newEmployeeButtonListener = null;
		
		loginButton.setVisible(false);
		newEmployeeButton.setVisible(false);
		employeeIdTF.setVisible(false);
		employeeIdLabel.setVisible(false);
		panel.setVisible(false);
		
		loginButton = null;
		newEmployeeButton = null;
		employeeIdTF = null;
		employeeIdLabel = null;
		panel = null;
		
		mainFrameRef = null;
	}
}