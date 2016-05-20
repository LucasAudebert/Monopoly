package Data;

public class Resultat {
	
    private Carreau carreau;
    private Joueur joueur;
    private String actionJoueur;

    public Resultat(){

    }

    public Carreau getCarreau() {
        return carreau;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public String getActionJoueur() {
        return actionJoueur;
    }

    public void update(Carreau carreau, Joueur joueur, String actionJoueur){
        this.carreau = carreau;
        this.joueur = joueur;
        this.actionJoueur = actionJoueur;
    }

}