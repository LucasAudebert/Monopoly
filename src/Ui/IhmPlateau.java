/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Joueur;
import Jeu.Controleur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.Box;

import javax.swing.BoxLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Maxence
 */
public class IhmPlateau extends JFrame implements Observateur{
    private Controleur controleur;
    private HashMap<Joueur,JPanel> joueurPanels;
    private HashMap<String,JButton> boutonsPanels;
    
    
    
    public IhmPlateau(Controleur controleur){
        this.controleur = controleur;
        joueurPanels = new HashMap<>();
        ititIhmPlateau();
        
        
    }
     private void ititIhmPlateau() {
        
        this.setLayout(new BorderLayout());
        
        
        JPanel panJoueurs = new JPanel();     
        
        
        
        if(controleur.getJoueurs().size() == 2){
             panJoueurs.setLayout(new GridLayout(1,2));
        }else if(controleur.getJoueurs().size()<=4){
            panJoueurs.setLayout(new GridLayout(2,2));
        }else if(controleur.getJoueurs().size()>4){
            panJoueurs.setLayout(new GridLayout(3,2));
        }
            
       
           
        
        JPanel panTour = new JPanel();
        IhmJoueurActuelle joueurActuelle = new IhmJoueurActuelle((Joueur)controleur.getJoueurs().get(1));
        
        
        panTour.setLayout(new BoxLayout(panTour,BoxLayout.Y_AXIS));
        panTour.add(joueurActuelle);
        JButton jouer = new JButton(" Jouer ");
        jouer.setMaximumSize(new Dimension(200,40));
        JButton construire = new JButton(" Construire ");
        construire.setMaximumSize(new Dimension(200,40));
        JButton abandonner = new JButton(" Abandonner ");
        abandonner.setMaximumSize(new Dimension(200,40));
        JButton quitterJeu = new JButton(" Arrêter la partie ");
        quitterJeu.setMaximumSize(new Dimension(200,40));
        
        panTour.add(jouer);        
        panTour.add(construire);        
        panTour.add(abandonner);        
        panTour.add(quitterJeu);
        
        panTour.add(new JLabel("Action Possible : "));
        
       /*JButton jouer = new JButton(" Jouer ");
        jouer.setMaximumSize(new Dimension(200,40));
        JButton construire = new JButton(" Construire ");
        construire.setMaximumSize(new Dimension(200,40));
        JButton abandonner = new JButton(" Abandonner ");
        abandonner.setMaximumSize(new Dimension(200,40));
        JButton quitterJeu = new JButton(" Arrêter la partie ");
        quitterJeu.setMaximumSize(new Dimension(200,40));
        
        panTour.add(jouer);        
        panTour.add(construire);        
        panTour.add(abandonner);        
        panTour.add(quitterJeu);*/
       
       
       
       
        for(Object jTemp : controleur.getJoueurs()){
            Joueur j = (Joueur)jTemp;
            IhmInfoJoueur ihmJoueur = new IhmInfoJoueur(j);                  
            panJoueurs.add(ihmJoueur);  
            joueurPanels.put(j,ihmJoueur);
        }
       
        Plateau plateau = new Plateau();
        
        this.add(panJoueurs,BorderLayout.WEST);
        this.add(plateau,BorderLayout.CENTER);
        this.add(panTour,BorderLayout.EAST);
        afficher();
        
        
       
    }
    public void afficher(){
        this.setSize(1920,1080);
         this.setVisible(true); 
         setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);       
     }
    @Override
    public Message notifier(Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
