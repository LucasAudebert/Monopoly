package Diagramme_du_domaine;

import java.util.ArrayList;
import Diagramme_du_domaine.Gare;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
	public ArrayList<Gare> gares = new ArrayList<Gare>();
	private Carreau positionCourante;

	public void payerLoyer(int l) {
		throw new UnsupportedOperationException();
	}

	public void recevoirLoyer(int l) {
		throw new UnsupportedOperationException();
	}

	public int getNbGares() {
		throw new UnsupportedOperationException();
	}

	public String getNomProprietaire() {
		throw new UnsupportedOperationException();
	}

	public Carreau getPositionCourante() {
		return this.positionCourante;
	}

	public void setPositionCourante(Carreau nouvellePosition) {
		throw new UnsupportedOperationException();
	}

	public boolean peutAcheter(int prixC) {
		throw new UnsupportedOperationException();
	}
}