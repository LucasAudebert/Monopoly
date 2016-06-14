/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Carreau;
import Data.Joueur;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Maxence
 */
public class Plateau extends Canvas {
    
    private Image ImagePlateau;
    private ArrayList<Carreau> plateau;
    private ArrayList<Joueur> joueurs;
    
    public Plateau(ArrayList<Carreau> carreaux, ArrayList<Joueur> joueurs){
        super();
        plateau = carreaux;
        this.joueurs = joueurs;
        
        try {
            ImagePlateau = ImageIO.read(new File("src/Image_Plateau.jpg"));
           // desACoudre = ImageIO.read(new File("src\\desACoudre.png"));
        } catch (IOException ex) {
            Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseClicked(MouseEvent e) {
                int num =0;
                
                int x = e.getX();
                int y = e.getY();
                
                int h = getSize().height;
                int w = getSize().width;
                int ih = ImagePlateau.getHeight(null);
                int iw = ImagePlateau.getHeight(null);
                int part = ih/13;
                
                int a1 = (w-iw)/2;
                int b1 = w-a1;
                int c1 = (h-ih)/2;
                int d1 = h-c1;
                
                int a2 = a1 + 2*part;
                int b2 = b1 - 2*part;
                int c2 = c1 + 2*part;
                int d2 = d1 - 2*part;
                
                if (y<=d1 && y>=d2 && x<=b1 && x>=a1) {
                    num = 11-((x-a1)/part);
                    if (num==-1) {
                        num=0;
                    }else if(num==11) {
                        num=10;     
                    }
                } else if (y<=c2 && y>=c1 && x<=b1 && x>=a1) {
                    num=((x-a1)/part)+19;
                    if (num==19) {
                        num=20;
                    } else if (num==31) {
                        num=30;
                    }
                } else if (y<=d1 && y>=c1 && x<=a2 && x>=a1) {
                    num=21-((y-c1)/part);
                } else if (y<=d1 && y>=c1 && x<=b1 && x>=b2) {
                    num=((y-c1)/part)+29;
                }
                
                IhmBoiteMessage.afficherBoiteDialogue(plateau.get(num).getInformations(), 0);
            }
            @Override
            public void mousePressed(MouseEvent e) {}                        
        }); 
    }

    @Override
    public void paint(Graphics g) {
        Dimension dim = this.getSize();

        int x = (int)((getWidth()/2) -(ImagePlateau.getHeight(null)/2));
        int y = (int)((getHeight()/2) - (ImagePlateau.getHeight(null)/2));
        g.drawImage(ImagePlateau, x, y, null);
        
        for(Joueur j : joueurs){
            if(!j.estElimine()){
                int[] coorPion = getPosition(j.getPositionCourante().getNumero() - 1);
                System.out.println(coorPion[0] +" : "+ coorPion[1]);
                g.drawImage(j.getImagePion(), coorPion[0], coorPion[1], null);
            }
        }
    }
    
    public int[] getPosition(int numCarreau) {
        int[] position = {0,0};
        
        int h = getSize().height;
        int w = getSize().width;
        int ih = ImagePlateau.getHeight(null);
        int iw = ImagePlateau.getHeight(null);
        int part = iw/13;        
        
        if (numCarreau <= 10) {
            position[1] = h-(((h-ih)/2)+part+part/2);
            if (numCarreau == 1) {
                position[0]= ((w-iw)/2)+part*3;
            } else if (numCarreau == 10) {
                position[0]= (((w-iw)/2)+part/4);            
            } else {
                position[0]=((11-numCarreau)*part)+part/4+((w-iw)/2);
            }
        } else if (numCarreau >= 20 && numCarreau <= 30) {
            position[1] = ((h-ih)/2)+part/2;
            if (numCarreau == 20) {
                position[0]= ((w-iw)/2)+part/4;                
            } else if (numCarreau == 30) {
                position[0]= w-(((w-iw)/2)+part/4);                
            } else {
                position[0]=((numCarreau-19)*part)+part/4+((w-iw)/2);
            }            
        } else if (numCarreau > 10 && numCarreau < 20) {
            position[0]= ((w-iw)/2)+part/2;
            position[1]=((11-(numCarreau-10))*part)+part/4+((h-ih)/2);
            
        } else if (numCarreau > 30) {
            position[0]= w-(((w-iw)/2)+part);
            position[1]=((numCarreau-30)*part)+((w-iw)/2);
        }
        
        return position;
    }
    
}
