import javax.swing.*;
import java.awt.*;

class Bird extends Rectangle{
	private int birdWidth;
	private int x,y;

	
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

}
