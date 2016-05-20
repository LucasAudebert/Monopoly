package Data;

public abstract class Carreau {
	private int numero;
	private String nomCarreau;
        private String type;
        
        public Carreau(int numero, String nomCarreau, String type){
            this.numero = numero;
            this.nomCarreau = nomCarreau;
            this.type = type;
        }
        
        public abstract Resultat action(Joueur joueur);
        
        public int getNumero(){
            return numero;
        }
        
}