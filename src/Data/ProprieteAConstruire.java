package Data;

import java.util.ArrayList;

/**
 *
 * @author Maxence
 */
public class ProprieteAConstruire extends Propriete{

    private Groupe groupe; 
    private ArrayList<Integer> loyers;
    private int nbMaisons;
    private int prixMaison;
    
    /**
     *
     * @param prix
     * @param numero
     * @param nomCarreau
     * @param groupe
     * @param loyer
     * @param prixMaison
     */
    public ProprieteAConstruire(int prix, int numero, String nomCarreau, Groupe groupe, ArrayList<Integer> loyer, int prixMaison) {
        super(prix, numero, nomCarreau);
        this.groupe = groupe;
        this.loyers = loyer;
        this.nbMaisons = 0;
        this.prixMaison = prixMaison;
    }

    /**
     *
     * @return
     */
    public int getLoyer() {
        return loyers.get(nbMaisons);
    }

    public int getNbMaisons() {
        return nbMaisons;
    }
    
    /**
     *
     * @return
     */
    @Override
    public int calculLoyer(Joueur joueur) {
         if(groupe.memeProprietaire()){
           return getLoyer()*2;
         }else{
           return  getLoyer();
         }
    }

    /**
     *
     * @param joueur
     */
    @Override
    public void achat(Joueur joueur) {
        super.achat(joueur);
        joueur.addProprieteAConstruire(this);
    }
    
    public int getPrixMaison(){
        return prixMaison;
    }
    
    public void addMaison(){
        nbMaisons++;
    }
    
    public boolean peutConstruire() {
        return groupe.peutConstruire(this);
    }
}