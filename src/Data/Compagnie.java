package Data;

/**
 *
 * @author Maxence
 */
public class Compagnie extends Propriete {

    /**
     *
     * @param prix
     * @param numero
     * @param nomCarreau
     */
    public Compagnie(int prix, int numero, String nomCarreau) {
        super(prix, numero, nomCarreau);
    }

    @Override
    public int calculLoyer(Joueur joueur) {
        if(getProprietaire().getNbCompagnies() == 1){
            return 4 * joueur.getDerniereValeurDes();  
        }else{
            return 10 * joueur.getDerniereValeurDes();
        }   
    }

    /**
     *
     * @param joueur
     */
    @Override
    public void achat(Joueur joueur) {
        super.achat(joueur);
        joueur.addCompagnie(this);
    }
}