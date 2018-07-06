package gui.frame;

import javax.swing.JFrame;

import gui.panel.MainPanel;
import util.GUIUtil;

public class MainJFrame extends JFrame{
	static {
		GUIUtil.useLNF();
	}
	public static MainJFrame instance = new MainJFrame();
	
	private MainJFrame(){
		 setSize(550,450);
         setTitle("Ò»±¾ºýÍ¿ÕË");
         setContentPane(MainPanel.instance);
         setLocationRelativeTo(null);
         setResizable(false);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		instance.setVisible(true);
	}

}
