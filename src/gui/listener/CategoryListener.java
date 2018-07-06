package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.catagory;
import gui.panel.CatagoryPanel;
import service.CategoryService;

public class CategoryListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		CatagoryPanel p = CatagoryPanel.instance;
		CategoryService s = new CategoryService();
		// TODO Auto-generated method stub
		JButton b= (JButton) e.getSource();
		if(b ==p.add){
			String a =JOptionPane.showInputDialog(p,"请输入分类");
			if(a.isEmpty()){
				JOptionPane.showMessageDialog(p, "输入数据不能为空!");
				return;
			}
			s.add(a);
		}
		if(b==p.edit){
			String a= JOptionPane.showInputDialog(p,"请修改选项");
			if(a.isEmpty()){
				JOptionPane.showMessageDialog(p, "输入数据不能为空!");
				return;
			}
			catagory c =p.getSelectedCategory();
			int id = c.id;
			s.update(id, a);
			
			
		}
		if(b ==p.delete){
			if(s.list().isEmpty()){
				JOptionPane.showMessageDialog(p, "无可删除项!");
				return;
			}
			catagory c =p.getSelectedCategory();
			if(c.recordNumber != 0){
				JOptionPane.showMessageDialog(p, "该记录下有消费记录,不能删除!");
				return;
			}
			if(JOptionPane.OK_OPTION!=JOptionPane.showConfirmDialog(p, "确认删除?") ){
				return;
			}
			new CategoryService().delete(c.id);
			
			
		}
		p.updateData();
	}

}
