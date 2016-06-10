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
    private int loyer;
    private Propriete propriete;    
    private AutreCarreau autreCarreau;
    private int taxe;
    
    public Resultat(Joueur joueur, EnumerationsMonopoly.TYPE_RESULTAT type){
        update(joueur, type);
    }
    
    public Resultat(Propriete propriete, Joueur joueur, EnumerationsMonopoly.TYPE_RESULTAT type){
        update(joueur, type);
        this.propriete = propriete;
    }

    public Resultat(Propriete propriete, Joueur joueur, EnumerationsMonopoly.TYPE_RESULTAT type, int loyer){ //résultat basique pour une Propriété contenant en plus le loyer
        update(joueur, type);
        this.propriete = propriete;
        this.loyer = loyer;
    }
    
    public Resultat(AutreCarreau autreCarreau, Joueur joueur, EnumerationsMonopoly.TYPE_RESULTAT type){
        update(joueur, type);
        this.autreCarreau = autreCarreau;
    }    

    public Resultat(AutreCarreau autreCarreau, Joueur joueur, EnumerationsMonopoly.TYPE_RESULTAT type, int taxe){ //résultat basique pour un AutreCarreau contenant en plus une taxe
        update(joueur, type);
        this.autreCarreau = autreCarreau;
        this.taxe = taxe;
    }   
    
    public void update(Joueur joueur, EnumerationsMonopoly.TYPE_RESULTAT type){ //modifie le résultat
        this.joueur = joueur;
        typeResultat = type;
    }
    
    public Joueur getJoueur() {
        return joueur;
    }
    
    public EnumerationsMonopoly.TYPE_RESULTAT getTypeResultat() {
        return typeResultat;
    }    

    public int getLoyer() {
        return loyer;
    }    
    
    public Propriete getPropriete() {
        return propriete;
    }  
    
    public AutreCarreau getCarreau() {
        return autreCarreau;
    }
    
    public int getTaxe() {
        return taxe;
    }
}
