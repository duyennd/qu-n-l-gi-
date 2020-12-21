package com.oms.components.abstractdata.gui;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class ADataPagePane<T> extends JPanel{
	public ADataPagePane(ADataAddPane<T> addPane, ADataSearchPane searchPane, ADataListPane<T> listPane) {
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.add(addPane);
		this.add(searchPane);
		this.add(listPane);
		
		layout.putConstraint(SpringLayout.NORTH, addPane, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, addPane, -500, SpringLayout.EAST, this);

		
		layout.putConstraint(SpringLayout.WEST, searchPane, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, searchPane, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, searchPane, -5, SpringLayout.EAST, this);
		
		
		layout.putConstraint(SpringLayout.WEST, listPane, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, listPane, 5, SpringLayout.SOUTH, searchPane);
		layout.putConstraint(SpringLayout.EAST, listPane, -5, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, listPane, -5, SpringLayout.SOUTH, this);
	}
}
