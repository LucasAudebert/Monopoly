package Jeu;

import Data.*;
import Ui.Ihm;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Controleur {
        
        private Monopoly monopoly;
        private Ihm ihm;
        
        public Controleur(){
            monopoly = new Monopoly();
            ihm = new Ihm();
        }
        
	public void creerPlateau(String dataFilename){
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			//TODO: create cases instead of displaying
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
                                        if(monopoly.getGroupe(EnumerationsMonopoly.COULEUR_PROPRIETE.valueOf(data.get(i)[3])) == null){
                                            monopoly.addGroupe(new Groupe(EnumerationsMonopoly.COULEUR_PROPRIETE.valueOf(data.get(i)[3])));
                                        }
                                        ProprieteAConstruire proprieteTemp = new ProprieteAConstruire(Integer.parseInt(data.get(i)[4]), Integer.parseInt(data.get(i)[1]), data.get(i)[2], monopoly.getGroupe(EnumerationsMonopoly.COULEUR_PROPRIETE.valueOf(data.get(i)[3])), Integer.parseInt(data.get(i)[5]));
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
				else
					System.err.println("[buildGamePleateau()] : Invalid Data type");
			}
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[buildGamePlateau()] : Error while reading file!");
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
        
        public void inscrireJoueurs(){                              
            ArrayList<String> nomJoueurs = ihm.saisirNouveauJoueur();
            for(String nomTemp : nomJoueurs){
                monopoly.addJoueur(new Joueur(nomTemp, monopoly.getCarreau(0)));
            }
        }
        
        private void lancerDesAvancer(Joueur joueur){
            int[] des = new int[2];
            des[0] = (int) (Math.random() * 6) + 1;
            des[1] = (int) (Math.random() * 6) + 1;
            if(des[0] == des[1]){
                ihm.afficher("Vous obtenez un double " + des[1]);
            }else{
                ihm.afficher("Vous obtenez un " + des[0] + " et un " + des[1]);
            }
            joueur.setDerniereValeurDes(des);
            joueur.setPositionCourante(monopoly.getNouvellePosition(des[0]+des[1], joueur.getPositionCourante()));
        }
        
        private void jouerCoup(Joueur joueur){           
            lancerDesAvancer(joueur);
            Resultat resultat = joueur.getPositionCourante().action(joueur);
            switch(resultat.getTypeResultat()){
                case achat :
                    ihm.afficher("Vous étes tombé(e) sur la propriété libre " + resultat.getPropriete().getNom());
                    if(ihm.demandeAchat(resultat)){
                        resultat.getPropriete().achat(joueur);
                    }
                break;
                case loyer :
                    ihm.afficher("Vous êtes tombé(e) sur la propriété " + resultat.getPropriete().getNom() + " appartenant à " + resultat.getPropriete().getProprietaire().getNomJoueur());
                    ihm.afficher("Vous payez " + resultat.getLoyer());
                    joueur.payerLoyer(resultat.getLoyer());
                    resultat.getPropriete().getProprietaire().recevoirLoyer( resultat.getLoyer() ); 
                    if(joueur.estElimine()){
                        monopoly.eliminerJoueur(joueur);
                        ihm.afficher(joueur.getNomJoueur() + " est ruiné(e)");
                    }
                break;
                case autreCarreau :
                    ihm.afficher("Vous étes tombé(e) sur un carreau quelconque");
                break;
                case neRienFaire : 
                    System.out.println("Rien faire");
                break;   
            }
            if(joueur.desDouble() && !monopoly.isFinDePartie()){
                ihm.afficherInfosJoueur(joueur);
                ihm.attendreBouton("\033[32m" + joueur.getNomJoueur() + " appuyez sur Entrer pour rejouer.\033[32m");
                jouerCoup(joueur);
            }
        }
        
        public void boucleDeJeu(){
            int nbTours = 1;
            boolean finPartieJoueur = false;
            while(!finPartieJoueur && !monopoly.isFinDePartie()){
                ihm.afficher("\033[34m------------- Tour " + nbTours + " -------------\033[34m");
                for(Joueur jTemp : monopoly.getJoueurs()){
                     if(!monopoly.getJoueursElimines().contains(jTemp)){
                   
                    finPartieJoueur = ihm.menuTourJoueur(jTemp);
                    if(finPartieJoueur){
                        break;
                    }
                    jouerCoup(jTemp);
                    if(monopoly.isFinDePartie()){
                        break;
                    }
                    ihm.afficherInfosJoueur(jTemp);
               
                if(!finPartieJoueur){
                    ihm.attendreBouton("Appuyer sur Entrer pour voir le récapitulatif du tour");
                    ihm.afficherFinDeTour(monopoly.getJoueurs());
                }
                }
            }
                nbTours++;
            }
            ihm.afficher("\033[31m----------- Fin de partie -----------\033[31m");
            if(monopoly.isFinDePartie()){
                
                ihm.afficherGagnant(monopoly.getJoueurs());
            }else if(finPartieJoueur){
                ihm.afficherFinDePartie(monopoly.getJoueurs());
            }
        }
        
}


