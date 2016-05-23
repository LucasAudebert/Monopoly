package Data;

import java.util.ArrayList;
import java.util.HashSet;

public class Monopoly {
    
	private HashSet<Joueur> joueurs;
        private ArrayList<Carreau> carreaux; // HashMap ??!!!

        public Monopoly(){
            this.joueurs = new HashSet<Joueur>();
            this.carreaux = new ArrayList<Carreau>();
        }
        
        public ArrayList getCarreaux() {
            return carreaux;
        }
        
        public Carreau getCarreau(int index){
            return carreaux.get(index);
        }
        
        public void addCarreau(Carreau carreau){
            carreaux.add(carreau);
        }

        public HashSet<Joueur> getJoueurs() {
            return joueurs;
        }
        
        public void addJoueur(Joueur joueur){
            joueurs.add(joueur);
        }        

        public void setJoueurs(HashSet<Joueur> joueurs) {
            this.joueurs = joueurs;
        }
        
        

	public Carreau getNouvellePosition(int des, Carreau anciennePosition) {
	    if(anciennePosition.getNumero() + des > carreaux.size()){
                return getCarreau(anciennePosition.getNumero() + des - (carreaux.size() + 1));
            }else{
                return getCarreau(anciennePosition.getNumero() + des - 1);
            }
	}
}