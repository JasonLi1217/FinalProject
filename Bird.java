import javax.swing.*;
import java.awt.*;

class Bird extends Rectangle{
	public static boolean jumping=false; //helps decide when to stop bird falling and make it jump instead
	public int x,y;
	private int birdWidth;

	
	public Bird(int width){
		super(FlappyBird.WIDTH/2, FlappyBird.HEIGHT/2, width, width);
		
		x = FlappyBird.WIDTH/2;
		y = FlappyBird.HEIGHT/2;
		birdWidth = width;
	}
	public int X(){
		return x;
	}
	public int Y(){
		return y;
	}
	public int size(){ //all birds will be squares
		return birdWidth;
	}
	public void jump(){
		if (FlappyBird.birdSpeed > 0){
			FlappyBird.birdSpeed = 0;
		}
		FlappyBird.birdSpeed -= 10;
	}

}
