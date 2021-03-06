package com.oms.components.abstractdata.controller;

import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import com.oms.components.abstractdata.gui.ADataAddPane;
import com.oms.components.abstractdata.gui.ADataListPane;
import com.oms.components.abstractdata.gui.ADataPagePane;
import com.oms.components.abstractdata.gui.ADataSearchPane;
import com.oms.components.abstractdata.gui.ADataSinglePane;

public abstract class ADataPageController<T> {
	private ADataPagePane<T> pagePane;
	
	public ADataPageController() {
		ADataSearchPane searchPane = createSearchPane();
		
		ADataListPane<T> listPane = createListPane();
		ADataAddPane<T> addPane = createAddPane();
		addPane.setListPane(listPane);
		searchPane.setController(new IDataSearchController() {
			@Override
			public void search(Map<String, String> searchParams) {
				List<? extends T> list = ADataPageController.this.search(searchParams);
				addPane.setList((List<T>) list);
				listPane.updateData(list);
			}
		});
		
		searchPane.fireSearchEvent();
		
		pagePane = new ADataPagePane<T>(addPane, searchPane, listPane);
	}
	
	public JPanel getDataPagePane() {
		return pagePane;
	}
	
	
	public abstract ADataSearchPane createSearchPane();

	public abstract List<? extends T> search(Map<String, String> searchParams);
	
	
	
	public abstract ADataSinglePane<T> createSinglePane();
	
	public abstract ADataListPane<T> createListPane();
	public abstract ADataAddPane<T> createAddPane();
}
