package Jeu;

import Data.*;
import Ui.Ihm;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
					//System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        monopoly.addCarreau(new ProprieteAConstruire(Integer.parseInt(data.get(i)[4]), Integer.parseInt(data.get(i)[1]), data.get(i)[2], EnumerationsMonopoly.typeCarreau[2]));
				}
				else if(caseType.compareTo("G") == 0){
					//System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        monopoly.addCarreau(new Gare(25, Integer.parseInt(data.get(i)[1]), data.get(i)[2], EnumerationsMonopoly.typeCarreau[0]));
				}
				else if(caseType.compareTo("C") == 0){
					//System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        monopoly.addCarreau(new Compagnie(125, Integer.parseInt(data.get(i)[1]), data.get(i)[2], EnumerationsMonopoly.typeCarreau[1]));
				}
				else if(caseType.compareTo("AU") == 0){
					//System.out.println("Case Autre :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        monopoly.addCarreau(new AutreCarreau(Integer.parseInt(data.get(i)[1]), data.get(i)[2], EnumerationsMonopoly.typeCarreau[3]));
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
	
	/*private void buildGamePlateau(String dataFilename)
	{
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			//TODO: create cases instead of displaying
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
					System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("G") == 0){
					System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("C") == 0){
					System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("AU") == 0){
					System.out.println("Case Autre :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
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
	}*/
	
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
            String[] nomJoueurs = ihm.saisirNouveauJoueur();
            for(int i = 0; i < nomJoueurs.length; i++){
                monopoly.addJoueur(new Joueur(nomJoueurs[i], monopoly.getCarreau(0)));
            }
        }
        
        private void lancerDesAvancer(Joueur joueur){
            int[] des = new int[2];
            des[0] = (int) (Math.random() % 6) + 1;
            des[1] = (int) (Math.random() % 6) + 1;
            joueur.setDerniereValeurDes(des);
            joueur.setPositionCourante(monopoly.getNouvellePosition(des[0]+des[1], joueur.getPositionCourante()));
        }
        
        private void jouerCoup(Joueur joueur){
            lancerDesAvancer(joueur);
            Resultat resultat = joueur.getPositionCourante().action(joueur);
            
        }
        
        public void boucleDeJeu(){
            for(Joueur jTemp : monopoly.getJoueurs()){
                jouerCoup(jTemp);
            }
        }
}


