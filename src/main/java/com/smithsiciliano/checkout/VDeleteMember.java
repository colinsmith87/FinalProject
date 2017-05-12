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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.smithsiciliano.dao.MembersDAO;
import com.smithsiciliano.models.Members;

public class VDeleteMember extends JPanel {

	private CDeleteMember controllerRef = null;
	private JFrame mainFrameRef = null;
	
	private JButton deleteButton = null;
	private JComboBox itemsCB = null;
	
	private String[] itemsList = null;
	
	private ActionListener deleteButtonListener = null;
	private JTextField idTF;
	private JLabel idL;
	
	public VDeleteMember(CDeleteMember controllerRef, JFrame mainFrameRef) {
		this.controllerRef = controllerRef;
		this.mainFrameRef = mainFrameRef;
	}
	
	public void initUI() {
		setPreferredSize(new Dimension(630,200));
		setLayout(new GridBagLayout());
		Border border = BorderFactory.createEtchedBorder();
		setBorder(BorderFactory.createTitledBorder(border,"Delete Member"));
		GridBagConstraints panelGBC = new GridBagConstraints();
		panelGBC.gridx = 0;
		panelGBC.gridy = 0;
		panelGBC.anchor = GridBagConstraints.CENTER;
		
		idTF = new JTextField();
		idTF.setPreferredSize(new Dimension(100,20));
		GridBagConstraints idTFGBC = new GridBagConstraints();
		idTFGBC.gridx = 1;
		idTFGBC.gridy = 0;
		idTFGBC.insets = new Insets(5,0,0,0);
		idTFGBC.anchor = GridBagConstraints.WEST;
		add(idTF,idTFGBC);
		
		idL = new JLabel("Member ID:");
		GridBagConstraints idLGBC = new GridBagConstraints();
		idLGBC.gridx = 0;
		idLGBC.gridy = 0;
		idLGBC.insets = new Insets(5,0,0,5);
		idLGBC.anchor = GridBagConstraints.WEST;
		add(idL,idLGBC);		
		
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
				MembersDAO membersDAO = new MembersDAO();
				List<Members> list = membersDAO.selectByMemberId(Integer.parseInt(idTF.getText()));
				controllerRef.deleteMember(list.get(0));
			}
		};
		deleteButton.addActionListener(deleteButtonListener);
	}
}

