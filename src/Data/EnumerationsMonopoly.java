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

    public enum TYPE_RESULTAT { //différents types que prendra le résultat

        neRienFaire,
        achat,
        loyer,
        taxe,
        allerEnPrison,
        piocherUneCarteChance,
        piocherUneCarteCDC        
    }

    public enum TYPE_RESULTAT_CARTE { //différents types que prendra le résultat carte
        
        allerEnPrison,
        sortieDePrison,
        deplacement,
        deplacementSpecial,
        perte,
        gain,
        anniversaire
    }
    
    public enum TYPE_MESSAGE { //différents types que prendra le message
        
        deplacement,
        actionCarreau,
        actionCarte
    }
    
}
