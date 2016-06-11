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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
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
public class IhmTroisPointZero extends JFrame {
    
    private Controleur controleur;
    private JButton inscrireJoueur;
    private JButton demarrerPartie;
    private JButton quitter;
    private JButton validerInscription;
    private ArrayList<String> nomJs;
    private HashMap<String, Image> pionJs;
    private IhmInscriptionJoueurs ihmIJ;
   
    
     public IhmTroisPointZero(Controleur controleur){
        this.controleur = controleur;
        //controleur.setObservateur(this);
        
        afficherMenu();
        
        ihmIJ = new IhmInscriptionJoueurs();
        validerInscription = new JButton("Valider Inscription");        
        ihmIJ.add(validerInscription, BorderLayout.SOUTH);
        validerInscription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ihmIJ.verification()){
                    nomJs = ihmIJ.getJoueurs();
                    pionJs = ihmIJ.getPions();
                    ihmIJ.setVisible(false);
                    demarrerPartie.setEnabled(true);
                }
            }
        });
        
        inscrireJoueur.addMouseListener( new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ihmIJ.setVisible(true);               
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
        demarrerPartie.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(nomJs.size() != 0){
                    controleur.inscrireJoueurs(nomJs, pionJs);
                    IhmPlateau ihmPlateau = new IhmPlateau(controleur);   
                    setVisible(false);
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
        JLabel image = new JLabel( new ImageIcon( "src/baniere.png"));
        logo.add(image);
  
        
        inscrireJoueur = new JButton("Inscrire Joueur");   
        inscrireJoueur.setMaximumSize(new Dimension(200,40));
        inscrireJoueur.setAlignmentX(center.CENTER_ALIGNMENT);
        
        
        
        demarrerPartie = new JButton("Demarrer Partie"); 
        demarrerPartie.setMaximumSize(new Dimension(200,40));
        demarrerPartie.setEnabled(false);
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
  /*  @Override
    public void notifier(Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    public static void main(String[] args){
        Controleur controleur = new Controleur();
        IhmTroisPointZero ihm = new IhmTroisPointZero(controleur);     
        ihm.afficher();
    }

    public void loadJoueurs(ArrayList joueurs){
        this.nomJs = joueurs;
    }
    
}
