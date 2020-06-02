import javax.swing.*;
import java.awt.*;


class MyPanel extends JPanel {
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		FlappyBird.flappybird.repaint(g);
	}

}
