import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Help extends JPanel implements ActionListener{
	
	public Timer timer;
	private JButton goBack;
	
	public Help(){
		timer = new Timer(20, this);
		setLayout(null);
		
		goBack = new JButton(MainMenu.loadAndResizeImg("return.png",190, 57));
		goBack.setBounds(5,5, 190, 57);
		add(goBack);
		goBack.addActionListener(this);
		
		timer.start();
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==goBack){
			timer.stop();
			Game.card.show(Game.c, "menu");
		}
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);		
		g.drawImage(FlappyBird.background, 0, -200, null);
		g.drawImage(FlappyBird.background, 760, -200, null);
		
	}


}