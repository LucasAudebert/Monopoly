/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Joueur;
import Data.Propriete;
import Data.ProprieteAConstruire;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author audeberl
 */
public class IhmProprieteConstruire extends JPanel {
    private JLabel nom;
    private  JLabel construction;
    private JLabel cout;    
    private JButton boutonConstruire;

    
    public IhmProprieteConstruire(ProprieteAConstruire p){
        super();               
        initComponent(p);
        
    }
    
    public void initComponent(ProprieteAConstruire p){
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        nom = new JLabel("Nom : "+p.getNom());
        this.add(nom);
        
        String chaine ="Construction(s) : ";
        if (p.getNbMaisons()==0) {
            chaine +="aucune";
        } else if (p.getNbMaisons()==5) {
            chaine +="1 hotel";
        } else if (p.getNbMaisons()==1) {
            chaine +="1 maison";            
        } else {
            chaine =Integer.toString(p.getNbMaisons()) +" maisons";
        }
        construction = new JLabel(chaine);
        this.add(construction);
        
        cout = new JLabel("Cout : "+Integer.toString(p.getPrixMaison())+"€");
        this.add(cout);
        
        boutonConstruire = new JButton(" Construire ");
        if (!p.peutConstruire()) {
            boutonConstruire.setEnabled(false);
        }
        this.add(boutonConstruire);
        
        afficher();        
    }

    private void afficher() {
        setVisible(true);
    }
}
