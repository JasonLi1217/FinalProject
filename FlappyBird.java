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
	private JButton goBack;
	
	public FlappyBird() {
		//load image
		setLayout(null);
		ImageIcon img = new ImageIcon ("background.png");
		background = img.getImage();
		
		bird = new Bird(55, 36);
		tube1 = new TopTube(500,400);
		tube2 = new BottomTube(500,400);
		timer = new Timer(20, this);
		
		goBack = new JButton(MainMenu.loadAndResizeImg("return.png",190, 57));
		goBack.setBounds(5,5, 190, 57);
		add(goBack);
		goBack.addActionListener(this);
		
		addMouseListener(this);
	}
	public void actionPerformed(ActionEvent e){
		time++;
		//return
		if(e.getSource()==goBack){
			timer.stop();
			Game.card.show(Game.c, "menu");
		}
		
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
		//tubes
		g.drawImage(tube1.getImage(), tube1.getX(), tube1.getY(), null);
		g.drawImage(tube2.getImage(), tube2.getX(), tube2.getY(), null);
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
