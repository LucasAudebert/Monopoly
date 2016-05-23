package Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class Monopoly {
    
	private HashSet<Joueur> joueurs;
        private ArrayList<Carreau> carreaux; // HashMap ??!!!
        private HashMap<CouleurPropriete,Groupe> groupes;

        public Monopoly(){
            this.joueurs = new HashSet<Joueur>();
            this.carreaux = new ArrayList<Carreau>();
            this.groupes = new HashMap<CouleurPropriete,Groupe>();
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
        
        public Groupe getGroupe(CouleurPropriete couleur){
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
}