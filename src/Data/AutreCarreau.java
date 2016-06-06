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
    public ResultatPropriete action(Joueur joueur) {
        ResultatPropriete res = new ResultatPropriete();
        res.update(null, joueur, EnumerationsMonopoly.TYPE_RESULTAT.autreCarreau);
        return res;
    }
}