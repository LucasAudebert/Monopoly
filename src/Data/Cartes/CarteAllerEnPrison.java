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
public class CarteAllerEnPrison extends Carte{

    public CarteAllerEnPrison(String libelle) {
        super(libelle);
    }

    @Override
    public ResultatCarte Action(Joueur j) {
        return new ResultatCarte(super.getLibelle(), EnumerationsMonopoly.TYPE_RESULTAT_CARTE.allerEnPrison);
    }    
}
