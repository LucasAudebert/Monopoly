/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Cartes;

import Data.Joueur;

/**
 *
 * @author audeberl
 */
public abstract class Carte {
    private String libelle;
    
    public Carte(String libelle) {
        this.libelle = libelle;
    }
    
    public abstract ResultatCarte Action(Joueur j);

    public String getLibelle() {
        return libelle;
    }
    
}
