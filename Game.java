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
	
	public Game(){
		c = getContentPane();
		card = new CardLayout();
		c.setLayout(card);
		
		MainMenu menu = new MainMenu();
		FlappyBird flappy = new FlappyBird();
		
		c.add("menu", menu);
		c.add("FlappyBird", flappy);
		
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
