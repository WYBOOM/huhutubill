package gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.catagory;
import service.CategoryService;

public class CategoryTableModel extends AbstractTableModel{
	public List<catagory> cs= new CategoryService().list();
	String columnNames[] = {"分类名称","消费次数"};
	
	public Object getValueAt(int rowIndex, int columnIndex){
		if(columnIndex ==0)
			return cs.get(rowIndex);
		if(columnIndex ==1)
			return cs.get(rowIndex).recordNumber;
		return null;
	}


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return cs.size();
	}


	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	public String getColumnName(int columnIndex) {
        
        return columnNames[columnIndex];
    }
	
}
