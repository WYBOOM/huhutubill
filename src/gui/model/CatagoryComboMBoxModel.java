package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.catagory;
import entity.record;
import javafx.scene.control.ComboBox;
import service.CategoryService;


public class CatagoryComboMBoxModel implements ComboBoxModel<catagory> {
	public List<catagory> cs = new CategoryService().list();
	catagory  c;
	public CatagoryComboMBoxModel(){
		if(!cs.isEmpty())
			c = cs.get(0);
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return cs.size();
	}
	@Override
	public catagory getElementAt(int index) {
		// TODO Auto-generated method stub
		return cs.get(index);
	}
	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		c = (catagory) anItem;
	}
	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return c;
	}
	
	
	
	
}
