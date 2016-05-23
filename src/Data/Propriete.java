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
    
    public Propriete(int prix, int numero, String nomCarreau, String type){
        super(numero, nomCarreau, type);
        this.prix = prix;
    }
    
    public abstract int calculLoyer();
    
    public boolean achatPossible(Joueur joueur){
        return joueur.getCash() > prix;
    }
    
    public Joueur getProprietaire(){
        return proprietaire;
    }
    
    public Resultat action(Joueur joueur) {
        ResultatAchat res = new ResultatAchat();
        if(this.getProprietaire() == null){
            
        }else if (this.getProprietaire() != joueur){
            res.update(this, joueur);
            // doit payer le loyer
        }
        return res;
    }
}
