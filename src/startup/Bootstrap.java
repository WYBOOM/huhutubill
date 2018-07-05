package startup;

import javax.swing.SwingUtilities;

import gui.frame.MainJFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GUIUtil;

public class Bootstrap {
	public static void main(String[] args) throws Exception {
		GUIUtil.useLNF();
		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				MainJFrame.instance.setVisible(true);
				MainPanel.instance.workPanel.show(SpendPanel.instance);
				
			}
		});
	}

}
