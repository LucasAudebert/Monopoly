/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.AutreCarreau;
import Data.Carreau;
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
public class IhmInfoJoueur extends JPanel {
    private Joueur joueur;
    
    public IhmInfoJoueur(Joueur joueur){
       this.joueur =  joueur;
       initFenetre();       
        
    }
    public void initFenetre(){
        
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        
        JLabel nom = new JLabel("Joueur : "+joueur.getNomJoueur());
        this.add(nom);
        
        JLabel argent = new JLabel("Cash : "+joueur.getCash());
        this.add(argent);
        
        
        JLabel position  = new JLabel("Position actuelles : "+joueur.getPositionCourante().getNom());
        this.add(position);
        
        JLabel compagnie = new JLabel("Compagnie : ");
        this.add(compagnie);
        
        if(joueur.getCompagnies().isEmpty()){
           JLabel pasCompagnie = new JLabel("    Pas de compagnies");
           this.add(pasCompagnie);
            
        }else{
            for(Compagnie cTemp : joueur.getCompagnies()){
                this.add(new JLabel("   "+cTemp.getNom()));          
            }
        }
        
        
       JLabel gare = new JLabel("Gares : ");
       this.add(gare);
        if(joueur.getGares().isEmpty()){
            JLabel pasGare = new JLabel("    Pas de gares");
            this.add(pasGare);
        }else{
             for(Gare gTemp : joueur.getGares()){
                 this.add(new JLabel("  "+gTemp.getNom()));
            }
        }
       
        JLabel propAConstruire = new JLabel("Proprieté à construire : ");
        this.add(propAConstruire);
        if(joueur.getGares().isEmpty()){
            JLabel pasPropaConstruire = new JLabel("    Pas de proprieté à construire");
            this.add(pasPropaConstruire);
        }else{
            for(ProprieteAConstruire pTemp : joueur.getProprieteAConstruires() ){
                    this.add(new JLabel("  "+pTemp.getNom()));
            }
        }
       
       afficher();
        
    }

    public Joueur getJoueur() {
        return joueur;
    }
    
    public void updateJoueur(Joueur joueur){
        this.joueur = joueur;
        removeAll();
        initFenetre();
    }
    
    public void afficher(){
        
        this.setSize(500,500);
        this.setVisible(true);
    }
    
        
}
