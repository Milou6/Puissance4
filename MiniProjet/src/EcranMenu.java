import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EcranMenu extends JPanel {
	public EcranMenu() {
		setLayout(new MigLayout("", "[grow,center]", "[grow][][][grow]"));

		JLabel lblTitre = new JLabel("Puissance 4 : Le Jeu");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Stencil", Font.PLAIN, 42));
		add(lblTitre, "cell 0 0,grow");
		
		JButton btnDemmarer = new JButton("D\u00E9mmarer la partie");
		btnDemmarer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("oui");
			}
		});
		btnDemmarer.setFont(new Font("Stencil", Font.PLAIN, 16));
		add(btnDemmarer, "cell 0 1,alignx center");
		
		JButton btnQuitter = new JButton("Quitter");
		btnDemmarer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(ABORT);
			}
		});
		btnQuitter.setFont(new Font("Stencil", Font.PLAIN, 16));
		add(btnQuitter, "cell 0 2,alignx center");
	}

}
