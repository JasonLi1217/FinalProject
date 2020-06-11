import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class FlappyBird extends JPanel implements ActionListener, MouseListener{
	
	static Image background;
	static int birdSpeed, time;
	static Timer timer;
	
	private Bird bird;
	
	public FlappyBird() {
		//load image
		ImageIcon img = new ImageIcon ("background.png");
		background = img.getImage();
		bird = new Bird(55, 36);
		timer = new Timer(20, this);
		
		addMouseListener(this);
	}
	public void actionPerformed(ActionEvent e){
		time++;
		if (time>30){ //gives small pause before game starts
			if(time%2==0 && birdSpeed<15){
				birdSpeed += 2;
			}
			//bottom-floor
			if(bird.getY() > Game.HEIGHT-bird.getHeight()-70){
				bird.y = Game.HEIGHT-bird.getHeight()-69;
			}  
			bird.y += birdSpeed;
		}
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(background, 0, -200, null);
		g.drawImage(background, 760, -200, null);	

		//bird
		g.drawImage(bird.getImage(), bird.getX(), bird.getY(), null);
	}
	//Mouse Actions
	public void mouseClicked(MouseEvent e){
		bird.jump();
	}
	public void mousePressed(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}

	
	
}
