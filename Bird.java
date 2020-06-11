import javax.swing.*;
import java.awt.*;

class Bird{
	public Image birdSprite;
	public int x,y;
	private int width,height;
	
	public Bird(int width, int height){//can add Strig path parameter later for customization
		ImageIcon ii = MainMenu.loadAndResizeImg("bird.png", width, height);
		birdSprite = ii.getImage();
		
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
