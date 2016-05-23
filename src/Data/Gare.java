package Data;

public class Gare extends Propriete {

    public Gare(int prix, int numero, String nomCarreau, String type, int loyer) {
        super(prix, numero, nomCarreau, type, loyer);
    }

    @Override
    public int calculLoyer() {
        return super.getProprietaire().getNbGares() * getLoyer();
    }	
}