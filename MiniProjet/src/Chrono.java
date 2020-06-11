import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Chrono {
	// L'objet Timer en soi
	Timer timer;
	// Le label qui affiche le temps du timer sur l' écran
	JLabel timerText;
	// La variable qui permet de mettre à jour l'affichage
	int seconds;

	public Chrono(JLabel timerText) {
		// delay détermine à quelle fréquence (en ms) le Timer active l' ActionListener
		int delay = 1000;
		this.seconds = 1;
		this.timerText = timerText;

		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				// Si le joueur a pas encore fait de coup après 20s, il perd
				if (seconds == 20) {
					System.out.println("LOSEEE");
				}

				// Toutes les secondes, on met à jour l'affichage du JLabel
				timerText.setText(seconds + ".00");
				seconds += 1;
				timerText.repaint();
			}
		};

		// On crée le Timer et on lui rajoute l'ActionListener
		timer = new Timer(delay, taskPerformer);
		timer.start();

	}


	// A chaque coup, on remet le chrono a 0
	public void restart() {
		timerText.setText("0.00");
		timer.restart();
		timerText.repaint();
		seconds = 1;
	}



















}






