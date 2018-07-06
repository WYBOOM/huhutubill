package util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

import javafx.scene.layout.Border;

/*
 * 各种工具
 */
public class GUIUtil {
	public static boolean checkEmpty(JTextField tf,String input) {
		// TODO Auto-generated method stub
		String str = tf.getText().trim();
		if(str.length() ==0){
			JOptionPane.showMessageDialog(null, input+"不能为空");
			return false;
		}
		
		//false 为空 ,true 不为空
		return true;
	}
	public static boolean checkNumber(JTextField tf,String input){
		String str = tf.getText().trim();
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,input+"应是整数!");
			tf.grabFocus();
			return false;
		}
		
		// true 为数字
		
	}
	public static boolean checkZero(JTextField tf,String input){
		if(!checkNumber(tf, input))
			return false;
		String str = tf.getText().trim();
		if(0==Integer.parseInt(str)){
			JOptionPane.showMessageDialog(null, input+"不能为0!");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	public static void setColor(Color c,JComponent...cs ){
		for (JComponent jComponent : cs) {
			jComponent.setForeground(c);
		}
		
	}
	private static String imageFolder ="E:/JAVA/workspace/hutubill/img";
	public static void setImageIcon(JButton jb,String FileName,String tip) {
		
		// TODO Auto-generated method stub
		ImageIcon i = new ImageIcon(new File(imageFolder ,FileName).getAbsolutePath());
		jb.setIcon(i);
		jb.setToolTipText(tip);
		jb.setPreferredSize(new Dimension(61, 81));
		jb.setVerticalTextPosition(JButton.BOTTOM);
		jb.setHorizontalTextPosition(JButton.CENTER);
        jb.setText(tip);

	}
	public static void useLNF(){
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void showPanel(JPanel jp,double rate){
		JFrame f = new JFrame();
		f.setSize(500,500);
		f.setLocationRelativeTo(null);
		CenterPanel cp = new CenterPanel(rate);
		f.setContentPane(cp);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.show(jp);
		
	}
	
	public static void showPanel(JPanel jp){
		showPanel(jp, 1);
	}

}
