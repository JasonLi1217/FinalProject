/*
Neo Navin, Jason Li
ICS3U7
Final Project: FlappyBird
*/
import javax.swing.*;
import java.awt.*;

class Game extends JFrame{

	static Container c;
	static CardLayout card;
	
	public Game(){
		c = getContentPane();
		card = new CardLayout();
		c.setLayout(card);
		
		//MainMenu menu = new MainMenu();
		FlappyBird flappy = new FlappyBird();
		
		//c.add("menu", menu);
		c.add("FlappyBird", flappy);
		
	}
	
	public static void main(String[] args){
		Game game = new Game();
		game.setTitle("FlappyBird 2.0");
		game.setSize(1350, 700);
		game.setVisible(true);
		game.setResizable(false);
		game.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		FlappyBird.timer.start();
		card.show(c, "FlappyBird");
		
	}

}
