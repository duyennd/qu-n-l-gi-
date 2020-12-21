package com.oms.components.parking.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import com.oms.bean.Cost;
import com.oms.components.abstractdata.controller.ADataPageController;
import com.oms.components.abstractdata.controller.IDataManageController;
import com.oms.components.abstractdata.gui.ADataAddPane;
import com.oms.components.parking.controller.AdminCostPageController;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

@SuppressWarnings("serial")
public class CostAddPane extends ADataAddPane<Cost> {
	
	public CostAddPane(ADataPageController<Cost> controller) {
		this.setController(controller);
	}

	@Override
	public void buildControls() {
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		JButton addButton = new JButton("Add");
		add(addButton, c);
		
		IDataManageController<Cost> manageController = new IDataManageController<Cost>() {
			@Override
			public void update(Cost t) {
			}

			@Override
			public void create(Cost t) {
				if (controller instanceof AdminCostPageController) {
					((AdminCostPageController) controller).addCost(t);
					appendListPane(t);
				}
			}

			@Override
			public void read(Cost t) {
			}

			@Override
			public void delete(Cost t) {
				
			}
		};
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CostAddDialog(manageController);
			}
		});	
	}
	
}

