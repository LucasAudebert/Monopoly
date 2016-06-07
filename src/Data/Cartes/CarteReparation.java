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
public class CarteReparation extends Carte {
    
    private int valReprationMaison;
    private int valReprationHotel;    

    public CarteReparation( String libelle, int valReprationMaison, int valReprationHotel) {
        super(libelle);
        this.valReprationMaison = valReprationMaison;
        this.valReprationHotel = valReprationHotel;
    }
    
    @Override
    public ResultatCarte Action(Joueur j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
