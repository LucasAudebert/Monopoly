package Data;

public class Compagnie extends Propriete {

    public Compagnie(int prix, int numero, String nomCarreau, String type, int loyer) {
        super(prix, numero, nomCarreau, type, loyer);
    }

    @Override
    public int calculLoyer() {
        if(getProprietaire().getNbCompagnies() == 1){
            return 4 * getProprietaire().getDerniereValeurDes();  
        }else{
            return 10 * getProprietaire().getDerniereValeurDes();
        }   
    }
}