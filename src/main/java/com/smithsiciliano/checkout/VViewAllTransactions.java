package com.smithsiciliano.checkout;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class VViewAllTransactions extends JPanel {
	
	private CViewAllTransactions controllerRef = null;
	private JFrame mainFrameRef = null;
	
	private JTextArea transactionView = null;
	private JScrollPane transactionViewSP = null;
	private JButton backButton = null;
	
	private JLabel totalL = null;
		
	private ArrayList<JButton> storesButtons = null;
	private ArrayList<String> storesList = null;
	
	private ActionListener storesButtonListener = null;
	private ActionListener backButtonListener = null;

	public VViewAllTransactions(CViewAllTransactions controllerRef, JFrame mainFrameRef) {
		this.controllerRef = controllerRef;
		this.mainFrameRef = mainFrameRef;
	}
	
	public void initUI() {
		
		setPreferredSize(new Dimension(650,400));
		setLayout(new GridBagLayout());
		Border border = BorderFactory.createEtchedBorder();
		setBorder(BorderFactory.createTitledBorder(border,"View All Transactions"));
		GridBagConstraints panelGBC = new GridBagConstraints();
		panelGBC.gridx = 0;
		panelGBC.gridy = 0;
		panelGBC.anchor = GridBagConstraints.CENTER;
		
		storesButtons = new ArrayList<JButton>();
		
		storesList = controllerRef.getStoresList();
		
		for(int i = 0; i < storesList.size(); i++) {
			storesButtons.add(new JButton(storesList.get(i)));
			storesButtons.get(i).setPreferredSize(new Dimension(150,75));
			GridBagConstraints storesButtonsGBC = new GridBagConstraints();
			storesButtonsGBC.gridx = i%4;
			storesButtonsGBC.gridy = i/4;
			add(storesButtons.get(i),storesButtonsGBC);
		}
		
		mainFrameRef.add(this,panelGBC);
		mainFrameRef.pack();
	}
	
	public void initTransactionsView() {
		
		transactionView = new JTextArea(20,20);
		transactionView.setEditable(false);
		GridBagConstraints transactionViewGBC = new GridBagConstraints();
		transactionViewGBC.gridx = 0;
		transactionViewGBC.gridy = 0;
		transactionViewSP = new JScrollPane(transactionView);
		add(transactionViewSP,transactionViewGBC);
		
		totalL = new JLabel("Total:");
		GridBagConstraints totalLGBC = new GridBagConstraints();
		totalLGBC.gridx = 0;
		totalLGBC.gridy = 1;
		totalLGBC.insets = new Insets(0,0,10,0);
		totalLGBC.anchor = GridBagConstraints.WEST;
		add(totalL,totalLGBC);
		
		backButton = new JButton("Back");
		GridBagConstraints backButtonGBC = new GridBagConstraints();
		backButtonGBC.gridx = 0;
		backButtonGBC.gridy = 2;
		add(backButton,backButtonGBC);
		
		initBackButtonListener();
	}
	
	public void initBackButtonListener() {
		backButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanupTransactions();
				backToStoresButtons();
			}
		};
		backButton.addActionListener(backButtonListener);
	}
	
	public void initListeners() {
		storesButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanupStoresButtons();
				initTransactionsView();
				transactionView.setText(controllerRef.getTransactionListByStore(((JButton)e.getSource()).getText()));
				totalL.setText("Total:     "+controllerRef.getTotal());
			}
		};
		for(int i = 0; i < storesButtons.size(); i++) {
			storesButtons.get(i).addActionListener(storesButtonListener);
		}
	}
	
	private void cleanupTransactions() {
		transactionView.setText("");
		transactionView.setVisible(false);
		transactionViewSP.setVisible(false);
		backButton.setVisible(false);
		totalL.setVisible(false);
		controllerRef.clearTotal();
	}
	
	private void backToStoresButtons() {
		for(JButton button : storesButtons) {
			button.setVisible(true);
		}
	}
	
	private void cleanupStoresButtons() {
		for(JButton button : storesButtons) {
			button.setVisible(false);
		}
	}
}
