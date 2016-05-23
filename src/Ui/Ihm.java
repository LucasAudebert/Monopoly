/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

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
            System.out.print("Saisir nom du joueur " + i + ": ");
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
    
    public void afficher(String s){
        System.out.println(s);
    }
}
