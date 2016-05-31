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
    
    /**
     *
     * @return
     */
    public abstract int calculLoyer();
    
    /**
     *
     * @param joueur
     */
    public abstract void achat(Joueur joueur);
    
    /**
     *
     * @param joueur
     * @return
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
    
    /**
     *
     * @return
     */
    public Joueur getProprietaire(){
        return proprietaire;
    }

    /**
     *
     * @param joueur
     */
    public void setProprietaire(Joueur joueur){
        this.proprietaire = joueur;
    }
        
    /**
     *
     * @return
     */
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
        Resultat res = new Resultat();
        if(this.getProprietaire() == null){
            res = achatPossible(joueur);
        }else if (this.getProprietaire() != joueur){
            res.update(this, joueur, TYPE_RESULTAT.loyer, calculLoyer());
        }else{
            res.update(this, joueur, TYPE_RESULTAT.neRienFaire);
        }
        return res;
    }
}
