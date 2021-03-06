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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Maxence
 */
public class IhmPlateau extends JFrame implements Observateur{
    private Controleur controleur;

    private ArrayList<IhmInfoJoueur> InfoJoueurs;
    private JPanel panTour;
    private JButton lancerDes;
    private JButton construire;
    private JButton tourSuivant;
    private JButton quitter;
    private IhmJoueurActuelle joueurActuelle;
    private Joueur joueurCourant;
    private Des desUn;
    private Des desDeux;    
    private boolean rejouer;
    private Plateau plateau;
    
    
    public IhmPlateau(Controleur controleur){
        this.controleur = controleur;
        controleur.setObservateur(this);
        InfoJoueurs = new ArrayList<>();
        joueurCourant = controleur.getJoueurs().get(0); 
        plateau = new Plateau(controleur.getCarreaux(), controleur.getJoueurs());
        
        ititIhmPlateau();
        
        
    }
     private void ititIhmPlateau() {
        
        this.setLayout(new BorderLayout());
            
        JPanel panelJoueurs = new JPanel(); 
        GridLayout layout = new GridLayout(6, 1);
        layout.setVgap(30);
        panelJoueurs.setLayout(layout);
        panelJoueurs.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
        
        desUn = new Des();
        desDeux = new Des();
        
        panTour = new JPanel();
        panTour.setLayout(new BoxLayout(panTour,BoxLayout.Y_AXIS));
        panTour.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 20));
       
        lancerDes = new JButton("Lancer Dès");
        lancerDes.setPreferredSize(new Dimension(300,30));
        lancerDes.setMaximumSize(new Dimension(300,30));
        
        lancerDes.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                
                if(lancerDes.isEnabled()){
                    construire.setEnabled(false);               
                    lancerDes.setEnabled(false);
                    tourSuivant.setEnabled(true);  
                    if(!joueurCourant.getProprieteAConstruires().isEmpty()){
                         construire.setEnabled(true);      
                    }else{
                        construire.setEnabled(false);
                    }      

                    if (controleur.estEnPrison(joueurCourant) && joueurCourant.possedeCarteSortieDePrison() ) {
                        if ( IhmBoiteMessage.afficherBoiteDialogue("Vous possèdez une carte Sortie de prison.\nSouhaitez-vous l'utilisez pour sortir de prison ?", 1)) {
                            controleur.sortirPrison(joueurCourant);
                        }
                    }                 
                    controleur.lancerDesAvancer(joueurCourant);
                }
                
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        }); 
        
        construire = new JButton(" Construire ");
        construire.setPreferredSize(new Dimension(300,30));
        construire.setMaximumSize(new Dimension(300,30));
        construire.setEnabled(false);
        
        IhmPlateau ihmPlateau = this;
        
        construire.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                if(construire.isEnabled()){
                    IhmConstruire i = new IhmConstruire(joueurCourant,ihmPlateau,controleur);
                }
                
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        }); 
        
        tourSuivant = new JButton(" Tour Suivant ");
        tourSuivant.setPreferredSize(new Dimension(300,30));
        tourSuivant.setMaximumSize(new Dimension(300,30));
        tourSuivant.setEnabled(false);
        tourSuivant.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                if(tourSuivant.isEnabled()){
                    // gèrer fin de partie
                    joueurCourant = controleur.joueurSuivant(joueurCourant);
                    lancerDes.setEnabled(true);
                    if(!joueurCourant.getProprieteAConstruires().isEmpty()){
                         construire.setEnabled(true);                     
                    }else{
                        construire.setEnabled(false);                   
                    }                
                    tourSuivant.setEnabled(false);
                    joueurActuelle.updateIhmJoueurActuelle(joueurCourant);  
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        }); 
        
        quitter = new JButton(" Quitter ");
        quitter.setPreferredSize(new Dimension(300,30));
        quitter.setMaximumSize(new Dimension(300,30));
        quitter.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                if (IhmBoiteMessage.afficherBoiteDialogue("Êtes-vous vraiment sûr(e) de vouloir quitter la partie ?", 2)) {
                    System.exit(0);                  
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        }); 
        
        joueurActuelle = new IhmJoueurActuelle(joueurCourant);        
        panTour.add(joueurActuelle);
        panTour.add(Box.createRigidArea(new Dimension(0,10)));
        joueurActuelle.setAlignmentX( panTour.CENTER_ALIGNMENT );
        
        panTour.add(lancerDes); 
        panTour.add(Box.createRigidArea(new Dimension(0,10)));
        lancerDes.setAlignmentX( panTour.CENTER_ALIGNMENT );
        
        panTour.add(construire);
        panTour.add(Box.createRigidArea(new Dimension(0,10)));
        construire.setAlignmentX( panTour.CENTER_ALIGNMENT );
        
        panTour.add(tourSuivant);
        panTour.add(Box.createRigidArea(new Dimension(0,10)));
        tourSuivant.setAlignmentX( panTour.CENTER_ALIGNMENT );
        
        panTour.add(quitter);
        panTour.add(Box.createRigidArea(new Dimension(0,10)));
        quitter.setAlignmentX( panTour.CENTER_ALIGNMENT );       
       
        JLabel valDes = new JLabel("Valeur des dés : ");
        panTour.add(valDes);
        panTour.add(Box.createRigidArea(new Dimension(0,10)));
        valDes.setAlignmentX( panTour.CENTER_ALIGNMENT );
                
        JPanel panelDes = new JPanel();
        panelDes.setLayout( new BoxLayout(panelDes,BoxLayout.X_AXIS));
        panelDes.add(desUn);
        panelDes.add(desDeux);
        
        panTour.add(panelDes);
        panelDes.setAlignmentX( panTour.CENTER_ALIGNMENT );
       
        for(Joueur jTemp : controleur.getJoueurs()){
            IhmInfoJoueur ihmJoueur = new IhmInfoJoueur((Joueur)jTemp);      
            InfoJoueurs.add(ihmJoueur);
            panelJoueurs.add(ihmJoueur);   
        }   
        
        
        Color fond = new Color(213,231,207);
        this.setBackground(Color.BLACK);
        this.add(panelJoueurs,BorderLayout.WEST);
        this.add(plateau,BorderLayout.CENTER);
        this.add(panTour,BorderLayout.EAST);
        this.pack();
        afficher();  
    }
     
    public void afficher(){
         this.setSize(1920,1080);
         this.setVisible(true); 
         setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);       
     }
    
    @Override
    public void notifier(Message message) {
       switch(message.getTypeMessage()) {
            case deplacement :
               resetDes();
                rejouer = message.aFaitUnDouble();         
                
                if (controleur.estEnPrison(joueurCourant) && rejouer){
                    IhmBoiteMessage.afficherBoiteDialogue("Vous avez fait un double.\nVous sortez de prison !", 0);                       
                    controleur.sortirPrison(joueurCourant);
                    
                } else if(controleur.estEnPrison(joueurCourant) && joueurCourant.getCompteurEssaiPrison() < 2 ){
                    IhmBoiteMessage.afficherBoiteDialogue("Vous n'avez pas fait de double.\nVous restez en prison.", 0);                    
                    joueurCourant.incrementCompteurEssaiPrison();

                } else if (joueurCourant.getCompteurEssaiPrison() >= 2){                        
                        IhmBoiteMessage.afficherBoiteDialogue("Vous avez fais vos trois essais.\nPayez une caution de 50€.", 0);
                        joueurCourant.payer(50);
                        controleur.sortirPrison(joueurCourant);
                }    
                updateAffichage(); 
                
                if (joueurCourant.getCompteurDouble() == 3){
                     IhmBoiteMessage.afficherBoiteDialogue("Vous avez réalisé trois doubles consécutifs.\nVous allez en prison !",0);
                     controleur.allerPrison(joueurCourant);
                } else if( !controleur.estEnPrison(joueurCourant)){
                    controleur.traiterActionCarreau(joueurCourant);
                    if (message.passageCaseDepart()) {
                        IhmBoiteMessage.afficherBoiteDialogue("Vous êtes passez par la case départ.\nRecevez 200€.", 0);
                    }
                }
                updateAffichage();                
                break;
               
            case actionCarreau :
                Resultat resultat = message.getResultat();
                switch(resultat.getTypeResultat()){
                    case achat ://si le joueur peut acheter                        
                        if (IhmBoiteMessage.afficherBoiteDialogue("Vous êtes tombé(e) sur la propriété " + resultat.getPropriete().getNom()+".\nVoulez-vous acheter cette proprièté pour "+resultat.getPropriete().getPrix()+"€ ?", 1)) {
                            resultat.getPropriete().achat(joueurCourant);
                            if(!joueurCourant.getProprieteAConstruires().isEmpty()){
                                 construire.setEnabled(true);                     
                            }
                        }
                    break;
                    
                    case loyer :// si le joueur doit payer le loyer 
                        IhmBoiteMessage.afficherBoiteDialogue("Vous êtes tombé(e) sur la propriété " + resultat.getPropriete().getNom() + " appartenant à " + resultat.getPropriete().getProprietaire().getNomJoueur()+".\n Vous payez " + resultat.getLoyer()+"€.", 0);                 
                        joueurCourant.payer(resultat.getLoyer());//on fait payer le loyer au joueur 
                        resultat.getPropriete().getProprietaire().recevoirLoyer( resultat.getLoyer() );  //on donne le loyer au proprietaire de la proprietés
                    break;
                    
                    case piocherUneCarteChance ://si le joueur tombe sur un carreau quelconque
                        IhmBoiteMessage.afficherBoiteDialogue("Vous êtes tombé(e) sur une case Chance.\nVous piochez une carte.", 0);
                        controleur.tirerEtJouerCarte(controleur.piocherCarteChance(), joueurCourant, controleur.getPileChance());
                        
                    break;
                    
                    case piocherUneCarteCDC ://si le joueur tombe sur un carreau quelconque
                        IhmBoiteMessage.afficherBoiteDialogue("Vous êtes tombé(e) sur une case Caisse de Comunauté.\nVous piochez une carte.", 0);
                        controleur.tirerEtJouerCarte(controleur.piocherCarteCDC(), joueurCourant, controleur.getPileComunaute());
                    break;     
                    
                    case allerEnPrison ://si le joueur tombe sur un carreau quelconque
                        IhmBoiteMessage.afficherBoiteDialogue("Vous allez en Prison.", 0);
                        controleur.allerPrison(joueurCourant);
                        updateInfoJoueurs(controleur.getJoueurs());
                        
                    break;
                    
                    case taxe ://si le joueur tombe sur un carreau quelconque
                        IhmBoiteMessage.afficherBoiteDialogue("Vous étes tombé(e) sur "+resultat.getCarreau().getNom()+".\nPayez "+resultat.getTaxe()+"€.",0);
                        joueurActuelle.updateIhmJoueurActuelle(joueurCourant);
                        updateInfoJoueurs(controleur.getJoueurs());
                    break;   
                    
                    case neRienFaire : //si le joueur ne peut rien faire 
                        if(resultat.getCarreau() ==  null){
                            IhmBoiteMessage.afficherBoiteDialogue("Vous étes tombé(e) sur votre proprieté "+resultat.getPropriete().getNom()+".\nIl n'y a pas d'action pour cette case.",0);

                        }else{
                            IhmBoiteMessage.afficherBoiteDialogue("Vous étes tombé(e) sur "+resultat.getCarreau().getNom()+".\nIl n'y a pas d'action pour cette case.",0);

                        }
                    break;                
                } 
                updateAffichage();
                
                if(joueurCourant.estElimine()){//si le  joueur est eliminer 
                    controleur.eliminerJoueur(joueurCourant); // on elimine le joueur
                    IhmBoiteMessage.afficherBoiteDialogue(joueurCourant.getNomJoueur() + " est ruiné(e).\nIl est élimininé de la partie !",0); // on affiche que le joueur est éliminé
                    if (controleur.finDePartie()) {
                        IhmBoiteMessage.afficherBoiteDialogue("La partie est finis !\n"+controleur.getDernierJoueur().getNomJoueur()+ " a gagné la partie !",0);
                        System.exit(0);
                    }                   
                }
                if (rejouer && ( resultat.getTypeResultat() != EnumerationsMonopoly.TYPE_RESULTAT.piocherUneCarteCDC || resultat.getTypeResultat() != EnumerationsMonopoly.TYPE_RESULTAT.piocherUneCarteChance )&& !controleur.estEnPrison(joueurCourant)) {
                    IhmBoiteMessage.afficherBoiteDialogue("Vous avez fait un double.\nVous rejouez.",0);
                    controleur.lancerDesAvancer(joueurCourant);
                }                
                updateAffichage();
                break;

            case actionCarte :
                ResultatCarte resultatCarte = message.getResultatCarte();
                popupCarte(message.getResultatCarte().getLibelle());
                switch(resultatCarte.getTypeResultat()){
                    case allerEnPrison :
                        IhmBoiteMessage.afficherBoiteDialogue("Vous allez en prison !", 0);                         
                        controleur.allerPrison(joueurCourant);
                        joueurActuelle.updateIhmJoueurActuelle(joueurCourant);
                        break;
                        
                    case sortieDePrison :
                        if (!joueurCourant.possedeCarteSortieDePrison()) {
                            IhmBoiteMessage.afficherBoiteDialogue("Vous obtenez une carte Sortie de prison.", 0);                         
                            joueurCourant.setCarteSortieDePrison(message.getCarte());
                            joueurActuelle.updateIhmJoueurActuelle(joueurCourant);
                        } else {
                            IhmBoiteMessage.afficherBoiteDialogue("Vous avez piochez une carte Sortie de prison mais vous en possèder déja une.\nVous reposer la carte.", 0);                                  
                            message.getPile().reposerUneCarte(message.getCarte());
                        }
                        break;
                        
                    case deplacement :                      
                        if (joueurCourant.getPositionCourante().getNumero() > resultatCarte.getValeur()) {
                            joueurCourant.gagnerCash(200);
                            IhmBoiteMessage.afficherBoiteDialogue("Vous êtes passez par la case départ.\nRecevez 200€.", 0);
                        }
                        
                        
                    case deplacementSpecial :                           
                        joueurCourant.setPositionCourante(controleur.getCarreau(resultatCarte.getValeur()-1));
                        joueurCourant.aPiocherUneCarteDeplacement();                       
                        controleur.traiterActionCarreau( joueurCourant);
                        break;
                        
                    case perte :
                        IhmBoiteMessage.afficherBoiteDialogue("Vous perdez "+resultatCarte.getValeur()+"€.", 0);  
                        break;
                        
                    case gain :
                        IhmBoiteMessage.afficherBoiteDialogue("Vous gagnez "+resultatCarte.getValeur()+"€.", 0);                       
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
                        IhmBoiteMessage.afficherBoiteDialogue("Vous gagnez "+somme+"€.\n"+joueurs+" ont/a perdu "+resultatCarte.getValeur()+"€.", 0);  
                        break;
                }
                updateAffichage();  
                
                if(resultatCarte.getTypeResultat() != EnumerationsMonopoly.TYPE_RESULTAT_CARTE.sortieDePrison){
                    message.getPile().reposerUneCarte(message.getCarte());                
                }
                if(joueurCourant.estElimine()){//si le  joueur est eliminé 
                    controleur.eliminerJoueur(joueurCourant); // on elimine le joueur
                    IhmBoiteMessage.afficherBoiteDialogue(joueurCourant.getNomJoueur() + " est ruiné(e).\nIl est élimininé de la partie !",0); // on affiche que le joueur est éliminé
                    if (controleur.finDePartie()) {
                        IhmBoiteMessage.afficherBoiteDialogue("La partie est finis !\n"+controleur.getDernierJoueur().getNomJoueur()+ " a gagné la partie !",0);
                        System.exit(0);                        
                    }
                }
                updateAffichage();                
                if (rejouer) {
                    IhmBoiteMessage.afficherBoiteDialogue("Vous avez fait un double.\nVous rejouez.",0);
                    controleur.lancerDesAvancer(joueurCourant);
                }
                break;
            }   
    }    

    private void resetDes() {
        int[] des = joueurCourant.getDernierDes();
        desUn.updateDes(des[0]);
        desDeux.updateDes(des[1]);
    }

    public void popupCarte(String libelle) {
                JOptionPane.showMessageDialog(
                        null,
                        libelle, 
                        "Carte", 
                        JOptionPane.PLAIN_MESSAGE);
    }

    private void setJoueurCourant(Joueur joueur) {
        this.joueurCourant = joueur;
    }
    
    public void updateInfoJoueurs(ArrayList<Joueur> joueurs){
        
        plateau.repaint();
        for(int i=0;i<InfoJoueurs.size();i++){          
            for(Joueur jTemp : joueurs){                
                if(InfoJoueurs.get(i).getJoueur() ==jTemp ){
                    InfoJoueurs.get(i).updateJoueur(jTemp);                    
                }
            } 
        }      
    }   
    
    public void updateAffichage() {
        joueurActuelle.updateIhmJoueurActuelle(joueurCourant);
        updateInfoJoueurs(controleur.getJoueurs()); 
    }
}
