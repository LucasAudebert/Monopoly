package Data;

import java.util.ArrayList;

public class ProprieteAConstruire extends Propriete{

    private Groupe groupe; 
    private ArrayList<Integer> loyers;
    private int nbMaisons;
    private int prixMaison;
    
    public ProprieteAConstruire(int prix, int numero, String nomCarreau, Groupe groupe, ArrayList<Integer> loyer, int prixMaison) {
        super(prix, numero, nomCarreau);
        this.groupe = groupe;
        this.loyers = loyer;
        this.nbMaisons = 0;
        this.prixMaison = prixMaison;
    }

    public int getLoyer() {
        return loyers.get(nbMaisons);
    }

    public int getNbMaisons() {
        return nbMaisons;
    }
    
    @Override
    public int calculLoyer(Joueur joueur) { //calcul du loyer pour une propriété à construire
         if(groupe.memeProprietaire()){ //si le groupe de cette propriété contient des propriétés ayant toutes le même propriétaire
           return getLoyer()*2; //retourne le loyer de la propriété doublé
         }else{ //sinon
           return  getLoyer(); //retourne le loyer simple
         }
    }

    /**
     *
     * @param joueur
     */
    @Override
    public void achat(Joueur joueur) { //achat pour une propriété à construire
        super.achat(joueur); //achat de la proriété
        joueur.addProprieteAConstruire(this); //ajout de la propriété à construire dans la collection de propriétés à construire du joueur
    }
    
    public int getPrixMaison(){
        return prixMaison;
    }
    
    public void addMaison(){
        nbMaisons++;
    }
    
    public boolean peutConstruire() { //retourne vrai si le joueur peut construire, faux sinon
        return groupe.peutConstruire(this);
    }

    public void construire() {
        nbMaisons = nbMaisons + 1;
    }
}