package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.listener.ConfigListener;
import service.ConfigService;
import util.GUIUtil;

public class ConfigPanel extends WorkingPanel {
	static {
		GUIUtil.useLNF();
	}
	public static ConfigPanel instance = new ConfigPanel();
	JLabel lBudget = new JLabel("本月预算(￥)");
    public JTextField tfBudget = new JTextField("0");
     
    JLabel lMysql = new JLabel("Mysql安装目录");
    public JTextField tfMysqlPath = new JTextField("");
 
    JButton bSubmit = new JButton("更新");
	
	
	private ConfigPanel(){
		GUIUtil.setColor(Color.gray, lBudget,lMysql);
		setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		int gap = 40 ;
		north.setLayout(new GridLayout(4,1,gap,gap));
		north.add(lBudget);
		north.add(tfBudget);
		north.add(lMysql);
		north.add(tfMysqlPath);
		
		JPanel center = new JPanel();
		center.add(bSubmit);
		
		add(north,BorderLayout.NORTH);
		add(center,BorderLayout.CENTER);
		
		addListener();
	}
	public  void addListener() {
		// TODO Auto-generated method stub
		ConfigListener cl = new ConfigListener();
		bSubmit.addActionListener(cl);
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(ConfigPanel.instance);
	}
	
	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		String budget = new ConfigService().get(ConfigService.budget);
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		tfBudget.setText(budget);
		tfMysqlPath.setText(mysqlPath);
		
	}
	

}
