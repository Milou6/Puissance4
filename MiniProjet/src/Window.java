import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
 
public class Window extends JFrame implements ActionListener{
	private JButton btnDemarer;
	private JButton btnQuitter;
	private JButton btnAide;
	private JButton btnAbandon;
	private JPanel pnlMenu;
	private JPanel pnlGrille;
	private JLabel lblTimerRest;
	private JLabel timer;
	private EcranGrille grid;
	
	public Window(){                
	    this.setTitle("Mon Puissance 4");
	    this.setSize(800, 494);
	    this.setLocationRelativeTo(null); //center the window       
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit when window is closed
	 
	    pnlMenu = new JPanel();
	    this.setContentPane(pnlMenu);
	    GridBagLayout gbl_pnlMenu = new GridBagLayout();
	    gbl_pnlMenu.columnWidths = new int[]{782, 0};
	    gbl_pnlMenu.rowHeights = new int[]{202, 25, 25, 0};
	    gbl_pnlMenu.columnWeights = new double[]{0.0, Double.MIN_VALUE};
	    gbl_pnlMenu.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	    pnlMenu.setLayout(gbl_pnlMenu);
	    
	    btnQuitter = new JButton("Quitter");
	    btnQuitter.addActionListener(this);
	    
	    
	    btnDemarer = new JButton("D\u00E9marer la partie");
	    btnDemarer.addActionListener(this);
	    
	    JLabel lblTitre = new JLabel("Puissance 4 : Le Jeu");
	    lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTitre.setFont(new Font("Stencil", Font.PLAIN, 42));
	    GridBagConstraints gbc_lblTitre = new GridBagConstraints();
	    gbc_lblTitre.fill = GridBagConstraints.BOTH;
	    gbc_lblTitre.insets = new Insets(0, 0, 5, 0);
	    gbc_lblTitre.gridx = 0;
	    gbc_lblTitre.gridy = 0;
	    getContentPane().add(lblTitre, gbc_lblTitre);
	    btnDemarer.setFont(new Font("Stencil", Font.PLAIN, 16));
	    GridBagConstraints gbc_btnDemarer = new GridBagConstraints();
	    gbc_btnDemarer.anchor = GridBagConstraints.NORTH;
	    gbc_btnDemarer.insets = new Insets(0, 0, 5, 0);
	    gbc_btnDemarer.gridx = 0;
	    gbc_btnDemarer.gridy = 1;
	    getContentPane().add(btnDemarer, gbc_btnDemarer);
	    btnQuitter.setFont(new Font("Stencil", Font.PLAIN, 16));
	    GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
	    gbc_btnQuitter.anchor = GridBagConstraints.NORTH;
	    gbc_btnQuitter.gridx = 0;
	    gbc_btnQuitter.gridy = 2;
	    getContentPane().add(btnQuitter, gbc_btnQuitter);
		
		btnAbandon = new JButton("Abandonner");
		btnAbandon.addActionListener(this);
		
		btnAide = new JButton("Aide");
		btnAide.addActionListener(this);
	  	
	}


	public void actionPerformed(ActionEvent e) {
	  	Object src = e.getSource();
	  	System.out.println("Something Append");
	  	if(src == btnDemarer ){
		  	System.out.println("Démarage du jeu");
		  	//création de la grille de jeu
		  
		  	//création d'un timer et d'un Label pour le timer
		  	timer = new JLabel("0.00");
		  	timer.setFont(new Font("Stencil", Font.BOLD, 16));  	
		  	grid = new EcranGrille(timer);	
		  	
		  	pnlGrille = new JPanel();
			this.setBounds(100, 100, 800, 670);
			this.setContentPane(pnlGrille);
			GridBagLayout gbl_pnlGrille = new GridBagLayout();
			gbl_pnlGrille.columnWidths = new int[]{67, 36, 260, 67, 330, 0};
			gbl_pnlGrille.rowHeights = new int[]{557, 25, 0};
			gbl_pnlGrille.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pnlGrille.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			pnlGrille.setLayout(gbl_pnlGrille);    
		    		
    		//on ajoute la grille de jeu
    		JPanel pnlGrid = new JPanel();
    		pnlGrid.setLayout(new BorderLayout());
    		pnlGrid.add(grid);
    		GridBagConstraints gbc_pnlGrid = new GridBagConstraints();
    		gbc_pnlGrid.fill = GridBagConstraints.BOTH;
    		gbc_pnlGrid.insets = new Insets(0, 0, 5, 0);
    		gbc_pnlGrid.gridwidth = 5;
    		gbc_pnlGrid.gridx = 0;
    		gbc_pnlGrid.gridy = 0;
    		pnlGrille.add(pnlGrid, gbc_pnlGrid);
		    		
			grid.setVisible(true);
		  	
		    lblTimerRest = new JLabel("TEMPS :");
		    lblTimerRest.setFont(new Font("Stencil", Font.BOLD, 16));
		    GridBagConstraints gbc_lblTimerRest = new GridBagConstraints();
		    gbc_lblTimerRest.anchor = GridBagConstraints.WEST;
		    gbc_lblTimerRest.fill = GridBagConstraints.VERTICAL;
		    gbc_lblTimerRest.insets = new Insets(0, 0, 0, 5);
		    gbc_lblTimerRest.gridx = 0;
		    gbc_lblTimerRest.gridy = 1;
		    pnlGrille.add(lblTimerRest, gbc_lblTimerRest);
			
			//création d'un timer et d'un Label pour le timer	
		  	GridBagConstraints gbc_timer = new GridBagConstraints();
		  	gbc_timer.anchor = GridBagConstraints.WEST;
		  	gbc_timer.fill = GridBagConstraints.VERTICAL;
		  	gbc_timer.insets = new Insets(0, 0, 0, 5);
		  	gbc_timer.gridx = 1;
		  	gbc_timer.gridy = 1;
		  	pnlGrille.add(timer, gbc_timer);
			
			btnAide = new JButton("Aide");
			btnAide.setFont(new Font("Stencil", Font.PLAIN, 16));
			btnAide.addActionListener(this);
			
			GridBagConstraints gbc_btnAide = new GridBagConstraints();
			gbc_btnAide.anchor = GridBagConstraints.NORTHEAST;
			gbc_btnAide.insets = new Insets(0, 0, 0, 5);
			gbc_btnAide.gridx = 3;
			gbc_btnAide.gridy = 1;
			getContentPane().add(btnAide, gbc_btnAide);
		    
		    btnAbandon = new JButton("Abandonner");
		    btnAbandon.setFont(new Font("Stencil", Font.PLAIN, 16));
		    btnAbandon.addActionListener(this);
		    GridBagConstraints gbc_btnAbandon = new GridBagConstraints();
		    gbc_btnAbandon.anchor = GridBagConstraints.NORTHWEST;
		    gbc_btnAbandon.gridx = 4;
		    gbc_btnAbandon.gridy = 1;
		    getContentPane().add(btnAbandon, gbc_btnAbandon);
		  
			this.repaint();
			this.revalidate();//tell the layout manager to recalculate the layout
	  	}
	  	else if(src == btnQuitter){
	  		System.exit(ABORT);
	  	}
	  	else if(src == btnAide) {
		  	//stopper chrono
	  
	  	}
	  	else if(src == btnAbandon) {
	  		System.out.println("Partie Abondonnée");
	  		this.setContentPane(pnlMenu);
	  		this.repaint();
	  		this.revalidate();//tell the layout manager to recalculate the layout
	  	}
	}
}