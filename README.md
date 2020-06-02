# FinalProject
import javax.swing.*;
import java.awt.*;

class CirclePanel extends JPanel{

  public CirclePanel(){
    setPreferredSize( new Dimension(500, 500) );
    setBackground(Color.WHITE);   
  }
  
  public void paintComponent(Graphics gr){ 
    super.paintComponent( gr );

    int q2X = getWidth()/4;
    int q2Y = getHeight()/4;
	
	int q1X = getWidth()/2+getWidth()/4;
	int q1Y = getHeight()/4;
	
	int q3X = getWidth()/4;
    int q3Y = getWidth()/2+getWidth()/4;

	int q4X = getWidth()/2+getWidth()/4;
    int q4Y = getHeight()/2+getHeight()/4;
    
    
    int radius = getWidth()/6;
    
    gr.setColor( Color.GREEN );
    gr.drawOval( q1X-radius, q1Y-radius, radius*2, radius*2 );
	gr.setColor( Color.BLUE );
	gr.drawOval( q2X-radius, q2Y-radius, radius*2, radius*2 );
	gr.setColor( Color.RED );
	gr.drawOval( q3X-radius, q3Y-radius, radius*2, radius*2 );
	gr.setColor( Color.ORANGE );
	gr.drawOval( q4X-radius, q4Y-radius, radius*2, radius*2 );
   }
}

public class FlappyBird{
   public static void main ( String[] args ){
      JFrame frame = new JFrame("Circles");
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
      frame.getContentPane().add( new CirclePanel() );
      
      frame.pack();
      frame.setVisible( true );
   }
}
