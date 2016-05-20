package Data;

public class ProprieteAConstruire extends Propriete{

    public ProprieteAConstruire(int prix, int numero, String nomCarreau, String type) {
        super(prix, numero, nomCarreau, type);
    }

    @Override
    public int calculLoyer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resultat action(Joueur joueur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}