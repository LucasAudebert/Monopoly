/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Cartes.Carte;
import Data.Cartes.Pile;
import Data.Cartes.ResultatCarte;
import Data.EnumerationsMonopoly;
import Data.Joueur;
import Data.Resultat;

/**
 *
 * @author blachert
 */
public class Message {
    
    private EnumerationsMonopoly.TYPE_MESSAGE typeMessage;
    private Resultat resultat;
    private ResultatCarte resultatCarte;
    private Carte carte;
    private Pile pile;
    private Boolean caseDepart;
    private Boolean desDouble;

    public Message(EnumerationsMonopoly.TYPE_MESSAGE typeMessage, Boolean caseDepart, Boolean desDouble) {
        this.typeMessage = typeMessage;
        this.caseDepart = caseDepart;
        this.desDouble = desDouble;
    }

    public Message(EnumerationsMonopoly.TYPE_MESSAGE typeMessage, ResultatCarte resultatCarte, Carte carte, Pile pile) {
        this.typeMessage = typeMessage;
        this.resultatCarte = resultatCarte;
        this.carte = carte;
        this.pile = pile;
    }

    public Message(EnumerationsMonopoly.TYPE_MESSAGE typeMessage, Resultat resultat) {
        this.typeMessage = typeMessage;
        this.resultat = resultat;
    }

    public EnumerationsMonopoly.TYPE_MESSAGE getTypeMessage() {
        return typeMessage;
    }

    public Resultat getResultat() {
        return resultat;
    }

    public ResultatCarte getResultatCarte() {
        return resultatCarte;
    }

    public Carte getCarte() {
        return carte;
    }

    public Pile getPile() {
        return pile;
    }

    public Boolean passageCaseDepart() {
        return caseDepart;
    }

    public Boolean aFaitUnDouble() {
        return desDouble;
    }   
}
