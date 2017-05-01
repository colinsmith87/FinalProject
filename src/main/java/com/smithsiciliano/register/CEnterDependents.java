package com.smithsiciliano.register;

import com.smithsiciliano.App;
import com.smithsiciliano.dao.DependentDAO;

public class CEnterDependents {
	
	private VEnterDependents viewRef = null;
	private App mainFrameRef = null;
	private DependentDAO dependentDAO = null;
	
	public CEnterDependents(App mainFrameRef) {
		this.mainFrameRef = mainFrameRef;
		init();
	}
	
	private void init() {
		dependentDAO = new DependentDAO();
		viewRef = new VEnterDependents(this,mainFrameRef);
		viewRef.initUI();
		viewRef.initListeners();
	}
}