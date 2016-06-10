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
    public int calculLoyer(Joueur joueur) { //calcul du loyer pour une gare        
        return super.getProprietaire().getNbGares() * getLoyer(); //retourne le loyer calculé à partir du nombre de gares possédées par le proprietaire de la gare actuelle et du loyer d'une gare de base
    }	

    @Override
    public void achat(Joueur joueur) { //achat pour une gare
        super.achat(joueur); //achat de la proriété      
        joueur.addGare(this); //ajout de la gare dans la collection de gares du joueur
    }
}