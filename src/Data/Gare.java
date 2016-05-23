package Data;

public class Gare extends Propriete {

    public Gare(int prix, int numero, String nomCarreau, String type) {
        super(prix, numero, nomCarreau, type);
    }

    @Override
    public int calculLoyer() {
        return super.getProprietaire().getNbGares() * 25;
    }	
}