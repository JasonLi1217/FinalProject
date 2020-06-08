import javax.swing.*;
import java.awt.*;

class Column extends Rectangle{
	
	//public ArrayList<Column> columns;
	
	public Column(int x, int y, int height, int width){
		super(x,y,height,width);
	
	}
	
	public int width(){
		return width;
	}
	public int height(){ 
		return height;
	}
  
  public int X(){
		return x;
	}
	public int Y(){
		return y;
	}

}
