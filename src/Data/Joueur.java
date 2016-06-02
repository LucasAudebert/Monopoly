package Data;

import java.util.HashSet;

/**
 *
 * @author Maxence
 */
public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
        private HashSet<Compagnie> compagnies;
	private HashSet<Gare> gares;
        private HashSet<ProprieteAConstruire> proprietesAConstruire;
	private Carreau positionCourante;
        private int[] derniereValeurDes;

    /**
     *
     * @param nomJoueur
     * @param carreauDepart
     */
    public Joueur(String nomJoueur, Carreau carreauDepart){
            this.nomJoueur = nomJoueur;
            this.positionCourante = carreauDepart;
            compagnies = new HashSet();
            gares = new HashSet();
            proprietesAConstruire = new HashSet();
        }
        
    /**
     *
     * @return le nom du joueur 
     */
    public String getNomJoueur() {
            return nomJoueur;
        }

    /**
     *
     * @param nomJoueur
     */
    public void setNomJoueur(String nomJoueur) {
            this.nomJoueur = nomJoueur;
        }

    /**
     *
     * @return le cash du joueur 
     */
    public int getCash() {
            return cash;
        }

    /**
     *
     * @param cash
     */
    public void setCash(int cash) {
            this.cash = cash;
        }

    /**
     *
     * @return un HashSet des compagnies du joueur
     */
    public HashSet<Compagnie> getCompagnies() {
            return compagnies;
        }

    /**
     *
     * @param compagnie
     */
    public void addCompagnie(Compagnie compagnie){
            compagnies.add(compagnie);
        }
        
    /**
     *
     * @return un HashSet des gares du joueur
     */
    public HashSet<Gare> getGares() {
            return gares;
        }

    /**
     *
     * @return un HashSet des proprietés du joueur
     */
    public HashSet<Propriete> getProprietes(){
            HashSet proprietes = new HashSet(proprietesAConstruire);
            proprietes.addAll(gares);
            proprietes.addAll(compagnies);
            return proprietes;
        }
        
    /**
     *
     * @param gare
     */
    public void addGare(Gare gare){
            gares.add(gare);
        }

    /**
     *
     * @return un HashSet des proprietés à construire du joueur
     */
    public HashSet<ProprieteAConstruire> getProprieteAConstruires() {
            return proprietesAConstruire;
        }

    /**
     *
     * @param pac
     */
    public void addProprieteAConstruire(ProprieteAConstruire pac){
            proprietesAConstruire.add(pac);
        }
        
    /**
     *
     * @param l 
     * Soustrait l au  cash du joueur
     */
    public void payerLoyer(int l) {
                cash -= l;
	}

    /**
     *
     * @param l
     * ajoute l au cash du joueur
     */
    public void recevoirLoyer(int l) {
		cash += l;
	}

    /**
     *
     * @return le nbr de gare appartenant au joueur
     */
    public int getNbGares() {
		return gares.size();
	}

    /**
     *
     * @return le nbr de compagnies appartenant au joueur
     */
    public int getNbCompagnies(){
                return compagnies.size();
        }     
	
    /**
     *
     * @return le carreau sur lequelle se trouve le joueur
     */
    public Carreau getPositionCourante() {
		return this.positionCourante;
	}

    /**
     *
     * @param des
     * set la dernière valeure des dés du réalisé par le joueur
     */
    public void setDerniereValeurDes(int[] des){
            this.derniereValeurDes = des;
        }
        
    /**
     *
     * @return la dernière valeure des dés du réalisé par le joueur
     */
    public int getDerniereValeurDes(){
            return derniereValeurDes[0]+derniereValeurDes[1];
        }
        
    /**
     *
     * @param nouvellePosition 
     * set le carreau sur lequelle se trouve le joueur
     */
    public void setPositionCourante(Carreau nouvellePosition) {
		positionCourante = nouvellePosition;
	}
        
    /**
     *
     * @param prixC
     * @return vrai si le joueur peut payer le prixC sinon faux
     */
    public boolean peutPayer(int prixC) {
		return cash > prixC;
	}
        
    /**
     *
     * @return vrai sir le joueur a réalisé un double
     */
    public boolean desDouble(){
            return derniereValeurDes[0] == derniereValeurDes[1];
        }
        
    /**
     *
     * @return vraie si le joueur est éliminé (n'a plus d'argent)
     */
    public boolean estElimine(){
            return cash <= 0;
        }
}
