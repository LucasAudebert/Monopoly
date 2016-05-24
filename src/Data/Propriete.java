/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.EnumerationsMonopoly.typeResultat;

/**
 *
 * @author blachert
 */
public abstract class Propriete extends Carreau {
    
    private int prix;
    private int loyer;
    private Joueur proprietaire;
    
    public Propriete(int prix, int numero, String nomCarreau, String type, int loyer){
        super(numero, nomCarreau, type);
        this.prix = prix;
        this.loyer = loyer;
    }
    
    public abstract int calculLoyer();
    
    public Resultat achatPossible(Joueur joueur){
        Resultat res = new Resultat();
        if (joueur.peutPayer(prix)){
            res.update(this, joueur, typeResultat.achat);
        }else{
            res.update(this, joueur, typeResultat.neRienFaire);
        }
        return res;
    }
    
    public Resultat doitPayerLoyer(){
        return null;
    }
    
    public Joueur getProprietaire(){
        return proprietaire;
    }

    public int getLoyer() {
        return loyer;
    }
   
    @Override
    public Resultat action(Joueur joueur) {
        Resultat res = new Resultat();
        if(this.getProprietaire() == null){
            System.out.println("null");
            res = achatPossible(joueur);
        }else if (this.getProprietaire() != joueur){
            res.update(this, joueur, typeResultat.loyer);
            System.out.println("loyer");
        }else{
            res.update(this, joueur, typeResultat.neRienFaire);
            System.out.println("nerinfaire");
        }
        return res;
    }
}
