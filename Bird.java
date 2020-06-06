import javax.swing.*;
import java.awt.*;

class Bird extends Rectangle{
	public static boolean jumping=false; //helps decide when to stop bird falling and make it jump instead
	private int birdWidth;
	private int x,y, v_y;

	
	public Bird(int width){
		super(FlappyBird.WIDTH/2, FlappyBird.HEIGHT/2, width, width);
		
		x = FlappyBird.WIDTH/2;
		y = FlappyBird.HEIGHT/2;
		birdWidth = width;
		v_y = 5;
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
		if(y - v_y*20 <= 0){
			y = 0;
		}
		else{
			y -= v_y*20;
		}
	}
	public void fall(){
		if(y + v_y >= FlappyBird.HEIGHT-birdWidth){
			y = FlappyBird.HEIGHT-birdWidth-1;
		}
		else{
			y += v_y;
		}
	}

}
