import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.*;

public class Morp10n extends JFrame implements ActionListener {
	
        /*ImageIcon logo = new ImageIcon("logo morpion.png");*/
        ImageIcon logo = new ImageIcon(getClass().getResource("logomorpion.png"));
        
	    private JLabel label = new JLabel("jeu du morpion");
	    private JMenuBar menu;
	    private JMenu fichier,aide;
	    private JMenuItem nouveau,quitter,info_perso,aide_jeu;
	   
	    private String Xname = JOptionPane.showInputDialog(this, "Bonjour, donnez nom du joueur X:");
	    private String Oname = JOptionPane.showInputDialog(this, "Et donnez nom du joueur O:");
	    
	    private JButton[] b =new JButton[9];
	    private int tableau[]= new int[10];
	    private boolean tab[]= new boolean[10];
	    private boolean qui= false;
	    
	    //private String messageHelp="Joueur O: "+Oname+"; Joueur X: "+Xname+". O: blanc X: noir";
	    private String messageHelp="Le morpion est un jeu de réflexion se pratiquant à deux joueurs au tour par tour et dont le but est de créer le premier un alignement sur une grille.";
	     
	    public Morp10n(){
	         
	        Container c= getContentPane();
	        c.setLayout(new GridLayout(3,3,5,5));
	        
	        JFrame jf =new JFrame();
	        jf.setSize(500,300);
	        jf.setResizable(false);
	        jf.setLocationRelativeTo(null);
	        jf.setTitle("Morp10n");
	        
	        jf.setIconImage(logo.getImage());
	         
	        menu = new JMenuBar();
	        fichier = new JMenu("fichier");
	        aide = new JMenu("aide");
	        
	        nouveau = new JMenuItem("nouveau");
	        nouveau.addActionListener(this);
	        quitter = new JMenuItem("quitter");
	        quitter.addActionListener(this);
	        
	        info_perso = new JMenuItem("info perso");
	        info_perso.addActionListener(this);
	        aide_jeu = new JMenuItem("aide jeu");
	        aide_jeu.addActionListener(this);
	        
	        fichier.add(nouveau);
	        fichier.add(quitter);
	        
	        aide.add(info_perso);
	        aide.add(aide_jeu);
	        
	        menu.add(fichier);
	        menu.add(aide);
	        setJMenuBar(menu);
	        
	        
	        for(int i=0;i<b.length;i++){
	            b[i]=new JButton("");
	            b[i].setPreferredSize(new Dimension(100,50));
	            c.add(b[i]);
	            b[i].addActionListener(this);
	        }
	        //label.setPreferredSize(new Dimension (100,90));
	        //label.setHorizontalAlignment(SwingConstants.CENTER);
	         
	        jf.add(c,BorderLayout.CENTER);
	        jf.add(label,BorderLayout.NORTH);
	        jf.add(menu,BorderLayout.NORTH);
	        
	        jf.setVisible(true);
	         
	    }
    
	public static void main (String args[])
	{
		Morp10n morp = new Morp10n(); 
	}
	
	public void nouveauJeu(){
        for(int i=0;i<9;i++){
            tab[i]=false;
            tableau[i]=0;
            b[i].setIcon(null);
        }
    }
	/*public void textinfoperso(){
	    JOptionPane.showMessageDialog(null, messageHelp,"AIDE",JOptionPane.INFORMATION_MESSAGE);
	}*/
	public void texthelp(){
		JOptionPane.showMessageDialog(null, messageHelp,"AIDE",JOptionPane.INFORMATION_MESSAGE);
	}
	public void textinfo(){
	    JOptionPane.showMessageDialog(null, "Joueur O: "+Oname+"; Joueur X: "+Xname,"AIDE",JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//this.label.setText("bonjour");
		if(e.getSource()==nouveau)nouveauJeu();
		if(e.getSource()==quitter)System.exit(0);//this.dispose();
		if(e.getSource()==aide_jeu)texthelp();
		if(e.getSource()==info_perso)textinfo();
		
		for(int j=0;j<9;j++) 
           if(e.getSource()==b[j]){
        	   //b[j].setIcon(new ImageIcon(getClass().getResource("iconX.png")));
                if(tab[j]==false){
                    tab[j]=true;
                    if(qui==false)
                    {
                        setTitle("Joueur O");
                        b[j].setIcon(new ImageIcon(getClass().getResource("iconX.png")));
                        tableau[j]=1;
                    }
                    else{
                        setTitle("Joueur X");
                        b[j].setIcon(new ImageIcon(getClass().getResource("iconO.png")));
                        tableau[j]=2;
                    }
                    if(
                    		(tableau[0]==1 && tableau[1]==1 && tableau[2]==1) ||
                            (tableau[0]==2 && tableau[1]==2 && tableau[2]==2) ||
                             
                            (tableau[3]==1 && tableau[4]==1 && tableau[5]==1) ||
                            (tableau[3]==2 && tableau[4]==2 && tableau[5]==2) ||
                             
                            (tableau[6]==1 && tableau[7]==1 && tableau[8]==1) ||
                            (tableau[6]==2 && tableau[7]==2 && tableau[8]==2) ||
                             
                            (tableau[0]==1 && tableau[3]==1 && tableau[6]==1) ||
                            (tableau[0]==2 && tableau[3]==2 && tableau[6]==2) ||
                             
                            (tableau[1]==1 && tableau[4]==1 && tableau[7]==1) ||
                            (tableau[1]==2 && tableau[4]==2 && tableau[7]==2) ||
                             
                            (tableau[2]==1 && tableau[5]==1 && tableau[8]==1) ||
                            (tableau[2]==2 && tableau[5]==2 && tableau[8]==2) ||
                             
                            (tableau[0]==1 && tableau[4]==1 && tableau[8]==1) ||
                            (tableau[0]==2 && tableau[4]==2 && tableau[8]==2) ||
                             
                            (tableau[2]==1 && tableau[4]==1 && tableau[6]==1) ||
                            (tableau[2]==2 && tableau[4]==2 && tableau[6]==2)
                    ){
                        if(qui==false)
                            JOptionPane.showMessageDialog(null, Xname+" a gagner","gagner",JOptionPane.INFORMATION_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null, Oname+" a gagner","gagner",JOptionPane.INFORMATION_MESSAGE);
                        if(JOptionPane.showConfirmDialog(null, "Nouvelle partie ?","Morpion",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                            nouveauJeu();
                        else
                            System.exit(0);
                             
                    }
                    qui=!qui;
                }
                else JOptionPane.showMessageDialog(null, "Choisisez une autre case svp","Erreur",JOptionPane.ERROR_MESSAGE);
            }
        
	}

	
	
     
	
}
