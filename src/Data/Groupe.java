package Data;

import java.util.ArrayList;

public class Groupe {
	private CouleurPropriete couleur;
        private ArrayList<ProprieteAConstruire> proprietes;

    public Groupe(CouleurPropriete couleur){
        proprietes = new ArrayList<ProprieteAConstruire>();
        this.couleur = couleur;
    }
        
    public CouleurPropriete getCouleur() {
        return couleur;
    }

    public void addPropriete(ProprieteAConstruire propriete){
        proprietes.add(propriete);
    }
    
    public ArrayList<ProprieteAConstruire> getProprietes(){
        return proprietes;
    }
    
    public void setCouleur(CouleurPropriete couleur) {
        this.couleur = couleur;
    }
    
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