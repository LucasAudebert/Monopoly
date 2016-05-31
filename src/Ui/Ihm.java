/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Compagnie;
import Data.Gare;
import Data.Joueur;
import Data.ProprieteAConstruire;
import Data.Resultat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author blachert
 */
public class Ihm {
    private Scanner sc;
    
    public Ihm(){
        sc = new Scanner(System.in);
    }
    
    public ArrayList<String> saisirNouveauJoueur(){
        int reponse = 0;
        ArrayList listeJoueurs = new ArrayList<String>();
        do{
            System.out.print("Combien de joueurs ? (entre 2 et 6) : "); 
            reponse = Integer.parseInt(sc.nextLine());
        }while(reponse < 2 || reponse > 6);
        
        for(int i = 1; i <= reponse; i++){
            System.out.print("Saisir nom du joueur " + i + " : ");
            String nom = sc.nextLine();
            if(listeJoueurs.contains(nom)){
                System.out.println("nom deja saisi");
                i--;
            }else{
                listeJoueurs.add(nom);
            }
        }  
        
        return listeJoueurs;
    }
    
    public boolean demandeAchat(Resultat res){
        System.out.println("Votre cash : " + res.getJoueur().getCash());
        System.out.print("Voulez vous acheter " + res.getPropriete().getNom() + " pour " + res.getPropriete().getPrix() + " ? (y/n) : ");
        String rep = sc.nextLine();
        return !rep.contains("n");
    }
    public boolean menueTourJoueur(Joueur joueur){
        int reponse =0;
        System.out.println("C'est au tour de "+ joueur.getNomJoueur()+" de jouer !");
        
        do{ 
            System.out.println("Que voulez-vous faire : ");
            System.out.println(" 1 - JOUER ");
            System.out.println(" 2 - AFFICHER VOS INFORMATIONS ");
            System.out.println(" 3 - FIN DE PARTIE ");            
            reponse = Integer.parseInt(sc.nextLine());
        }while(reponse < 1 || reponse > 3);
        
        switch(reponse){
            case  1 : 
                 return false;                
            case 2 :
                System.out.println("Info du joueur : ");
                afficherInfosJoueur(joueur);
                System.out.println("Compagnies : ");
                for(Compagnie cTemp : joueur.getCompagnies()){
                    System.out.println(cTemp.getNom());
                }
                System.out.println("Gares : ");
                for(Gare gTemp : joueur.getGares()){
                    System.out.println(gTemp.getNom());
                }
                System.out.println("Proprietes à construire : ");
                for(ProprieteAConstruire pTemp : joueur.getProprieteAConstruires() ){
                    System.out.println(pTemp.getNom());
                }
                
                return false;                
            case 3 :
                return true;              
        }      
        return false;
               
    }
    
    public void afficherInfosJoueur(Joueur joueur){
        System.out.println("----------------------------------");
        System.out.println("Nom : " + joueur.getNomJoueur());
        System.out.println("Cash : " + joueur.getCash());
        System.out.println("Position : " + joueur.getPositionCourante().getNom());
        System.out.println("Numero de Case : " + joueur.getPositionCourante().getNumero());
        System.out.println("----------------------------------");
    }
        
    public void afficherFinDeTour(ArrayList<Joueur> joueurs){
        System.out.println("---------- Fin de tour : ---------");
        for(Joueur jTemp : joueurs){
            afficherInfosJoueur(jTemp);
        }
    }
    
    public void afficherFinDePartie(ArrayList<Joueur> joueurs){
        System.out.println("Statut fin de partie : ");
        for(Joueur jTemp : joueurs){
            afficherInfosJoueur(jTemp);
        }
    }
    public void afficherGagnant(ArrayList<Joueur> joueurs){
        for(Joueur jTemp : joueurs){
            System.out.println(jTemp.getNomJoueur());
        }
        
    }
    public void afficher(String chaine){
        System.out.println(chaine);
    }
    
    public void attendreBouton(String chaine){
        System.out.println(chaine);
        sc.nextLine();
    }
}
