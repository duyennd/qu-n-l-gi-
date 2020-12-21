
package com.oms.components.parking.gui;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.oms.components.abstractdata.gui.ADataSearchPane;



@SuppressWarnings("serial")
public class CostSearchPane extends ADataSearchPane {	
	private JTextField nameField;
//	private JTextField tienCocField;
//	private JTextField gia30pDauField;
//	private JTextField giaTangField;
	

	public CostSearchPane() {
		super();
	}
	
	@Override
	public void buildControls() {
		JLabel nameLabel = new JLabel("Loại xe");
		nameField = new JTextField(15);
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(nameLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(nameField, c);
		
//		JLabel tienCocLabel = new JLabel("Tiền cọc");
//		tienCocField = new JTextField(15);
//		row = getLastRowIndex();
//		c.gridx = 0;
//		c.gridy = row;
//		add(tienCocLabel, c);
//		c.gridx = 1;
//		c.gridy = row;
//		add(tienCocField, c);
//		
//		JLabel gia30pDauLabel = new JLabel("Gía 30 p đầu");
//		gia30pDauField = new JTextField(15);
//		row = getLastRowIndex();
//		c.gridx = 0;
//		c.gridy = row;
//		add(gia30pDauLabel, c);
//		c.gridx = 1;
//		c.gridy = row;
//		add(gia30pDauField, c);
//		
//		JLabel giaTangLabel = new JLabel("Gía tăng");
//		giaTangField = new JTextField(15);
//		row = getLastRowIndex();
//		c.gridx = 0;
//		c.gridy = row;
//		add(giaTangLabel, c);
//		c.gridx = 1;
//		c.gridy = row;
//		add(giaTangField, c);

	}

	@Override
	public Map<String, String> getQueryParams() {
		Map<String, String> res = super.getQueryParams();
		
		if (!nameField.getText().trim().equals("")) {
		res.put("loại xe", nameField.getText().trim());
	    }
//		if (!tienCocField.getText().trim().equals("")) {
//			res.put("tiền cọc", tienCocField.getText().trim());
//		}
//		if (!gia30pDauField.getText().trim().equals("")) {
//			res.put("giá 30 p đầu", gia30pDauField.getText().trim());
//		}
//		if (!giaTangField.getText().trim().equals("")) {
//			res.put("giá tăng", giaTangField.getText().trim());
//		}
		return res;
	}
}
