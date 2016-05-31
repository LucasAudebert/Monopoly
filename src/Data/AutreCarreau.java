package Data;

/**
 *
 * @author Maxence
 */
public class AutreCarreau extends Carreau{

    /**
     *
     * @param numero
     * @param nomCarreau
     */
    public AutreCarreau(int numero, String nomCarreau) {
        super(numero, nomCarreau);
    }

    /**
     *
     * @param joueur
     * @return
     */
    @Override
    public Resultat action(Joueur joueur) {
        Resultat res = new Resultat();
        res.update(null, joueur, EnumerationsMonopoly.TYPE_RESULTAT.autreCarreau);
        return res;
    }
}