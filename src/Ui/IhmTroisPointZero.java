/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Joueur;
import Jeu.Controleur;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;



/**
 *
 * @author Maxence
 */
public class IhmTroisPointZero extends JFrame implements Observateur {
    
    private Controleur controleur;
    private JButton inscrireJoueur;
    private JButton demarrerPartie;
    private JButton quitter;
    private ArrayList<String> nomJs;
   
    
     public IhmTroisPointZero(Controleur controleur){
        this.controleur = controleur;
        controleur.setObservateur(this);
        
        nomJs = new ArrayList<>();        
        afficherMenu();
        
        inscrireJoueur.addMouseListener( new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nomJs.clear();
                String[] nbJoueur =  {"2","3","4","5","6"};
                JOptionPane jopNombreJoueur = new JOptionPane();
                
                String nbJ = (String)jopNombreJoueur.showInputDialog(null,
                  " Etape 1 - Veuillez selectionner le nombre de joueur !",
                  " Etape 1 - Selection du nombre de joueur ",
                  JOptionPane.QUESTION_MESSAGE,
                  null,
                  nbJoueur,
                  nbJoueur[0]);
                if(nbJ != null){
                    for(int i = 1; i <= Integer.parseInt(nbJ); i++){
                        JOptionPane jopNomJoueurs = new JOptionPane();
                        String nom = jopNomJoueurs.showInputDialog(null,
                                "Etape 2 - Veuillez Saisir le nom du joueur n° "+i,
                                "Etape 2 - Saisir le nom du joueur",
                                JOptionPane.QUESTION_MESSAGE);
                        JOptionPane jopErreurSaisie = new JOptionPane();
                        if(nom == null){                            
                                jopErreurSaisie.showMessageDialog(null,
                                "Erreur  saisie vide, recommencez",
                                "Erreur de saisie, recommencez" ,
                                JOptionPane.WARNING_MESSAGE);                       
                                i--;
                        }else{
                            if(!(nomJs.contains(nom) || nom.equals(""))){//|| nom.equals("")s
                              nomJs.add(nom);
                            }else{
                                jopErreurSaisie.showMessageDialog(null,
                                "Erreur nom déjà saisie ou vide, recommencez",
                                "Erreur de saisie, recommencez" ,
                                JOptionPane.WARNING_MESSAGE);                       
                                i--;
                            }     
                        }
                        
                                                   
                    }
                        
                    
                    
                    JOptionPane jopVerification = new JOptionPane();
                    String listeNom = " ";
                    for(String nom : nomJs ){
                        listeNom += "\n" + " - "+nom;
                    }
                    jopVerification.showMessageDialog(null,
                            "Les joueurs sont :  "+listeNom ,
                            "Etapes 3 - Verification des noms" ,
                            JOptionPane.INFORMATION_MESSAGE);                    
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}            
            @Override
            public void mouseExited(MouseEvent e) {}           
        });
        demarrerPartie.addMouseListener(new MouseListener(
        ) {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(nomJs != null){
                    controleur.inscrireJoueurs(nomJs);
                    IhmPlateau plateau = new IhmPlateau(controleur);
                    
                }
                
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        
        quitter.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
              System.exit(0);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        
        
    }
    
     public void afficherMenu(){
        this.setLayout(new BorderLayout());
        JPanel center = new JPanel();        
        center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
       
        
        JPanel logo = new JPanel();
        JLabel image = new JLabel( new ImageIcon( "src\\baniere.png"));
        logo.add(image);
        
        
        
  
        
        inscrireJoueur = new JButton("Inscrire Joueur");   
        inscrireJoueur.setMaximumSize(new Dimension(200,40));
        inscrireJoueur.setAlignmentX(center.CENTER_ALIGNMENT);
        
        
        
        demarrerPartie = new JButton("Demarrer Partie");  
        demarrerPartie.setMaximumSize(new Dimension(200,40));
        demarrerPartie.setAlignmentX(center.CENTER_ALIGNMENT);
        
        quitter = new JButton("Quitter");         
        quitter.setMaximumSize(new Dimension(200,40));
        quitter.setAlignmentX(center.CENTER_ALIGNMENT);
         
        center.add(Box.createRigidArea(new Dimension(0,10)));
        center.add(inscrireJoueur);
        center.add(Box.createRigidArea(new Dimension(0,10)));
        center.add(demarrerPartie);
        center.add(Box.createRigidArea(new Dimension(0,10)));
        center.add(quitter);   
        center.add(Box.createRigidArea(new Dimension(0,10)));
        
      
        
        this.add(logo,BorderLayout.NORTH);
        this.add(center,BorderLayout.CENTER);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      
     }  
    
     private void afficher() {
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setSize(850, 400);
        setVisible(true);                        
    }
    @Override
    public Message notifier(Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args){
        Controleur controleur = new Controleur();
        IhmTroisPointZero ihm = new IhmTroisPointZero(controleur);     
        ihm.afficher();
    }

    
}
