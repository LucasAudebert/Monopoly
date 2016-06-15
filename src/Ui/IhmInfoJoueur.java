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
import java.awt.FlowLayout;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
    private JLabel nbGare;
    private JLabel nbCompagnie;
    private JLabel nbPropriete;
    private JLabel icon;
    
    private Joueur joueur;
    
    
    public IhmInfoJoueur(Joueur joueur){      
       this.joueur = joueur;
       
       icon = new JLabel(new ImageIcon(joueur.getImagePion()));
       
       nom = new JLabel();
       nom.setText(joueur.getNomJoueur());
       
       cash = new JLabel();
       cash.setText(Integer.toString(joueur.getCash()));
       
       positionCourante = new JLabel();
       positionCourante.setText(joueur.getPositionCourante().getNom());
       
       nbGare = new JLabel();
       nbGare.setText(Integer.toString(joueur.getNbGares()));
       
       nbCompagnie = new JLabel();
       nbCompagnie.setText(Integer.toString(joueur.getNbCompagnies()));
       
       nbPropriete = new JLabel();
       nbPropriete.setText(Integer.toString(joueur.getNombreProprieteAConstruire()));
       
       
       initFenetre();       
      
        
    }
    public void initFenetre(){
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
         
        this.add(icon);
        
        JPanel panNom = new JPanel();
        panNom.setLayout(new BoxLayout(panNom,BoxLayout.LINE_AXIS));
        panNom.setAlignmentX( this.LEFT_ALIGNMENT );
        
        panNom.add(new JLabel("Joueur : "));
        panNom.add(nom);
        this.add(panNom);
        
        JPanel panCash = new JPanel();
        panCash.setLayout(new BoxLayout(panCash,BoxLayout.X_AXIS));
        panCash.setAlignmentX( this.LEFT_ALIGNMENT );
        panCash.add(new JLabel("Votre argent : "));
        panCash.add(cash);
        this.add(panCash);
        
      
        JPanel panPosition = new JPanel();
        panPosition.setLayout(new BoxLayout(panPosition,BoxLayout.LINE_AXIS));
        panPosition.setAlignmentX( this.LEFT_ALIGNMENT );
        panPosition.add(new JLabel("Position actuelle  : "));
        panPosition.add(positionCourante);
        this.add(panPosition);
      
        JPanel panCompagnie = new JPanel();
        panCompagnie.setLayout(new BoxLayout(panCompagnie,BoxLayout.LINE_AXIS));
        panCompagnie.setAlignmentX( this.LEFT_ALIGNMENT );
        panCompagnie.add(new JLabel("Nombre de compagnie : "));
        panCompagnie.add(nbCompagnie);
        this.add(panCompagnie);
        
        
        JPanel panGare = new JPanel();
        panGare.setLayout(new BoxLayout(panGare,BoxLayout.LINE_AXIS));
        panGare.setAlignmentX( this.LEFT_ALIGNMENT );
        panGare.add(new JLabel("Nombre de gare : "));
        panGare.add(nbGare);
        this.add(panGare);
        
        JPanel panProp = new JPanel();
        panProp.setLayout(new BoxLayout(panProp,BoxLayout.LINE_AXIS));
        panProp.setAlignmentX( this.LEFT_ALIGNMENT );
        panProp.add(new JLabel("Nombre de Proprieté constructible : "));
        panProp.add(nbPropriete);
        this.add(panProp);
        
        
        this.setOpaque(false);

       
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
        nbCompagnie.setText(Integer.toString(joueur.getNbCompagnies()));
        nbGare.setText(Integer.toString(joueur.getNbGares()));
        nbPropriete.setText(Integer.toString(joueur.getNombreProprieteAConstruire()));
        
       
    }
    
    public void afficher(){
        
        this.setSize(500,500);
        this.setVisible(true);
    }
    
        
}
