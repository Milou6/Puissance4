import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Chrono {
	// L'objet Timer en soi
	Timer timer;
	// Le label qui affiche le temps du timer sur l' �cran
	JLabel timerText;
	// La variable qui permet de mettre � jour l'affichage
	int seconds;
	int joueurActuel;
	boolean paused;

	public Chrono(JLabel timerText, int joueurActuel) {
		// delay d�termine �quelle fr�quence (en ms) le Timer active l' ActionListener
		int delay = 1000;
		this.seconds = 1;
		this.timerText = timerText;
		this.joueurActuel = joueurActuel;
		this.paused = false;

		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				// Si le joueur a pas encore fait de coup apr�s 20s, il perd
				if (seconds == 20) {
					timer.stop();
					String gagnant = "";
					if (getJoueurActuel() == 1) {gagnant = "JAUNE";}
					else {gagnant = "BLEU";}
					final JComponent[] inputs = new JComponent[] {
						new JLabel("Temps écoulé!"),
						new JLabel("Joueur " + gagnant + " gagne.")
					};
					int result = JOptionPane.showConfirmDialog(null, inputs, "FIN DE PARTIE", JOptionPane.PLAIN_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						System.out.println("END");
						System.exit(0);
					}
					else {
						System.out.println("END");
					}
				}

				// Toutes les secondes, on met � jour l'affichage du JLabel
				timerText.setText(seconds + ".00");
				seconds += 1;
				timerText.repaint();
			}
		};

		// On cr�e le Timer et on lui rajoute l'ActionListener
		timer = new Timer(delay, taskPerformer);
		timer.start();

	}


	// A chaque coup, on remet le chrono a 0
	public void restart() {
		timerText.setText("0.00");
		timer.restart();
		timerText.repaint();
		seconds = 1;
		
		if (joueurActuel == 1) {joueurActuel = 2;}
		else {joueurActuel = 1;}
		System.out.println("joueurActuel " + joueurActuel);
	}
	
	public void stop() {
		timer.stop();
		paused = true;
	}
	
	public void reprendre() {
		timer.start();
		paused = false;
	}

	public int getJoueurActuel() {
		return this.joueurActuel;
	}


















}






