/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.Cartes;

/**
 *
 * @author audeberl
 */
public class CarteAllerEnPrison extends Carte{

    public CarteAllerEnPrison(String libelle) {
        super(libelle);
    }

    @Override
    public ResultatCarte Action() {
        return new ResultatCarte();
    }    
}
