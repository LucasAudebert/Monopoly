package Data;

import Data.Cartes.Carte;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Maxence
 */
public class Monopoly {
    
	private ArrayList<Joueur> joueurs;
        private ArrayList<Joueur> joueursElimines;
        private ArrayList<Carreau> carreaux; // HashMap ??!!!
        private HashSet<Joueur> prisonniers;
        private ArrayList<Carte> cartesChance, cartesCommunaute;
        private HashMap<EnumerationsMonopoly.COULEUR_PROPRIETE, Groupe> groupes;

    
    public Monopoly(){
            this.joueurs = new ArrayList<Joueur>();
            this.joueursElimines = new ArrayList<Joueur>();
            this.carreaux = new ArrayList<Carreau>();
            this.groupes = new HashMap<EnumerationsMonopoly.COULEUR_PROPRIETE, Groupe>();
            this.prisonniers = new HashSet();
            this.cartesChance = new ArrayList<Carte>();
            this.cartesCommunaute = new ArrayList<Carte>();
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
    
    public ArrayList getCartesChance() {
        return cartesChance;
        }
        
    public Carte getCarteChance(int index){
        return cartesChance.get(index);
        }
        
    public void addCarteChance(Carte carte){
            cartesChance.add(carte);
        }
    
    public ArrayList getCartesCommunaute() {
        return cartesCommunaute;
        }
        
    public Carte getCarteCommunaute(int index){
        return cartesCommunaute.get(index);
        }
        
    public void addCarteCommunaute(Carte carte){
            cartesChance.add(carte);
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

    public Groupe getGroupe(ProprieteAConstruire pac){
        int i = 0;
        while(!groupes.get(EnumerationsMonopoly.COULEUR_PROPRIETE.values()[i]).getProprietes().contains(pac)){
            i++;
        }
        return groupes.get(EnumerationsMonopoly.COULEUR_PROPRIETE.values()[i]);
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
    
    public Carreau getCarreauPrison(){
        return carreaux.get(10);
    }
    
    public void addPrisonnier(Joueur joueur){
        prisonniers.add(joueur);
    }
    
    public void removePrisonnier(Joueur joueur){
        prisonniers.remove(joueur);
    }
    
    public boolean estEnPrison(Joueur joueur){
        return prisonniers.contains(joueur);
    }
    
    public void construireMaison(ProprieteAConstruire pac, Joueur joueur){
        Groupe groupe = getGroupe(pac);
        if(groupe.peutConstruire(pac) && joueur.peutPayer(pac.getPrixMaison()) && pac.getNbMaisons() < 5){
            joueur.payer(pac.getPrixMaison());
            pac.addMaison();
        }
    }
}