import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
 
public class Window extends JFrame implements ActionListener{
	private JButton btnDemarer;
	private JButton btnQuitter;
//	static JLabel timer;
	
	public Window(){                
	    this.setTitle("Mon Puissance 4");
	    this.setSize(800, 494);
	    this.setLocationRelativeTo(null); //center the window       
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit when window is closed
	    this.setLayout(new MigLayout("", "[grow,center]", "[grow][][][grow]"));
	    
	    JPanel pnlMenu = new JPanel();
	    this.setContentPane(pnlMenu);
	    
	    setLayout(new MigLayout("", "[grow,center]", "[grow][][][grow]"));
	    
	    JLabel lblTitre = new JLabel("Puissance 4 : Le Jeu");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Stencil", Font.PLAIN, 42));
		add(lblTitre, "cell 0 0,grow");
		
		
		btnDemarer = new JButton("D\u00E9marer la partie");
	    btnDemarer.addActionListener(this);
	    btnDemarer.setFont(new Font("Stencil", Font.PLAIN, 16));
		add(btnDemarer, "cell 0 1,alignx center");
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(this);
		btnQuitter.setFont(new Font("Stencil", Font.PLAIN, 16));
		add(btnQuitter, "cell 0 2,alignx center");
		
	   //ControleurGrille ControleJeu = new ControleurGrille();
	   //pnlGrille = new EcranGrille(ControleJeu);
	   // EcranGrille pnlGrille = new EcranGrille(EcranJeu);
	    
	
//	    this.setVisible(true);
	}


  public void actionPerformed(ActionEvent e) {
	  Object src = e.getSource();
	  System.out.println("Something Append");
	  if(src == btnDemarer ){
		  System.out.println("Démarage du jeu");
		  //création de la grille de jeu
		  JPanel pnlGrille = new JPanel();
		  EcranGrille grid = new EcranGrille();	  
		  this.setBounds(100, 100, 800, 610);
		  this.setContentPane(pnlGrille);
		  this.setLayout(new BorderLayout());
		  
		  // On crée un JLabel qui affiche le timer
		  JLabel timer = new JLabel("0.00");
		  timer.setFont(new Font("Arial", Font.BOLD, 20));	  
//		  this.chrono = new Chrono(timer);
		  
		  //on ajoute la grille de jeu
		  add(grid, BorderLayout.CENTER);
		  add(timer, BorderLayout.PAGE_END);
		  grid.setVisible(true);
		  
		  this.repaint();
		  this.revalidate();//tell the layout manager to recalculate the layout
	  }
	  else if(src == btnQuitter){
		  System.exit(ABORT);
	  }
  }
}