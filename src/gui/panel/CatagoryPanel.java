package gui.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import dao.CategoryDAO;
import entity.catagory;
import gui.listener.CategoryListener;
import gui.model.CategoryTableModel;
import service.CategoryService;
import util.GUIUtil;

public class CatagoryPanel extends WorkingPanel{
	static{
		GUIUtil.useLNF();
	}
	public static CatagoryPanel instance = new CatagoryPanel();
	CategoryTableModel ctm = new CategoryTableModel();
	public JTable jt = new JTable(ctm);
	
	
	public JButton add = new JButton("ÐÂÔö");
	public JButton edit = new JButton("±à¼­");
	public JButton delete = new JButton("É¾³ý");
	CategoryListener l = new CategoryListener();
	
	private CatagoryPanel(){
		 jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(new BorderLayout());
		
		 JPanel center = new JPanel();
		
		JScrollPane north = new JScrollPane(jt);
		center.setLayout(new FlowLayout());
		center.add(add);
		center.add(edit);
		center.add(delete);
		
		add(north,BorderLayout.CENTER);
		add(center,BorderLayout.SOUTH);
		addListener();
	}
	
	public void addListener() {
		// TODO Auto-generated method stub
		
		add.addActionListener(l);
		edit.addActionListener(l);
		delete.addActionListener(l);
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(CatagoryPanel.instance);
	}
	public catagory getSelectedCategory(){
		int row = jt.getSelectedRow();
		return ctm.cs.get(row);
		
	}
	public void updateData(){
		ctm.cs = new CategoryService().list();
		jt.updateUI();
		jt.getSelectionModel().setSelectionInterval(0, 0);
		
		if(ctm.cs.size()==0){
			edit.setEnabled(false);
			delete.setEnabled(false);
		}
		else{
			edit.setEnabled(true);
			delete.setEnabled(true);
		}
		
	}

	
}
