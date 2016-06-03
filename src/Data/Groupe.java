package Data;

import java.util.ArrayList;

/**
 *
 * @author Maxence
 */
public class Groupe {
	private EnumerationsMonopoly.COULEUR_PROPRIETE couleur;
        private ArrayList<ProprieteAConstruire> proprietes;

   
    public Groupe(EnumerationsMonopoly.COULEUR_PROPRIETE couleur){
        proprietes = new ArrayList<ProprieteAConstruire>();
        this.couleur = couleur;
    }
        
   
    public EnumerationsMonopoly.COULEUR_PROPRIETE getCouleur() {
        return couleur;
    }

    
    public void addPropriete(ProprieteAConstruire propriete){
        proprietes.add(propriete);
    }
    
    public ArrayList<ProprieteAConstruire> getProprietes(){
        return proprietes;
    }    
   
    public void setCouleur(EnumerationsMonopoly.COULEUR_PROPRIETE couleur) {
        this.couleur = couleur;
    }
    
    /**
     *
     * @return vrai si les proprietés du groupe ont le même proprietaire sinon faux
     */
    public boolean memeProprietaire(){
        boolean resultat = true;       
        int i =0;        
        Joueur jProprio = proprietes.get(i).getProprietaire() ; // jProprio est egual au proprietaire de la première proprieté
        i++;
        // tant que le proprietaire de i- est le même que le proprietaire à i ET i < au nbr de proprietes
        while(resultat && i < proprietes.size()){
            resultat = proprietes.get(i).getProprietaire() == jProprio; //vrai si le proprietaire de i et le même que le proprietaire à i-1
            jProprio = proprietes.get(i).getProprietaire() ; // jProprio jProprio est égual au proprietaire de la i ème proprieté
            i++;
        }
        return resultat;
    }
}