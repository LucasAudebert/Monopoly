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
        boolean erreur = true;
        ArrayList listeJoueurs = new ArrayList<String>();
        do{
            System.out.print("\033[32mCombien de joueurs ? (entre 2 et 6) : \033[32m"); 
            while(erreur){
                try{
                    erreur = false;
                    reponse = Integer.parseInt(sc.nextLine());
                }catch(java.lang.NumberFormatException e){
                    System.out.print("\033[32mVeuillez saisir un entier : \033[32m");
                    erreur = true;
                }
            }
            erreur = true;
        }while(reponse < 2 || reponse > 6);
        
        for(int i = 1; i <= reponse; i++){
            System.out.print("\033[32mSaisir nom du joueur " + i + " : \033[32m");
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
        String rep;
        boolean loop = true;
        System.out.println("Votre cash : " + res.getJoueur().getCash());
        do{
            System.out.print("\033[32mVoulez vous acheter " + res.getPropriete().getNom() + " pour " + res.getPropriete().getPrix() + " ? (y/n) : \033[32m");
            rep = sc.nextLine();
            if(rep.equalsIgnoreCase("n") || rep.equalsIgnoreCase("y")){
                loop = false;
            }else{
                System.out.println("\033[31mMauvaise saisie. \033[31m"); 
            }
        }while(loop);
        return rep.equalsIgnoreCase("y");
        
    }
    public boolean menuTourJoueur(Joueur joueur){
        int reponse = 0;
        boolean erreur = true;
        System.out.println("C'est au tour de "+ joueur.getNomJoueur()+" de jouer !");
        
        do{ 
            System.out.println("Que voulez-vous faire : ");
            System.out.println(" 1 - Jouer");
            System.out.println(" 2 - Afficher vos informations");
            System.out.println(" 3 - Fin de partie");    
            while(erreur){
                try{
                    erreur = false;
                    System.out.print("\033[32mVeuillez saisir votre choix : \033[32m");
                    reponse = Integer.parseInt(sc.nextLine());
                }catch(java.lang.NumberFormatException e){
                    erreur = true;
                    System.out.print("\033[31mMauvaise saisie. \033[31m");    
                }
            }
            erreur = true;
        }while(reponse < 1 || reponse > 3);
        
        switch(reponse){
            case  1 : 
                 return false;                
            case 2 :
                System.out.println("\033[34mInfo du joueur : \033[34m");
                afficherInfosJoueur(joueur);
                System.out.println("\033[34mCompagnies : \033[34m");
                for(Compagnie cTemp : joueur.getCompagnies()){
                    System.out.println("    " + cTemp.getNom());
                }
                System.out.println("\033[34mGares : \033[34m");
                for(Gare gTemp : joueur.getGares()){
                    System.out.println("    " + gTemp.getNom());
                }
                System.out.println("\033[34mProprietes à construire : \033[34m");
                for(ProprieteAConstruire pTemp : joueur.getProprieteAConstruires() ){
                    System.out.println("    " + pTemp.getNom());
                }
                attendreBouton("\033[32mAppuyez sur Entrer pour retourner au menu.\033[32m");
                menuTourJoueur(joueur);
                return false;                
            case 3 :
                return true;
           
        }      
        return false;
               
    }
    
    public void afficherInfosJoueur(Joueur joueur){
        System.out.println("\033[34m----------------------------------\033[34m");
        System.out.println("\033[0;1m Nom : " + joueur.getNomJoueur() + "\033[0;1m");
        System.out.println(" Cash : " + joueur.getCash());
        System.out.println(" Position : " + joueur.getPositionCourante().getNom());
        System.out.println(" Numero de Case : " + joueur.getPositionCourante().getNumero());
        System.out.println("\033[34m----------------------------------\033[34m");
    }
        
    public void afficherFinDeTour(ArrayList<Joueur> joueurs){
        System.out.println("\033[34m---------- Fin de tour : ---------\033[34m");
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
            if(!jTemp.estElimine()){
                System.out.print("BRAVO "+ jTemp.getNomJoueur() + " VOUS ETES LE GRAND GAGNANT !!!!!!!!!!! ");                
            }
        }
    }
    public void afficher(String chaine){
        System.out.println(chaine);
    }
    
    public void attendreBouton(String chaine){
        System.out.println(chaine);
        sc.nextLine();
    }
    
    public int lancerDes(){
        System.out.print("Entrer valeur dé : ");
        return Integer.parseInt(sc.nextLine());
    }
}
