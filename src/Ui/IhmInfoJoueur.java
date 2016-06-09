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
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author Maxence
 */
public class IhmInfoJoueur extends JPanel {
    private JLabel nom;
    private JLabel cash;
    private JLabel positionCourante;
    private Joueur joueur;
    private HashMap<String,JLabel> gares;
    private HashMap<String,JLabel> proprietes;
    private HashMap<String,JLabel> compagnies;
    
    public IhmInfoJoueur(Joueur joueur){
        System.out.println("testmachine ");
       this.joueur = joueur;
       nom = new JLabel();
       nom.setText(joueur.getNomJoueur());
       
       cash = new JLabel();
       cash.setText(Integer.toString(joueur.getCash()));
       
       positionCourante = new JLabel();
       positionCourante.setText(joueur.getPositionCourante().getNom());
       compagnies = new HashMap();
       proprietes = new HashMap();
       gares = new HashMap();
       initFenetre();       
      
        
    }
    public void initFenetre(){
        
        this.setBorder(BorderFactory.createLineBorder(Color.black));
      this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    
       
        
        JPanel panNom = new JPanel();
        panNom.setLayout(new BoxLayout(panNom,BoxLayout.LINE_AXIS));
        panNom.add(new JLabel("Joueur : "));
        panNom.add(nom);
        this.add(panNom);
        
        JPanel panCash = new JPanel();
        panCash.setLayout(new BoxLayout(panCash,BoxLayout.X_AXIS));
        panCash.add(new JLabel("Votre argent : "));
        panCash.add(cash);
        this.add(panCash);
        
      
        JPanel panPosition = new JPanel();
        panPosition.setLayout(new BoxLayout(panPosition,BoxLayout.LINE_AXIS));
        panPosition.add(new JLabel("Position actuelle  : "));
        panPosition.add(positionCourante);
        this.add(panPosition);
      
        this.add(new JLabel("Compagnie : "));
        
        
        if(joueur.getCompagnies().isEmpty()){          
           this.add(new JLabel("    Pas de compagnies"));            
        }else{
            for(Compagnie cTemp : joueur.getCompagnies()){
                 JLabel compagnie = new JLabel("     "+cTemp.getNom());                 
                 compagnies.put(cTemp.getNom(),compagnie);
                 this.add(compagnie);          
            }
        }
        
        
       
       this.add(new JLabel("Gares : "));
        if(joueur.getGares().isEmpty()){
            this.add(new JLabel("    Pas de gares"));
        }else{
             for(Gare gTemp : joueur.getGares()){
                 JLabel gare = new JLabel("     "+gTemp.getNom());                 
                 gares.put(gTemp.getNom(),gare);
                 this.add(gare);
            }
        }
       
       
        this.add(new JLabel("Proprieté à construire : "));
        if(joueur.getGares().isEmpty()){
            this.add(new JLabel("    Pas de proprieté à construire"));
        }else{
            for(ProprieteAConstruire pTemp : joueur.getProprieteAConstruires() ){
                 JLabel prop = new JLabel("     "+pTemp.getNom());                 
                 proprietes.put(pTemp.getNom(),prop);
                 this.add(prop);
                    
            }
        }
       
       afficher();
        
    }

    public Joueur getJoueur() {
        return joueur;
    }
    
    public void updateJoueur(Joueur joueur){
        this.joueur = joueur;
        nom.setText(joueur.getNomJoueur());
        positionCourante.setText(joueur.getPositionCourante().getNom());
        cash.setText(Integer.toString(joueur.getCash()));
        initFenetre();
    }
    
    public void afficher(){
        
        this.setSize(500,500);
        this.setVisible(true);
    }
    
        
}
