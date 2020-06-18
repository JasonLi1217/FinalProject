import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class FlappyBird extends JPanel implements ActionListener, MouseListener{
	
	static Image background;
	static int birdSpeed,time,tubeSpeed,score;
	static Timer timer;
	
	public static Bird bird;
	private Tubes tubes1, tubes2, tubes3;
	private JButton goBack;
	private boolean collision = false;
	
	public FlappyBird() {
		//load image
		setLayout(null);
		ImageIcon img = new ImageIcon ("background.png");
		background = img.getImage();
		
		bird = new Bird(55, 36);
		tubes1 = new Tubes(100,500, Game.WIDTH/2 + 300);
		tubes2 = new Tubes(100,500, Game.WIDTH + 300);
		tubes3 = new Tubes(100,500, Game.WIDTH+Game.WIDTH/2+ 300);
		timer = new Timer(20, this);
		
		goBack = new JButton(MainMenu.loadAndResizeImg("return.png",190, 57));
		goBack.setBounds(5,5, 190, 57);
		add(goBack);
		goBack.addActionListener(this);
		
		addMouseListener(this);
	}
	public void actionPerformed(ActionEvent e){
		time++;
		tubeSpeed = 10;
		//return
		if(e.getSource()==goBack){
			timer.stop();
			reset();
			Game.card.show(Game.c, "menu");
		}
		
		//bird
		if (time>30){ //gives small pause before game starts
			if(time%2==0 && birdSpeed<15){
				birdSpeed += 2;
			}
			//bottom-floor
			if(bird.getY() > Game.HEIGHT-bird.getHeight()-70){
				bird.y = Game.HEIGHT-bird.getHeight()-69;
			}  
			bird.y += birdSpeed;
			checkCollisions();
			
			//tubes
			tubes1.setX(tubes1.getX()-tubeSpeed);
			tubes2.setX(tubes2.getX()-tubeSpeed);
			tubes3.setX(tubes3.getX()-tubeSpeed);
			
			if(tubes1.getX()<= -100){
				tubes1.setX(Game.WIDTH+Game.WIDTH/2);
				//create new gap height
				tubes1.setTopy(-(int)(Math.random()*450));
				tubes1.setBoty(tubes1.getTopy()+500+tubes1.getGap());
			}
			if(tubes2.getX()<= -100){
				tubes2.setX(Game.WIDTH+Game.WIDTH/2);
				tubes2.setTopy(-(int)(Math.random()*450));
				tubes2.setBoty(tubes2.getTopy()+500+tubes2.getGap());
			} 
			if(tubes3.getX()<= -100){
				tubes3.setX(Game.WIDTH+Game.WIDTH/2);
				tubes3.setTopy(-(int)(Math.random()*450));
				tubes3.setBoty(tubes3.getTopy()+500+tubes3.getGap());
			}
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
		g.drawImage(tubes1.getTopTube(), tubes1.getX(), tubes1.getTopy(), null);
		g.drawImage(tubes1.getBotTube(), tubes1.getX(), tubes1.getBoty(), null);
		
		g.drawImage(tubes2.getTopTube(), tubes2.getX(), tubes2.getTopy(), null);
		g.drawImage(tubes2.getBotTube(), tubes2.getX(), tubes2.getBoty(), null);  
		
		g.drawImage(tubes3.getTopTube(), tubes3.getX(), tubes3.getTopy(), null);
		g.drawImage(tubes3.getBotTube(), tubes3.getX(), tubes3.getBoty(), null);  
	}
	
	public void reset(){
		bird.y = Game.HEIGHT/2;
		tubes1.setX(Game.WIDTH/2 + 300);
		tubes2.setX(Game.WIDTH + 300);
		tubes3.setX(Game.WIDTH+Game.WIDTH/2+ 300);
		
	}
	
	public void checkCollisions() {

		Rectangle r1 = bird.getBounds();
		Rectangle r2 = tubes1.getBoundsTop();
		Rectangle r3 = tubes1.getBoundsBottom();
		Rectangle r4 = tubes2.getBoundsTop();
		Rectangle r5 = tubes2.getBoundsBottom();
		Rectangle r6 = tubes3.getBoundsTop();
		Rectangle r7 = tubes3.getBoundsBottom();

		if (r1.intersects(r2)||r1.intersects(r3)||r1.intersects(r4)||r1.intersects(r5)||r1.intersects(r6)||r1.intersects(r7)) {
			collision= true;
			tubeSpeed = 0;
			
		}else{
			collision = false;
		}
		
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
