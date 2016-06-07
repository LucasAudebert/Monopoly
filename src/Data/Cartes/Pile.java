/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Cartes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author audeberl
 */
public class Pile {
    private Vector cartes;
    
    public Pile() {
        cartes = new Vector();
    }
    
    public void addCarte(Carte c) {
        cartes.add(c);
    }
    
    public void removeCarte(Carte c) {
        cartes.remove(c);
    }
    
    public void melanger() {
        Collections.shuffle(cartes);
    }
    
    public Carte tirerUneCarte() {
        Carte c = (Carte) cartes.get(0);
        cartes.remove(c);
        return c;
    }
    
    public void reposerUneCarte(Carte c) {
        addCarte(c);
    }
    
    public Carte tirerEtReposerUneCarte() {
        Carte c = tirerUneCarte();
        reposerUneCarte(c);
        return c;
    }
}
