package Data;

public class Compagnie extends Propriete {

    public Compagnie(int prix, int numero, String nomCarreau) {
        super(prix, numero, nomCarreau);
    }

    @Override
    public int calculLoyer(Joueur joueur) { //calcul du loyer pour une compagnie
        if(getProprietaire().getNbCompagnies() == 1){ //si le nombre de compagnies du proprietaire de la compagnie actuelle est égal à 1
            return 4 * joueur.getDerniereValeurDes(); //on multiplie la valeur des dés par 4
        }else{ 
            return 10 * joueur.getDerniereValeurDes(); //sinon on multiplie la valeur des dés par 10
        }   
    }

    @Override
    public void achat(Joueur joueur) { //achat pour une compagnie
        super.achat(joueur); //achat de la proriété
        joueur.addCompagnie(this); //ajout de la compagnie dans la collection de compagnies du joueur
    }
}