import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
 
public class Window extends JFrame implements ActionListener{

	private JButton button1;
	private JButton button2;
	
	public Window(){                
	    this.setTitle("Mon Puissance 4");
	    this.setSize(800, 600);
	    this.setLocationRelativeTo(null); //center the window       
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit when window is closed
	    Grille grilleJeu = new Grille();
	    this.setContentPane(grilleJeu);
	    
	    grilleJeu.setLayout(new FlowLayout());
	  
//		this.button1 = new JButton("Button1");
//		this.button1.addActionListener(this);
//		pan.add(this.button1);
//	
//		this.button2 = new JButton("Button2");
//		this.button2.addActionListener(this);
//		pan.add(this.button2);
	
	    this.setVisible(true);
	}
  
  public void actionPerformed(ActionEvent e) {
	  Object src = e.getSource();
	  if(src == button1){
		  System.out.println("Click button1");
	  }
	  else if(src == button2){
		  System.out.println("Load another Pane");
		  Panel2 pan = new Panel2();
		  this.setContentPane(pan);
		  this.repaint();
		  this.revalidate();//tell the layout manager to recalculate the layout
	  }
  }
}