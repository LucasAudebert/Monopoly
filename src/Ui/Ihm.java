/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

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
    
    public String[] saisirNouveauJoueur(){
        int reponse = 0;
        do{
            System.out.print("Combien de joueurs ? (entre 2 et 6) : "); 
            reponse = sc.nextInt();
        }while(reponse < 2 || reponse > 6);
        String[] listeJoueur = new String[reponse];
        
        for(int i = 1; i <= 6; i++){
            System.out.print("Saisir nom du joueur " + i + ": ");
            listeJoueur[i - 1] = sc.nextLine();
        }  
        
        return listeJoueur;
    }
    
    public void afficher(String s){
        System.out.println(s);
    }
}
