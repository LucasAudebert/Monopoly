package Data;

import java.util.HashSet;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
        private HashSet<Compagnie> compagnies;
	private HashSet<Gare> gares;
        private HashSet<ProprieteAConstruire> proprietesAConstruire;
	private Carreau positionCourante;
        private int[] derniereValeurDes;

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
        
	public void payerLoyer(int l) {
                cash -= l;
	}

	public void recevoirLoyer(int l) {
		cash += l;
	}

	public int getNbGares() {
		return gares.size();
	}

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
        
        public boolean peutPayer(int prixC) {
		return cash > prixC;
	}
        
        public boolean desDouble(){
            return derniereValeurDes[0] == derniereValeurDes[1];
        }
        
        public boolean estElimine(){
            return cash <= 0;
        }
}
