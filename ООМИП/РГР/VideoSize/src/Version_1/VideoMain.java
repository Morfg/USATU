package Version_1;


import java.awt.Color;
import javax.swing.*;

import javax.swing.JFrame;

public class VideoMain {
	public static String text="ŒŒÃ»œ";
	public static void main(String args[]) {
		
		MyFrame r = new MyFrame(text);
		r.setVisible(true);
		//r.getContentPane().setForeground(Color.yellow); 
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		r.setSize(450,600);
		r.setResizable(false); 
		r.setLocationRelativeTo(null);
		r.getContentPane().setBackground(Color.BLACK ); 
		ImageIcon image = new ImageIcon("13.png");
		  r.setIconImage(image.getImage());
	}
}