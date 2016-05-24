/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author blachert
 */
public class EnumerationsMonopoly {
    
    public static final String[] COULEUR_PROPRIETE = {"bleuFonce", "orange", "mauve", "violet", "bleuCiel", "jaune", "vert", "rouge"};
    

    public enum typeResultat {
        neRienFaire, achat, loyer
    }

    public static final String[] TYPE_RESULTAT = {"achat", "loyer", "neRienFaire"};

    
    public static final String[] TYPE_CARREAU = {"gare", "compagnie", "proprieteAConstruire", "autre"};
    
}
