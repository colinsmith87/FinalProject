package com.smithsiciliano.register;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.smithsiciliano.App;

public class VRegister extends JPanel {
	
	private CRegister controllerRef = null;
	private App mainFrameRef = null;
	
	private JPanel panel = null;
	
	public VRegister(CRegister controllerRef, App mainFrameRef) {
		this.controllerRef = controllerRef;
		this.mainFrameRef = mainFrameRef;
	}
	
	public void initUI() {
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(350,250));
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Register"));
		GridBagConstraints panelGBC = new GridBagConstraints();
		panelGBC.gridx = 0;
		panelGBC.gridy = 0;
		panelGBC.anchor = GridBagConstraints.CENTER;
		
		mainFrameRef.add(panel,panelGBC);
	}
	
	public void initListeners() {
		
	}
}