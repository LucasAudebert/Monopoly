package Data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Maxence
 */
public class Monopoly {
    
	private ArrayList<Joueur> joueurs;
        private ArrayList<Joueur> joueursElimines;
        private ArrayList<Carreau> carreaux; // HashMap ??!!!
        private HashMap<EnumerationsMonopoly.COULEUR_PROPRIETE, Groupe> groupes;

    
    public Monopoly(){
            this.joueurs = new ArrayList<Joueur>();
            this.joueursElimines = new ArrayList<Joueur>();
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

    public ArrayList<Joueur> getJoueursElimines() {
        return joueursElimines;
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
        
    /**
     *
     * @param des
     * @param anciennePosition
     * 
     * @return le nouveau carreau selon la valeur des dés et un carreau
     */
    public Carreau getNouvellePosition(int des, Carreau anciennePosition) {
	    if(anciennePosition.getNumero() + des > carreaux.size()){// Si la valeur des dés + l'ancienne position est superieure à la valeur des dés
                return getCarreau(anciennePosition.getNumero() + des - (carreaux.size() + 1));// calcul la nouvelle position si la valeur des dés + l'ancienne position est supérieure au nbr de carreaux 
            }else{
                return getCarreau(anciennePosition.getNumero() + des - 1);// calcul la nouvelle position si la valeur des dés + l'ancienne position est inferieure au nbr de carreaux 
            }
	}
        
    /**
     *
     * @param joueur 
     * ajoute le joueur à la liste de joueur éliminé 
     * boucle sur les proprietés qu'il possède pour mettre le proprietaire à null
     */
    public void eliminerJoueur(Joueur joueur){    
        joueursElimines.add(joueur);
        for(Propriete pTemp : joueur.getProprietes()){
            pTemp.setProprietaire(null);
        }      
    }
        
    /**
     *
     * @return vrai si le nbr de joueurs eliminés est egual au nombre de joueurs -1 (si il reste juste un joueur pas eliminé) faux sinon
     */
    public boolean isFinDePartie(){
        int cpt = 0;
        for(Joueur jTemp :joueurs){
            if(jTemp.estElimine()){
               cpt++; 
            }
        }
        
        return (cpt == joueurs.size()-1);
    }
    
    public Carreau getPrison(){
      return  carreaux.get(10);
    }
}