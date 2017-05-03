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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import com.smithsiciliano.App;

public class VCheckout extends JPanel {
	
	private App mainFrameRef = null;
	private CCheckout controllerRef = null;
	
	private JTextArea itemListTextArea = null;
	
	private JPanel bottomPanel = null;
	
	private ArrayList<JButton> categoryButtons = null;
	private ArrayList<JButton> itemButtons = null;
	private ArrayList<String> categories = null;
	
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
	
	public VCheckout(CCheckout controllerRef, App mainFrameRef) {
		this.controllerRef = controllerRef;
		this.mainFrameRef = mainFrameRef;
	}
	
	public void initUI() {
		
		categories = controllerRef.getCategories();
				
		setPreferredSize(new Dimension(1000,500));
		setLayout(new GridBagLayout());
		Border border = BorderFactory.createEtchedBorder();
		setBorder(BorderFactory.createTitledBorder(border,"Checkout"));
		GridBagConstraints panelGBC = new GridBagConstraints();
		panelGBC.gridx = 0;
		panelGBC.gridy = 0;
		panelGBC.anchor = GridBagConstraints.CENTER;
		
		itemListTextArea = new JTextArea(3,25);
		itemListTextArea.setEditable(false);
		GridBagConstraints itemListTextAreaGBC = new GridBagConstraints();
		itemListTextAreaGBC.gridx = 3;
		itemListTextAreaGBC.gridy = 0;
		itemListTextAreaGBC.gridheight = 4;
		itemListTextAreaGBC.gridwidth = 2;
		itemListTextAreaGBC.fill = GridBagConstraints.BOTH;
		add(itemListTextArea,itemListTextAreaGBC);
		
		categoryButtons = new ArrayList<JButton>();
		
		for(int i = 0; i < categories.size(); i++) {
			categoryButtons.add(new JButton(categories.get(i)));
			categoryButtons.get(i).setPreferredSize(new Dimension(150,75));
		}

		for(int i = 0; i < categoryButtons.size(); i++) {
			GridBagConstraints categoryButtonGBC = new GridBagConstraints();
			categoryButtonGBC.gridx = i%3;
			categoryButtonGBC.gridy = i/3;
			categoryButtonGBC.fill = GridBagConstraints.BOTH;
			add(categoryButtons.get(i),categoryButtonGBC);
		}
		
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
	
	public void initItems() {
		
		initItemButtonListeners();
	}
	
	public void initPayment() {
		
		initPaymentButtonListeners();
	}
	
	public void initCash() {
		
	}
	
	public void initDone() {
		
		initDoneButtonListeners();
	}
	
	public void initListeners() {
		logoutButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		logoutButton.addActionListener(logoutButtonListener);
		editProfileButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		editProfileButton.addActionListener(editProfileButtonListener);
		editTransactionButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		editTransactionButton.addActionListener(editTransactionButtonListener);
		cancelTransactionButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		cancelTransactionButton.addActionListener(cancelTransactionButtonListener);
		addFoodItemButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		addFoodItemButton.addActionListener(addFoodItemButtonListener);
		removeFoodItemButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		removeFoodItemButton.addActionListener(removeFoodItemButtonListener);
		viewAllTransactionsButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		viewAllTransactionsButton.addActionListener(viewAllTransactionsButtonListener);
		finishButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		finishButton.addActionListener(finishButtonListener);
		categoryButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		for(JButton button : categoryButtons) {
			button.addActionListener(categoryButtonListener);
		}
	}
	
	public void initItemButtonListeners() {

		itemButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		for(JButton button : itemButtons) {
			button.addActionListener(itemButtonListener);
		}
	}
	
	public void initPaymentButtonListeners() {
		
		creditDebitButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		creditDebitButton.addActionListener(creditDebitButtonListener);
		cashButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		cashButton.addActionListener(cashButtonListener);
	}

	public void initDoneButtonListeners() {
		
		doneButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		doneButton.addActionListener(doneButtonListener);
	}
	
	public void cleanupAfterCategory() {
		
	}
	
	public void cleanupAfterItem() {
		
	}
	
	public void cleanupAfterPayment() {
		
	}
	
	public void cleanupAfterCash() {
		
	}
	
	public void cleanupAfterDone() {
		
	}
}
