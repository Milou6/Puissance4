import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ControleurGrille {
	EcranGrille grid;
	Chrono chrono;
	int joueurActuel;
	
	public ControleurGrille(JLabel lbltimer, int joueurActuel) {
		// On lie le controleur à un objet Grille
//		this.grid = new EcranGrille(this);
		this.joueurActuel = joueurActuel;
		chrono = new Chrono(lbltimer, joueurActuel);

		
		// On cr�e un JFrame qui contient tout l'affichage du jeu (Grille, Timer, Boutons)
//		JFrame EcranJeu = new JFrame();	
//		EcranJeu.setBounds(100, 100, 800, 610);
//		EcranJeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		EcranJeu.getContentPane().setLayout(new BorderLayout());
//		EcranJeu.setVisible(true);
		
		// On cr�e un JLabel qui affiche le timer
//		JLabel timer = new JLabel("0.00");
//		timer.setFont(new Font("Arial", Font.BOLD, 20));

		// On rajoute les diff�rents �l�ments au JFrame
//		EcranJeu.add(grid, BorderLayout.CENTER);
//		EcranJeu.add(timer, BorderLayout.PAGE_END);
//		grid.setVisible(true);
	}
	

	public int[] getSquareToPaint(int x, int y, int[][] matricePions) {
		int panelWidth = 800;
		int panelHeight = 494;
		System.out.println(panelWidth);
		System.out.println(panelHeight);	
		
		int LigneAPeindre = -1;
		int[] result = {-1, -1};
		
		int colonneClickee = x / (panelWidth/7);
		System.out.println(colonneClickee);
		
		for (int i=0; i<6; i++) {
			if (matricePions[colonneClickee][i] == 0) {
				LigneAPeindre = i;
			}
			if (matricePions[colonneClickee][i] != 0) {
				break;
			}
		}
		
		result[0] = colonneClickee;
		result[1] = LigneAPeindre;
		System.out.println(Arrays.toString(result));
		return result;	
	}
	
	
	public int detecterGagnant(int[][] matricePions, int[] dernierPion) {
		int gagnant = 0;
		int rayonRecherche = 3;
		
		// A chaque coup, on remet le chrono a 0
		chrono.restart();
		
		
		int[] diagonaleTestee = new int[rayonRecherche*2 + 1];
		int indexDiagonaleTestee = 0;
		
		// CHECKER LA DIAGONALE DESCENDANTE //------------------------------------------	
		for (int i= -rayonRecherche; i<rayonRecherche+1; i++) {
			try {
				Integer caseDiagonale = matricePions[dernierPion[0]+i][dernierPion[1]+i];
				diagonaleTestee[indexDiagonaleTestee] = caseDiagonale.intValue();
			}
			catch (Exception e) {System.out.println("except.");}
			indexDiagonaleTestee += 1;
		}
		System.out.println("DIAG  " + Arrays.toString(diagonaleTestee));
		
		// On v�rifie si on a une s�rie de 4x le m�me pion dans cette diagonale obtenue
		int compteurSerie = 0;
		int pionDAvant = diagonaleTestee[0];
		
		// On parcours les �l�ments de la diagonale, gardant en m�moire toujours l'�l�ment actuel et celui d'avant
		for (int j=0; j<diagonaleTestee.length; j++) {
			Integer pionActuel = diagonaleTestee[j];
			
			// Si les 2 �l�ments sont des pions de m�me couleur, on augmente compteurSerie de 1
			if (pionActuel != 0 && pionActuel == pionDAvant) {compteurSerie +=1;}
			else {compteurSerie = 1;}	
			// Si compteurSerie est à 4, on a 4 pions de m�me couleur qui se suivent
			if (compteurSerie == 4) {
				gagnant = pionActuel.intValue();
//				System.out.println("WIN!!!!!!!!!!!!!!!!!!  " + gagnant);
				chrono.stop();
				return gagnant;
			}			
			// Le pion actuel devient le pion d'avant pour la prochaine it�ration
			pionDAvant = diagonaleTestee[j];
		}
		
		

		// CHECKER LA DIAGONALE ASCENDANTE //------------------------------------------
		diagonaleTestee = new int[rayonRecherche*2 + 1];
		indexDiagonaleTestee = 0;
		for (int i= -rayonRecherche; i<rayonRecherche+1; i++) {
			try {
				Integer caseDiagonale = matricePions[dernierPion[0]+i][dernierPion[1]-i];
				diagonaleTestee[indexDiagonaleTestee] = caseDiagonale.intValue();
			}
			catch (Exception e) {System.out.println("except.");}
			indexDiagonaleTestee += 1;
		}
		System.out.println("DIAG ASC  " + Arrays.toString(diagonaleTestee));
		
		// On v�rifie si on a une s�rie de 4x le m�me pion dans cette diagonale obtenue
		compteurSerie = 0;
		pionDAvant = diagonaleTestee[0];
		
		// On parcours les �l�ments de la diagonale, gardant en m�moire toujours l'�l�ment actuel et celui d'avant
		for (int j=0; j<diagonaleTestee.length; j++) {
			Integer pionActuel = diagonaleTestee[j];
			
			// Si les 2 �l�ments sont des pions de m�me couleur, on augmente compteurSerie de 1
			if (pionActuel != 0 && pionActuel == pionDAvant) {compteurSerie +=1;}
			else {compteurSerie = 1;}	
			// Si compteurSerie est à 4, on a 4 pions de m�me couleur qui se suivent
			if (compteurSerie == 4) {
				gagnant = pionActuel.intValue();
//				System.out.println("WIN ASC!!!!!!!!!!!!!!!!!!  " + gagnant);
				chrono.stop();
				return gagnant;
			}			
			// Le pion actuel devient le pion d'avant pour la prochaine it�ration
			pionDAvant = diagonaleTestee[j];
		}
		
		
		
		// CHECKER L' HORIZONTALE DU PION PLACE //------------------------------------------
		int[] horizontaleTestee = new int[rayonRecherche*2 + 1];
		int indexHorizontaleTestee = 0;
		for (int i= -rayonRecherche; i<rayonRecherche+1; i++) {
			try {
				Integer caseHorizontale = matricePions[dernierPion[0]+i][dernierPion[1]];
				horizontaleTestee[indexHorizontaleTestee] = caseHorizontale.intValue();
			}
			catch (Exception e) {System.out.println("except.");}
			indexHorizontaleTestee += 1;
		}
		System.out.println("HORIZONTALE  " + Arrays.toString(horizontaleTestee));
		
		// On v�rifie si on a une s�rie de 4x le m�me pion dans cette horizontale obtenue
		compteurSerie = 0;
		pionDAvant = horizontaleTestee[0];
		
		// On parcours les �l�ments de l'horizontale, gardant en m�moire toujours l'�l�ment actuel et celui d'avant
		for (int j=0; j<horizontaleTestee.length; j++) {
			Integer pionActuel = horizontaleTestee[j];
			
			// Si les 2 �l�ments sont des pions de m�me couleur, on augmente compteurSerie de 1
			if (pionActuel != 0 && pionActuel == pionDAvant) {compteurSerie +=1;}
			else {compteurSerie = 1;}	
			// Si compteurSerie est à 4, on a 4 pions de m�me couleur qui se suivent
			if (compteurSerie == 4) {
				gagnant = pionActuel.intValue();
//				System.out.println("WIN HORIZONTAL!!!!!!!!!!!!!!!!!!  " + gagnant);
				chrono.stop();
				return gagnant;
			}			
			// Le pion actuel devient le pion d'avant pour la prochaine it�ration
			pionDAvant = horizontaleTestee[j];
		}
		
		
		
		// CHECKER LA VERTICALE DU PION PLACE //------------------------------------------
		int[] verticaleTestee = new int[rayonRecherche*2 + 1];
		int indexVerticaleTestee = 0;
		for (int i= -rayonRecherche; i<rayonRecherche+1; i++) {
			try {
				Integer caseVerticale = matricePions[dernierPion[0]][dernierPion[1]+i];
				verticaleTestee[indexVerticaleTestee] = caseVerticale.intValue();
			}
			catch (Exception e) {System.out.println("except.");}
			indexVerticaleTestee += 1;
		}
		System.out.println("VERTICALE  " + Arrays.toString(verticaleTestee));
		
		// On v�rifie si on a une s�rie de 4x le m�me pion dans cette verticale obtenue
		compteurSerie = 0;
		pionDAvant = verticaleTestee[0];
		
		// On parcours les �l�ments de la verticale, gardant en m�moire toujours l'�l�ment actuel et celui d'avant
		for (int j=0; j<verticaleTestee.length; j++) {
			Integer pionActuel = verticaleTestee[j];
			
			// Si les 2 �l�ments sont des pions de m�me couleur, on augmente compteurSerie de 1
			if (pionActuel != 0 && pionActuel == pionDAvant) {compteurSerie +=1;}
			else {compteurSerie = 1;}	
			// Si compteurSerie est à 4, on a 4 pions de m�me couleur qui se suivent
			if (compteurSerie == 4) {
				gagnant = pionActuel.intValue();
//				System.out.println("WIN VERTICAL!!!!!!!!!!!!!!!!!!  " + gagnant);
				chrono.stop();
				return gagnant;
			}			
			// Le pion actuel devient le pion d'avant pour la prochaine it�ration
			pionDAvant = verticaleTestee[j];
		}
		
		
	return gagnant;
	}
	
	
}
