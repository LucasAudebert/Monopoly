/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Cartes.ResultatCarte;
import Data.EnumerationsMonopoly;
import Data.Joueur;
import Data.Resultat;
import Jeu.Controleur;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import java.util.HashMap;


import javax.swing.BoxLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author Maxence
 */
public class IhmPlateau extends JFrame implements Observateur{
    private Controleur controleur;

    private ArrayList<IhmInfoJoueur> panelJoueurs;
    private JPanel panTour;
    private JButton lancerDes;
    private JButton construire;
    private JButton tourSuivant;
    private JButton quitter;
    private IhmJoueurActuelle joueurActuelle;
    private Joueur joueurCourant;
    
    
    public IhmPlateau(Controleur controleur){
        this.controleur = controleur;
        controleur.setObservateur(this);
        panelJoueurs = new ArrayList<>();
        joueurCourant = controleur.getJoueurs().get(0);
        
        
        ititIhmPlateau();
        
        
    }
     private void ititIhmPlateau() {
        
        this.setLayout(new BorderLayout());
        
        
        JPanel panelJoueurs = new JPanel();     
        
        
        
        if(controleur.getJoueurs().size() == 2){
             panelJoueurs.setLayout(new GridLayout(1,2));
        }else if(controleur.getJoueurs().size()<=4){
            panelJoueurs.setLayout(new GridLayout(2,2));
        }else if(controleur.getJoueurs().size()>4){
            panelJoueurs.setLayout(new GridLayout(3,2));
        }
            
       
           
        
        panTour = new JPanel();
        joueurActuelle = new IhmJoueurActuelle(joueurCourant);
        
        
        panTour.setLayout(new BoxLayout(panTour,BoxLayout.Y_AXIS));
        panTour.add(joueurActuelle);
        
        lancerDes = new JButton(" Lancer Dès ");
        lancerDes.setMaximumSize(new Dimension(200,40));
        lancerDes.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                lancerDes.setEnabled(false);
                if (controleur.estEnPrison(joueurCourant) && joueurCourant.possedeCarteSortieDePrison() ) {
                    if ( IhmBoiteMessage.afficherBoiteDialogue("Vous possèdez une carte 'Sortie de prison'\nSouhaitez-vous l'utilisez pour sortir de prison ?", 1)) {
                        controleur.sortirPrison(joueurCourant);
                    }
                }                 
                controleur.lancerDesAvancer(joueurCourant);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        }); 
        
        construire = new JButton(" Construire ");
        construire.setMaximumSize(new Dimension(200,40));
        construire.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                // construction
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        }); 
        
        tourSuivant = new JButton(" Tour Suivant ");
        tourSuivant.setMaximumSize(new Dimension(200,40));
        tourSuivant.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                // gèrer fin de partie
                joueurCourant = controleur.joueurSuivant(joueurCourant);
                lancerDes.setEnabled(true);
                construire.setEnabled(true);
                joueurActuelle.updateIhmJoueurActuelle(joueurCourant);  
                
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        }); 
        
        quitter = new JButton(" Quitter ");
        quitter.setMaximumSize(new Dimension(200,40));
        quitter.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
              System.exit(0);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });        
        
        panTour.add(lancerDes);        
        panTour.add(construire);        
        panTour.add(tourSuivant);        
        panTour.add(quitter);      

            
         
        JButton quitterJeu = new JButton(" Arrêter la partie ");
        quitterJeu.setMaximumSize(new Dimension(200,40));
        panTour.add(quitterJeu);
       
       
       
       
        for(Object jTemp : controleur.getJoueurs()){
            
            IhmInfoJoueur ihmJoueur = new IhmInfoJoueur((Joueur)jTemp);                  
            panelJoueurs.add(ihmJoueur);  
            
        }
       
        Plateau plateau = new Plateau();
        
        this.add(panelJoueurs,BorderLayout.WEST);
        this.add(plateau,BorderLayout.CENTER);
        this.add(panTour,BorderLayout.EAST);
        afficher();
        
        
       
    }
    public void afficher(){
         this.setSize(1920,1080);
         this.setVisible(true); 
         setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);       
     }
    
    public void updateInfoJoueurs(ArrayList<Joueur> joueurs){
        for(IhmInfoJoueur panTemp : panelJoueurs){
            for(Joueur jTemp : joueurs){
                if(panTemp.getJoueur().getNomJoueur() ==jTemp.getNomJoueur() ){
                    panTemp.updateJoueur(jTemp);
                    
                }
            }
        }
    }
    
    
    @Override
    public void notifier(Message message) {
       switch(message.getTypeMessage()) {
            case deplacement :
               resetDes();
                
                    // gèrer sortie de prison
                if (controleur.estEnPrison(joueurCourant) && message.aFaitUnDouble()){
                    controleur.sortirPrison(joueurCourant);
                    updateInfoJoueurs(controleur.getJoueurs());
                    
                } else if(controleur.estEnPrison(joueurCourant) && joueurCourant.getCompteurEssaiPrison() < 2 ){
                    IhmBoiteMessage.afficherBoiteDialogue("Vous n'avez pas fait de double\nVous restez en prison", 0);                    
                    joueurCourant.incrementCompteurEssaiPrison();
                    updateInfoJoueurs(controleur.getJoueurs());

                } else if (joueurCourant.getCompteurEssaiPrison() >= 2){                        
                        IhmBoiteMessage.afficherBoiteDialogue("Vous avez vos trois essais\nPayez une caution de 50", 0);
                        joueurCourant.payer(50);
                        controleur.sortirPrison(joueurCourant);
                        updateInfoJoueurs(controleur.getJoueurs());
                }    

                if(joueurCourant.getCompteurDouble() != 3){
                    controleur.traiterActionCarreau(joueurCourant);
                    if (message.passageCaseDepart()) {
                        IhmBoiteMessage.afficherBoiteDialogue("Vous êtes passez par la case départ\nRecevez 200", 0);
                        updateInfoJoueurs(controleur.getJoueurs());
                    }
                }else{
                     IhmBoiteMessage.afficherBoiteDialogue(" Vous avez réalisé trois doubles consécutifs\nVous allez en prison !",0);
                     controleur.allerPrison(joueurCourant);
                     updateInfoJoueurs(controleur.getJoueurs());
                }                
               break;
               
            case actionCarreau :
                
                Resultat resultat = message.getResultat();
                switch(resultat.getTypeResultat()){
                    case achat ://si le joueur peut acheter                        
                        if (IhmBoiteMessage.afficherBoiteDialogue("Voulez-vous acheter cette proprièté ?", 1)) {
                            resultat.getPropriete().setProprietaire(joueurCourant);
                            int i =0;
                             while(controleur.getJoueurs().get(i) != joueurCourant ){
                                   i++;
                            }          
                            setJoueurCourant(controleur.getJoueurs().get(i));
                            joueurActuelle.updateIhmJoueurActuelle(joueurCourant);
                            updateInfoJoueurs(controleur.getJoueurs());
                        }
                    break;
                    
                    case loyer :// si le joueur doit payer le loyer 
                        IhmBoiteMessage.afficherBoiteDialogue("Vous êtes tombé(e) sur la propriété " + resultat.getPropriete().getNom() + " appartenant à " + resultat.getPropriete().getProprietaire().getNomJoueur()+"\n Vous payez" + resultat.getLoyer(), 0);                 
                        joueurCourant.payer(resultat.getLoyer());//on fait payer le loyer au joueur 
                        resultat.getPropriete().getProprietaire().recevoirLoyer( resultat.getLoyer() );  //on donne le loyer au proprietaire de la proprietés
                        joueurActuelle.updateIhmJoueurActuelle(joueurCourant);
                        updateInfoJoueurs(controleur.getJoueurs());
                    break;
                    
                    case piocherUneCarteChance ://si le joueur tombe sur un carreau quelconque
                        IhmBoiteMessage.afficherBoiteDialogue("Vous êtes tombé(e) sur une case 'Chance'", 0);
                        controleur.tirerEtJouerCarte(controleur.piocherCarteChance(), joueurCourant, controleur.getPileChance());
                        
                    break;
                    
                    case piocherUneCarteCDC ://si le joueur tombe sur un carreau quelconque
                        IhmBoiteMessage.afficherBoiteDialogue("Vous êtes tombé(e) sur une case 'Caisse de Comunauté'", 0);
                        controleur.tirerEtJouerCarte(controleur.piocherCarteCDC(), joueurCourant, controleur.getPileComunaute());
                    break;     
                    
                    case allerEnPrison ://si le joueur tombe sur un carreau quelconque
                        IhmBoiteMessage.afficherBoiteDialogue("Vous allez en Prison.", 0);
                        controleur.allerPrison(joueurCourant);
                        updateInfoJoueurs(controleur.getJoueurs());
                        
                    break;
                    
                    case taxe ://si le joueur tombe sur un carreau quelconque
                        IhmBoiteMessage.afficherBoiteDialogue("Vous étes tombé(e) sur "+resultat.getCarreau().getNom()+"\nPayez "+resultat.getTaxe(),0);
                        joueurActuelle.updateIhmJoueurActuelle(joueurCourant);
                        updateInfoJoueurs(controleur.getJoueurs());
                    break;   
                    
                    case neRienFaire : //si le joueur ne peut rien faire 
                        IhmBoiteMessage.afficherBoiteDialogue("Vous étes tombé(e) sur "+resultat.getCarreau().getNom()+"\nIl n'y a pas d'action pour cette case",0);
                    break;
                                      
                }
                
                if(joueurCourant.estElimine()){//si le  joueur est eliminer 
                    controleur.eliminerJoueur(joueurCourant); // on elimine le joueur
                    IhmBoiteMessage.afficherBoiteDialogue(joueurCourant.getNomJoueur() + " est ruiné(e)\nIl est élimininé de la partie",0); // on affiche que le joueur est éliminé
                }
                break;

            case actionCarte :
                ResultatCarte resultatCarte = message.getResultatCarte();
                popupCarte(message.getResultatCarte().getLibelle());
                switch(resultatCarte.getTypeResultat()){
                    case allerEnPrison :
                        IhmBoiteMessage.afficherBoiteDialogue("Vous allez en prison", 0);                         
                        controleur.allerPrison(joueurCourant);
                        joueurActuelle.updateIhmJoueurActuelle(joueurCourant);
                        updateInfoJoueurs(controleur.getJoueurs());
                        break;
                        
                    case sortieDePrison :
                        if (!joueurCourant.possedeCarteSortieDePrison()) {
                            IhmBoiteMessage.afficherBoiteDialogue("Vous obtenez une carte 'Sortie de prison'", 0);                         
                            joueurCourant.setCarteSortieDePrison(message.getCarte());
                            joueurActuelle.updateIhmJoueurActuelle(joueurCourant);
                            updateInfoJoueurs(controleur.getJoueurs());
                        } else {
                            
                        }
                        break;
                        
                    case deplacement :                      
                        if (joueurCourant.getPositionCourante().getNumero() > resultatCarte.getValeur()) {
                            joueurCourant.gagnerCash(200);
                            IhmBoiteMessage.afficherBoiteDialogue("Vous êtes passez par la case départ\nRecevez 200", 0); 
                            joueurActuelle.updateIhmJoueurActuelle(joueurCourant);
                            updateInfoJoueurs(controleur.getJoueurs());
                        }
                    case deplacementSpecial :                           
                        joueurCourant.setPositionCourante(controleur.getCarreau(resultatCarte.getValeur()-1));
                        joueurCourant.aPiocherUneCarteDeplacement();                       
                        controleur.traiterActionCarreau( joueurCourant);
                        joueurActuelle.updateIhmJoueurActuelle(joueurCourant);
                        updateInfoJoueurs(controleur.getJoueurs());
                        break;
                        
                    case perte :
                        IhmBoiteMessage.afficherBoiteDialogue("Vous perdez "+resultatCarte.getValeur(), 0);  
                        joueurActuelle.updateIhmJoueurActuelle(joueurCourant);
                        updateInfoJoueurs(controleur.getJoueurs());
                        break;
                        
                    case gain :
                        IhmBoiteMessage.afficherBoiteDialogue("Vous gagnez "+resultatCarte.getValeur(), 0);
                        joueurActuelle.updateIhmJoueurActuelle(joueurCourant);
                        updateInfoJoueurs(controleur.getJoueurs());                        
                        break;
                        
                    case anniversaire :
                        String joueurs= "";
                        int i =1;                        
                        int somme =0;

                        for(Joueur jTemp : controleur.getJoueurs()){                   
                            if(jTemp != joueurCourant && !controleur.estElimine(jTemp)){
                                jTemp.payer(resultatCarte.getValeur());
                                joueurCourant.gagnerCash(resultatCarte.getValeur());
                                somme = somme + resultatCarte.getValeur();
                                
                                    // creation d'une chaine des joueurs qui donnent des sous au joueur courant 
                                if (i!=1) {joueurs = joueurs +",";}
                                joueurs = joueurs +" "+ jTemp.getNomJoueur();
                                i++;
                            }                           
                        }
                        IhmBoiteMessage.afficherBoiteDialogue("Vous gagnez "+somme+"\n"+joueurs+" ont/a perdu "+resultatCarte.getValeur(), 0);  
                        joueurActuelle.updateIhmJoueurActuelle(joueurCourant);
                        updateInfoJoueurs(controleur.getJoueurs());                        
                        break;
                }
                if(resultatCarte.getTypeResultat() != EnumerationsMonopoly.TYPE_RESULTAT_CARTE.sortieDePrison){
                    message.getPile().reposerUneCarte(message.getCarte());                
                }                
                break;
            }   
    }    

    private void resetDes() {
        System.out.println("a faire ");
    }

    private void popupCarte(String libelle) {
        System.out.println("a faire ");
    }

    private void setJoueurCourant(Joueur joueur) {
        this.joueurCourant = joueur;
    }
}
