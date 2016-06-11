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
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author audeberl
 */
public class PanelPropriete extends JPanel {
    private ProprieteAConstruire propriete;
    private IhmConstruire ihmConstruire;
    private JLabel nom;
    private  JLabel construction;
    private JLabel cout;    
    private JButton boutonConstruire;

    
    public PanelPropriete(ProprieteAConstruire p, IhmConstruire ihm){
        super();
        propriete = p;
        ihmConstruire = ihm;
        initComponent();        
    }
    
    public void initComponent(){
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBorder(BorderFactory.createLineBorder(Color.black));
        panelPrincipal.setLayout(new GridLayout(4,2));
        
        panelPrincipal.add(new JLabel(" Nom : "));
        nom = new JLabel(propriete.getNom()+" ");
        panelPrincipal.add(nom);
        
        panelPrincipal.add(new JLabel(" Construction(s) : "));    
        if (propriete.getNbMaisons()==0) {
            construction = new JLabel("aucune ");
        } else if (propriete.getNbMaisons()==5) {
            construction = new JLabel("1 hotel ");
        } else if (propriete.getNbMaisons()==1) {
            construction = new JLabel("1 maison "); 
        } else {
            construction = new JLabel(Integer.toString(propriete.getNbMaisons()) +" maisons ");
        }
        panelPrincipal.add(construction);

        panelPrincipal.add(new JLabel(" Cout : "));            
        cout = new JLabel(Integer.toString(propriete.getPrixMaison())+"€ ");
        panelPrincipal.add(cout);
        
        boutonConstruire = new JButton(" Construire ");
        if (!propriete.peutConstruire()) {
            boutonConstruire.setEnabled(false);
        }
       
        boutonConstruire.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                propriete.construire();
                updateAll();
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        }); 
        
        JPanel panelBouton = new JPanel();
        panelBouton.add(boutonConstruire);        
        panelPrincipal.add(panelBouton);
        
        this.add(panelPrincipal);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        afficher();        
    }

    private void afficher() {
        setVisible(true);
    }

    public void updateAll(){
        ihmConstruire.update();
    }
    
    public void update() {
        if (propriete.getNbMaisons()==0) {
            construction.setText("aucune ");
        } else if (propriete.getNbMaisons()==5) {
            construction.setText("1 hotel ");
        } else if (propriete.getNbMaisons()==1) {
            construction.setText("1 maison "); 
        } else {
            construction.setText(Integer.toString(propriete.getNbMaisons()) +" maisons ");
        }
        
        if (!propriete.peutConstruire()) {
            boutonConstruire.setEnabled(false);
        }
    }

    public ProprieteAConstruire getPropriete() {
        return propriete;
    }
    
}
