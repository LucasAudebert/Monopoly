/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Joueur;
import Data.ProprieteAConstruire;
import javax.swing.JFrame;

/**
 *
 * @author audeberl
 */
public class IhmConstruire extends JFrame {
    private Joueur joueur;
    
    public IhmConstruire(Joueur joueur) {
        super();
        this.setSize(800, 800);
        for (ProprieteAConstruire p : joueur.getProprieteAConstruires()) {
            this.add(new IhmProprieteConstruire(p));
        }
        this.setVisible(true);
    }
}
