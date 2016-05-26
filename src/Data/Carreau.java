package Data;

public abstract class Carreau {
	private int numero;
	private String nomCarreau;
        private EnumerationsMonopoly.TYPE_CARREAU type;
        
        public Carreau(int numero, String nomCarreau, EnumerationsMonopoly.TYPE_CARREAU type){
            this.numero = numero;
            this.nomCarreau = nomCarreau;
            this.type = type;
        }
        
        public abstract Resultat action(Joueur joueur);
        
        public int getNumero(){
            return numero;
        }
        
        public String getNom(){
            return nomCarreau;
        }
        
        public EnumerationsMonopoly.TYPE_CARREAU getType(){
            return type;
        }
        
}