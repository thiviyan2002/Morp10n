package Morpion;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.*;

public class morpion extends JFrame implements ActionListener {
	
        /*ImageIcon logo = new ImageIcon("logo morpion.png");*/
        ImageIcon logo = new ImageIcon(getClass().getResource("logomorpion.png"));
        
	    private JLabel label = new JLabel("jeu du morpion");
	    private JMenuItem nouveau,quitter,aide;
	    private JMenuBar menu;
	    private JMenu fichier,help;
	    private JButton[] b =new JButton[9];
	     /*String myChoice = JOptionPane.showInputDialog(panel, "Faites votre choix:");*/
	    
	    private String Oname = JOptionPane.showInputDialog(this, "Bonjour, donnez nom du joueur O:");
	    private String Xname = JOptionPane.showInputDialog(this, "Et donnez nom du joueur X:");
	    
	    private int tableau[]= new int[10];
	    private boolean tab[]= new boolean[10];
	    private boolean qui= false;
	     
	    private String messageO= Oname + " gagne";
	    private String messageX= Xname + " gagne";
	    private String messageHelp="Joueur O: "+Oname+"; Joueur X: "+Xname+". O: blanc X: noir";
	     
	    public morpion(){
	         
	        Container c= getContentPane();
	        c.setLayout(new GridLayout(3,3,5,5));
	        
	        JFrame jf =new JFrame();
	        jf.setSize(500,300);
	        jf.setResizable(false);
	        jf.setLocationRelativeTo(null);
	        jf.setTitle("morpion");
	        
	        jf.setIconImage(logo.getImage());
	         
	        menu = new JMenuBar();
	        fichier = new JMenu("fichier");
	        help = new JMenu("help");
	        nouveau = new JMenuItem("nouveau");
	        nouveau.addActionListener(this);
	        quitter = new JMenuItem("quitter");
	        quitter.addActionListener(this);
	        aide= new JMenuItem("?");
	        aide.addActionListener(this);
	        fichier.add(nouveau);
	        fichier.add(quitter);
	        help.add(aide);
	        menu.add(fichier);
	        menu.add(help);
	        setJMenuBar(menu);
	        /*Oname = JOptionPane.showInputDialog(this, "Donnez nom du joueur O:");
	        Xname = JOptionPane.showInputDialog(this, "Donnez nom du joueur X:");*/
	        for(int i=0;i<b.length;i++){
	            b[i]=new JButton("");
	            b[i].setPreferredSize(new Dimension(100,50));
	            c.add(b[i]);
	            b[i].addActionListener(this);
	        }
	        label.setPreferredSize(new Dimension (100,90));
	        label.setHorizontalAlignment(SwingConstants.CENTER);
	         
	        jf.add(c,BorderLayout.CENTER);
	        jf.add(label,BorderLayout.NORTH);
	        jf.add(menu,BorderLayout.NORTH);
	         
	        jf.setVisible(true);
	         
	    }
    
	public static void main (String args[])
	{
		morpion morp = new morpion(); 
	}
	public void nouveauJeu(){
        for(int i=0;i<9;i++){
            tab[i]=false;
            tableau[i]=0;
            b[i].setIcon(null);
        }
    }
    public void texthelp(){
    JOptionPane.showMessageDialog(null, messageHelp,"AIDE",JOptionPane.INFORMATION_MESSAGE);
     
    }
    public boolean verifie(){
        boolean a= false;
         
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
        )
            a=true;
        return a;
             
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==nouveau)nouveauJeu();
        if(e.getSource()==quitter)System.exit(0);
        if(e.getSource()==aide)texthelp();
         
        
        for(int j=0;j<9;j++)
            if(e.getSource()==b[j]){
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
                    if(verifie()==true){
                        if(qui==true)
                            JOptionPane.showMessageDialog(null, messageO,"gagner",JOptionPane.INFORMATION_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null, messageX,"gagner",JOptionPane.INFORMATION_MESSAGE);
                        if(JOptionPane.showConfirmDialog(null, "other game?","Morpion",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                            nouveauJeu();
                        else
                            System.exit(0);
                             
                    }
                    qui=!qui;
                }
                else
                    JOptionPane.showMessageDialog(null, "other case","Erreur",JOptionPane.ERROR_MESSAGE);
            }
             
         
    }
     
	
}
