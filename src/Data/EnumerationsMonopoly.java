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
    
    
    public enum COULEUR_PROPRIETE {

        bleuFonce,
        orange,
        mauve,
        violet,
        bleuCiel,
        jaune,
        vert,
        rouge
    }

    public enum TYPE_RESULTAT {

        neRienFaire,
        achat,
        loyer,
        taxe,
        allerEnPrison,
        piocherUneCarte
    }

    public enum TYPE_RESULTAT_CARTE {
        
        allerEnPrison,
        sortieDePrison,
        deplacement,
        deplacementSpecial,
        perte,
        gain,
        anniversaire
    }
    
}
