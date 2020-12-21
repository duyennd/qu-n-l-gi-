package com.oms.components.parking.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.oms.bean.Cost;
import com.oms.components.abstractdata.controller.ADataPageController;
import com.oms.components.abstractdata.controller.IDataManageController;
import com.oms.components.abstractdata.gui.ADataListPane;
import com.oms.components.abstractdata.gui.ADataSinglePane;
import com.oms.components.parking.controller.AdminCostPageController;



@SuppressWarnings("serial")

public class AdminCostListPane extends ADataListPane<Cost>{
	
	public AdminCostListPane(ADataPageController<Cost> controller) {
		this.controller = controller;
	}
	
	@Override
	public void decorateSinglePane(ADataSinglePane<Cost> singlePane) {
		JButton editbutton = new JButton("Edit");
		singlePane.addDataHandlingComponent(editbutton);
		JButton deleteButton = new JButton("delete");
		singlePane.addDataHandlingComponent(deleteButton);
		
		IDataManageController<Cost> manageController = new IDataManageController<Cost>() {
			@Override
			public void update(Cost t) {
				if (controller instanceof AdminCostPageController) {
					Cost newCost = ((AdminCostPageController) controller).updateCost(t);
					singlePane.updateData(newCost);
				}
			}

			@Override
			public void create(Cost t) {
			}

			@Override
			public void read(Cost t) {
			}

			@Override
			public void delete(Cost t) {
				if (controller instanceof AdminCostPageController) {
					((AdminCostPageController) controller).deleteCost(t);
					singlePane.setVisible(false);
				}
				
			}
		};
		
		editbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CostEditDialog(singlePane.getData(), manageController);
			}
		});
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manageController.delete(singlePane.getData());
			}
		});	
	}
}

