import java.util.Arrays;

public class Aligneur {
	Grille grid;
	
	public Aligneur(Grille grid) {
		this.grid = grid;
	}

	public int[] getSquareToPaint(int x, int y, int[][] matricePions) {
		int panelWidth = grid.getWidth();
		int panelHeight = grid.getHeight();
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
		
		// On vérifie si on a une série de 4x le même pion dans cette diagonale obtenue
		int compteurSerie = 0;
		int pionDAvant = diagonaleTestee[0];
		
		// On parcours les éléments de la diagonale, gardant en mémoire toujours l'élément actuel et celui d'avant
		for (int j=0; j<diagonaleTestee.length; j++) {
			Integer pionActuel = diagonaleTestee[j];
			
			// Si les 2 éléments sont des pions de même couleur, on augmente compteurSerie de 1
			if (pionActuel != 0 && pionActuel == pionDAvant) {compteurSerie +=1;}
			else {compteurSerie = 1;}	
			// Si compteurSerie est à 4, on a 4 pions de même couleur qui se suivent
			if (compteurSerie == 4) {
				gagnant = pionActuel.intValue();
				System.out.println("WIN!!!!!!!!!!!!!!!!!!  " + gagnant);
				return gagnant;
			}			
			// Le pion actuel devient le pion d'avant pour la prochaine itération
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
		
		// On vérifie si on a une série de 4x le même pion dans cette diagonale obtenue
		compteurSerie = 0;
		pionDAvant = diagonaleTestee[0];
		
		// On parcours les éléments de la diagonale, gardant en mémoire toujours l'élément actuel et celui d'avant
		for (int j=0; j<diagonaleTestee.length; j++) {
			Integer pionActuel = diagonaleTestee[j];
			
			// Si les 2 éléments sont des pions de même couleur, on augmente compteurSerie de 1
			if (pionActuel != 0 && pionActuel == pionDAvant) {compteurSerie +=1;}
			else {compteurSerie = 1;}	
			// Si compteurSerie est à 4, on a 4 pions de même couleur qui se suivent
			if (compteurSerie == 4) {
				gagnant = pionActuel.intValue();
				System.out.println("WIN ASC!!!!!!!!!!!!!!!!!!  " + gagnant);
				return gagnant;
			}			
			// Le pion actuel devient le pion d'avant pour la prochaine itération
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
		
		// On vérifie si on a une série de 4x le même pion dans cette horizontale obtenue
		compteurSerie = 0;
		pionDAvant = horizontaleTestee[0];
		
		// On parcours les éléments de l'horizontale, gardant en mémoire toujours l'élément actuel et celui d'avant
		for (int j=0; j<horizontaleTestee.length; j++) {
			Integer pionActuel = horizontaleTestee[j];
			
			// Si les 2 éléments sont des pions de même couleur, on augmente compteurSerie de 1
			if (pionActuel != 0 && pionActuel == pionDAvant) {compteurSerie +=1;}
			else {compteurSerie = 1;}	
			// Si compteurSerie est à 4, on a 4 pions de même couleur qui se suivent
			if (compteurSerie == 4) {
				gagnant = pionActuel.intValue();
				System.out.println("WIN HORIZONTAL!!!!!!!!!!!!!!!!!!  " + gagnant);
				return gagnant;
			}			
			// Le pion actuel devient le pion d'avant pour la prochaine itération
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
		
		// On vérifie si on a une série de 4x le même pion dans cette verticale obtenue
		compteurSerie = 0;
		pionDAvant = verticaleTestee[0];
		
		// On parcours les éléments de la verticale, gardant en mémoire toujours l'élément actuel et celui d'avant
		for (int j=0; j<verticaleTestee.length; j++) {
			Integer pionActuel = verticaleTestee[j];
			
			// Si les 2 éléments sont des pions de même couleur, on augmente compteurSerie de 1
			if (pionActuel != 0 && pionActuel == pionDAvant) {compteurSerie +=1;}
			else {compteurSerie = 1;}	
			// Si compteurSerie est à 4, on a 4 pions de même couleur qui se suivent
			if (compteurSerie == 4) {
				gagnant = pionActuel.intValue();
				System.out.println("WIN VERTICAL!!!!!!!!!!!!!!!!!!  " + gagnant);
				return gagnant;
			}			
			// Le pion actuel devient le pion d'avant pour la prochaine itération
			pionDAvant = verticaleTestee[j];
		}
		
		
	return gagnant;
	}
	
	
}
