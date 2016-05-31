package Data;

import java.util.ArrayList;

/**
 *
 * @author Maxence
 */
public class Groupe {
	private EnumerationsMonopoly.COULEUR_PROPRIETE couleur;
        private ArrayList<ProprieteAConstruire> proprietes;

    /**
     *
     * @param couleur
     */
    public Groupe(EnumerationsMonopoly.COULEUR_PROPRIETE couleur){
        proprietes = new ArrayList<ProprieteAConstruire>();
        this.couleur = couleur;
    }
        
    /**
     *
     * @return
     */
    public EnumerationsMonopoly.COULEUR_PROPRIETE getCouleur() {
        return couleur;
    }

    /**
     *
     * @param propriete
     */
    public void addPropriete(ProprieteAConstruire propriete){
        proprietes.add(propriete);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<ProprieteAConstruire> getProprietes(){
        return proprietes;
    }
    
    /**
     *
     * @param couleur
     */
    public void setCouleur(EnumerationsMonopoly.COULEUR_PROPRIETE couleur) {
        this.couleur = couleur;
    }
    
    /**
     *
     * @return
     */
    public boolean memeProprietaire(){
        boolean resultat = true;
       
        int i =0;
        Joueur jProprio = proprietes.get(i).getProprietaire() ;
        i++;
        while(resultat && i < proprietes.size()){
            resultat = proprietes.get(i).getProprietaire() == jProprio;
            jProprio = proprietes.get(i).getProprietaire() ;
            i++;
        }
        return resultat;
    }
}