/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Resultat;

/**
 *
 * @author blachert
 */
public interface Observateur {
    public void notifier(Message message);
}
