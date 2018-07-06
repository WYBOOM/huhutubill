package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entity.catagory;
import entity.record;
import service.CategoryService;
import service.PreviewService;
import util.DateUtil;

public class PreviewTableModel implements TableModel {
	 String[] columnNames = {"消费金额","消费类别","备注","日期"};
	    public List<record> rs = new PreviewService().getRecord();
	     
	    @Override
	    public int getRowCount() {
	        return rs.size();
	    }
	 
	    @Override
	    public int getColumnCount() {
	        return columnNames.length;
	    }
	     
	    @Override
	    public String getColumnName(int columnIndex) {
	        return columnNames[columnIndex];
	    }
	 
	    @Override
	    public Class<?> getColumnClass(int columnIndex) {
	        return record.class;
	    }
	 
	    @Override
	    public boolean isCellEditable(int rowIndex, int columnIndex) {
	        return false;
	    }
	 
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        record r = rs.get(rowIndex);
	        catagory c = new CategoryService().getCategoryById(r.getCid());
	        if(0==columnIndex)
	            return r.getSpend();
	        if(1==columnIndex)
	            return c.getName();
	        if(2==columnIndex)
	            return r.getComment();
	        if(3==columnIndex)
	            return DateUtil.date2string(r.getDate());
	        return null;
	    }

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}
}
