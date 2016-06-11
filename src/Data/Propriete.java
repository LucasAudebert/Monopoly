/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.EnumerationsMonopoly.TYPE_RESULTAT;

public abstract class Propriete extends Carreau {
    
    private int prix;
    private Joueur proprietaire;
    
    public Propriete(int prix, int numero, String nomCarreau){
        super(numero, nomCarreau);
        this.prix = prix;
    }
    
    public abstract int calculLoyer(Joueur joueur);
    
    public void achat(Joueur joueur){
        this.setProprietaire(joueur);
        joueur.payer(this.getPrix());

    }
    
    public Resultat achatPossible(Joueur joueur){
        if (joueur.peutPayer(prix)){ //si le joueur peut payer la propriété actuelle
            return new Resultat(this, joueur, TYPE_RESULTAT.achat); //retourne un résultat de type "achat"
        }else{ //sinon
            return new Resultat(this, joueur, TYPE_RESULTAT.neRienFaire); //retourne un résultat de type "neRienFaire"
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
    
    @Override
    public String getInformations() {
        String info = super.getInformations()+"\n";
        info += "Propriètaire : ";
        if (proprietaire != null) {
            info += proprietaire.getNomJoueur();
        } else {
            info += "aucun";
        }
        info += "\nPrix : "+prix;        
        return info;
    }
   
    @Override
    public Resultat action(Joueur joueur) {
        if(this.getProprietaire() == null){ //si la propriété n'a pas de propriétaire
            return achatPossible(joueur); //vérifie si le joueur peut éventuellement l'acheter
        }else if (this.getProprietaire() != joueur){ //si le propriétaire de la propriété est différent du joueur actuel
            return new Resultat(this, joueur, TYPE_RESULTAT.loyer, calculLoyer(joueur)); //retourne un résultat de type "loyer" contenant le calcul du loyer pour cette propriété
        }else { //si le joueur est proprietaire            
            return new Resultat(this, joueur, TYPE_RESULTAT.neRienFaire); //retourne un résultat de type "neRienFaire"
        }
    }
}
