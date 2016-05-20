package Data;

public class Gare extends Propriete {

    public Gare(int prix, int numero, String nomCarreau, String type) {
        super(prix, numero, nomCarreau, type);
    }

    @Override
    public int calculLoyer() {
        return super.getProprietaire().getNbGares() * 25;
    }

    @Override
    public Resultat action(Joueur joueur) {
        Resultat res = new Resultat();
        if(this.getProprietaire() == null){
            res.update(this, joueur, "acheter");
        }else{
            res.update(this, joueur, "payerLoyer");
        }
        return res;
    }
	
}