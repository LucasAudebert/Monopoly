package Data;

/**
 *
 * @author Maxence
 */
public class Gare extends Propriete {

    private int loyer ;
    
    /**
     *
     * @param prix
     * @param numero
     * @param nomCarreau
     * @param loyer
     */
    public Gare(int prix, int numero, String nomCarreau, int loyer) {
        super(prix, numero, nomCarreau);
        this.loyer = loyer;
    }

    /**
     *
     * @return
     */
    public int getLoyer() {
        return loyer;
    }
    
    /**
     *
     * @return
     */
    @Override
    public int calculLoyer() {
        return super.getProprietaire().getNbGares() * getLoyer();
    }	

    /**
     *
     * @param joueur
     */
    @Override
    public void achat(Joueur joueur) {
        this.setProprietaire(joueur);
        joueur.addGare(this);
        joueur.payerLoyer(getPrix());
    }
}