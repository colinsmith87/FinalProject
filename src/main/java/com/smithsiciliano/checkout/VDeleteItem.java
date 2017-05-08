package com.smithsiciliano.checkout;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class VDeleteItem extends JPanel {

	private CDeleteItem controllerRef = null;
	private JFrame mainFrameRef = null;
	
	private JButton deleteButton = null;
	private JComboBox itemsCB = null;
	
	private String[] itemsList = null;
	
	private ActionListener deleteButtonListener = null;
	
	public VDeleteItem(CDeleteItem controllerRef, JFrame mainFrameRef) {
		this.controllerRef = controllerRef;
		this.mainFrameRef = mainFrameRef;
	}
	
	public void initUI() {
		setPreferredSize(new Dimension(630,200));
		setLayout(new GridBagLayout());
		Border border = BorderFactory.createEtchedBorder();
		setBorder(BorderFactory.createTitledBorder(border,"Delete Item"));
		GridBagConstraints panelGBC = new GridBagConstraints();
		panelGBC.gridx = 0;
		panelGBC.gridy = 0;
		panelGBC.anchor = GridBagConstraints.CENTER;
		
		itemsList = controllerRef.getItems();
		
		itemsCB = new JComboBox<String>();
		itemsCB.setModel(new DefaultComboBoxModel<String>(itemsList));
		GridBagConstraints itemsCBGBC = new GridBagConstraints();
		itemsCBGBC.gridx = 0;
		itemsCBGBC.gridy = 0;
		itemsCBGBC.insets = new Insets(15,15,15,15);
		add(itemsCB,itemsCBGBC);
		
		deleteButton = new JButton("Delete");
		GridBagConstraints deleteButtonGBC = new GridBagConstraints();
		deleteButtonGBC.gridx = 0;
		deleteButtonGBC.gridy = 1;
		add(deleteButton,deleteButtonGBC);
		
		mainFrameRef.add(this,panelGBC);
		mainFrameRef.pack();
	}
	
	public void initListeners() {
		deleteButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerRef.deleteItem((String)itemsCB.getSelectedItem());
				itemsCB.remove(itemsCB.getSelectedIndex());
			}
		};
		deleteButton.addActionListener(deleteButtonListener);
	}
}
