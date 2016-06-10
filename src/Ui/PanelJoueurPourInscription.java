/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author blachert
 */
public class PanelJoueurPourInscription extends JPanel {
    
    private JPanel panelPion, panelText, panelImage;
    private int numero;
    private JLabel image;
    private BoutonImage up, down;
    private JTextField nom;
    
    public PanelJoueurPourInscription(int num, ImageIcon icon){
        numero = num;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        panelPion = new JPanel();
        panelPion.setLayout(new BoxLayout(panelPion,BoxLayout.Y_AXIS));
        nom = new JTextField();
        up = new BoutonImage("src/up.png");
        panelText = new JPanel();
        panelText.setLayout(new BoxLayout(panelText,BoxLayout.Y_AXIS));
        image = new JLabel();
        image.setIcon(icon);
        down = new BoutonImage("src/down.png");
        
        this.add(Box.createRigidArea(new Dimension(5,15)));
        this.add(new JLabel("Joueur " + (numero + 1) + " :"));
        this.add(Box.createRigidArea(new Dimension(15,0)));
        panelText.add(Box.createRigidArea(new Dimension(15,15)));
        panelText.add(nom);
        panelText.add(Box.createRigidArea(new Dimension(15,15)));
        this.add(panelText);
        this.add(Box.createRigidArea(new Dimension(25,0)));
        
        panelPion.add(up);
        panelImage = new JPanel();
        panelImage.setLayout(new BoxLayout(panelImage, BoxLayout.X_AXIS));
        panelImage.add(image);
        panelImage.add(Box.createRigidArea(new Dimension(20,0)));
        panelPion.add(panelImage);
        panelPion.add(Box.createRigidArea(new Dimension(10,8)));
        panelPion.add(down);
        
        up.repaint();
        
        this.add(panelPion);
        this.add(Box.createRigidArea(new Dimension(5,0)));
    }

    public int getNumero() {
        return numero;
    }

    public ImageIcon getIcon() {
        return (ImageIcon) image.getIcon();
    }

    public BoutonImage getUp() {
        return up;
    }

    public BoutonImage getDown() {
        return down;
    }

    public String getNom() {
        return nom.getText();
    }

    public void setIcon(ImageIcon icon) {
        image.setIcon(icon);
    }
    
    public void setPionBorderColor(Color color){
        image.setBorder(BorderFactory.createLineBorder(color));
    }
    
    public void setTextBorderColor(Color color){
        nom.setBorder(BorderFactory.createLineBorder(color));
    }
    
}
