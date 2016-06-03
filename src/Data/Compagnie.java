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
    public int calculLoyer() {
        if(getProprietaire().getNbCompagnies() == 1){
            return 4 * getProprietaire().getDerniereValeurDes();  
        }else{
            return 10 * getProprietaire().getDerniereValeurDes();
        }   
    }

    /**
     *
     * @param joueur
     */
    @Override
    public void achat(Joueur joueur) {
        this.setProprietaire(joueur);
        joueur.addCompagnie(this);
        joueur.payerLoyer(getPrix());
    }
}