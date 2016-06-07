/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Cartes;

import Data.EnumerationsMonopoly;
import Data.Joueur;
import Data.ProprieteAConstruire;

/**
 *
 * @author audeberl
 */
public class CarteReparation extends Carte {
    
    private int valReparationMaison;
    private int valReparationHotel;    

    public CarteReparation( String libelle, int valReparationMaison, int valReparationHotel) {
        super(libelle);
        this.valReparationMaison = valReparationMaison;
        this.valReparationHotel = valReparationHotel;
    }
    
    @Override
    public ResultatCarte Action(Joueur j) {
        int taxe = 0;
        for(ProprieteAConstruire p : j.getProprieteAConstruires()) {
            if (p.getNbMaisons()==5) {
                taxe =+ valReparationHotel;
            } else {
                taxe =+ p.getNbMaisons()*valReparationMaison;
            }
        }
        j.payer(taxe);
        return new ResultatCarte(super.getLibelle(),EnumerationsMonopoly.TYPE_RESULTAT_CARTE.perte,taxe);
    }
    
}
