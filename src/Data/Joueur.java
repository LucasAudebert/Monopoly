package Data;

import Data.Cartes.Carte;
import java.util.HashSet;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
        private HashSet<Compagnie> compagnies;
	private HashSet<Gare> gares;
        private HashSet<ProprieteAConstruire> proprietesAConstruire;
	private Carreau positionCourante;
        private int[] derniereValeurDes;
        private int compteurDouble = 0 ;
        private int compteurEssaiPrison = 0;
        private Carte carteSortieDePrison;
        private boolean piocheCarteDeplacement;

    public Joueur(String nomJoueur, Carreau carreauDepart){
            this.nomJoueur = nomJoueur;
            this.positionCourante = carreauDepart;
            compagnies = new HashSet();
            gares = new HashSet();
            proprietesAConstruire = new HashSet();
            carteSortieDePrison = null;
        }
        
    public String getNomJoueur() {
            return nomJoueur;
        }

    public void setNomJoueur(String nomJoueur) {
            this.nomJoueur = nomJoueur;
        }

    public int getCash() {
            return cash;
        }

    public void setCash(int cash) {
            this.cash = cash;
        }

    public HashSet<Compagnie> getCompagnies() {
            return compagnies;
        }

    public void addCompagnie(Compagnie compagnie){
            compagnies.add(compagnie);
        }
        
    public HashSet<Gare> getGares() {
            return gares;
        }

    public HashSet<Propriete> getProprietes(){
            HashSet proprietes = new HashSet(proprietesAConstruire);
            proprietes.addAll(gares);
            proprietes.addAll(compagnies);
            return proprietes;
        }
        
    public void addGare(Gare gare){
            gares.add(gare);
        }

    public HashSet<ProprieteAConstruire> getProprieteAConstruires() {
            return proprietesAConstruire;
        }

    public void addProprieteAConstruire(ProprieteAConstruire pac){
            proprietesAConstruire.add(pac);
        }
        
    public void payer(int l) { //soustrait un prix l au cash du joueur
                cash -= l;
	}

    public void recevoirLoyer(int l) { //ajoute le loyer au cash du joueur
		cash += l;
	}

    public int getNbGares() { //renvoie le nombre de gares possédées par le joueur
		return gares.size();
	}

    public int getNbCompagnies(){ //renvoie le nombre de gares possédés par le joueur
                return compagnies.size();
        }     
	
    public Carreau getPositionCourante() {
		return this.positionCourante;
	}

    public void setDerniereValeurDes(int[] des){
            this.derniereValeurDes = des;
        }
        
    public int getDerniereValeurDes(){
            return derniereValeurDes[0]+derniereValeurDes[1];
        }
        
    public void setPositionCourante(Carreau nouvellePosition) {
		positionCourante = nouvellePosition;
	}
        
    public boolean peutPayer(int prixC) { 
		return cash > prixC; //vrai si le joueur peut payer le prixC (prix du carreau) sinon faux
	}
        
    public void gagnerCash(int cash){
        this.cash += cash;
    }
    
    public boolean desDouble(){
            return derniereValeurDes[0] == derniereValeurDes[1]; //vrai si le joueur à réalisé un double
    }
        
    public boolean estElimine(){ 
            return cash <= 0; //vrai si le joueur n'a plus d'argent, il est donc éliminé
    }

    public int getCompteurDouble() { //renvoie le compteur de doubles effectués à la suite
        return compteurDouble;
    }

    public void reinitCompteurDouble() { //réinitialise le compteur de doubles à 0
        this.compteurDouble = 0;
    }
    
    public void incrementCompteurDee(){ //incrémente le compteur de doubles
        compteurDouble ++;
    }  
    
    public void incrementCompteurEssaiPrison(){ //incrémente le compteur de tour effectués en prison
        compteurEssaiPrison ++;
    } 
    
    public void reinitCompteurEssaiPrison() { //réinitialise le compteur de tour effectués en prison à 0
        this.compteurEssaiPrison = 0;
    }
    
    public int getCompteurEssaiPrison() { //renvoie le compteur de tour effectués en prison
        return compteurEssaiPrison;
    }

    public void setCarteSortieDePrison(Carte carteSortieDePrison) { //ajoute au joueur le fait qu'il possède une carte SortieDePrison
        this.carteSortieDePrison = carteSortieDePrison;
    }
    
    public boolean possedeCarteSortieDePrison() { //retourne vrai si le joueur possède une carte SortieDePrison faux sinon
        return carteSortieDePrison != null;
    }
    
    public Carte utiliserCarteSortieDePrison(){ //utilise la carte SortieDePrison et la supprime des possessions du joueur
        Carte c = carteSortieDePrison;
        carteSortieDePrison = null;
        return c;
    }
    
    public void aPiocherUneCarteDeplacement() { //piocheCarteDeplacement devient vrai lorsque le joueur pioche une carte de déplacement
        piocheCarteDeplacement = true;
    }
    
    public boolean rejouer() { //permet au joueur de rejouer
        if (piocheCarteDeplacement || !desDouble()) { //si il a pioché une carte de déplacement ou s'il n'a pas réalisé de double
            piocheCarteDeplacement = false; //piocheCarteDeplacement devient faux     
            return false; 
        } else {
            return true;
        }
    }
    
    public int getNombreProprieteAConstruire() { //retourne le nombre de Propriétés à Construire que possède le joueur
        return proprietesAConstruire.size();
    }
}
