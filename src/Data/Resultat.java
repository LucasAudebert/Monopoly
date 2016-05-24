package Data;


public class Resultat {
	
    private Propriete propriete;
    private Joueur joueur;
    private EnumerationsMonopoly.typeResultat typeResultat;


    public Resultat(){        
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Propriete getPropriete() {
        return propriete;
    }
   
    public void update(Propriete propriete, Joueur joueur, EnumerationsMonopoly.typeResultat type){
        this.joueur = joueur;
        this.propriete = propriete;
    }

    public EnumerationsMonopoly.typeResultat getTypeResultat() {
        return typeResultat;
    }

    public void setCarreau(Propriete propriete) {
        this.propriete = propriete;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public void setType(EnumerationsMonopoly.typeResultat typeResultat) {
        this.typeResultat = typeResultat;
    }

}
