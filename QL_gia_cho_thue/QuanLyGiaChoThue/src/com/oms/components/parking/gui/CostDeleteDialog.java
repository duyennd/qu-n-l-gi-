package com.oms.components.parking.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.oms.bean.Cost;
import com.oms.components.abstractdata.controller.IDataManageController;
import com.oms.components.abstractdata.gui.ADataDeleteDialog;

@SuppressWarnings("serial")
public class CostDeleteDialog extends ADataDeleteDialog<Cost>{
	
	private JTextField nameField;
	private JTextField addressField;
	private JTextField tienCocField;
	private JTextField gia30pDauField;
	private JTextField giaTangField;
	
	

	public CostDeleteDialog(Cost cost, IDataManageController<Cost> controller) {
		super(cost, controller);
	}

	@Override
	public void buildControls() {
		int row = getLastRowIndex();
		JLabel nameLabel = new JLabel("Loại xe");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(nameLabel, c);
		nameField = new JTextField(15);
		nameField.setText(t.getName());
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(nameField, c);
		
		
		row = getLastRowIndex();
		JLabel tienCocLabel = new JLabel("Tiền cọc");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(tienCocLabel, c);
		tienCocField = new JTextField(15);

		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(tienCocField, c);
		
		row = getLastRowIndex();
		JLabel gia30pDauLabel = new JLabel("Gía 30 p đầu");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(gia30pDauLabel, c);
		gia30pDauField = new JTextField(15);

		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(gia30pDauField, c);
		
		row = getLastRowIndex();
		JLabel giaTangLabel = new JLabel("Gía tăng");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(giaTangLabel, c);
		tienCocField = new JTextField(15);

		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(giaTangField, c);

		
	}

	@Override
	public Cost getNewData() {
		t.setName(nameField.getText());
		t.setTienCoc(Float.parseFloat(tienCocField.getText()));
		t.setGia30pDau(Float.parseFloat(gia30pDauField.getText()));
		t.setGiaTang(Float.parseFloat(giaTangField.getText()));
		return t;
	}
}

