package Data;

public class ProprieteAConstruire extends Propriete{

    private Groupe groupe; 
    private int loyer;
    
    public ProprieteAConstruire(int prix, int numero, String nomCarreau, Groupe groupe, int loyer) {
        super(prix, numero, nomCarreau);
        this.groupe = groupe;
        this.loyer = loyer;
    }

    public int getLoyer() {
        return loyer;
    }
    
    @Override
    public int calculLoyer() {
         if(groupe.memeProprietaire()){
           return getLoyer()*2;
         }else{
           return  getLoyer();
         }
    }

    @Override
    public void achat(Joueur joueur) {
        this.setProprietaire(joueur);
        joueur.addProprieteAConstruire(this);
        joueur.payerLoyer(this.getPrix());
    }
    
}