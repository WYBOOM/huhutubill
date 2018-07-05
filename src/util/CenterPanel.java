package util;

/*
 * 自定义居中JPanel
 * 实例化后调用 show(component c)方法
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.panel.WorkingPanel;
import javafx.scene.layout.Border;

public class CenterPanel extends JPanel {
	private double rate;
	private boolean strech;
	private JComponent c;
	public CenterPanel(double rate,boolean strech){
		this.setLayout(null);
		this.rate =rate;
		this.strech = strech;
	}
	public CenterPanel(double rate){
		this(rate,true);
	}
	public  void repaint() {
		if(null!=c){
			Dimension containerSize = this.getSize();
			Dimension componentSize = c.getPreferredSize();
			if(strech==false){
				c.setSize(componentSize);
			}else{
				c.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
			}
			c.setLocation(containerSize.width/2 -c.getSize().width/2,containerSize.height/2 -c.getSize().height/2 );
			super.repaint();
		}
	}
	public void show(JComponent c) {
		// TODO Auto-generated method stub
		this.c =c;
		Component cs[] = getComponents();
		for (Component asd : cs) {
			remove(asd);
		}
		add(c);
		if(c instanceof WorkingPanel)
			((WorkingPanel) c).updateData();
		this.updateUI();
	}
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setBounds(200, 200, 500, 400);
		f.setLayout(new BorderLayout());
		
		JButton b = new JButton("按钮");
		b.setPreferredSize(new Dimension(100,100));
		CenterPanel cp = new CenterPanel(0.1,true);
		f.add(cp,BorderLayout.CENTER);
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cp.show(b);
		
	}
}
