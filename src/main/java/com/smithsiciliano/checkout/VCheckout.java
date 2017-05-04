package com.smithsiciliano.checkout;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import com.smithsiciliano.App;

public class VCheckout extends JPanel {

	private JFrame mainFrameRef = null;
	private CCheckout controllerRef = null;

	private JTextArea itemListTextArea = null;
	private JScrollPane textAreaSP = null;

	private JPanel bottomPanel = null;
	private JPanel textAreaPanel = null;
	private JPanel buttonPanel = null;
	
	private JLabel totalL = null;

	private ArrayList<JButton> categoryButtons = null;
	private ArrayList<JButton> itemButtons = null;
	private ArrayList<String> categories = null;
	private ArrayList<String> items = null;

	private JButton creditDebitButton = null;
	private JButton cashButton = null;
	private JButton doneButton = null;

	private JButton logoutButton = null;
	private JButton editProfileButton = null;
	private JButton editTransactionButton = null;
	private JButton cancelTransactionButton = null;
	private JButton addFoodItemButton = null;
	private JButton removeFoodItemButton = null;
	private JButton viewAllTransactionsButton = null;
	private JButton finishButton = null;

	private ActionListener logoutButtonListener = null;
	private ActionListener editProfileButtonListener = null;
	private ActionListener editTransactionButtonListener = null;
	private ActionListener cancelTransactionButtonListener = null;
	private ActionListener addFoodItemButtonListener = null;
	private ActionListener removeFoodItemButtonListener = null;
	private ActionListener viewAllTransactionsButtonListener = null;
	private ActionListener finishButtonListener = null;
	private ActionListener categoryButtonListener = null;
	private ActionListener itemButtonListener = null;
	private ActionListener creditDebitButtonListener = null;
	private ActionListener cashButtonListener = null;
	private ActionListener doneButtonListener = null;

	public VCheckout(CCheckout controllerRef, JFrame mainFrameRef) {
		this.controllerRef = controllerRef;
		this.mainFrameRef = mainFrameRef;
	}

	public void initUI(String storeLoc) {

		setPreferredSize(new Dimension(1000,500));
		setLayout(new GridBagLayout());
		Border border = BorderFactory.createEtchedBorder();
		setBorder(BorderFactory.createTitledBorder(border,storeLoc));
		GridBagConstraints panelGBC = new GridBagConstraints();
		panelGBC.gridx = 0;
		panelGBC.gridy = 0;
		panelGBC.anchor = GridBagConstraints.CENTER;
		
		textAreaPanel = new JPanel();
		textAreaPanel.setLayout(new GridBagLayout());

		itemListTextArea = new JTextArea(25,25);
		itemListTextArea.setEditable(false);
		GridBagConstraints itemListTextAreaGBC = new GridBagConstraints();
		itemListTextAreaGBC.gridx = 0;
		itemListTextAreaGBC.gridy = 0;
		textAreaSP = new JScrollPane(itemListTextArea);
		textAreaPanel.add(textAreaSP,itemListTextAreaGBC);
		itemListTextAreaGBC.gridx = 1;
		
		totalL = new JLabel("Total:\t");
		GridBagConstraints totalLGBC = new GridBagConstraints();
		totalLGBC.gridx = 0;
		totalLGBC.gridy = 1;
		totalLGBC.anchor = GridBagConstraints.WEST;
		textAreaPanel.add(totalL,totalLGBC);
		
		add(textAreaPanel,itemListTextAreaGBC);
		
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(460,460));
		buttonPanel.setLayout(new GridBagLayout());
		GridBagConstraints buttonPanelGBC = new GridBagConstraints();
		buttonPanelGBC.gridx = 0;
		buttonPanelGBC.gridy = 0;

		categories = controllerRef.getCategories();

		categoryButtons = new ArrayList<JButton>();

		for(int i = 0; i < categories.size(); i++) {
			categoryButtons.add(new JButton(categories.get(i)));
			categoryButtons.get(i).setPreferredSize(new Dimension(150,75));
		}

		for(int i = 0; i < categoryButtons.size(); i++) {
			GridBagConstraints categoryButtonGBC = new GridBagConstraints();
			categoryButtonGBC.gridx = i%3;
			categoryButtonGBC.gridy = i/3;
			buttonPanel.add(categoryButtons.get(i),categoryButtonGBC);
		}
		
		
		add(buttonPanel,buttonPanelGBC);
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridBagLayout());
		bottomPanel.setBorder(BorderFactory.createEtchedBorder());
		GridBagConstraints bottomPanelGBC = new GridBagConstraints();
		bottomPanelGBC.gridx = 0;
		bottomPanelGBC.gridy = 1;
		bottomPanelGBC.insets = new Insets(5,0,0,0);

		logoutButton = new JButton("Logout");
		GridBagConstraints logoutButtonGBC = new GridBagConstraints();
		logoutButtonGBC.gridx = 0;
		logoutButtonGBC.gridy = 0;
		logoutButtonGBC.insets = new Insets(5,5,5,5);
		bottomPanel.add(logoutButton,logoutButtonGBC);

		editProfileButton = new JButton("Edit Profile");
		GridBagConstraints editProfileButtonGBC = new GridBagConstraints();
		editProfileButtonGBC.gridx = 1;
		editProfileButtonGBC.gridy = 0;
		editProfileButtonGBC.insets = new Insets(5,0,5,5);
		bottomPanel.add(editProfileButton,editProfileButtonGBC);

		editTransactionButton = new JButton("Edit Transaction");
		GridBagConstraints editTransactionButtonGBC = new GridBagConstraints();
		editTransactionButtonGBC.gridx = 2;
		editTransactionButtonGBC.gridy = 0;
		editTransactionButtonGBC.insets = new Insets(5,0,5,5);
		bottomPanel.add(editTransactionButton,editTransactionButtonGBC);

		cancelTransactionButton = new JButton("Cancel Transaction");
		GridBagConstraints cancelTransactionButtonGBC = new GridBagConstraints();
		cancelTransactionButtonGBC.gridx = 3;
		cancelTransactionButtonGBC.gridy = 0;
		cancelTransactionButtonGBC.insets = new Insets(5,0,5,5);
		bottomPanel.add(cancelTransactionButton,cancelTransactionButtonGBC);

		addFoodItemButton = new JButton("Add Food Item");
		GridBagConstraints addFoodItemButtonGBC = new GridBagConstraints();
		addFoodItemButtonGBC.gridx = 5;
		addFoodItemButtonGBC.gridy = 0;
		addFoodItemButtonGBC.insets = new Insets(5,0,5,5);
		bottomPanel.add(addFoodItemButton,addFoodItemButtonGBC);

		removeFoodItemButton = new JButton("Remove Food Item");
		GridBagConstraints removeFoodItemButtonGBC = new GridBagConstraints();
		removeFoodItemButtonGBC.gridx = 6;
		removeFoodItemButtonGBC.gridy = 0;
		removeFoodItemButtonGBC.insets = new Insets(5,0,5,5);
		bottomPanel.add(removeFoodItemButton,removeFoodItemButtonGBC);

		viewAllTransactionsButton = new JButton("View All Transactions");
		GridBagConstraints viewAllTransactionsButtonGBC = new GridBagConstraints();
		viewAllTransactionsButtonGBC.gridx = 4;
		viewAllTransactionsButtonGBC.gridy = 0;
		viewAllTransactionsButtonGBC.insets = new Insets(5,0,5,5);
		bottomPanel.add(viewAllTransactionsButton,viewAllTransactionsButtonGBC);

		finishButton = new JButton("Finish");
		GridBagConstraints finishButtonGBC = new GridBagConstraints();
		finishButtonGBC.gridx = 7;
		finishButtonGBC.gridy = 0;
		finishButtonGBC.insets = new Insets(5,0,5,5);
		bottomPanel.add(finishButton,finishButtonGBC);

		mainFrameRef.add(this,panelGBC);
		mainFrameRef.add(bottomPanel,bottomPanelGBC);
		mainFrameRef.pack();
	}

	public void initItems(String category) {

		items = controllerRef.getItemsStringByCategory(category);
		
		itemButtons = new ArrayList<JButton>();

		for(int i = 0; i < items.size(); i++) {
			itemButtons.add(new JButton(items.get(i)));
			itemButtons.get(i).setPreferredSize(new Dimension(150,75));
		}

		for(int i = 0; i < itemButtons.size(); i++) {
			GridBagConstraints itemButtonGBC = new GridBagConstraints();
			itemButtonGBC.gridx = i%3;
			itemButtonGBC.gridy = i/3;
			buttonPanel.add(itemButtons.get(i),itemButtonGBC);
		}
		initItemButtonListeners();
	}

	public void initPayment() {
		
		creditDebitButton = new JButton("Credit/Debit");
		creditDebitButton.setPreferredSize(new Dimension(150,75));
		GridBagConstraints creditDebitButtonGBC = new GridBagConstraints();
		creditDebitButtonGBC.gridx = 0;
		creditDebitButtonGBC.gridy = 0;
		buttonPanel.add(creditDebitButton,creditDebitButtonGBC);
		
		cashButton = new JButton("Cash");
		cashButton.setPreferredSize(new Dimension(150,75));
		GridBagConstraints cashButtonGBC = new GridBagConstraints();
		cashButtonGBC.gridx = 1;
		cashButtonGBC.gridy = 0;
		buttonPanel.add(cashButton,cashButtonGBC);
		
		initPaymentButtonListeners();
	}

	public void initDone() {
		
		doneButton = new JButton("Done");
		doneButton.setPreferredSize(new Dimension(150,75));
		GridBagConstraints doneButtonGBC = new GridBagConstraints();
		doneButtonGBC.gridx = 0;
		doneButtonGBC.gridy = 0;
		buttonPanel.add(doneButton, doneButtonGBC);
		initDoneButtonListeners();
	}

	public void initListeners() {
		logoutButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerRef.launchLoginScreen();
			}
		};
		logoutButton.addActionListener(logoutButtonListener);
		editProfileButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerRef.editProfile();
			}
		};
		editProfileButton.addActionListener(editProfileButtonListener);
		editTransactionButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		};
		editTransactionButton.addActionListener(editTransactionButtonListener);
		cancelTransactionButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemListTextArea.setText("");
				totalL.setText("Total:");
				controllerRef.cancelTransaction();
			}
		};
		cancelTransactionButton.addActionListener(cancelTransactionButtonListener);
		addFoodItemButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		};
		addFoodItemButton.addActionListener(addFoodItemButtonListener);
		removeFoodItemButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		};
		removeFoodItemButton.addActionListener(removeFoodItemButtonListener);
		viewAllTransactionsButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		};
		viewAllTransactionsButton.addActionListener(viewAllTransactionsButtonListener);
		finishButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanupAfterCategory();
				initPayment();
			}
		};
		finishButton.addActionListener(finishButtonListener);
		categoryButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanupAfterCategory();
				initItems(((JButton)e.getSource()).getText());
			}
		};
		for(JButton button : categoryButtons) {
			button.addActionListener(categoryButtonListener);
		}
	}

	public void initItemButtonListeners() {

		itemButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanupAfterItem();
				itemListTextArea.setText(itemListTextArea.getText()+controllerRef.getFoodItemInfo(((JButton)e.getSource()).getText())+"\n");
				totalL.setText("Total:     "+controllerRef.getTotal());
				backToCategories(false);
			}
		};
		for(JButton button : itemButtons) {
			button.addActionListener(itemButtonListener);
		}
	}

	public void initPaymentButtonListeners() {

		creditDebitButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanupAfterPayment();
				initDone();
			}
		};
		creditDebitButton.addActionListener(creditDebitButtonListener);
		cashButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanupAfterPayment();
				initDone();
			}
		};
		cashButton.addActionListener(cashButtonListener);
	}

	public void initDoneButtonListeners() {

		doneButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanupAfterDone();
				controllerRef.createTransaction();
				itemListTextArea.setText("");
				totalL.setText("Total:");
				backToCategories(true);
			}
		};
		doneButton.addActionListener(doneButtonListener);
	}
	
	public void backToCategories(boolean done) {
		
		if(done) {
			categories = controllerRef.getCategories();

			categoryButtons = new ArrayList<JButton>();

			for(int i = 0; i < categories.size(); i++) {
				categoryButtons.add(new JButton(categories.get(i)));
				categoryButtons.get(i).setPreferredSize(new Dimension(150,75));
			}

			for(int i = 0; i < categoryButtons.size(); i++) {
				GridBagConstraints categoryButtonGBC = new GridBagConstraints();
				categoryButtonGBC.gridx = i%3;
				categoryButtonGBC.gridy = i/3;
				buttonPanel.add(categoryButtons.get(i),categoryButtonGBC);
			}
		}
		for(JButton button : categoryButtons) {
			button.setVisible(true);
		}
	}

	public void cleanupAfterCategory() {
		for(JButton button : categoryButtons) {
			button.setVisible(false);;
		}
	}

	public void cleanupAfterItem() {
		for(JButton button : itemButtons) {
			button.setVisible(false);
		}
	}

	public void cleanupAfterPayment() {
		creditDebitButton.setVisible(false);
		cashButton.setVisible(false);
	}

	public void cleanupAfterDone() {
		doneButton.setVisible(false);
	}
	
	public void cleanup() {
		
		for(JButton button : categoryButtons) {
			button.removeActionListener(categoryButtonListener);
			button.setVisible(false);
		}
		if(itemButtons!=null) {
			for(JButton button : itemButtons) {
				button.removeActionListener(itemButtonListener);
				button.setVisible(false);
			}
		}

		if (creditDebitButton!=null) {
			creditDebitButton.removeActionListener(itemButtonListener);
			creditDebitButton.setVisible(false);
		}
		if (cashButton!=null) {
			cashButton.removeActionListener(cashButtonListener);
			cashButton.setVisible(false);
		}
		if (doneButton!=null) {
			doneButton.removeActionListener(doneButtonListener);
			doneButton.setVisible(false);
		}
		logoutButton.removeActionListener(logoutButtonListener);
		editProfileButton.removeActionListener(editProfileButtonListener);
		editTransactionButton.removeActionListener(editTransactionButtonListener);
		cancelTransactionButton.removeActionListener(cancelTransactionButtonListener);
		addFoodItemButton.removeActionListener(addFoodItemButtonListener);
		removeFoodItemButton.removeActionListener(removeFoodItemButtonListener);
		viewAllTransactionsButton.removeActionListener(viewAllTransactionsButtonListener);
		finishButton.removeActionListener(finishButtonListener);
		
		itemListTextArea.setVisible(false);
		logoutButton.setVisible(false);
		editProfileButton.setVisible(false);
		editTransactionButton.setVisible(false);
		cancelTransactionButton.setVisible(false);
		addFoodItemButton.setVisible(false);
		removeFoodItemButton.setVisible(false);
		viewAllTransactionsButton.setVisible(false);
		finishButton.setVisible(false);
		
		bottomPanel.setVisible(false);
		textAreaPanel.setVisible(false);
		buttonPanel.setVisible(false);
		
		this.setVisible(false);
		
		mainFrameRef.remove(this);
		mainFrameRef.remove(bottomPanel);
	}
}
