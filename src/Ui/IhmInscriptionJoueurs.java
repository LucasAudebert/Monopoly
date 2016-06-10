/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author blachert
 */
public class IhmInscriptionJoueurs extends JFrame {
    
    private JPanel panelPrincipal, panelNbJoueurs, panelNorth, panelJoueurs;
    private BoutonImage boutonPlus, boutonMoins;
    private JLabel nbJfield;
    private ArrayList<PanelJoueurPourInscription> listePanelsJ;
    private ArrayList<ImageIcon> listeImagesPions;
    private int nbJ = 2;
    private JButton btnValider;
            
    public IhmInscriptionJoueurs(){
        listePanelsJ = new ArrayList();
        listeImagesPions = new ArrayList<ImageIcon>();
        loadImages();
        
        
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        this.setSize(300, 550);
        this.setResizable(false);
        this.setTitle("Inscription des joueurs");
        
        panelPrincipal = new JPanel(new BorderLayout());
        panelNorth = new JPanel();
        panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.X_AXIS));
        panelNbJoueurs = new JPanel(new GridLayout(1,3));
        
        panelNbJoueurs.add(boutonMoins = new BoutonImage("src/moins.png"));
        panelNbJoueurs.add(nbJfield = new JLabel(((Integer)nbJ).toString()));
        nbJfield.setHorizontalAlignment(JLabel.CENTER);
        //Font??
        panelNorth.add(Box.createRigidArea(new Dimension(100,40)));
        panelNbJoueurs.add(boutonPlus = new BoutonImage("src/plus.png"));
        panelNorth.add(panelNbJoueurs);
        panelNorth.add(Box.createRigidArea(new Dimension(100,40)));
        panelJoueurs = new JPanel(new GridLayout(6, 1));
        panelPrincipal.add(panelJoueurs, BorderLayout.CENTER);
        panelPrincipal.add(panelNorth, BorderLayout.NORTH);
        this.add(Box.createRigidArea(new Dimension(100,10)), BorderLayout.NORTH);
        this.add(panelPrincipal, BorderLayout.CENTER);
        //boutonPlus.repaint();
        //boutonMoins.repaint();
        for(int i = 0; i < nbJ; i++){
            ajouterPanelJoueur();
        }
        
        btnValider = new JButton("Valider");
        this.add(btnValider, BorderLayout.SOUTH);
        this.setVisible(false);
        
        
        boutonMoins.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(nbJ > 2){
                    nbJ--;
                    panelJoueurs.remove(listePanelsJ.get(listePanelsJ.size() - 1));
                    listePanelsJ.remove(listePanelsJ.size() - 1);
                    panelPrincipal.revalidate();
                    panelJoueurs.repaint();
                    nbJfield.setText(((Integer)nbJ).toString());
                }
                    
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
            
        });
        
        boutonPlus.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(nbJ < 6){
                    nbJ++;
                    ajouterPanelJoueur();
                    nbJfield.setText(((Integer)nbJ).toString());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
            
        });
    }
    
    private void loadImages(){
        listeImagesPions.add(new ImageIcon("src/Pions/voiture.png"));
        listeImagesPions.add(new ImageIcon("src/Pions/chapeau.png"));
        listeImagesPions.add(new ImageIcon("src/Pions/bateau.png"));
        listeImagesPions.add(new ImageIcon("src/Pions/chaussure.png"));
        listeImagesPions.add(new ImageIcon("src/Pions/deACoudre.png"));
        listeImagesPions.add(new ImageIcon("src/Pions/chien.png"));
    }
    
    private void ajouterPanelJoueur(){
        
        PanelJoueurPourInscription panel = new PanelJoueurPourInscription(listePanelsJ.size(), listeImagesPions.get(listePanelsJ.size()));
        
        panel.getUp().addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(listeImagesPions.indexOf(panel.getIcon()) == 0){
                    panel.setIcon(listeImagesPions.get(listeImagesPions.size() - 1));
                }else{
                    panel.setIcon(listeImagesPions.get(listeImagesPions.indexOf(panel.getIcon()) - 1));
                }
                
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
            
        });
        
        panel.getDown().addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(listeImagesPions.indexOf(panel.getIcon()) == listeImagesPions.size() - 1){
                    panel.setIcon(listeImagesPions.get(0));
                }else{
                    panel.setIcon(listeImagesPions.get(listeImagesPions.indexOf(panel.getIcon()) + 1));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
            
        });
        panelJoueurs.add(panel);
        listePanelsJ.add(panel);
    }
    
    public ArrayList getJoueurs(){
        ArrayList<String> joueurs = new ArrayList<String>();
        for(PanelJoueurPourInscription pJ : listePanelsJ){
            joueurs.add(pJ.getNom());
        }
        
        return joueurs;
    }
    
    public HashMap getPions(){
        HashMap<String, ImageIcon> pions = new HashMap();
        for(PanelJoueurPourInscription pJ : listePanelsJ){
            pions.put(pJ.getNom(), pJ.getIcon());
        }
        return pions;
    }
    
    public boolean verification(){
        boolean verified = true;
        for(PanelJoueurPourInscription pJ : listePanelsJ){
            pJ.setTextBorderColor(Color.GREEN);
            pJ.setPionBorderColor(Color.GREEN);
            pJ.getNomField().setToolTipText("Saisie valide");
            pJ.getImage().setToolTipText("Pion valide");
        }
        for(PanelJoueurPourInscription pJ1 : listePanelsJ){
            for(PanelJoueurPourInscription pJ2 : listePanelsJ){
                if(pJ1 != pJ2){
                    if( pJ1.getNom().compareTo(pJ2.getNom()) == 0){
                        verified = false;
                        pJ1.setTextBorderColor(Color.RED);
                        pJ1.getNomField().setToolTipText("Vous ne pouvez pas posséder le même nom qu'une autre personne");
                        pJ2.setTextBorderColor(Color.RED);
                        pJ2.getNomField().setToolTipText("Vous ne pouvez pas posséder le même nom qu'une autre personne");
                    }
                    if(pJ1.getIcon() == pJ2.getIcon()){
                        verified = false;
                        pJ1.setPionBorderColor(Color.RED);
                        pJ2.setPionBorderColor(Color.RED);
                        pJ1.getImage().setToolTipText("Vous ne pouvez pas posséder le même pion qu'une autre personne");
                        pJ1.getImage().setToolTipText("Vous ne pouvez pas posséder le même pion qu'une autre personne");
                    }
                }
            }
            if(pJ1.getNom().compareTo("") == 0){
                verified = false;
                pJ1.setTextBorderColor(Color.RED);
                pJ1.getNomField().setToolTipText("Veuillez saisir un nom");
            }
        }
        return verified;
    }
}
