package Data;

public class Gare extends Propriete {

    public Gare(int prix, int numero, String nomCarreau, EnumerationsMonopoly.TYPE_CARREAU type, int loyer) {
        super(prix, numero, nomCarreau, type, loyer);
    }

    @Override
    public int calculLoyer() {
        return super.getProprietaire().getNbGares() * getLoyer();
    }	
}