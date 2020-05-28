import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

public class Grille extends JPanel { 
	private int[][] matricePions;
	private int joueurActuel = 1;
	
	public Grille() {
		
		this.matricePions = new int[7][];
		for (int i=0 ; i<matricePions.length; i++) {
			matricePions[i] = new int[] {0,0,0,0,0,0};
			System.out.println(Arrays.toString(matricePions[i]));
		}
		this.joueurActuel = 1;
		
		
		Aligneur align= new Aligneur(this);
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int[] carreAPeindre = align.getSquareToPaint(e.getX(), e.getY(), matricePions);
				
				// On ajoute le pion placé à la matrice
				matricePions[carreAPeindre[0]][carreAPeindre[1]] = joueurActuel;
				if (joueurActuel == 1) {joueurActuel = 2;}
				else {joueurActuel = 1;}
				
				// On repeint la grille pour dessiner le pion rajouté
				repaint();
				
				int joueurGagnant = align.detecterGagnant(matricePions, carreAPeindre);
				
			}	
		});
	}

	public void paintComponent(Graphics g){
		//    g.fillOval(200, 0, 75, 75); //filled circle of radius 75 at coord (200;0)
		//    g.drawRect(10, 10, 50, 60); //rect of size 50 X 60 at coord (10;10)
		//    g.fillRect(65, 65, 30, 40); //filled rect...
		//    Font font = new Font("Courier", Font.BOLD, 20);
		//    g.setFont(font);
		//    g.setColor(Color.red);
		//    g.drawString("Hello, world...", 200, 200);

		// Obtient les dimensions de la grille
		int panelWidth = this.getWidth();
		int panelHeight = this.getHeight();

		// Peint le quadrillage du panel
		for (int j=0; j<6; j++) {
			for (int i=0; i<7; i++) {
				g.drawRect( i*(panelWidth/7) , j*(panelHeight/6) , (panelWidth/7), (panelHeight/6) );
			}
		}
		
		
		// Ce bloc chèque avec matricePions quels cases sont à colorer
		for (int col=0; col<matricePions.length; col++ ) {
			for (int row=0; row<6; row++ ) {
				if (matricePions[col][row] != 0) {
					if (matricePions[col][row] == 1) {
						g.setColor(Color.BLUE);
						g.fillOval(col*(panelWidth/7), row*(panelHeight/6), (panelWidth/7), (panelHeight/6));
					}
					else {
						g.setColor(Color.YELLOW);
						g.fillOval(col*(panelWidth/7), row*(panelHeight/6), (panelWidth/7), (panelHeight/6));
					}
				}
			}
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}