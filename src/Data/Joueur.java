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
     * @return
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
     * @return
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
     * @return
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
     * @return
     */
    public HashSet<Gare> getGares() {
            return gares;
        }

    /**
     *
     * @return
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
     * @return
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
     */
    public void payerLoyer(int l) {
                cash -= l;
	}

    /**
     *
     * @param l
     */
    public void recevoirLoyer(int l) {
		cash += l;
	}

    /**
     *
     * @return
     */
    public int getNbGares() {
		return gares.size();
	}

    /**
     *
     * @return
     */
    public int getNbCompagnies(){
                return compagnies.size();
        }     
	
    /**
     *
     * @return
     */
    public Carreau getPositionCourante() {
		return this.positionCourante;
	}

    /**
     *
     * @param des
     */
    public void setDerniereValeurDes(int[] des){
            this.derniereValeurDes = des;
        }
        
    /**
     *
     * @return
     */
    public int getDerniereValeurDes(){
            return derniereValeurDes[0]+derniereValeurDes[1];
        }
        
    /**
     *
     * @param nouvellePosition
     */
    public void setPositionCourante(Carreau nouvellePosition) {
		positionCourante = nouvellePosition;
	}
        
    /**
     *
     * @param prixC
     * @return
     */
    public boolean peutPayer(int prixC) {
		return cash > prixC;
	}
        
    /**
     *
     * @return
     */
    public boolean desDouble(){
            return derniereValeurDes[0] == derniereValeurDes[1];
        }
        
    /**
     *
     * @return
     */
    public boolean estElimine(){
            return cash <= 0;
        }
}
