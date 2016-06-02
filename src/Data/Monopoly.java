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
     * @return
     */
    public Carreau getNouvellePosition(int des, Carreau anciennePosition) {
	    if(anciennePosition.getNumero() + des > carreaux.size()){
                return getCarreau(anciennePosition.getNumero() + des - (carreaux.size() + 1));
            }else{
                return getCarreau(anciennePosition.getNumero() + des - 1);
            }
	}
        
    /**
     *
     * @param joueur
     */
    public void eliminerJoueur(Joueur joueur){
            for(Propriete pTemp : joueur.getProprietes()){
                pTemp.setProprietaire(null);
            }
    }
        
    /**
     *
     * @return
     */
    public boolean isFinDePartie(){
        return joueurs.size() == 1;
    }
}