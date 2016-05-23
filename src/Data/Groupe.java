package Data;

import java.util.HashSet;

public class Groupe {
	private CouleurPropriete couleur;
        private HashSet<ProprieteAConstruire> proprietes;

    public Groupe(CouleurPropriete couleur){
        proprietes = new HashSet<ProprieteAConstruire>();
        this.couleur = couleur;
    }
        
    public CouleurPropriete getCouleur() {
        return couleur;
    }

    public void addPropriete(ProprieteAConstruire propriete){
        proprietes.add(propriete);
    }
    
    public HashSet<ProprieteAConstruire> getProprietes(){
        return proprietes;
    }
    
    public void setCouleur(CouleurPropriete couleur) {
        this.couleur = couleur;
    }
}