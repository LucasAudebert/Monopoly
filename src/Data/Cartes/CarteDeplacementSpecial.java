/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Cartes;

import Data.EnumerationsMonopoly;
import Data.Joueur;
import Data.Resultat;

/**
 *
 * @author audeberl
 */
public class CarteDeplacementSpecial extends CarteDeplacement {

    public CarteDeplacementSpecial(String libelle, int numeroCarreau) {
        super(libelle, numeroCarreau);
    }

    @Override
    public ResultatCarte action(Joueur j) {
        if (super.getNumeroCarreau() < 0) {
            super.setNumeroCarreau(j.getPositionCourante().getNumero()-1 + super.getNumeroCarreau());
        }
        return new ResultatCarte(super.getLibelle(), EnumerationsMonopoly.TYPE_RESULTAT_CARTE.deplacementSpecial, super.getNumeroCarreau());
    }
    
}
