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
        private int compteurDouble = 0 ;
        private int compteurEssaiPrison = 0;

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
        
    public String getNomJoueur() {
            return nomJoueur;
        }

    public void setNomJoueur(String nomJoueur) {
            this.nomJoueur = nomJoueur;
        }

    public int getCash() {
            return cash;
        }

    public void setCash(int cash) {
            this.cash = cash;
        }

    public HashSet<Compagnie> getCompagnies() {
            return compagnies;
        }

    public void addCompagnie(Compagnie compagnie){
            compagnies.add(compagnie);
        }
        
    public HashSet<Gare> getGares() {
            return gares;
        }

    public HashSet<Propriete> getProprietes(){
            HashSet proprietes = new HashSet(proprietesAConstruire);
            proprietes.addAll(gares);
            proprietes.addAll(compagnies);
            return proprietes;
        }
        
    public void addGare(Gare gare){
            gares.add(gare);
        }

    public HashSet<ProprieteAConstruire> getProprieteAConstruires() {
            return proprietesAConstruire;
        }

    public void addProprieteAConstruire(ProprieteAConstruire pac){
            proprietesAConstruire.add(pac);
        }
        
    /**
     *
     * @param l 
     * Soustrait l au  cash du joueur
     */
    public void payer(int l) {
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
	
    public Carreau getPositionCourante() {
		return this.positionCourante;
	}

    public void setDerniereValeurDes(int[] des){
            this.derniereValeurDes = des;
        }
        
    public int getDerniereValeurDes(){
            return derniereValeurDes[0]+derniereValeurDes[1];
        }
        
    public void setPositionCourante(Carreau nouvellePosition) {
		positionCourante = nouvellePosition;
	}
        
    /**
     *
     * @param prixC
     * @return vrai si le joueur peut payer le prixC (prix du carreau) sinon faux
     */
    public boolean peutPayer(int prixC) {
		return cash > prixC;
	}
        
    public void gagnerCash(int cash){
        this.cash += cash;
    }
    
    /**
     *
     * @return vrai si le joueur a réalisé un double
     */
    public boolean desDouble(){
            return derniereValeurDes[0] == derniereValeurDes[1];
        }
        
    /**
     *
     * @return vrai si le joueur est éliminé (n'a plus d'argent)
     */
    public boolean estElimine(){
            return cash <= 0;
        }

    public int getCompteurDouble() {
        return compteurDouble;
    }

    public void reinitCompteurDouble() {
        this.compteurDouble = 0;
    }
    
    public void incrementCompteurDee(){
        compteurDouble ++;
    }  
    
    public void incrementCompteurEssaiPrison(){
        compteurEssaiPrison ++;
    } 
    
    public void reinitCompteurEssaiPrison() {
        this.compteurEssaiPrison = 0;
    }
    
    public int getCompteurEssaiPrison() {
        return compteurEssaiPrison;
    }
    
}
