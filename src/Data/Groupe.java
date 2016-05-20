package Data;

import java.util.HashSet;

public class Groupe {
	private CouleurPropriete couleur;
        private HashSet<Carreau> carreaux;

    public Groupe(){
        carreaux = new HashSet<Carreau>();
    }
        
    public CouleurPropriete getCouleur() {
        return couleur;
    }

    public void setCouleur(CouleurPropriete couleur) {
        this.couleur = couleur;
    }
}