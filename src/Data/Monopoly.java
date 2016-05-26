package Data;

import java.util.ArrayList;
import java.util.HashMap;

public class Monopoly {
    
	private ArrayList<Joueur> joueurs;
        private ArrayList<Carreau> carreaux; // HashMap ??!!!
        private HashMap<EnumerationsMonopoly.COULEUR_PROPRIETE, Groupe> groupes;

        public Monopoly(){
            this.joueurs = new ArrayList<Joueur>();
            this.carreaux = new ArrayList<Carreau>();
            this.groupes = new HashMap<EnumerationsMonopoly.COULEUR_PROPRIETE, Groupe>();
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

        public ArrayList<Joueur> getJoueurs() {
            return joueurs;
        }
        
        public void addJoueur(Joueur joueur){
            joueurs.add(joueur);
        }        

        public void setJoueurs(ArrayList<Joueur> joueurs) {
            this.joueurs = joueurs;
        }
        
        public Groupe getGroupe(EnumerationsMonopoly.COULEUR_PROPRIETE couleur){
            return groupes.get(couleur);
        }

        public void addGroupe(Groupe groupe){
            groupes.put(groupe.getCouleur(), groupe);
        }
        
	public Carreau getNouvellePosition(int des, Carreau anciennePosition) {
	    if(anciennePosition.getNumero() + des > carreaux.size()){
                return getCarreau(anciennePosition.getNumero() + des - (carreaux.size() + 1));
            }else{
                return getCarreau(anciennePosition.getNumero() + des - 1);
            }
	}
        
        public boolean isFinDePartie(){
            return joueurs.size() == 1;
        }
}