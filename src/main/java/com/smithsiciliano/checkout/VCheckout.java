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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.smithsiciliano.App;
import com.smithsiciliano.models.Members;

public class VCheckout extends JPanel {

	private JFrame mainFrameRef = null;
	private CCheckout controllerRef = null;

	private JTextArea itemListTextArea = null;
	private JScrollPane textAreaSP = null;

	private JPanel bottomPanel = null;
	private JPanel textAreaPanel = null;
	private JPanel buttonPanel = null;
	private JPanel itemButtonPanel = null;

	private JLabel totalL = null;

	private ArrayList<JButton> categoryButtons = null;
	private ArrayList<JButton> itemButtons = null;
	private ArrayList<String> categories = null;
	private ArrayList<String> items = null;

	private JButton backButton = null;

	private JButton creditDebitButton = null;
	private JButton cashButton = null;
	private JButton doneButton = null;

	private JButton logoutButton = null;
	private JButton editProfileButton = null;
	private JButton removeLastItemButton = null;
	private JButton cancelTransactionButton = null;
	private JButton addFoodItemButton = null;
	private JButton addMemberButton = null;
	private JButton viewAllTransactionsButton = null;
	private JButton finishButton = null;
	private JButton deleteAccountButton = null;
	private JButton removeItemButton = null;
	private JButton removeMemberButton = null;
	private JButton viewUnpopularItemsButton = null;

	private ActionListener logoutButtonListener = null;
	private ActionListener editProfileButtonListener = null;
	private ActionListener removeLastItemButtonListener = null;
	private ActionListener cancelTransactionButtonListener = null;
	private ActionListener addFoodItemButtonListener = null;
	private ActionListener addMemberButtonListener = null;
	private ActionListener viewAllTransactionsButtonListener = null;
	private ActionListener finishButtonListener = null;
	private ActionListener categoryButtonListener = null;
	private ActionListener itemButtonListener = null;
	private ActionListener backButtonListener = null;
	private ActionListener creditDebitButtonListener = null;
	private ActionListener cashButtonListener = null;
	private ActionListener doneButtonListener = null;
	private ActionListener deleteAccountButtonListener = null;
	private ActionListener removeItemButtonListener = null;
	private ActionListener removeMemberButtonListener = null;
	private ActionListener viewUnpopularItemsButtonListener = null;
	private JTextField memberIdTF;
	private JLabel memberIdL;
	private JButton memberIdButton;
	private ActionListener memberIdButtonListener;

	public VCheckout(CCheckout controllerRef, JFrame mainFrameRef) {
		this.controllerRef = controllerRef;
		this.mainFrameRef = mainFrameRef;
	}

	public void initUI(String storeLoc) {

		setPreferredSize(new Dimension(1100,550));
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

		totalL = new JLabel("Total:     0.00");
		GridBagConstraints totalLGBC = new GridBagConstraints();
		totalLGBC.gridx = 0;
		totalLGBC.gridy = 1;
		totalLGBC.anchor = GridBagConstraints.WEST;
		textAreaPanel.add(totalL,totalLGBC);

		add(textAreaPanel,itemListTextAreaGBC);

		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(650,500));
		buttonPanel.setLayout(new GridBagLayout());
		GridBagConstraints buttonPanelGBC = new GridBagConstraints();
		buttonPanelGBC.gridx = 0;
		buttonPanelGBC.gridy = 0;

		categories = controllerRef.getCategories();

		categoryButtons = new ArrayList<JButton>();

		for(int i = 0; i < categories.size(); i++) {
			categoryButtons.add(new JButton(categories.get(i)));
			categoryButtons.get(i).setPreferredSize(new Dimension(150,75));
			GridBagConstraints categoryButtonGBC = new GridBagConstraints();
			categoryButtonGBC.gridx = i%4;
			categoryButtonGBC.gridy = i/4;
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
		logoutButtonGBC.fill = GridBagConstraints.HORIZONTAL;
		bottomPanel.add(logoutButton,logoutButtonGBC);

		editProfileButton = new JButton("Edit Profile");
		GridBagConstraints editProfileButtonGBC = new GridBagConstraints();
		editProfileButtonGBC.gridx = 1;
		editProfileButtonGBC.gridy = 0;
		editProfileButtonGBC.insets = new Insets(5,0,5,5);
		editProfileButtonGBC.fill = GridBagConstraints.HORIZONTAL;
		bottomPanel.add(editProfileButton,editProfileButtonGBC);

		removeLastItemButton = new JButton("Remove Last Item");
		GridBagConstraints removeLastItemButtonGBC = new GridBagConstraints();
		removeLastItemButtonGBC.gridx = 2;
		removeLastItemButtonGBC.gridy = 0;
		removeLastItemButtonGBC.insets = new Insets(5,0,5,5);
		removeLastItemButtonGBC.fill = GridBagConstraints.HORIZONTAL;
		bottomPanel.add(removeLastItemButton,removeLastItemButtonGBC);

		cancelTransactionButton = new JButton("Cancel Transaction");
		GridBagConstraints cancelTransactionButtonGBC = new GridBagConstraints();
		cancelTransactionButtonGBC.gridx = 3;
		cancelTransactionButtonGBC.gridy = 0;
		cancelTransactionButtonGBC.insets = new Insets(5,0,5,5);
		cancelTransactionButtonGBC.fill = GridBagConstraints.HORIZONTAL;
		bottomPanel.add(cancelTransactionButton,cancelTransactionButtonGBC);

		addFoodItemButton = new JButton("Add/Edit Item to System");
		GridBagConstraints addFoodItemButtonGBC = new GridBagConstraints();
		addFoodItemButtonGBC.gridx = 5;
		addFoodItemButtonGBC.gridy = 0;
		addFoodItemButtonGBC.insets = new Insets(5,0,5,5);
		addFoodItemButtonGBC.fill = GridBagConstraints.HORIZONTAL;
		bottomPanel.add(addFoodItemButton,addFoodItemButtonGBC);

		addMemberButton = new JButton("Add Member");
		GridBagConstraints addMemberButtonGBC = new GridBagConstraints();
		addMemberButtonGBC.gridx = 6;
		addMemberButtonGBC.gridy = 0;
		addMemberButtonGBC.insets = new Insets(5,0,5,5);
		addMemberButtonGBC.fill = GridBagConstraints.HORIZONTAL;
		bottomPanel.add(addMemberButton,addMemberButtonGBC);

		viewAllTransactionsButton = new JButton("View All Transactions");
		GridBagConstraints viewAllTransactionsButtonGBC = new GridBagConstraints();
		viewAllTransactionsButtonGBC.gridx = 4;
		viewAllTransactionsButtonGBC.gridy = 0;
		viewAllTransactionsButtonGBC.insets = new Insets(5,0,5,5);
		viewAllTransactionsButtonGBC.fill = GridBagConstraints.HORIZONTAL;
		bottomPanel.add(viewAllTransactionsButton,viewAllTransactionsButtonGBC);

		finishButton = new JButton("Finish");
		GridBagConstraints finishButtonGBC = new GridBagConstraints();
		finishButtonGBC.gridx = 7;
		finishButtonGBC.gridy = 0;
		finishButtonGBC.insets = new Insets(5,0,5,5);
		finishButtonGBC.fill = GridBagConstraints.HORIZONTAL;
		bottomPanel.add(finishButton,finishButtonGBC);

		deleteAccountButton = new JButton("Delete Account");
		GridBagConstraints deleteAccountButtonGBC = new GridBagConstraints();
		deleteAccountButtonGBC.gridx = 2;
		deleteAccountButtonGBC.gridy = 1;
		deleteAccountButtonGBC.insets = new Insets(0,0,5,5);
		deleteAccountButtonGBC.fill = GridBagConstraints.HORIZONTAL;
		bottomPanel.add(deleteAccountButton,deleteAccountButtonGBC);

		removeItemButton = new JButton("Delete Item");
		GridBagConstraints removeItemButtonGBC = new GridBagConstraints();
		removeItemButtonGBC.gridx = 3;
		removeItemButtonGBC.gridy = 1;
		removeItemButtonGBC.insets = new Insets(0,0,5,5);
		removeItemButtonGBC.fill = GridBagConstraints.HORIZONTAL;
		bottomPanel.add(removeItemButton,removeItemButtonGBC);

		removeMemberButton = new JButton("Delete Member");
		GridBagConstraints removeMemberButtonGBC = new GridBagConstraints();
		removeMemberButtonGBC.gridx = 4;
		removeMemberButtonGBC.gridy = 1;
		removeMemberButtonGBC.insets = new Insets(0,0,5,5);
		removeMemberButtonGBC.fill = GridBagConstraints.HORIZONTAL;
		bottomPanel.add(removeMemberButton,removeMemberButtonGBC);

		viewUnpopularItemsButton = new JButton("View Unpopular Items");
		GridBagConstraints viewUnpopularItemsButtonGBC = new GridBagConstraints();
		viewUnpopularItemsButtonGBC.gridx = 5;
		viewUnpopularItemsButtonGBC.gridy = 1;
		viewUnpopularItemsButtonGBC.insets = new Insets(0,0,5,5);
		viewUnpopularItemsButtonGBC.fill = GridBagConstraints.HORIZONTAL;
		bottomPanel.add(viewUnpopularItemsButton,viewUnpopularItemsButtonGBC);

		mainFrameRef.add(this,panelGBC);
		mainFrameRef.add(bottomPanel,bottomPanelGBC);
		mainFrameRef.pack();
	}

	public void initItems(String category) {

		itemButtonPanel = new JPanel();
		itemButtonPanel.setLayout(new GridBagLayout());
		GridBagConstraints itemButtonPanelGBC = new GridBagConstraints();
		itemButtonPanelGBC.gridx = 0;
		itemButtonPanelGBC.gridy = 0;
		itemButtonPanelGBC.insets = new Insets(15,15,15,15);

		items = controllerRef.getItemsStringByCategory(category);

		itemButtons = new ArrayList<JButton>();

		for(int i = 0; i < items.size(); i++) {
			itemButtons.add(new JButton(items.get(i)));
			itemButtons.get(i).setPreferredSize(new Dimension(150,75));
			GridBagConstraints itemButtonGBC = new GridBagConstraints();
			itemButtonGBC.gridx = i%4;
			itemButtonGBC.gridy = i/4;
			itemButtonPanel.add(itemButtons.get(i),itemButtonGBC);
		}

		backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension(150,75));
		GridBagConstraints backButtonGBC = new GridBagConstraints();
		backButtonGBC.gridx = 0;
		backButtonGBC.gridy = 1;

		buttonPanel.add(itemButtonPanel, itemButtonPanelGBC);
		buttonPanel.add(backButton, backButtonGBC);

		initItemButtonListeners();
	}

	public void initPayment() {

		creditDebitButton = new JButton("Member? Yes");
		creditDebitButton.setPreferredSize(new Dimension(150,75));
		GridBagConstraints creditDebitButtonGBC = new GridBagConstraints();
		creditDebitButtonGBC.gridx = 0;
		creditDebitButtonGBC.gridy = 0;
		buttonPanel.add(creditDebitButton,creditDebitButtonGBC);

		cashButton = new JButton("Member? No");
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
	
	public void initPoints(){
		memberIdTF = new JTextField();
		memberIdTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints idTFGBC = new GridBagConstraints();
		idTFGBC.gridx = 1;
		idTFGBC.gridy = 0;
		idTFGBC.insets = new Insets(5,0,0,0);
		idTFGBC.anchor = GridBagConstraints.WEST;
		buttonPanel.add(memberIdTF,idTFGBC);
		
		memberIdL = new JLabel("Member ID:");
		GridBagConstraints idLGBC = new GridBagConstraints();
		idLGBC.gridx = 0;
		idLGBC.gridy = 0;
		idLGBC.insets = new Insets(5,0,0,5);
		idLGBC.anchor = GridBagConstraints.WEST;
		buttonPanel.add(memberIdL,idLGBC);		
		
		memberIdButton = new JButton("Submit");
		memberIdButton.setPreferredSize(new Dimension(100,50));
		GridBagConstraints creditDebitButtonGBC = new GridBagConstraints();
		creditDebitButtonGBC.gridx = 0;
		creditDebitButtonGBC.gridy = 1;
		buttonPanel.add(memberIdButton,creditDebitButtonGBC);

		initMemberButtonListeners();
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
		removeLastItemButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemListText = itemListTextArea.getText();
				if(!itemListText.equals("")) {
					String removedLastNewLine = itemListText.substring(0,itemListText.lastIndexOf("\n"));
					String removedLastItemText = removedLastNewLine.substring(0,removedLastNewLine.lastIndexOf("\n")+1);
					itemListTextArea.setText(removedLastItemText);
					controllerRef.removeLastItem();
					totalL.setText("Total:     "+controllerRef.getTotal());
				}
			}
		};
		removeLastItemButton.addActionListener(removeLastItemButtonListener);
		cancelTransactionButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemListTextArea.setText("");
				totalL.setText("Total:     0.00");
				controllerRef.cancelTransaction();
			}
		};
		cancelTransactionButton.addActionListener(cancelTransactionButtonListener);
		addFoodItemButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerRef.addFoodItem();
			}
		};
		addFoodItemButton.addActionListener(addFoodItemButtonListener);
		addMemberButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerRef.addMember();
			}
		};
		addMemberButton.addActionListener(addMemberButtonListener);
		viewAllTransactionsButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerRef.viewAllTransactions();
			}
		};
		viewAllTransactionsButton.addActionListener(viewAllTransactionsButtonListener);
		finishButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanupAfterCategory();
				cleanupAfterItem();
				initPayment();
			}
		};
		finishButton.addActionListener(finishButtonListener);
		categoryButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanupAfterCategory();
				if(itemButtons!=null) {
					cleanupAfterItem();
				}
				initItems(((JButton)e.getSource()).getText());
			}
		};
		for(JButton button : categoryButtons) {
			button.addActionListener(categoryButtonListener);
		}
		deleteAccountButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerRef.deleteEmployee();
				controllerRef.launchLoginScreen();
			}
		};
		deleteAccountButton.addActionListener(deleteAccountButtonListener);
		removeMemberButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerRef.removeMemberFromSystem();
			}
		};
		removeMemberButton.addActionListener(removeMemberButtonListener);
		removeItemButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerRef.removeItemFromSystem();
			}
		};
		removeItemButton.addActionListener(removeItemButtonListener);
		viewUnpopularItemsButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerRef.viewUnpopularItems();
			}
		};
		viewUnpopularItemsButton.addActionListener(viewUnpopularItemsButtonListener);
	}

	public void initItemButtonListeners() {

		itemButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemListTextArea.setText(itemListTextArea.getText()+controllerRef.getFoodItemInfo(((JButton)e.getSource()).getText()));
				totalL.setText("Total:     "+controllerRef.getTotal());
			}
		};
		for(JButton button : itemButtons) {
			button.addActionListener(itemButtonListener);
		}
		backButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanupAfterItem();
				backToCategories(false);
			}
		};
		backButton.addActionListener(backButtonListener);
	}

	public void initPaymentButtonListeners() {

		creditDebitButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanupAfterPayment();
				initPoints();
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
				totalL.setText("Total:     0.00");
				backToCategories(true);
			}
		};
		doneButton.addActionListener(doneButtonListener);
	}
	
	public void initMemberButtonListeners(){
		memberIdButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int memberPoints = controllerRef.updateMemberPoints(Integer.parseInt(memberIdTF.getText()));
				if(memberPoints != -1){
					JOptionPane.showMessageDialog(VCheckout.this, "Your New Total Member Points: "+memberPoints,"Grocery Store Management System",JOptionPane.INFORMATION_MESSAGE);
					cleanupAfterMember();
					initDone();
				}
				else{
					JOptionPane.showMessageDialog(VCheckout.this, "Invalid Member Id.","Grocery Store Management System",JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		memberIdButton.addActionListener(memberIdButtonListener);
	
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
				categoryButtonGBC.gridx = i%4;
				categoryButtonGBC.gridy = i/4;
				buttonPanel.add(categoryButtons.get(i),categoryButtonGBC);
			}

			buttonPanel.repaint();

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
		for(JButton button : categoryButtons) {
			button.setVisible(true);
		}
	}

	public void showOutOfStockError() {
		JOptionPane.showMessageDialog(VCheckout.this, "This item is out of stock","Grocery Store Management System",JOptionPane.WARNING_MESSAGE);
	}

	public void cleanupAfterCategory() {
		if(categoryButtons!=null) {
			for(JButton button : categoryButtons) {
				button.setVisible(false);;
			}
		}
	}

	public void cleanupAfterItem() {
		if(itemButtons!=null) {
			for(JButton button : itemButtons) {
				button.setVisible(false);
			}
			itemButtonPanel.setVisible(false);
			backButton.setVisible(false);
		}
	}

	public void cleanupAfterPayment() {
		if(creditDebitButton!=null) {
			creditDebitButton.setVisible(false);
			cashButton.setVisible(false);
		}
	}

	public void cleanupAfterDone() {
		if(doneButton!=null) {
			doneButton.setVisible(false);
		}
	}
	
	public void cleanupAfterMember() {
		if(memberIdButton!=null) {
			memberIdButton.setVisible(false);
			memberIdL.setVisible(false);
			memberIdTF.setVisible(false);
		}
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
			itemButtonPanel.setVisible(false);
			backButton.setVisible(false);
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
		removeLastItemButton.removeActionListener(removeLastItemButtonListener);
		cancelTransactionButton.removeActionListener(cancelTransactionButtonListener);
		addFoodItemButton.removeActionListener(addFoodItemButtonListener);
		addMemberButton.removeActionListener(addMemberButtonListener);
		viewAllTransactionsButton.removeActionListener(viewAllTransactionsButtonListener);
		finishButton.removeActionListener(finishButtonListener);
		deleteAccountButton.removeActionListener(deleteAccountButtonListener);
		removeItemButton.removeActionListener(removeItemButtonListener);
		removeMemberButton.removeActionListener(removeMemberButtonListener);
		viewUnpopularItemsButton.removeActionListener(viewUnpopularItemsButtonListener);

		itemListTextArea.setVisible(false);
		logoutButton.setVisible(false);
		editProfileButton.setVisible(false);
		removeLastItemButton.setVisible(false);
		cancelTransactionButton.setVisible(false);
		addFoodItemButton.setVisible(false);
		addMemberButton.setVisible(false);
		viewAllTransactionsButton.setVisible(false);
		finishButton.setVisible(false);
		deleteAccountButton.setVisible(false);
		removeItemButton.setVisible(false);
		removeMemberButton.setVisible(false);
		viewUnpopularItemsButton.setVisible(false);

		bottomPanel.setVisible(false);
		textAreaPanel.setVisible(false);
		buttonPanel.setVisible(false);

		this.setVisible(false);

		mainFrameRef.remove(this);
		mainFrameRef.remove(bottomPanel);
	}
}
