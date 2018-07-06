package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

public class MainPanel extends JPanel{
	static{
		GUIUtil.useLNF();
	}
	public static MainPanel instance = new MainPanel();
	public JToolBar tb =new JToolBar();
	    public JButton bSpend = new JButton();
	    public JButton bPreview = new JButton();
	    public JButton bRecord = new JButton();
	    public JButton bCategory = new JButton();
	    public JButton bReport = new JButton();
	    public JButton bConfig = new JButton();
	    public JButton bBackup = new JButton();
	    public JButton bRecover = new JButton();
	    
	    public CenterPanel workPanel;
	    
	    private MainPanel(){
	    	GUIUtil.setImageIcon(bSpend, "home.png", "����һ��");
	    	GUIUtil.setImageIcon(bPreview, "u=1264176655,225578136&fm=27&gp=0.jpg", "������ϸ");
	        GUIUtil.setImageIcon(bRecord, "record.png", "��һ��");
	        GUIUtil.setImageIcon(bCategory, "category2.png", "���ѷ���");
	        GUIUtil.setImageIcon(bReport, "report.png", "�����ѱ���");
	        GUIUtil.setImageIcon(bConfig, "config.png", "����");
	        GUIUtil.setImageIcon(bBackup, "backup.png", "����");
	        GUIUtil.setImageIcon(bRecover, "restore.png", "�ָ�");
	        
	        tb.add(bSpend);
	        tb.add(bSpend);
	        tb.add(bPreview);
	        tb.add(bRecord);
	        tb.add(bCategory);
	        tb.add(bReport);
	        tb.add(bConfig);
	        tb.add(bBackup);
	        tb.add(bRecover);
	        tb.setFloatable(false);
	        
	        workPanel  = new CenterPanel(0.8,true);
	        setLayout(new BorderLayout());
	        add(tb,BorderLayout.NORTH);
	        add(workPanel,BorderLayout.CENTER);
	    	
	        ToolBarListener tbl = new ToolBarListener();
	        bSpend.addActionListener(tbl);
	        bPreview.addActionListener(tbl);
	        bRecord.addActionListener(tbl);
	        bCategory.addActionListener(tbl);
	        bReport.addActionListener(tbl);
	        bConfig.addActionListener(tbl);
	        bBackup.addActionListener(tbl);
	        bRecover.addActionListener(tbl);
	        
	    	
	    }
	 
		public static void main(String[] args) {
			GUIUtil.showPanel(MainPanel.instance,1);
		}
	

}
