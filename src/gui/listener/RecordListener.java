package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.catagory;
import gui.panel.CatagoryPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.SpendPanel;
import service.RecordService;
import util.GUIUtil;

public class RecordListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		RecordService rs= new RecordService();
		RecordPanel rp= RecordPanel.instance;
		if(rp.ccm.getSize()==0)
		{
			JOptionPane.showMessageDialog(rp, "暂时没有分类,请先添加分类!");
			MainPanel.instance.workPanel.show(CatagoryPanel.instance);
			return;
		}
		if(!GUIUtil.checkZero(rp.tSpend, "花费不能为0!"))
			return;
		int spend = Integer.parseInt(rp.tSpend.getText());
		catagory c = (catagory) rp.BCategory.getSelectedItem();
		String comment = rp.TComment.getText();
		Date date =rp.JXDate.getDate();
		rs.add(spend, c, comment, date);
		MainPanel.instance.workPanel.show(SpendPanel.instance);
	}

}
