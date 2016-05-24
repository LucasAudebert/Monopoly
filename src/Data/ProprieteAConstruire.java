package Data;

public class ProprieteAConstruire extends Propriete{

    private Groupe groupe; 
    
    public ProprieteAConstruire(int prix, int numero, String nomCarreau, String type, Groupe groupe, int loyer) {
        super(prix, numero, nomCarreau, type, loyer);
        this.groupe = groupe;
    }

    @Override
    public int calculLoyer() {
         if(groupe.memeProprietaire()){
           return getLoyer()*2;
         }else{
           return  getLoyer();
         }
    }
}