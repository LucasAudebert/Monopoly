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
public abstract class Propriete extends Carreau {
    
    private int prix;
    private Joueur proprietaire;
    
    public Propriete(int prix, int numero, String nomCarreau){
        super(numero, nomCarreau);
        this.prix = prix;
    }
    
    public abstract int calculLoyer();
    
    public Joueur getProprietaire(){
        return proprietaire;
    }
    
}
