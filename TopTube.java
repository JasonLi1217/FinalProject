import javax.swing.*;
import java.awt.*;
import java.awt.Image;

class TopTube{
	public Image tubeSprite;
	private int x;
	private int y;
	private int width,height;
	
	public TopTube(int width, int height){
	
		ImageIcon ii = MainMenu.loadAndResizeImg("tubedown.png", width, height);
		tubeSprite = ii.getImage();
	
		this.width = width;
		this.height = height;
		x = Game.WIDTH/2;
		y = -200;
	
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public Image getImage(){
		return tubeSprite;
	}
	
}
