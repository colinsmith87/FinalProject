package com.smithsiciliano.checkout;

import javax.swing.JPanel;

import com.smithsiciliano.App;

public class VCheckout extends JPanel {
	
	private App mainFrameRef = null;
	private CCheckout controllerRef = null;
	
	public VCheckout(CCheckout controllerRef, App mainFrameRef) {
		this.controllerRef = controllerRef;
		this.mainFrameRef = mainFrameRef;
	}
	
	public void initUI() {
		
	}
	
	public void initListeners() {
		
	}
}
