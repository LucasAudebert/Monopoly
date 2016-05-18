package Data;

import java.util.ArrayList;

public class Monopoly {
	private Carreau carreaux;
	private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();

        public Carreau getCarreaux() {
            return carreaux;
        }

        public void setCarreaux(Carreau carreaux) {
            this.carreaux = carreaux;
        }

        public ArrayList<Joueur> getJoueurs() {
            return joueurs;
        }

        public void setJoueurs(ArrayList<Joueur> joueurs) {
            this.joueurs = joueurs;
        }

	public Carreau getNouvellePosition(Object des, Object anciennePosition) {
		throw new UnsupportedOperationException();
	}
}