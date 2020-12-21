package com.oms.components.abstractdata.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import com.oms.components.abstractdata.controller.ADataPageController;

@SuppressWarnings("serial")
public abstract class ADataAddPane<T> extends JPanel {
	protected GridBagLayout layout;
	protected GridBagConstraints c;
	
	protected ADataPageController<T> controller;
	private List<T> list;
	private ADataListPane<T> listPane;

	public ADataAddPane() {
		layout = new GridBagLayout();
		this.setLayout(layout);

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		this.buildControls();
	}
	
	public abstract void buildControls();
	
	public ADataAddPane(ADataPageController<T> controller) {
		this();
		this.controller = controller;
	}
	
	public Map<String, String> getQueryParams() {
		Map<String, String> res = new HashMap<String, String>();
		return res;
	}
	
	protected int getLastRowIndex() {
		layout.layoutContainer(this);
		int[][] dim = layout.getLayoutDimensions();
	    int rows = dim[1].length;
	    return rows;
	}
	
	
	public void setController(ADataPageController<T> controller) {
		this.controller = controller;
	}
	
	public ADataPageController<T> getController() {
		return this.controller;
	}
	
	public void fireSearchEvent() {
		controller.search(getQueryParams());
	}


	public void setList(List<T> list) {
		// TODO Auto-generated method stub
		this.list = list; 
	}

	public void setListPane(ADataListPane<T> listPane) {
		// TODO Auto-generated method stub
		this.listPane = listPane;
	}
	
	public void appendListPane(T t) {
		list.add(0, t);
		listPane.updateData(list);
	}
}
