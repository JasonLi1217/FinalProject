/*
Neo Navin, Jason Li
ICS3U7
Final Project: FlappyBird
*/
import javax.swing.*;
import java.awt.*;

class Game extends JFrame{
	
	static final int WIDTH = 1350, HEIGHT = 700;
	static Container c;
	static CardLayout card;
	static FlappyBird flappy ;
	
	public Game(){
		c = getContentPane();
		card = new CardLayout();
		c.setLayout(card);
		
		MainMenu menu = new MainMenu();
		flappy = new FlappyBird();
		Help help = new Help();
		Shop shop = new Shop();
		
		c.add("menu", menu);
		c.add("FlappyBird", flappy);
		c.add("Help", help);
		c.add("Shop", shop);
	}
	
	public static void main(String[] args){
		Game game = new Game();
		
		game.setTitle("FlappyBird 2.0");
		game.setSize(WIDTH, HEIGHT);
		game.setVisible(true);
		game.setResizable(false);
		game.setDefaultCloseOperation(EXIT_ON_CLOSE);

		
	}

}
