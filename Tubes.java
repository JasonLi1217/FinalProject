import javax.swing.*;
import java.awt.*;
import java.awt.Image;

class Tubes{
	public Image topTube, botTube;
	private int width, height,x, topy, boty, gap;
	
	public Tubes(int width, int height, int x){
		ImageIcon tii = MainMenu.loadAndResizeImg("tubedown.png", width, height);
		topTube = tii.getImage();
		
		ImageIcon bii = MainMenu.loadAndResizeImg("tubeup.png", width, height+300);
		botTube = bii.getImage();
	
		this.width = width;
		this.height = height;
		gap = 175;
		this.x = x;
		topy = -(int)(Math.random()*350);
		boty = topy+500+gap;
	
	}
	public int getX(){
		return x;
	}
	
	public int getGap(){
		return gap;
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
	public void setTopy(int y){
		this.topy = y;
	}
	public void setBoty(int y){
		this.boty = y;
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
	
	public Rectangle getBoundsTop() {
		return new Rectangle(x, topy, width, height);
	}
	
	public Rectangle getBoundsBottom() {
		return new Rectangle(x, boty, width, height);
	}
	
}
