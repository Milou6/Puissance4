import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
 
public class Panel2 extends JPanel { 

	public void paintComponent(Graphics g){
		g.setColor(Color.blue);
		g.fillOval(50, 50, 75, 75); //filled circle of radius 75 at coord (200;0)
		Font font = new Font("Courier", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.red);
		g.drawString("Another Panel", 200, 200);
	}               
}