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

    public int getLoyer() {
        return loyer;
    }
    
    /**
     *
     * @return le prix du loyer en fonction du nombre de gares que possède le proprietaire
     */
    @Override
    public int calculLoyer(Joueur joueur) {
        System.out.println(super.getProprietaire().getNbGares());
        System.out.println(getLoyer());
        System.out.println(super.getProprietaire().getNbGares()*getLoyer());        
        return super.getProprietaire().getNbGares() * getLoyer();
    }	

    /**
     *
     * @param joueur
     * set le Joueur joueur comme proprietaire de la Gare
     * ajouter la proprieté aux Gares du joueur
     * fait payer le joueur le prix de la Gare 
     */
    @Override
    public void achat(Joueur joueur) {
        super.achat(joueur);        
        joueur.addGare(this); 
    }
}