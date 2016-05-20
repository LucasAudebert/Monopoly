package Data;

public class AutreCarreau extends Carreau{

    public AutreCarreau(int numero, String nomCarreau) {
        super(numero, nomCarreau);
    }

    @Override
    public Resultat action(Joueur joueur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}