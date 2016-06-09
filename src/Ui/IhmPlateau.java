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
import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.HashMap;


import javax.swing.BoxLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author Maxence
 */
public class IhmPlateau extends JFrame implements Observateur{
    private Controleur controleur;
    private ArrayList<Joueur> joueurs;
    private ArrayList<IhmInfoJoueur> panelJoueurs;
    private HashMap<String,JButton> boutonsPanels;
    private JPanel panTour;
    
    
    
    public IhmPlateau(Controleur controleur){
        this.controleur = controleur;
        joueurs = new ArrayList<>();
        joueurs = controleur.getJoueurs();
        panelJoueurs = new ArrayList<>();
        ititIhmPlateau();
        
        
    }
     private void ititIhmPlateau() {
        
        this.setLayout(new BorderLayout());
        
        
        JPanel panelJoueurs = new JPanel();     
        
        
        
        if(controleur.getJoueurs().size() == 2){
             panelJoueurs.setLayout(new GridLayout(1,2));
        }else if(controleur.getJoueurs().size()<=4){
            panelJoueurs.setLayout(new GridLayout(2,2));
        }else if(controleur.getJoueurs().size()>4){
            panelJoueurs.setLayout(new GridLayout(3,2));
        }
            
       
           
        
        panTour = new JPanel();
        IhmJoueurActuelle joueurActuelle = new IhmJoueurActuelle(joueurs.get(1));
        
        
        panTour.setLayout(new BoxLayout(panTour,BoxLayout.Y_AXIS));
        panTour.add(joueurActuelle);
        JButton jouer = new JButton(" Jouer ");
        jouer.setMaximumSize(new Dimension(200,40));
        JButton construire = new JButton(" Construire ");
        construire.setMaximumSize(new Dimension(200,40));
        JButton abandonner = new JButton(" Abandonner ");
        abandonner.setMaximumSize(new Dimension(200,40));
      
        
        panTour.add(jouer);        
        panTour.add(construire);        
        panTour.add(abandonner);        
      
        
        panTour.add(new JLabel("Action Possible : "));
        
        JButton lancerDes = new JButton(" Lancer les Dés ");
        panTour.add(lancerDes);
        lancerDes.setMaximumSize(new Dimension(200,40));
        
       
        
        
            
         
        JButton quitterJeu = new JButton(" Arrêter la partie ");
        quitterJeu.setMaximumSize(new Dimension(200,40));
        panTour.add(quitterJeu);
       
       
       
       
        for(Joueur jTemp : joueurs){
           
            IhmInfoJoueur ihmJoueur = new IhmInfoJoueur(jTemp);                  
            panelJoueurs.add(ihmJoueur);  
            
        }
       
        Plateau plateau = new Plateau();
        
        this.add(panelJoueurs,BorderLayout.WEST);
        this.add(plateau,BorderLayout.CENTER);
        this.add(panTour,BorderLayout.EAST);
        afficher();
        
        
       
    }
    public void afficher(){
         this.setSize(1920,1080);
         this.setVisible(true); 
         setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);       
     }
    
    public void updateInfoJoueurs(ArrayList<Joueur> joueurs){
        for(IhmInfoJoueur panTemp : panelJoueurs){
            for(Joueur jTemp : joueurs){
                if(panTemp.getJoueur().getNomJoueur() ==jTemp.getNomJoueur() ){
                    panTemp.updateJoueur(jTemp);
                    
                }
            }
        }
    }
    
    
    @Override
    public Message notifier(Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
