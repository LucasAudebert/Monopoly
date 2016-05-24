package Data;


public class Resultat {
	
    private Propriete propriete;
    private Joueur joueur;
    private String typeResultat;
    

    private EnumerationsMonopoly.typeResultat type;


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

    public void setPropriete(Propriete propriete) {
        this.propriete = propriete;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public void setType(EnumerationsMonopoly.typeResultat type) {
        this.type = type;
    }

}
