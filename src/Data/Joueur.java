package Data;

import java.util.ArrayList;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
        private ArrayList<Compagnie> compagnies;
	private ArrayList<Gare> gares;
        private ArrayList<ProprieteAConstruire> proprieteAConstruires;
	private Carreau positionCourante;

        public Joueur(String nomJoueur, Carreau carreauDepart){
            this.nomJoueur = nomJoueur;
            this.positionCourante = carreauDepart;
            compagnies = new ArrayList();
            gares = new ArrayList();
            proprieteAConstruires = new ArrayList();
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

        public ArrayList<Gare> getGares() {
            return gares;
        }

        public void setGares(ArrayList<Gare> gares) {
            this.gares = gares;
        }

	public void payerLoyer(int l) {
		throw new UnsupportedOperationException();
	}

	public void recevoirLoyer(int l) {
		cash += l;
	}

	public int getNbGares() {
		return gares.size();
	}

	public String getNomProprietaire() {
		throw new UnsupportedOperationException();
	}

	public Carreau getPositionCourante() {
		return this.positionCourante;
	}

	public void setPositionCourante(Carreau nouvellePosition) {
		positionCourante = nouvellePosition;
	}

	public boolean peutAcheter(int prixC) {
		if(cash >= prixC){
                    return true;
                }else{
                    return false;
                }
	}
}
