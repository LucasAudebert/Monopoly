
package Data;

public class AllerEnPrison extends AutreCarreau{

    public AllerEnPrison(int numero, String nomCarreau) {
        super(numero, nomCarreau);
    }
    
    @Override
    public Resultat action(Joueur joueur) {
        
        return new Resultat(this, joueur,EnumerationsMonopoly.TYPE_RESULTAT.allerEnPrison); //renvoie un résultat de type "allerEnPrison" qui sera analysé par le controleur
    }
    
}
