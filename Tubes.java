import javax.swing.*;
import java.awt.*;
import java.awt.Image;

class Tubes{
	public Image topTube, botTube;
	private int width, height, x, topy, boty;
	
	public Tubes(int width, int height, int x){
		ImageIcon tii = MainMenu.loadAndResizeImg("tubedown.png", width, height);
		topTube = tii.getImage();
		
		ImageIcon bii = MainMenu.loadAndResizeImg("tubeup.png", width, height);
		botTube = bii.getImage();
	
		this.width = width;
		this.height = height;
		
		this.x = x;
		topy = -200;
		boty = Game.HEIGHT/2;
	
	}
	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x = x;
	}
	public int getTopy(){
		return topy;
	}
	public int getBoty(){
		return boty;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public Image getTopTube(){
		return topTube;
	}
	public Image getBotTube(){
		return botTube;
	}
}
