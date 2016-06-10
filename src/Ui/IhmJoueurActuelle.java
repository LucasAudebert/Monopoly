/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Compagnie;
import Data.Gare;
import Data.Joueur;
import Data.ProprieteAConstruire;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Maxence
 */
public final class IhmJoueurActuelle extends JPanel{
   
    private JLabel nom;
    private  JLabel cash;
    private JLabel tourJoueur;
    
    private JLabel argent;
    
    public IhmJoueurActuelle(Joueur joueur){
        super();
        
        nom = new JLabel();
        nom.setText(joueur.getNomJoueur());
        
        cash = new JLabel();
        cash.setText(Integer.toString(joueur.getCash())); 
         
        initComponent();
       
    }
    public void initComponent(){
        JPanel panCash = new JPanel();
        panCash.setLayout(new BoxLayout(panCash,BoxLayout.X_AXIS));
        
        JPanel panNom = new JPanel();
        panNom.setLayout(new BoxLayout(panNom,BoxLayout.X_AXIS));
        
        
        
       
        panNom.add(new JLabel("C'est au tour de "));
        panNom.add(nom);
       
      
        
        panCash.add(new JLabel("Cash : "));
        panCash.add(cash);
       
       
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(panNom);
        this.add(panCash);
        afficher();
        
    }
    public void updateIhmJoueurActuelle(Joueur joueur){
        nom.setText(joueur.getNomJoueur());
      
        cash.setText(Integer.toString(joueur.getCash()));
        
        repaint();
    }

    private void afficher() {
        setVisible(true);
    }
    
    
    
}
