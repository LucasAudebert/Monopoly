/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author blachert
 */
public class CarreauPiocherCarteChance extends AutreCarreau {
    
    
    public CarreauPiocherCarteChance(int numero, String nomCarreau) {
        super(numero, nomCarreau);
    }
    
    @Override
    public Resultat action(Joueur joueur){
        return new Resultat(this, joueur,EnumerationsMonopoly.TYPE_RESULTAT.piocherUneCarteChance);
    } 
}
