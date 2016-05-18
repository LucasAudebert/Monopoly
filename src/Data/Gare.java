package Data;

public class Gare extends Carreau {
	private Joueur proprietaire;

        public void setProprietaire(Joueur proprietaire) {
            this.proprietaire = proprietaire;
        }

	public void action(Joueur j) {
		throw new UnsupportedOperationException();
	}

	private int calculLoyer() {
		throw new UnsupportedOperationException();
	}

	private Joueur getProprietaire() {
		return this.proprietaire;
	}

	private void achatPossible(Joueur j) {
		throw new UnsupportedOperationException();
	}

	public int getPrix() {
		throw new UnsupportedOperationException();
	}

	public String getNom() {
		throw new UnsupportedOperationException();
	}
}