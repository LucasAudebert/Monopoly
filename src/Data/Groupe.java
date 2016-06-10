package Data;

import java.util.ArrayList;

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
    
    public boolean memeProprietaire(){
        boolean resultat = true;       
        int i =0;        
        Joueur jProprio = proprietes.get(i).getProprietaire() ; // jProprio est égal au propriétaire de la première proprieté
        i++;
        //tant que le proprietaire de i- est le même que le proprietaire à i ET i < au nombre de propriétés
        while(resultat && i < proprietes.size()){
            resultat = proprietes.get(i).getProprietaire() == jProprio; //vrai si le propriétaire de i et le même que le propriétaire à i-1
            jProprio = proprietes.get(i).getProprietaire() ; // jProprio est égal au propriétaire de la ième proprieté
            i++;
        }
        return resultat; //retourne vrai si les proprietés du groupe ont le même proprietaire sinon faux
    }
    
    public boolean peutConstruire(ProprieteAConstruire pac){
        boolean resultat = true;
        int i = 0;
        
        while(resultat && i < proprietes.size()){
            resultat = proprietes.get(i).getNbMaisons() >= pac.getNbMaisons();
            i++;
        }
        return resultat && memeProprietaire();
    }
}