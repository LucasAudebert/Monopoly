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
public class CarteDeplacementSpecial extends Carte {

    private int numeroCarreau;
    
    public CarteDeplacementSpecial(String libelle, int numeroCarreau) {
        super(libelle);
        this.numeroCarreau = numeroCarreau ;
    }

    @Override
    public ResultatCarte Action(Joueur j) {
        if (numeroCarreau < 0) {
            numeroCarreau = j.getPositionCourante().getNumero() + numeroCarreau - 1;
        }
        return new ResultatCarte(super.getLibelle(), EnumerationsMonopoly.TYPE_RESULTAT_CARTE.deplacementSpecial, numeroCarreau);
    }
    
}
