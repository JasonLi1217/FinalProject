/*
Neo Navin, Jason Li
ICS3U7
Final Project: FlappyBird
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class FlappyBird implements KeyListener, ActionListener {
	
	public static FlappyBird flappybird;
	
	public static final int WIDTH = 600, HEIGHT = 900;
	public MyPanel panel;
	public Bird bird;
	public final BufferedImage img = ImageIO.read(new File("background.png"));
	
	public FlappyBird()throws IOException{
		//background image
		//JLabel background = new JLabel("", img, JLabel.CENTER);
		//background.setBounds(0,0, WIDTH, HEIGHT);
		
		JFrame frame = new JFrame("FlappyBird");
		panel = new MyPanel();
		Timer timer = new Timer(20, this);
		
		//frame.add(background);
		frame.add(panel);
		frame.pack();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.addKeyListener(this);
		bird = new Bird(30);
		
		timer.start();

	} 
	public void actionPerformed(ActionEvent e){
		panel.repaint();
	}
		public void actionPerformed(ActionEvent e){
		panel.repaint();
	}
	public void keyPressed( KeyEvent e )   {
		if(e.getKeyCode()==32){
			bird.jump(); //when pressed bird jumps v_y
			bird.jumping = true;
		}
	}

	public void keyReleased( KeyEvent e ){
		if(e.getKeyCode()==32){
			bird.jump(); 
			bird.jumping = false; //bird can return to falling when released
		}
	}
	public void keyTyped( KeyEvent e )  {}
	public void repaint(Graphics g){
		g.drawImage(img, 0, 0, null);
		
		if(bird.jumping == false){
			bird.fall(); //bird falls when nothing happens
		}
		g.setColor(Color.ORANGE);
		g.fillRect(bird.X()-bird.size(), bird.Y(), bird.size(), bird.size());
	}
	
	
	public static void main(String[] args) throws Exception{
		flappybird = new FlappyBird();
	}

  
}





