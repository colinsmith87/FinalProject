package com.smithsiciliano.checkout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VAddItem extends JPanel {
	
	private JFrame mainFrameRef = null;
	private CAddItem controllerRef = null;
	
	public VAddItem(CAddItem controllerRef, JFrame mainFrameRef) {
		this.controllerRef = controllerRef;
		this.mainFrameRef = mainFrameRef;
	}
	
	public void initUI() {
		
	}
	
	public void initListeners() {
		
	}
}
