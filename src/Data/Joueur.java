package Data;

import java.util.ArrayList;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
        private ArrayList<Compagnie> compagnies;
	private ArrayList<Gare> gares;
        private ArrayList<ProprieteAConstruire> proprietes;
	private Carreau positionCourante;
        private int[] derniereValeurDes;

        public Joueur(String nomJoueur, Carreau carreauDepart){
            this.nomJoueur = nomJoueur;
            this.positionCourante = carreauDepart;
            compagnies = new ArrayList();
            gares = new ArrayList();
            proprietes = new ArrayList();
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

        public ArrayList<Compagnie> getCompagnies() {
            return compagnies;
        }

        public void addCompagnie(Compagnie compagnie){
            compagnies.add(compagnie);
        }
        
        public ArrayList<Gare> getGares() {
            return gares;
        }

        public void addGare(Gare gare){
            gares.add(gare);
        }

        public ArrayList<ProprieteAConstruire> getProprieteAConstruires() {
            return proprietes;
        }

        public void addProprieteAConstruire(ProprieteAConstruire pac){
            proprietes.add(pac);
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
		if(cash >= prixC){
                    return true;
                }else{
                    return false;
                }
	}
        
        public boolean desDouble(){
            return derniereValeurDes[0] == derniereValeurDes[1];
        }
}
