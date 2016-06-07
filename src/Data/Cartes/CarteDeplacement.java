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
public class CarteDeplacement extends Carte {
    
    private int numeroCarreau;
    
    public CarteDeplacement(String libelle, int numeroCarreau) {
        super(libelle);
        this.numeroCarreau = numeroCarreau;
    }

    @Override
    public ResultatCarte Action(Joueur j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
