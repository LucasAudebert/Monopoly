/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Cartes;

import Data.EnumerationsMonopoly;
import Data.Joueur;

/**
 *
 * @author audeberl
 */
public class CarteAmende extends Carte {

    private int amende;
    
    public CarteAmende(String libelle, int amende) {
        super(libelle);
        this.amende = amende;
    }

    @Override
    public ResultatCarte Action(Joueur j) {
        j.payer(amende);
        return new ResultatCarte(super.getLibelle(), EnumerationsMonopoly.TYPE_RESULTAT_CARTE.perte, amende);
    }
    
}
