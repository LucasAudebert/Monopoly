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

    /**
     *
     */
    public Monopoly(){
            this.joueurs = new ArrayList<Joueur>();
            this.joueursElimines = new ArrayList<Joueur>();
            this.carreaux = new ArrayList<Carreau>();
            this.groupes = new HashMap<EnumerationsMonopoly.COULEUR_PROPRIETE, Groupe>();
        }
        
    /**
     *
     * @return
     */
    public ArrayList getCarreaux() {
            return carreaux;
        }
        
    /**
     *
     * @param index
     * @return
     */
    public Carreau getCarreau(int index){
            return carreaux.get(index);
        }
        
    /**
     *
     * @param carreau
     */
    public void addCarreau(Carreau carreau){
            carreaux.add(carreau);
        }

    /**
     *
     * @return
     */
    public ArrayList<Joueur> getJoueurs() {
            return joueurs;
        }
        
    /**
     *
     * @param joueur
     */
    public void addJoueur(Joueur joueur){
            joueurs.add(joueur);
        }        

    public ArrayList<Joueur> getJoueursElimines() {
        return joueursElimines;
    }

    /**
     *
     * @param joueurs
     */
    public void setJoueurs(ArrayList<Joueur> joueurs) {
            this.joueurs = joueurs;
        }
        
    /**
     *
     * @param couleur
     * @return
     */
    public Groupe getGroupe(EnumerationsMonopoly.COULEUR_PROPRIETE couleur){
            return groupes.get(couleur);
        }

    /**
     *
     * @param groupe
     */
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
            // Si la valeur des dés + l'ancienne position est superieur à la valeur des dés
	    if(anciennePosition.getNumero() + des > carreaux.size()){
                return getCarreau(anciennePosition.getNumero() + des - (carreaux.size() + 1));// calcul la nouvelle position si la valeur des dés + l'ancienne position est superieur au nbr de carreaux 
            }else{
                return getCarreau(anciennePosition.getNumero() + des - 1);// calcul la nouvelle position si la valeur des dés + l'ancienne position est inferieur au nbr de carreaux 
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
     * @return vrai si le nbr de joueur eliminé est eguale au nombre de joueur -1 (si il reste juste un joueur pas eliminé) faux sinon
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
    
    
    //JEU DE TEST
    public void donnéProprietés(Joueur joueur){
        for(Groupe gp : groupes.values()){
            for(ProprieteAConstruire pc : gp.getProprietes()){
                pc.setProprietaire(joueur);
                joueur.addProprieteAConstruire(pc);
            }
        }
    }
}