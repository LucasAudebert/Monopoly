package Data;

public class AutreCarreau extends Carreau{

    public AutreCarreau(int numero, String nomCarreau, String type) {
        super(numero, nomCarreau, type);
    }

    @Override
    public Resultat action(Joueur joueur) {
        Resultat res = new Resultat();
        res.update(null, joueur, EnumerationsMonopoly.typeResultat.autreCarreau);
        return res;
    }
}