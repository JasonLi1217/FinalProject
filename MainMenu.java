import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class MainMenu extends JPanel implements ActionListener{
	
	public Timer timer;
	private JButton play, shop, help;
	
	public MainMenu(){
		timer = new Timer(20, this);
		setLayout(null);
		
		//load icons
		play = new JButton(loadAndResizeImg("play.png",190, 57));
		shop = new JButton(loadAndResizeImg("shop.png",190, 57));
		help = new JButton(loadAndResizeImg("help.png",190, 57));
		
		play.setBounds(Game.WIDTH/2-95,200, 190, 57);
		shop.setBounds(Game.WIDTH/2-95,300, 190, 57);
		help.setBounds(Game.WIDTH/2-95,400, 190, 57);
		
		add(play);
		add(shop);
		add(help);
		
		play.addActionListener(this);
		shop.addActionListener(this);
		help.addActionListener(this);
		
		timer.start();
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == play){
			Game.card.show(Game.c, "FlappyBird");
			FlappyBird.timer.start();
		}
		if(e.getSource() == help){
			Game.card.show(Game.c, "Help");
		}
		if(e.getSource() == shop){
			Game.card.show(Game.c, "Shop");
		}
		if(e.getSource() == timer){
			repaint();
		}
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);		
		g.drawImage(FlappyBird.background, 0, -200, null);
		g.drawImage(FlappyBird.background, 760, -200, null);
		
		//welcome
		Font f = new Font("Monospaced", Font.BOLD, 65);
		g.setFont(f);
		g.setColor(Color.WHITE);
		g.drawString("FlappyBird 2.0", Game.WIDTH/2-250, 100);
	}
	
	//this method allows to resize out icons for the buttons
	public static ImageIcon loadAndResizeImg(String path, int width, int height){
		ImageIcon img = new ImageIcon(path);
		Image image = img.getImage();
		Image modifiedImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		
		img = new ImageIcon(modifiedImage);
		return (img);
	}
	
}
