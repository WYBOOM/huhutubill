package gui.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.page.SpendPage;
import javafx.scene.layout.Border;
import service.SpendService;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class SpendPanel extends WorkingPanel {
	static{
		GUIUtil.useLNF();
	}
	
	public static SpendPanel instance = new SpendPanel();
	
	public JLabel lMonthSpend = new JLabel("本月消费");
    public JLabel lTodaySpend = new JLabel("今日消费");
    public JLabel lAvgSpendPerDay = new  JLabel("日均消费");
    public JLabel lMonthLeft = new  JLabel("本月剩余");
    public JLabel lDayAvgAvailable = new  JLabel("日均可用");
    public JLabel lMonthLeftDay = new  JLabel("距离月末");
 
    public JLabel vMonthSpend = new  JLabel("");
    public JLabel vTodaySpend = new  JLabel("");
    public JLabel vAvgSpendPerDay = new JLabel("");
    public JLabel vMonthAvailable = new  JLabel("");
    public JLabel vDayAvgAvailable = new  JLabel("");
    public JLabel vMonthLeftDay = new JLabel("");
    
    CircleProgressBar bar;
    
    
    private SpendPanel(){
		setLayout(new BorderLayout());
		
		bar=new CircleProgressBar();
		bar.setBackgroundColor(ColorUtil.blueColor);
		GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
                lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
        GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);
        
        
        vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        
        add(south(),BorderLayout.SOUTH);
		add(center(),BorderLayout.CENTER);
	}
    private JPanel south(){
    	JPanel south = new JPanel();	
    	south.setLayout(new GridLayout(2, 4));
    	south.add(lAvgSpendPerDay);
    	south.add(lMonthLeft);
    	south.add(lDayAvgAvailable);
    	south.add(lMonthLeftDay);
    	south.add(vAvgSpendPerDay);
    	south.add(vMonthAvailable);
    	south.add(vDayAvgAvailable);
    	south.add(vMonthLeftDay);
    	return south;
    }
    private JPanel center(){
    	JPanel center = new JPanel();
    	center.setLayout(new BorderLayout());
    	center.add(center1(),BorderLayout.CENTER);
    	center.add(west(), BorderLayout.WEST);
    	return center;
    }
    
	private JPanel west() {
		// TODO Auto-generated method stub
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(4, 1));
		west.add(lMonthSpend);
		west.add(vMonthSpend);
		west.add(lTodaySpend);
		west.add(vTodaySpend);
		return west;
	}
	private Component center1() {
		// TODO Auto-generated method stub
		return bar;
	}
	public static void main(String[] args) {
		GUIUtil.showPanel(SpendPanel.instance);
	}
	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		 SpendPage spend = new SpendService().getSpendPage();
	        vMonthSpend.setText(spend.monthSpend);
	        vTodaySpend.setText(spend.todaySpend);
	        vAvgSpendPerDay.setText(spend.avgSpendPerDay);
	        vMonthAvailable.setText(spend.monthAvailable);
	        vDayAvgAvailable.setText(spend.dayAvgAvailable);
	        vMonthLeftDay.setText(spend.monthLeftDay);
	 
	        bar.setProgress(spend.usagePercentage);
	        if (spend.isOverSpend) {
	            vMonthAvailable.setForeground(ColorUtil.warningColor);
	            vMonthSpend.setForeground(ColorUtil.warningColor);
	            vTodaySpend.setForeground(ColorUtil.warningColor);
	 
	        } else {
	            vMonthAvailable.setForeground(ColorUtil.grayColor);
	            vMonthSpend.setForeground(ColorUtil.blueColor);
	            vTodaySpend.setForeground(ColorUtil.blueColor);
	        }
	        bar.setForegroundColor(ColorUtil.getByPercentage(spend.usagePercentage));
	        addListener();
	 
		
	}
}
