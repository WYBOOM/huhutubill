package gui.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import dao.CategoryDAO;
import dao.RecordDAO;
import gui.listener.RecordListener;
import gui.model.CatagoryComboMBoxModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class RecordPanel extends WorkingPanel{
	static{
		GUIUtil.useLNF();
	}
	public static RecordPanel instance = new RecordPanel();
	JLabel lSpend = new JLabel("花费(￥)");
    JLabel lCategory = new JLabel("分类");
    JLabel lComment = new JLabel("备注");
    JLabel lDate = new JLabel("日期");
    
    public CatagoryComboMBoxModel ccm  = new CatagoryComboMBoxModel();
    
    public JTextField tSpend = new JTextField("0");
    public JComboBox BCategory = new JComboBox(ccm);
    public JTextField TComment = new JTextField();
    public JXDatePicker JXDate = new JXDatePicker();
    
    JButton jb = new JButton("记一笔");
    
    private RecordPanel(){
    	GUIUtil.setColor(ColorUtil.grayColor, lSpend,lCategory,lComment,lDate);
        GUIUtil.setColor(ColorUtil.blueColor, jb);
        
        setLayout(new BorderLayout());
        add(north(),BorderLayout.NORTH);
        add(center(),BorderLayout.CENTER);
        addListener();
    }

	private Component center() {
		// TODO Auto-generated method stub
		JPanel center = new JPanel();
		center.add(jb);
		return center;
	}

	private Component north() {
		// TODO Auto-generated method stub
		JPanel north = new JPanel();
		int gap = 40;
		north.setLayout(new GridLayout(4, 2,gap,gap));
		north.add(lSpend);
		north.add(tSpend);
		north.add(lCategory);
		north.add(BCategory);
		north.add(lComment);
		north.add(TComment);
		north.add(lDate);
		north.add(JXDate);
		
		
		return north;
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(RecordPanel.instance);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		RecordListener l = new RecordListener();
		jb.addActionListener(l);
		
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub

		ccm.cs = new CategoryService().list();
		lCategory.updateUI();
		tSpend.setText("0");
        TComment.setText("");
        if(0!=ccm.cs.size())
            BCategory.setSelectedIndex(0);
        JXDate.setDate(new Date());
        lSpend.grabFocus();
		
	}
}
