import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import net.miginfocom.swing.MigLayout;

public class EcranGrille extends JPanel {
	public ControleurGrille controleur;
	private int[][] matricePions;
	private int joueurActuel = 1;
	private Window parent;
	
	public EcranGrille(JLabel lbltimer, Window parent) {
		ControleurGrille ControleJeu = new ControleurGrille(lbltimer, joueurActuel);
		this.controleur = ControleJeu;
		this.matricePions = new int[7][];
		for (int i=0 ; i<matricePions.length; i++) {
			matricePions[i] = new int[] {0,0,0,0,0,0};
			System.out.println(Arrays.toString(matricePions[i]));
		}
		this.joueurActuel = 1;
		this.parent = parent;
		
//		ControleurGrille align = new ControleurGrille(this);
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int[] carreAPeindre = controleur.getSquareToPaint(e.getX(), e.getY(), matricePions);
				
				// On ajoute le pion plac� � la matrice
				matricePions[carreAPeindre[0]][carreAPeindre[1]] = joueurActuel;
				if (joueurActuel == 1) {joueurActuel = 2;}
				else {joueurActuel = 1;}
				
				// On repeint la grille pour dessiner le pion rajouté
				repaint();
				//updateUI();
				
				int joueurGagnant = controleur.detecterGagnant(matricePions, carreAPeindre);
				
				// Dialog Panel si un des joueurs a gagné
				if (joueurGagnant != 0) {
					if (joueurGagnant == 1) {
						final JComponent[] inputs = new JComponent[] {
							new JLabel("Joueur BLEU gagne!"),
						};
						int result = JOptionPane.showConfirmDialog(null, inputs, "FIN DE PARTIE", JOptionPane.PLAIN_MESSAGE);
						parent.setContentPane(parent.pnlMenu);
						parent.repaint();
						parent.revalidate();
					}
					else {
						final JComponent[] inputs = new JComponent[] {
								new JLabel("Joueur JAUNE gagne!"),
							};
							int result = JOptionPane.showConfirmDialog(null, inputs, "FIN DE PARTIE", JOptionPane.PLAIN_MESSAGE);
							parent.setContentPane(parent.pnlMenu);
							parent.repaint();
							parent.revalidate();
					}
				}
				
			}	
		});
	}

	public void paintComponent(Graphics g){
		// Obtient les dimensions de la grille
		int panelWidth = getParent().getWidth();
		int panelHeight = getParent().getHeight();
		// Peint le quadrillage du panel
		for (int j=0; j<6; j++) {
			for (int i=0; i<7; i++) {
				g.drawRect( i*(panelWidth/7) , j*(panelHeight/6) , (panelWidth/7), (panelHeight/6) );
			}
		}
		
		
		// Ce bloc ch�que avec matricePions quels cases sont � colorer
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