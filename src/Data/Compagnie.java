package Data;

public class Compagnie extends Propriete {

    public Compagnie(int prix, int numero, String nomCarreau, String type) {
        super(prix, numero, nomCarreau, type);
    }

    @Override
    public int calculLoyer() {
        if(getProprietaire().getNbCompagnies() == 1){
            return 4 * getProprietaire().getValeurDes();  
        }else{
            return 10 * getProprietaire().getValeurDes();
        }   
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