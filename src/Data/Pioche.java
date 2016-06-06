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
public class Pioche extends AutreCarreau {
    
    
    public Pioche(int numero, String nomCarreau) {
        super(numero, nomCarreau);
    }
    
    @Override
    public ResultatPropriete action(Joueur joueur){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
