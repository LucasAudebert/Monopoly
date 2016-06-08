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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BoxLayout;

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
    private HashMap<Joueur,JPanel> joueurPanels;
    
    public IhmPlateau(Controleur controleur){
        this.controleur = controleur;
        joueurPanels = new HashMap<>();
        ititIhmPlateau();
        
        
    }
     private void ititIhmPlateau() {
        
        this.setLayout(new BorderLayout());
        JPanel panJoueurs = new JPanel();
        panJoueurs.setLayout(new BoxLayout(panJoueurs,BoxLayout.PAGE_AXIS));
        System.out.println("test1");
       
         System.out.println(controleur.getJoueurs().size());
        for(Object jTemp : controleur.getJoueurs()){
            Joueur j = (Joueur)jTemp;
            IhmInfoJoueur ihmJoueur = new IhmInfoJoueur(j);            
            panJoueurs.add(ihmJoueur);       
            joueurPanels.put(j,ihmJoueur);

        }
       
                
        JLabel panelJeu = new JLabel( new ImageIcon("src\\Image_Plateau.jpg"));
        this.add(panJoueurs,BorderLayout.WEST);
        this.add(panelJeu,BorderLayout.CENTER);
        afficher();
        
        panelJeu.addMouseListener(new MouseListener(
        ) {
            @Override
            public void mouseClicked(MouseEvent e) {}

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
