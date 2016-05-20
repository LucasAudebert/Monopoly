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
        Resultat res = new Resultat();
        res.setJoueur(joueur);
        res.setCarreau(this);
        if(this.getProprietaire() == null){
            res.setActionJoueur("acheter");
        }else{
            res.setActionJoueur("payerLoyer");
        }
        return res;
    }
	
}