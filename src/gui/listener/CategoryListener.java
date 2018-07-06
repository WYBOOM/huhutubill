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
			String a =JOptionPane.showInputDialog(p,"���������");
			if(a.isEmpty()){
				JOptionPane.showMessageDialog(p, "�������ݲ���Ϊ��!");
				return;
			}
			s.add(a);
		}
		if(b==p.edit){
			String a= JOptionPane.showInputDialog(p,"���޸�ѡ��");
			if(a.isEmpty()){
				JOptionPane.showMessageDialog(p, "�������ݲ���Ϊ��!");
				return;
			}
			catagory c =p.getSelectedCategory();
			int id = c.id;
			s.update(id, a);
			
			
		}
		if(b ==p.delete){
			if(s.list().isEmpty()){
				JOptionPane.showMessageDialog(p, "�޿�ɾ����!");
				return;
			}
			catagory c =p.getSelectedCategory();
			if(c.recordNumber != 0){
				JOptionPane.showMessageDialog(p, "�ü�¼�������Ѽ�¼,����ɾ��!");
				return;
			}
			if(JOptionPane.OK_OPTION!=JOptionPane.showConfirmDialog(p, "ȷ��ɾ��?") ){
				return;
			}
			new CategoryService().delete(c.id);
			
			
		}
		p.updateData();
	}

}
