package Data;


public class Resultat {
	
    private Carreau carreau;
    private Joueur joueur;
    private EnumerationsMonopoly.typeResultat type;


    public Resultat(){        
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Carreau getCarreau() {
        return carreau;
    }
   
    public void update(Carreau carreau, Joueur joueur, EnumerationsMonopoly.typeResultat type){
        this.joueur = joueur;
        this.carreau = carreau;
    }

    public EnumerationsMonopoly.typeResultat getType() {
        return type;
    }

    public void setCarreau(Carreau carreau) {
        this.carreau = carreau;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public void setType(EnumerationsMonopoly.typeResultat type) {
        this.type = type;
    }

}
