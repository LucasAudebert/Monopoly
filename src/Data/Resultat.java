package Data;


public abstract class Resultat {
	
    private Propriete propriete;
    private Joueur joueur;
    private String typeResultat;
    
    public Resultat(){
        
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Propriete getPropriete() {
        return propriete;
    }
   
    public void update(Propriete propriete, Joueur joueur){
        this.joueur = joueur;
        this.propriete = propriete;
    }

}