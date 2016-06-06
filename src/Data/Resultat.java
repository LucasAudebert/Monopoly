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
public class Resultat {


    private Joueur joueur;
    private EnumerationsMonopoly.TYPE_RESULTAT typeResultat;

    public Resultat() {
        
    }
   
    public Joueur getJoueur() {
        return joueur;
    }
    
    public EnumerationsMonopoly.TYPE_RESULTAT getTypeResultat() {
        return typeResultat;
    }
    
    public void update(Joueur joueur, EnumerationsMonopoly.TYPE_RESULTAT type){
        this.joueur = joueur;
        typeResultat = type;
    }
    
    
}
