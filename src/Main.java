/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Data.*;
import Jeu.*;

/**
 *
 * @author blachert
 * Projet Monopoly S2 IUT2 Grenoble
 */
public class Main {
   
    //private Controleur controleur; 
    
    public static void main(String[] args){
        //Initialisation
        Controleur controleur = new Controleur();
        controleur.creerPlateau("data.txt");
        controleur.inscrireJoueurs();
        //Boucle de Jeu
        controleur.boucleDeJeu();
        
        //Fin
    }
    
}
