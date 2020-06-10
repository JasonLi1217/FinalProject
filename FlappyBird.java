import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class FlappyBird extends JPanel implements KeyListener, ActionListener{
	
	public static Image background;
	static Timer timer;
	
	public FlappyBird() {
		//load image
		ImageIcon img = new ImageIcon ("background.png");
		background = img.getImage();

		timer = new Timer(20, this);
	
		addKeyListener(this);
		
		//timer.start(); //dont start timer in constructor with cardLayout. Do it when this card is shown
	}
	public void actionPerformed(ActionEvent e){
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(background, 0, -200, null);
		g.drawImage(background, 760, -200, null);		
	}
	
	public void keyPressed( KeyEvent e )   {}
	public void keyReleased( KeyEvent e ){}
	public void keyTyped( KeyEvent e )  {}	
	
	
}
