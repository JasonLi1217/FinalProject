import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Shop extends JPanel implements ActionListener{
	
	public Timer timer;
	private JButton goBack, yellow, red, blue, special;
	private boolean redStatus, blueStatus, specialStatus; //booleans used to know if a bird is locked or unlocked 
	private Image yellowBird, redBird, blueBird, specialBird;
	private ImageIcon greenButton, lockedButton;
	public Shop(){
		timer = new Timer(20, this);
		setLayout(null);
		
		//initialize button states
		
		yellowBird = loadImage("yellowbird.png", 160,113 );
		blueBird = loadImage("bluebird.png", 160,113 );
		redBird = loadImage("redbird.png",160,113 );
		specialBird = loadImage("specialbird.png", 160 ,130 );
		//buttons
		greenButton = MainMenu.loadAndResizeImg("greenButton.png",160, 57);
		lockedButton = MainMenu.loadAndResizeImg("lockedButton.png",160, 57);
		
		yellow = new JButton(greenButton);
		yellow.setBounds(104,400, 120, 57);
		
		red = new JButton(greenButton);
		red.setBounds(440,400, 120, 57);
		
		blue = new JButton(greenButton);
		blue.setBounds(776,400, 120, 57);
		
		special = new JButton(greenButton);
		special.setBounds(1112,400, 120, 57);
		
		goBack = new JButton(MainMenu.loadAndResizeImg("return.png",190, 57));
		goBack.setBounds(5,5, 190, 57);
		
		add(yellow);
		add(red);
		add(blue);
		add(special);
		add(goBack);
		
		yellow.addActionListener(this);
		red.addActionListener(this);
		blue.addActionListener(this);
		special.addActionListener(this);
		goBack.addActionListener(this);
		
		timer.start();
	}
	public void actionPerformed(ActionEvent e){
		//update buttons
		
		if(e.getSource()==goBack){
			timer.stop();
			Game.card.show(Game.c, "menu");
		}
		if(e.getSource()==yellow){
			FlappyBird.bird.setImage("yellowbird.png", 55, 36);
		}
		if(e.getSource()==red){
			FlappyBird.bird.setImage("bluebird.png", 55, 36);
		}
		if(e.getSource()==blue){
			FlappyBird.bird.setImage("redbird.png", 55, 36);
		}
		if(e.getSource()==special){
			FlappyBird.bird.setImage("specialbird.png", 55, 43);
		}
		repaint();
	}
	public Image loadImage(String path, int width, int height){
		ImageIcon ii = MainMenu.loadAndResizeImg(path, width, height);
		Image img = ii.getImage();
		return img;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);		
		g.drawImage(FlappyBird.background, 0, -200, null);
		g.drawImage(FlappyBird.background, 760, -200, null);
		
		g.drawImage(yellowBird, 84, 200, null);
		g.drawImage(blueBird, 420, 200, null);
		g.drawImage(redBird, 756, 200, null);
		g.drawImage(specialBird,1092,200 , null);
	}
	//add updateButtons() which should check score and changes button images (put in actionPerformed)

}
