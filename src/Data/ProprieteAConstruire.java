package Data;

/**
 *
 * @author Maxence
 */
public class ProprieteAConstruire extends Propriete{

    private Groupe groupe; 
    private int loyer;
    
    /**
     *
     * @param prix
     * @param numero
     * @param nomCarreau
     * @param groupe
     * @param loyer
     */
    public ProprieteAConstruire(int prix, int numero, String nomCarreau, Groupe groupe, int loyer) {
        super(prix, numero, nomCarreau);
        this.groupe = groupe;
        this.loyer = loyer;
    }

    /**
     *
     * @return
     */
    public int getLoyer() {
        return loyer;
    }
    
    /**
     *
     * @return
     */
    @Override
    public int calculLoyer(Joueur joueur) {
         if(groupe.memeProprietaire()){
           return getLoyer()*2;
         }else{
           return  getLoyer();
         }
    }

    /**
     *
     * @param joueur
     */
    @Override
    public void achat(Joueur joueur) {
        super.achat(joueur);
        joueur.addProprieteAConstruire(this);
    }
    
}