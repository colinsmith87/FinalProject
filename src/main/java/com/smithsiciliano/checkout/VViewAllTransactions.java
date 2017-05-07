package com.smithsiciliano.checkout;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class VViewAllTransactions extends JPanel {
	
	private CViewAllTransactions controllerRef = null;
	private JFrame mainFrameRef = null;
		
	private ArrayList<JButton> storesButtons = null;
	private ArrayList<String> storesList = null;

	public VViewAllTransactions(CViewAllTransactions controllerRef, JFrame mainFrameRef) {
		this.controllerRef = controllerRef;
		this.mainFrameRef = mainFrameRef;
	}
	
	public void initUI() {
		
		setPreferredSize(new Dimension(300,300));
		setLayout(new GridBagLayout());
		Border border = BorderFactory.createEtchedBorder();
		setBorder(BorderFactory.createTitledBorder(border,"View All Transactions"));
		GridBagConstraints panelGBC = new GridBagConstraints();
		panelGBC.gridx = 0;
		panelGBC.gridy = 0;
		panelGBC.anchor = GridBagConstraints.CENTER;
		
		storesButtons = new ArrayList<JButton>();
		
		storesList = controllerRef.getStoresList();
		
		for(String name : storesList) {
			storesButtons.add(new JButton("name"));
		}
		
		mainFrameRef.add(this,panelGBC);
		mainFrameRef.pack();
	}
	
	public void initListeners() {
		
	}
}
