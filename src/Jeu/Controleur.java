package Jeu;

import Data.*;
import Ui.Ihm;
import Ui.Observateur;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Data.Cartes.*;
import Ui.IhmBoiteMessage;
import Ui.Message;
import java.util.HashMap;
import javax.swing.ImageIcon;

public class Controleur {
        private Monopoly monopoly;
        private Ihm ihm;
        private Observateur observateur;
        
        public Controleur(){
            monopoly = new Monopoly();
            ihm = new Ihm();
            initPartie();
        }
        
        public Controleur(Observateur obs){
            monopoly = new Monopoly();
            this.observateur = obs;
            initPartie();
        }
        
        public void setObservateur(Observateur observateur) {
            this.observateur = observateur;
        }           
        
        private void initPartie(){
            creerPlateau("src/data.txt");
            creerCartes("src/cartes.txt");
            monopoly.melangerPiles();
        }
        
	private void creerPlateau(String dataFilename){
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			//TODO: create cases instead of displaying
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
                                        if(monopoly.getGroupe(EnumerationsMonopoly.COULEUR_PROPRIETE.valueOf(data.get(i)[3])) == null){
                                            monopoly.addGroupe(new Groupe(EnumerationsMonopoly.COULEUR_PROPRIETE.valueOf(data.get(i)[3])));
                                        }
                                        ArrayList loyers = new ArrayList<Integer>();
                                        for(int j = 6; j <= 10; j++){
                                            loyers.add(Integer.parseInt(data.get(i)[j]));
                                        }
                                        ProprieteAConstruire proprieteTemp = new ProprieteAConstruire(Integer.parseInt(data.get(i)[4]), Integer.parseInt(data.get(i)[1]), data.get(i)[2], monopoly.getGroupe(EnumerationsMonopoly.COULEUR_PROPRIETE.valueOf(data.get(i)[3])), loyers, Integer.parseInt(data.get(i)[11]));
                                        monopoly.addCarreau(proprieteTemp);
                                        
                                        monopoly.getGroupe(EnumerationsMonopoly.COULEUR_PROPRIETE.valueOf(data.get(i)[3])).addPropriete(proprieteTemp);
                                        
				}
				else if(caseType.compareTo("G") == 0){
                                        monopoly.addCarreau(new Gare(Integer.parseInt(data.get(i)[3]), Integer.parseInt(data.get(i)[1]), data.get(i)[2], 25));
				}
				else if(caseType.compareTo("C") == 0){
                                        monopoly.addCarreau(new Compagnie(Integer.parseInt(data.get(i)[3]), Integer.parseInt(data.get(i)[1]), data.get(i)[2]));
				}
				else if(caseType.compareTo("AU") == 0){
                                        monopoly.addCarreau(new AutreCarreau(Integer.parseInt(data.get(i)[1]), data.get(i)[2]));
				}
                                else if(caseType.compareTo("CH") == 0){
                                        monopoly.addCarreau(new CarreauPiocherCarteChance(Integer.parseInt(data.get(i)[1]), data.get(i)[2]));
                                }
                                else if(caseType.compareTo("CC") == 0){
                                        monopoly.addCarreau(new CarreauPiocherCarteCDC(Integer.parseInt(data.get(i)[1]), data.get(i)[2]));    
                                }
                                else if(caseType.compareTo("PR") == 0){
                                        monopoly.addCarreau(new AllerEnPrison(Integer.parseInt(data.get(i)[1]), data.get(i)[2]));
                                }
                                else if(caseType.compareTo("T") == 0){
                                        monopoly.addCarreau(new Taxe(Integer.parseInt(data.get(i)[1]), data.get(i)[2], Integer.parseInt(data.get(i)[3])));
                                }
				else
					System.err.println("[creerPlateau()] : Invalid Data type");
			}
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[creerPlateau()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[creerPlateau()] : Error while reading file!");
		}		
	}
        
        private void creerCartes(String filename){
                
            try{
                ArrayList<String[]> data = readDataFile(filename, ",");
                for(int i=0; i<data.size(); ++i){
                    String caseType = data.get(i)[0];
                    Carte carte = null;
                    if(caseType.compareTo("DD") == 0){
                        carte = new CarteDeplacement(data.get(i)[2], Integer.parseInt(data.get(i)[3]));
                    }else if(caseType.compareTo("SP") == 0){
                        carte = new CarteSortieDePrison(data.get(i)[2]);
                    }else if(caseType.compareTo("R") == 0){
                        carte = new CarteReparation(data.get(i)[2], Integer.parseInt(data.get(i)[3]), Integer.parseInt(data.get(i)[4]));
                    }else if(caseType.compareTo("D") == 0){
                        carte = new CarteDeplacementSpecial(data.get(i)[2], Integer.parseInt(data.get(i)[3]));
                    }else if(caseType.compareTo("GG") == 0){
                        carte = new CarteGain(data.get(i)[2], Integer.parseInt(data.get(i)[3]));
                    }else if(caseType.compareTo("A") == 0){
                        carte = new CarteAmende(data.get(i)[2], Integer.parseInt(data.get(i)[3]));
                    }else if(caseType.compareTo("HB") == 0){
                        carte = new CarteAnniversaire(data.get(i)[2], Integer.parseInt(data.get(i)[3]));
                    }else if(caseType.compareTo("AP") == 0){
                        carte = new CarteAllerEnPrison(data.get(i)[2]);
                    }else{
                        System.err.println("[creerCartes()] : Invalid Data type");
                    }
                    if(data.get(i)[1].compareTo("Chance") == 0){
                        monopoly.getPileChance().addCarte(carte);
                    }else{
                        monopoly.getPileCommunaute().addCarte(carte);
                    }
                }
                
            }catch(FileNotFoundException e){
                System.err.println("[creerCartes()] : File is not found!");
            }catch(IOException e){
                System.err.println("[creerCartes()] : Error while reading file!");
            }     
        }
        
	private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			data.add(line.split(token));
		}
		reader.close();
		
		return data;
	}
           
        public void inscrireJoueurs(ArrayList<String> nomJoueurs, HashMap<String, ImageIcon> pions){                                             
                for(String nomTemp : nomJoueurs){
                    monopoly.addJoueur(new Joueur(nomTemp, monopoly.getCarreau(0), pions.get(nomTemp)));
                }
            }

        /*
        public void inscrireJoueurs(){                              
                ArrayList<String> nomJoueurs = ihm.saisirNouveauJoueur();
                for(String nomTemp : nomJoueurs){
                    monopoly.addJoueur(new Joueur(nomTemp, monopoly.getCarreau(0)));
                }
            }
        */
        public ArrayList<Joueur> getJoueurs(){
            return monopoly.getJoueurs();
        }
        
        public void allerPrison(Joueur joueur){
            joueur.setPositionCourante(monopoly.getCarreauPrison());
            monopoly.addPrisonnier(joueur);
        }     

        public void sortirPrison(Joueur joueur){
            monopoly.removePrisonnier(joueur);
            joueur.reinitCompteurEssaiPrison();
        }  
        
        private int[] lancerDes(){
            int[] des = new int[2];
            des[0] = (int) (Math.random() * 6) + 1;
            des[1] = (int) (Math.random() * 6) + 1;
            System.out.println("Score de des : "+ des[0]+" "+des[1]);
            return des;
        }
        
        public void lancerDesAvancer(Joueur joueur){
            int[] des = lancerDes();
            if(des[0] == des[1]){
                ihm.afficher("Vous obtenez un double " + des[1]);
               joueur.incrementCompteurDee();
            }else{
                ihm.afficher("Vous obtenez un " + des[0] + " et un " + des[1]);
                joueur.reinitCompteurDouble();
            }
            joueur.setDerniereValeurDes(des);
            if(!monopoly.estEnPrison(joueur) || des[0]==des[1] || joueur.getCompteurEssaiPrison() >= 2 )
                joueur.setPositionCourante(monopoly.getNouvellePosition(des[0]+des[1], joueur.getPositionCourante()));
            if(joueur.getDerniereValeurDes() >= joueur.getPositionCourante().getNumero()){
                joueur.gagnerCash(200);
                ihm.afficher("Vous êtes passé par la case départ (+200)");
            }
            
            observateur.notifier(new Message(EnumerationsMonopoly.TYPE_MESSAGE.deplacement,joueur.getDerniereValeurDes() > joueur.getPositionCourante().getNumero(),des[0]==des[1]));
        }
        
        public void tirerEtJouerCarte(Carte carte, Joueur joueur, Pile pile){
            observateur.notifier( new Message(EnumerationsMonopoly.TYPE_MESSAGE.actionCarte, carte.action(joueur), carte, pile));
        }
        
        public void traiterActionCarreau( Joueur joueur){           
            observateur.notifier(new Message(EnumerationsMonopoly.TYPE_MESSAGE.actionCarreau, joueur.getPositionCourante().action(joueur)));        
        }
        
//        public void jouerCoup(Joueur joueur){
//                // Si le joueur a une carte prison et souhaite l'utiliser pour sortir de prison          
//            if (monopoly.estEnPrison(joueur) && joueur.possedeCarteSortieDePrison() && IhmBoiteMessage.afficherBoiteDialogue("Vous possèdez une carte 'Sortie de prison'\nSouhaitez-vous l'utilisez pour sortir de prison ?", 1)) {
//                sortirPrison(joueur);
//            }     
//            
//                // On lance les dès et on déplace le joueur
//            boolean desDouble = false;
//            
//                //Liberation de prison si double
//            if (monopoly.estEnPrison(joueur) && desDouble){
//                sortirPrison(joueur);
//            }
//            
//                //Si joueur en prison et des non double et compteur < 3 => compteur++ et ne joue pas 
//            if(monopoly.estEnPrison(joueur) && joueur.getCompteurEssaiPrison() < 2 ){
//                joueur.incrementCompteurEssaiPrison();
//            }else{
//                if(joueur.getCompteurEssaiPrison() >= 2){
//                    ihm.afficher("Payer caution 50");
//                    joueur.payer(50);
//                    sortirPrison(joueur);
//                }
//                Resultat resultat = joueur.getPositionCourante().action(joueur);
//                if(joueur.getCompteurDouble() != 3){
//                    traiterActionCarreau(joueur);
//                    
//                    if(joueur.rejouer() && !monopoly.isFinDePartie()){ //si le joueur fait un double/piocher une carte de deplacement et que ce n'est pas une fin de partie 
//                        ihm.afficherInfosJoueur(joueur); // on affiche les infos du joueur
//                        ihm.attendreBouton("\033[32m" + joueur.getNomJoueur() + " appuyez sur Entrer pour rejouer.\033[32m");
//                        jouerCoup(joueur); // on fait rejouer le joueur 
//                    }
//                    
//                }else{
//                    ihm.afficher(" Vous avez réalisé trois double vous allez en prison ! BATARD VA ");
//                    allerPrison(joueur);
//                }
//            } 
//        }
        
    /**
     *
     */
//    public void boucleDeJeu(){
//            int nbTours = 1;
//            boolean finPartieJoueur = false; //boolean de fin de partie decider par les joueur
//            while(!finPartieJoueur && !monopoly.isFinDePartie()){ // tant que finPartieJoueur false ET pas de vainqeur faire 
//                ihm.afficher("\033[34m------------- Tour " + nbTours + " -------------\033[34m");
//                for(Joueur jTemp : monopoly.getJoueurs()){// boucle sur tout les joueurs du monopoly
//                     if(!monopoly.getJoueursElimines().contains(jTemp)){// verifie que jTemp n'est pas éliminé
//                   
//                    finPartieJoueur = ihm.menuTourJoueur(jTemp); 
//                    if(finPartieJoueur){//si fin de partie décider par les joueurs arrêter de jouer 
//                        break;
//                    }
//                    jouerCoup(jTemp);
//                    if(monopoly.isFinDePartie()){ // si fin de partie car vainqueur arrêter de joueur
//                        break;
//                    }
//                    ihm.afficherInfosJoueur(jTemp); //affiche l'etat du joueur qui vient de jouer
//               
//                
//                  }
//                }
//                
//                if(!finPartieJoueur){ 
//                    ihm.attendreBouton("Appuyer sur Entrer pour voir le récapitulatif du tour");
//                    ihm.afficherFinDeTour(monopoly.getJoueurs()); // affiche l'etat de chaque joueur à la fin du tour
//                }
//                nbTours++; // increment de 1  le nbr tour à chauqe fin de tour 
//            }
//            ihm.afficher("\033[31m----------- Fin de partie -----------\033[31m");
//            
//            if(monopoly.isFinDePartie()){  //Si fin de partie car il y a un gagnant               
//                ihm.afficherGagnant(monopoly.getJoueurs()); // affiche le gagnant 
//            }else if(finPartieJoueur){//si fin de partie décider par les joueur
//                ihm.afficherFinDePartie(monopoly.getJoueurs());// afficher l'etat des joueur à ce moment 
//            }
//        }

    public boolean estEnPrison(Joueur joueurCourant) {        
        return monopoly.estEnPrison(joueurCourant);
    }

    public Joueur joueurSuivant(Joueur joueur) {
        int i = 0;       
            while(monopoly.getJoueurs().get(i) != joueur ){
                i++;
            }
            if(i == monopoly.getJoueurs().size()-1 ){
                return monopoly.getJoueurs().get(0);
            }else{
                return monopoly.getJoueurs().get(i+1);
            }            
        }

    public Carte piocherCarteChance() {
        return monopoly.getPileChance().tirerUneCarte();       
    }

    public Carte piocherCarteCDC() {
        return monopoly.getPileCommunaute().tirerUneCarte();
    }

    public Pile getPileChance() {
        return monopoly.getPileChance();
    }
    
    public Pile getPileComunaute() {
        return monopoly.getPileCommunaute();
    } 
   
    public void eliminerJoueur(Joueur joueurCourant) {        
      monopoly.eliminerJoueur(joueurCourant);        
    }

    public boolean finDePartie() {
        return (monopoly.getJoueurs().size()-monopoly.getJoueursElimines().size()) == 1;
    }

    public Carreau getCarreau(int i) {
        return monopoly.getCarreau(i);
    }

    public boolean estElimine(Joueur j) {
        return monopoly.getJoueursElimines().contains(j);
    }

    public Joueur getDernierJoueur() {
        return monopoly.getJoueurs().get(0);
    }
}


