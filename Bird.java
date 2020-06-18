import javax.swing.*;
import java.awt.*;

class Bird{
	static Image birdSprite;
	public int x,y;
	private int width,height;
	
	public Bird(int width, int height){//can add Strig path parameter later for customization
		setImage("yellowbird.png", width, height);
		
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
		return birdSprite;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
	
	public void setImage(String path, int width, int height){
		ImageIcon ii = MainMenu.loadAndResizeImg(path, width, height);
		birdSprite = ii.getImage();
	}
	public void jump(){
		if (FlappyBird.birdSpeed > 0){
			FlappyBird.birdSpeed = 0;
		}
		if(y <= 0){ //top ceiling
			y = 0;
		}else{
			FlappyBird.birdSpeed -= 10;
		}
	}
	

}
