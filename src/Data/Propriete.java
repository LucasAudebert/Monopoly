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
    private int loyer;
    private Joueur proprietaire;
    
    public Propriete(int prix, int numero, String nomCarreau, EnumerationsMonopoly.TYPE_CARREAU type, int loyer){
        super(numero, nomCarreau, type);
        this.prix = prix;
        this.loyer = loyer;
    }
    
    public abstract int calculLoyer();
    
    public Resultat achatPossible(Joueur joueur){
        Resultat res = new Resultat();
        if (joueur.peutPayer(prix)){
            res.update(this, joueur, TYPE_RESULTAT.achat);
        }else{
            res.update(this, joueur, TYPE_RESULTAT.neRienFaire);
        }
        return res;
    }
    
    public Resultat doitPayerLoyer(){
        return null;
    }
    
    public Joueur getProprietaire(){
        return proprietaire;
    }

    public void setProprietaire(Joueur joueur){
        this.proprietaire = joueur;
    }
    
    public int getLoyer() {
        return loyer;
    }
    
    public int getPrix(){
        return prix;
    }
   
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
