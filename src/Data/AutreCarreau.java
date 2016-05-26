package Data;

public class AutreCarreau extends Carreau{

    public AutreCarreau(int numero, String nomCarreau) {
        super(numero, nomCarreau);
    }

    @Override
    public Resultat action(Joueur joueur) {
        Resultat res = new Resultat();
        res.update(null, joueur, EnumerationsMonopoly.TYPE_RESULTAT.autreCarreau);
        return res;
    }
}