package Data;

/**
 *
 * @author Maxence
 */
public class ResultatPropriete extends Resultat {
	
    private Propriete propriete;
    private int loyer;

    public ResultatPropriete() {
        super();
    }

   
    public Propriete getPropriete() {
        return propriete;
    }
    
    /**
     *
     * @param propriete
     * @param joueur
     * @param type
     */
    public void update(Propriete propriete, Joueur joueur, EnumerationsMonopoly.TYPE_RESULTAT type){
        super.update(joueur, type);
        this.propriete = propriete;
    }

    /**
     *
     * @param propriete
     * @param joueur
     * @param type
     * @param loyer
     */
    public void update(Propriete propriete, Joueur joueur, EnumerationsMonopoly.TYPE_RESULTAT type, int loyer){
        super.update(joueur, type);
        this.propriete = propriete;
        this.loyer = loyer;
    }   

    public int getLoyer() {
        return loyer;
    }
}
