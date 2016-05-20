package Data;

import java.util.ArrayList;

public class Monopoly {
    
	private ArrayList<Joueur> joueurs;
        private ArrayList<Carreau> carreaux;

        public Monopoly(ArrayList joueurs){
            this.joueurs = joueurs;
            this.carreaux = new ArrayList();
        }
        
        public ArrayList getCarreaux() {
            return carreaux;
        }
        
        public void addCarreau(Carreau carreau){
            carreaux.add(carreau);
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