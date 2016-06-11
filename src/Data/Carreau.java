package Data;


public abstract class Carreau {
	private int numero;
	private String nomCarreau;
        
        
    public Carreau(int numero, String nomCarreau){
            this.numero = numero;
            this.nomCarreau = nomCarreau;
        }
        
    public abstract Resultat action(Joueur joueur); //renvoie un résultat dont le type sera défini par redéfinition puis sera analysé par le controleur
        
    public int getNumero(){
            return numero;
        }
        
    public String getNom(){
            return nomCarreau;
        }

    public String getInformations() {
        return "Carreau n°"+numero+" : "+nomCarreau;
    }
        
}