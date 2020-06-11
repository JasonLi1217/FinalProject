import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class MainMenu extends JPanel implements ActionListener{
	
	public Timer timer;
	private JButton play, shop, help;
	
	public MainMenu(){
		timer = new Timer(20, this);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//load icons
		play = new JButton(loadAndResizeImg("play.png",190, 57));
		
		add(play);
		play.addActionListener(this);
		
		timer.start();
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == play){
			Game.card.show(Game.c, "FlappyBird");
			timer.stop();
			FlappyBird.timer.start();
		}
		if(e.getSource() == timer){
			repaint();
		}
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(FlappyBird.background, 0, -200, null);
		g.drawImage(FlappyBird.background, 760, -200, null);
		
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
