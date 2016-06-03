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
    
    public abstract int calculLoyer();
    
    public abstract void achat(Joueur joueur);
    
    /**
     *
     * @param joueur
     * @return Resultat 
     */
    public Resultat achatPossible(Joueur joueur){
        Resultat res = new Resultat();
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
    public Resultat action(Joueur joueur) {
        Resultat res = new Resultat();//Creation du resultat renvoyé au controleur
        if(this.getProprietaire() == null){
            res = achatPossible(joueur);
        }else if (this.getProprietaire() != joueur){
            res.update(this, joueur, TYPE_RESULTAT.loyer, calculLoyer());
        }else{// Si le joueur est proprietaire de la propriete ou que la case ne peut pas être achetée
            res.update(this, joueur, TYPE_RESULTAT.neRienFaire);
        }
        return res;
    }
}
