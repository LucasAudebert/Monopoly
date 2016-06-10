/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Maxence
 */
public class Plateau extends Canvas {
    
    public Plateau(){
        super();
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
                int height = getSize().height;
                int width = getSize().width;
                int part = height/13;
                
                if (e.getY()>=11*part) {
                    if (getX()>=11*part) {
                        num =1;
                    } else if (e.getX()<=2*part) {
                        num=11;
                    } else {
                        num=12-e.getX()/part;                        
                    }
                } else if (e.getY()<=2*part) {
                    if (getX()>=11*part) {
                        num=31;
                    } else if (e.getX()<=2*part) {
                        num=21;
                    } else {
                        num=e.getX()/part+20;
                    }                   
                } else if (e.getX()>=11*part) {
                        num=22-e.getY()/part;                     
                } else if (e.getX()<=2*part) {
                        num=e.getX()/part+30;                       
                }
            System.out.println(num);                
            }
            @Override
            public void mousePressed(MouseEvent e) {}                        
        }); 
    }

    @Override
    public void paint(Graphics g) {
       Dimension dim = this.getSize();
       Image plateau = null;
     //  Image desACoudre = null;
        try {
            plateau = ImageIO.read(new File("src/Image_Plateau.jpg"));
           // desACoudre = ImageIO.read(new File("src\\desACoudre.png"));
        } catch (IOException ex) {
            Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        }
        int x = (int)((getWidth()/2) -(plateau.getHeight(null)/2));
        int y = (int)((getHeight()/2) - (plateau.getHeight(null)/2));
        g.drawImage(plateau,x,y, null);
      
        
        
        
    }
    
    
    
}
