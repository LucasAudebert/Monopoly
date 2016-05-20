package Data;

import java.util.ArrayList;

public class Monopoly {
    
	private ArrayList<Joueur> joueurs;
        private ArrayList<Carreau> carreaux; // HashMap ??!!!

        public Monopoly(){
            this.joueurs = new ArrayList<Joueur>();
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

        /*public Joueur getJoueur(String nomJoueur) { // HashMap ?
            
        }*/
        
        public void addJoueur(Joueur joueur){
            joueurs.add(joueur);
        }        

        public void setJoueurs(ArrayList<Joueur> joueurs) {
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