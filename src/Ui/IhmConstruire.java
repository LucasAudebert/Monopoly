/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Joueur;
import Data.ProprieteAConstruire;
import Jeu.Controleur;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author audeberl
 */
public class IhmConstruire extends JFrame {
    private IhmPlateau ihmPrincipale;
    private Controleur controleur;
    private Joueur joueur;
    private HashSet<PanelPropriete> panels;
    private JButton boutonValider;
    private JButton boutonAnnuler;   
    
    public IhmConstruire(Joueur joueur, IhmPlateau ihm, Controleur c) {
        super();
        
        this.ihmPrincipale = ihm;
        this.controleur = c;        
        this.joueur = joueur;
        this.panels = new HashSet<PanelPropriete>();
        
        initComponent();       
    }

    private void initComponent() {
        this.setLayout(new BorderLayout());
        
       JPanel panel = new JPanel();
       panel.setLayout(new GridLayout(4,4));
        for (ProprieteAConstruire p : joueur.getProprieteAConstruires()) {
            PanelPropriete pan = new PanelPropriete(p,this);
            panel.add(pan);
            panels.add(pan);
        }               
        this.add(panel,BorderLayout.NORTH);
        
        afficher();
    }
    
    public void afficher(){
          this.setSize(1200, 700);
          this.setVisible(true);
    }
    
    public void update(){
          for (PanelPropriete pan : panels) {
              pan.update();
          }
          ihmPrincipale.updateAffichage();
    }
    
    public Controleur getControleur() {
        return controleur;
    }
}
