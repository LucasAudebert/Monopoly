
package Data;

public class CarreauPiocherCarteCDC extends AutreCarreau { //Carreau caisse de communauté

    public CarreauPiocherCarteCDC(int numero, String nomCarreau) {
        super(numero, nomCarreau);
    }
    
    @Override
    public Resultat action(Joueur joueur){
        return new Resultat(this, joueur,EnumerationsMonopoly.TYPE_RESULTAT.piocherUneCarteCDC); //renvoie un résultat de type "piocherUneCarteCDC" qui sera analysé par le controleur
    } 
}
