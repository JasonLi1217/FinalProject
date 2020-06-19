import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Help extends JPanel implements ActionListener{
	
	public Timer timer;
	private JButton goBack;
	private Image leftClick, arrow;
	
	public Help(){
		timer = new Timer(20, this);
		setLayout(null);
		
		ImageIcon ii = new ImageIcon("leftclick.png");
		leftClick = ii.getImage();
		ii = MainMenu.loadAndResizeImg("arrow.png", 200,200);
		arrow = ii.getImage();
		
		goBack = new JButton(MainMenu.loadAndResizeImg("return.png",190, 57));
		goBack.setBounds(5,5, 190, 57);
		add(goBack);
		goBack.addActionListener(this);
		
		timer.start();
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==goBack){
			timer.stop();
			Game.card.show(Game.c, "menu");
		}

		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);		
		g.drawImage(FlappyBird.background, 0, -200, null);
		g.drawImage(FlappyBird.background, 760, -200, null);
		
		Font f = new Font("Monospaced", Font.BOLD, 48);
		g.setFont(f);
		g.setColor(Color.WHITE);
		g.drawString("Left click to jump", Game.WIDTH/8-100, 300);
		
		g.drawImage(leftClick, Game.WIDTH/6+50, 400, null);
		g.drawImage(Bird.birdSprite,Game.WIDTH/2+200, 300, null);
		g.drawImage(arrow, Game.WIDTH/2+300, 200, null);
		
	}


}
