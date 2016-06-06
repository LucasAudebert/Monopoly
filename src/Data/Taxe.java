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
public class Taxe extends AutreCarreau{
    
    private int valTaxe;
    
    public Taxe(int numero, String nomCarreau, int valTaxe) {
        super(numero, nomCarreau);
        this.valTaxe = valTaxe;
    }
    
    @Override
    public Resultat action(Joueur joueur){
        joueur.payer(valTaxe);
        return new Resultat(this, joueur,EnumerationsMonopoly.TYPE_RESULTAT.taxe, valTaxe);
    } 
}
