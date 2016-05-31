package Data;

/**
 *
 * @author Maxence
 */
public abstract class Carreau {
	private int numero;
	private String nomCarreau;
        
    /**
     *
     * @param numero
     * @param nomCarreau
     */
    public Carreau(int numero, String nomCarreau){
            this.numero = numero;
            this.nomCarreau = nomCarreau;
        }
        
    /**
     *
     * @param joueur
     * @return
     */
    public abstract Resultat action(Joueur joueur);
        
    /**
     *
     * @return
     */
    public int getNumero(){
            return numero;
        }
        
    /**
     *
     * @return
     */
    public String getNom(){
            return nomCarreau;
        }
        
}