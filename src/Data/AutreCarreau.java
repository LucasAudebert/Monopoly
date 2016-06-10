package Data;

public class AutreCarreau extends Carreau{

    public AutreCarreau(int numero, String nomCarreau) {
        super(numero, nomCarreau);
    }

    @Override
    public Resultat action(Joueur joueur) {
        return new Resultat(this, joueur, EnumerationsMonopoly.TYPE_RESULTAT.neRienFaire); //renvoie un résultat de type "neRienFaire" qui sera analysé par le controleur
    }
}