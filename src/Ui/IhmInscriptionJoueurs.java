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
public class IhmInscriptionJoueurs {
    
    private JPanel panelPrincipal, panelNbJoueurs, panelNorth, panelJoueurs;
    private JFrame frame;
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
        
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        frame.setSize(300, 550);
        frame.setResizable(false);
        frame.setTitle("Inscription des joueurs");
        
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
        frame.add(Box.createRigidArea(new Dimension(100,10)), BorderLayout.NORTH);
        frame.add(panelPrincipal, BorderLayout.CENTER);
        //boutonPlus.repaint();
        //boutonMoins.repaint();
        for(int i = 0; i < nbJ; i++){
            ajouterPanelJoueur();
        }
        
        btnValider = new JButton("Valider");
        frame.add(btnValider, BorderLayout.SOUTH);
        frame.setVisible(true);
        
        
        btnValider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verification()){
                    
                }
            }
            
        });
        
        boutonMoins.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(nbJ > 2){
                    nbJ--;
                    panelJoueurs.remove(listePanelsJ.get(listePanelsJ.size() - 1));
                    listePanelsJ.remove(listePanelsJ.size() - 1);
                    panelPrincipal.revalidate();
                    frame.repaint();
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
    
    private boolean verification(){
        boolean verified = true;
        for(PanelJoueurPourInscription pJ : listePanelsJ){
            pJ.setTextBorderColor(Color.GREEN);
            pJ.setPionBorderColor(Color.GREEN);
        }
        for(PanelJoueurPourInscription pJ1 : listePanelsJ){
            for(PanelJoueurPourInscription pJ2 : listePanelsJ){
                if(pJ1 != pJ2){
                    if( pJ1.getNom().compareTo(pJ2.getNom()) == 0){
                        verified = false;
                        pJ1.setTextBorderColor(Color.RED);
                        pJ2.setTextBorderColor(Color.RED);
                    }
                    if(pJ1.getIcon() == pJ2.getIcon()){
                        verified = false;
                        pJ1.setPionBorderColor(Color.RED);
                        pJ2.setPionBorderColor(Color.RED);
                    }
                }
            }
            if(pJ1.getNom().compareTo("") == 0){
                verified = false;
                pJ1.setTextBorderColor(Color.RED);
            }
        }
        return verified;
    }
}
