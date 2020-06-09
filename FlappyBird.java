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
import java.util.ArrayList;
import java.util.Random;


class FlappyBird implements KeyListener, ActionListener{
	
	public static FlappyBird flappybird;
	
	public static final int WIDTH = 1300, HEIGHT = 700;
	public static int ticks, birdSpeed;
	
	public MyPanel panel;
	public Bird bird;
	public ArrayList<Column> columns;
	public Random rand;

	
	public final BufferedImage img = ImageIO.read(new File("background.png"));
	
	public FlappyBird()throws IOException{
		
		JFrame frame = new JFrame("FlappyBird");
		panel = new MyPanel();
		Timer timer = new Timer(20, this);
		
		rand = new Random();

		frame.add(panel);
		frame.pack();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.addKeyListener(this);
		bird = new Bird(25);
		columns = new ArrayList<Column>();
		
		for (int i=0; i<100; i++){
			addColumn(true);
		}
		
		
		timer.start();

	} 
	public void actionPerformed(ActionEvent e){
		//bird
		ticks++;
		
		if(ticks%2==0 && birdSpeed<15){
			birdSpeed += 2;
		}
		
		bird.y += birdSpeed;
		//columns
		int speed = 10;
		
		for (int i = 0; i < columns.size(); i++){
			Column column = columns.get(i);

			column.x -= speed;
		}
		
		panel.repaint();
	}
	
	public void keyPressed( KeyEvent e )   {
	}

	public void keyReleased( KeyEvent e ){
		if(e.getKeyCode()==32){
			bird.jump(); 
		}
	}
	public void keyTyped( KeyEvent e )  {}
	
	public void repaint(Graphics g){
		g.drawImage(img, 0, -200, null);
		g.drawImage(img, 760, -200, null);

		g.setColor(Color.ORANGE);
		g.fillRect(bird.X()-bird.size(), bird.Y(), bird.size(), bird.size());
		
		for (Column column: columns)
		{
			paintColumn(g, column);
		}
		
	}
	
	public void addColumn(boolean start){
		int gap = 200;
		int width = 100;
		int height = rand.nextInt(350)+50;
		
		if (start){
			columns.add(new Column(WIDTH + width +columns.size()*300, HEIGHT-height, width, height));
			columns.add(new Column(WIDTH + width +(columns.size()-1)*300,0, width, HEIGHT-height-gap));
		}else{
			columns.add(new Column(columns.get(columns.size() - 1).x + 600, HEIGHT - height, width, height));
			columns.add(new Column(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - gap));
		}
			
	}
	
	public void paintColumn(Graphics g, Column column){
		g.setColor(Color.GREEN.darker());
		g.fillRect(column.x, column.y, column.width, column.height);
	}
	
	
	public static void main(String[] args) throws Exception{
		flappybird = new FlappyBird();
	}

  
}
