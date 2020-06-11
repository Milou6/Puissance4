import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
 
public class ControleurPartie extends JFrame implements ActionListener{

	private JButton button1;
	private JButton button2;
	
	public ControleurPartie(){                
	    this.setTitle("Mon Puissance 4");
	    this.setSize(800, 600);
	    this.setLocationRelativeTo(null); //center the window       
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit when window is closed
	    
	    
//	    Grille grilleJeu = new Grille();
//	    this.setContentPane(grilleJeu);
//	    
//	    grilleJeu.setLayout(new FlowLayout());
	  
	    ControleurGrille EcranJeu = new ControleurGrille();

	
//	    this.setVisible(true);
	}
  
  public void actionPerformed(ActionEvent e) {
	  Object src = e.getSource();
	  if(src == button1){
		  System.out.println("Click button1");
	  }
	  else if(src == button2){
//		  System.out.println("Load another Pane");
//		  Panel2 pan = new Panel2();
//		  this.setContentPane(pan);
//		  this.repaint();
//		  this.revalidate();//tell the layout manager to recalculate the layout
	  }
  }
}