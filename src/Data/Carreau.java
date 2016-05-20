package Data;

public abstract class Carreau {
	private int numero;
	private String nomCarreau;   
        
        public Carreau(int numero, String nomCarreau){
            this.numero = numero;
            this.nomCarreau = nomCarreau;
        }
        
        public abstract Resultat action(Joueur joueur);
        
}