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
    public ResultatPropriete action(Joueur joueur){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
