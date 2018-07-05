package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import gui.panel.*;
public class ToolBarListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainPanel p = MainPanel.instance;
		JButton B=(JButton) e.getSource();
		if (B == p.bReport)
            p.workPanel.show(ReportPanel.instance);
        if (B == p.bCategory)
            p.workPanel.show(CatagoryPanel.instance);
        if (B == p.bSpend)
            p.workPanel.show(SpendPanel.instance);
        if (B == p.bRecord)
            p.workPanel.show(RecordPanel.instance);
        if (B == p.bConfig)
            p.workPanel.show(ConfigPanel.instance);
        if (B == p.bBackup)
            p.workPanel.show(BackupPanel.instance);
        if (B == p.bRecover)
            p.workPanel.show(RecoverPanel.instance);
		}
			
	

}
