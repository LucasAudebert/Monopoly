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
public class IhmJoueurActuelle extends JPanel{
    private Joueur joueur;
    public IhmJoueurActuelle(Joueur joueur){
        super();
        this.joueur = joueur;
        initComponent();
    }
    public void initComponent(){
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        
        this.add(new JLabel("C'est au tour de "+joueur.getNomJoueur() + " de jouer ! "));
        
        JLabel argent = new JLabel("Cash : "+joueur.getCash());
        this.add(argent);
        
        
        afficher();
        
    }
    public void updateIhmJoueurActuelle(Joueur joueur){
        this.joueur = joueur;
        repaint();
    }

    private void afficher() {
        setVisible(true);
    }
    
    
    
}
