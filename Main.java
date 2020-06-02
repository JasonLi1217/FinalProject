/*
Neo Navin, Jason Li
ICS3U7
Final Project: FlappyBird
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class FlappyBird implements ActionListener {
	
	public static FlappyBird flappybird;
	
	public final int WIDTH = 800, HEIGHT = 800;
	public MyPanel panel;
	

	public FlappyBird(){
		JFrame frame = new JFrame("FlappyBird");
		panel = new MyPanel();
		Timer timer = new Timer(20, this);
		
		frame.add(panel);
		frame.pack();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		timer.start();

	} 
	public void actionPerformed(ActionEvent e){
		panel.repaint();
	}
	public void repaint(Graphics g){
		System.out.print("Heloo ");
	}
	public static void main(String[] args) {
		flappybird = new FlappyBird();
	}

  
}
