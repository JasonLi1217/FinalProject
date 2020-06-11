import javax.swing.*;
import java.awt.*;
import java.awt.Image;

class BottomTube{
	public Image tubeSprite;
	private int x;
	private int y;
	private int width,height;
	
	public BottomTube(int width, int height){
	
		ImageIcon ii = MainMenu.loadAndResizeImg("tubeup.png", width, height);

		tubeSprite = ii.getImage();

		
		this.width = width;
		this.height = height;
		x = Game.WIDTH/2;
		y = Game.HEIGHT/2;
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
