package Data;


public class Resultat {
	
    private Propriete propriete;
    private Joueur joueur;
    private EnumerationsMonopoly.TYPE_RESULTAT typeResultat;
    private int loyer;


    public Resultat(){
        
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Propriete getPropriete() {
        return propriete;
    }
 
    public EnumerationsMonopoly.TYPE_RESULTAT getTypeResultat() {
        return typeResultat;
    }
    
    public void update(Propriete propriete, Joueur joueur, EnumerationsMonopoly.TYPE_RESULTAT type){
        this.joueur = joueur;
        this.propriete = propriete;
        this.typeResultat = type;
    }

     public void update(Propriete propriete, Joueur joueur, EnumerationsMonopoly.TYPE_RESULTAT type, int loyer){
        this.joueur = joueur;
        this.propriete = propriete;
        this.typeResultat = type;
        this.loyer = loyer;
    }   

    public int getLoyer() {
        return loyer;
    }
}
