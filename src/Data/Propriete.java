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
        joueur.payerLoyer(this.getPrix());

    }
    
    /**
     *
     * @param joueur
     * @return ResultatPropriete 
     */
    public ResultatPropriete achatPossible(Joueur joueur){
        ResultatPropriete res = new ResultatPropriete();
        if (joueur.peutPayer(prix)){
            res.update(this, joueur, TYPE_RESULTAT.achat);
        }else{
            res.update(this, joueur, TYPE_RESULTAT.neRienFaire);
        }
        return res;
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
    public ResultatPropriete action(Joueur joueur) {
        ResultatPropriete res = new ResultatPropriete();//Creation du resultat renvoyé au controleur
        if(this.getProprietaire() == null){
            res = achatPossible(joueur);
        }else if (this.getProprietaire() != joueur){
            res.update(this, joueur, TYPE_RESULTAT.loyer, calculLoyer(joueur));
        }else{// Si le joueur est proprietaire de la propriete ou que la case ne peut pas être achetée
            res.update(this, joueur, TYPE_RESULTAT.neRienFaire);
        }
        return res;
    }
}
