/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Joueur;
import Jeu.Controleur;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Maxence
 */
public class IhmPlateau extends JFrame implements Observateur{
    private Controleur controleur;
    public IhmPlateau(Controleur controleur){
        this.controleur = controleur;
        ititIhmPlateau();
        
        
    }
     private void ititIhmPlateau() {
        
        this.setLayout(new BorderLayout());
        JPanel panJoueurs = new JPanel();
        for(Joueur jtemp : controleur.getJoueurs()){
            IhmInfoJoueur ihmJoueur = new IhmInfoJoueur(jtemp);
            panJoueurs.add(ihmJoueur);
        }
                
        JLabel panelJeu = new JLabel( new ImageIcon("src\\Image_Plateau.jpg"));
        this.add(panJoueurs,BorderLayout.WEST);
        this.add(panelJeu,BorderLayout.CENTER);
               
       
    }
    public void afficher(){
        this.setSize(1200,1200);
         this.setVisible(true); 
         setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
       
     }
     
   
     
    @Override
    public Message notifier(Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
