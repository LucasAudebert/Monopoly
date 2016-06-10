package Data;

import Data.Cartes.Carte;
import Data.Cartes.Pile;
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
        private Pile pileChance, pileCommunaute;
        private HashMap<EnumerationsMonopoly.COULEUR_PROPRIETE, Groupe> groupes;

    
    public Monopoly(){
            this.joueurs = new ArrayList<Joueur>();
            this.joueursElimines = new ArrayList<Joueur>();
            this.carreaux = new ArrayList<Carreau>();
            this.groupes = new HashMap<EnumerationsMonopoly.COULEUR_PROPRIETE, Groupe>();
            this.prisonniers = new HashSet();
            this.pileChance = new Pile();
            this.pileCommunaute = new Pile();
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
    
    public Pile getPileChance() { //retourne la pile de cartes Chance
        return pileChance;
        }
    
    public Pile getPileCommunaute() { //retourne la pile de cartes Caisse de Communauté
        return pileCommunaute;
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

    public Groupe getGroupe(ProprieteAConstruire pac){ //retourne le groupe d'une propriété pac donnée en paramètre
        int i = 0;
        while(!groupes.get(EnumerationsMonopoly.COULEUR_PROPRIETE.values()[i]).getProprietes().contains(pac)){
            i++;
        }
        return groupes.get(EnumerationsMonopoly.COULEUR_PROPRIETE.values()[i]);
    }
    
    public void addGroupe(Groupe groupe){
            groupes.put(groupe.getCouleur(), groupe);
        }
        
    public Carreau getNouvellePosition(int des, Carreau anciennePosition) { //retourne le nouveau carreau selon la valeur des dés et un carreau
	    if(anciennePosition.getNumero() + des > carreaux.size()){//si la valeur des dés + l'ancienne position est supérieure au nombre de carreaux
                return getCarreau(anciennePosition.getNumero() + des - (carreaux.size() + 1));// calcul la nouvelle position 
            }else{
                return getCarreau(anciennePosition.getNumero() + des - 1);//calcul la nouvelle position si la valeur des dés + l'ancienne position est inférieure au nombre de carreaux 
            }
	}
        
    public void eliminerJoueur(Joueur joueur){    
        joueursElimines.add(joueur); //ajoute le joueur à la liste des joueurs éliminés
        for(Propriete pTemp : joueur.getProprietes()){ //boucle sur les proprietés qu'il possède pour mettre le proprietaire à null
            pTemp.setProprietaire(null);
        }      
    }
        
    public boolean isFinDePartie(){
        int cpt = 0;
        for(Joueur jTemp :joueurs){
            if(jTemp.estElimine()){
               cpt++; 
            }
        }
        
        return (cpt == joueurs.size()-1); //vrai si le nombre de joueurs eliminés est égal au nombre de joueurs -1 (si il reste juste un joueur non eliminé) faux sinon
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
    
    public boolean estEnPrison(Joueur joueur){ //renvoie vrai si le joueur donné en paramètre est dans la liste des prisonniers
        return prisonniers.contains(joueur);
    }
    
    public void construireMaison(ProprieteAConstruire pac, Joueur joueur){
        Groupe groupe = getGroupe(pac);
        if(groupe.peutConstruire(pac) && joueur.peutPayer(pac.getPrixMaison()) && pac.getNbMaisons() <= 5){
            joueur.payer(pac.getPrixMaison());
            pac.addMaison();
        }
    }
    
    public void melangerPiles(){ //mélange les deux piles
        pileChance.melanger();
        pileCommunaute.melanger();
    }
}