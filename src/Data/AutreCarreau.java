package Data;

public class AutreCarreau extends Carreau{

    public AutreCarreau(int numero, String nomCarreau, String type) {
        super(numero, nomCarreau, type);
    }

    @Override
    public Resultat action(Joueur joueur) {
        return null;
    }
}