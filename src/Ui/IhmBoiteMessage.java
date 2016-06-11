/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import javax.swing.JOptionPane;

/**
 *
 * @author audeberl
 */
public class IhmBoiteMessage {

    public static boolean afficherBoiteDialogue(String message, Integer mode) {
        int response ;
        switch(mode) {
            case 0 :
                JOptionPane.showConfirmDialog(   null, 
                                                message, 
                                                "Informations",
                                                JOptionPane.DEFAULT_OPTION, 
                                                JOptionPane.INFORMATION_MESSAGE);
                return true ;
           case 1 :
                response = JOptionPane.showConfirmDialog(   null, 
                                                            message, 
                                                            "Choix du joueur",
                                                            JOptionPane.YES_NO_OPTION, 
                                                            JOptionPane.QUESTION_MESSAGE);
                return response == JOptionPane.YES_OPTION ;
           case 2 :
                response = JOptionPane.showConfirmDialog(   null, 
                                                            message, 
                                                            "Veuillez confirmer l'opération",
                                                            JOptionPane.WARNING_MESSAGE, 
                                                            JOptionPane.WARNING_MESSAGE);
                return response == JOptionPane.YES_OPTION ;                
        }
        return false;
    }
}
