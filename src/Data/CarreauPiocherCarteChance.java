
package Data;


public class CarreauPiocherCarteChance extends AutreCarreau {
    
    
    public CarreauPiocherCarteChance(int numero, String nomCarreau) {
        super(numero, nomCarreau);
    }
    
    @Override
    public Resultat action(Joueur joueur){
        return new Resultat(this, joueur,EnumerationsMonopoly.TYPE_RESULTAT.piocherUneCarteChance); //renvoie un résultat de type "piocherUneCarteChance" qui sera analysé par le controleur
    } 
}
