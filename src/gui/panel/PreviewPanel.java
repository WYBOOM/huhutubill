package gui.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.model.PreviewTableModel;
import service.CategoryService;
import service.PreviewService;
import util.ColorUtil;
import util.GUIUtil;

public class PreviewPanel extends WorkingPanel {
	static {
		GUIUtil.useLNF();
	}
	public static PreviewPanel instance = new PreviewPanel();

    String columnNames[] = new String[] { "花费", "分类", "备注", "日期" };
     
    public PreviewTableModel ptm = new PreviewTableModel();
    public JTable t =new JTable(ptm);
     
    public PreviewPanel() {
        JScrollPane sp =new JScrollPane(t);
        JPanel pSubmit = new JPanel();
         
        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
		GUIUtil.showPanel(PreviewPanel.instance);
	}
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateData(){
		ptm.rs = new PreviewService().getRecord();
		t.updateUI();
		t.getSelectionModel().setSelectionInterval(0, 0);
		
		
}}
