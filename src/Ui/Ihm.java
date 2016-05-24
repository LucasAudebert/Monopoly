/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Joueur;
import Data.Resultat;
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
    
    public HashSet<String> saisirNouveauJoueur(){
        int reponse = 0;
        HashSet listeJoueurs = new HashSet<String>();
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
        System.out.print("Voulez vous acheter " + res.getPropriete().getNom() + " pour " + res.getPropriete().getPrix() + " ? (y/n) : ");
        String rep = sc.nextLine();
        return !rep.contains("n");
    }
    
    public void afficherFinDeCoup(Joueur joueur){
        System.out.println("----------------------------------");
        System.out.println("Nom : " + joueur.getNomJoueur());
        System.out.println("Cash : " + joueur.getCash());
        System.out.println("Position : " + joueur.getPositionCourante().getNom());
        System.out.println("Numero de Case : " + joueur.getPositionCourante().getNumero());
        System.out.println("----------------------------------");
    }
    
    public void afficherFinDeTour(HashSet<Joueur> joueurs){
        System.out.println("--- Fin de tour : ----------------");
        for(Joueur jTemp : joueurs){
            afficherFinDeCoup(jTemp);
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
