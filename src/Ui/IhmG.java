/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Joueur;
import Jeu.Controleur;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author Maxence
 */
public class IhmG extends JFrame implements Observateur {
    
    private Controleur controleur;
    private JButton inscrireJoueur;
    private JButton demarrerPartie;
    private JButton quitter;
    private ArrayList<Joueur> joueurs;
   
    
     public IhmG(Controleur controleur){
        this.controleur = controleur;
      //  controleur.setObservarteur(this);
        joueurs = new ArrayList<>();
        afficherMenu();
        inscrireJoueur.addMouseListener( new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                
                JFrame panInscriptionJoueur = new JFrame();
                JLabel nbrJoueur = new JLabel("Combien de joueur voulez vous incrire");
                JTextField ins = new JTextField();
                int nbrJoueurs =  Integer.parseInt(ins.getText());
                for(int i = 0; i<nbrJoueurs;i++){
                    System.out.println("lalal");
                }
                panInscriptionJoueur.setVisible(true);
                
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
           
        });
        
        
    }
    
     public void afficherMenu(){
        inscrireJoueur = new JButton("Inscire Joueur");
        demarrerPartie = new JButton("Demarrer Partie");
        quitter = new JButton("Quitter");   
        this.add(inscrireJoueur);
        this.add(demarrerPartie);
             
     }
    
    
     private void afficher() {
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setSize(900, 900);
        setVisible(true);                        
    }
    
    public static void main(String[] args){
        Controleur controleur = new Controleur();
        IhmG ihm = new IhmG(controleur);
     
        ihm.afficher();
    }

    @Override
    public Message notifier(Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
