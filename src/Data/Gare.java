package Data;

public class Gare extends Propriete {

    public Gare(int prix, int numero, String nomCarreau) {
        super(prix, numero, nomCarreau);
    }

    @Override
    public int calculLoyer() {
        return super.getProprietaire().getNbGares() * 25;
    }

    @Override
    public Resultat action(Joueur joueur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}