package Data;

public class Gare extends Propriete {

    private int loyer ;
    
    public Gare(int prix, int numero, String nomCarreau, int loyer) {
        super(prix, numero, nomCarreau);
        this.loyer = loyer;
    }

    public int getLoyer() {
        return loyer;
    }
    
    @Override
    public int calculLoyer() {
        return super.getProprietaire().getNbGares() * getLoyer();
    }	

    @Override
    public void achat(Joueur joueur) {
        this.setProprietaire(joueur);
        joueur.addGare(this);
    }
}