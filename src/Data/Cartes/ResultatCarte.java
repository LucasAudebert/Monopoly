/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Cartes;

import Data.EnumerationsMonopoly;

/**
 *
 * @author audeberl
 */
public class ResultatCarte {
    private EnumerationsMonopoly.TYPE_RESULTAT_CARTE typeResultat;
    private String libelle;

    public ResultatCarte(String libelle, EnumerationsMonopoly.TYPE_RESULTAT_CARTE typeResultat) {
        this.typeResultat = typeResultat;
        this.libelle = libelle;
    }

    public EnumerationsMonopoly.TYPE_RESULTAT_CARTE getTypeResultat() {
        return typeResultat;
    }

    public String getLibelle() {
        return libelle;
    }
    
}
