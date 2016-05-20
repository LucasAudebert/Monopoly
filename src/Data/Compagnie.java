package Data;

public class Compagnie extends Propriete {

    public Compagnie(int prix, int numero, String nomCarreau) {
        super(prix, numero, nomCarreau);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}