/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.EnumerationsMonopoly.TYPE_RESULTAT;

/**
 *
 * @author blachert
 */
public abstract class Propriete extends Carreau {
    
    private int prix;
    private Joueur proprietaire;
    
    /**
     *
     * @param prix
     * @param numero
     * @param nomCarreau
     */
    public Propriete(int prix, int numero, String nomCarreau){
        super(numero, nomCarreau);
        this.prix = prix;
    }
    
    public abstract int calculLoyer(Joueur joueur);
    
    public void achat(Joueur joueur){
        this.setProprietaire(joueur);
        joueur.payer(this.getPrix());

    }
    
    /**
     *
     * @param joueur
     * @return ResultatPropriete 
     */
    public Resultat achatPossible(Joueur joueur){
        if (joueur.peutPayer(prix)){
            return new Resultat(this, joueur, TYPE_RESULTAT.achat);
        }else{
            return new Resultat(this, joueur, TYPE_RESULTAT.neRienFaire);
        }
    }
    
    public Joueur getProprietaire(){
        return proprietaire;
    }

    public void setProprietaire(Joueur joueur){
        this.proprietaire = joueur;
    }
        
    public int getPrix(){
        return prix;
    }
   
    /**
     *
     * @param joueur
     * @return
     */
    @Override
    public Resultat action(Joueur joueur) {
        if(this.getProprietaire() == null){
            return achatPossible(joueur);
        }else if (this.getProprietaire() != joueur){
            return new Resultat(this, joueur, TYPE_RESULTAT.loyer, calculLoyer(joueur));
        }else{// Si le joueur est proprietaire de la propriete ou que la case ne peut pas être achetée
            return new Resultat(this, joueur, TYPE_RESULTAT.neRienFaire);
        }
    }
}
