/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;


import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Maxence
 */
public class Des extends Canvas{
    
    private Image un;
    private Image deux;
    private Image trois;
    private Image quatre;
    private Image cinq;
    private Image six;
    private int valDes;
    
    public Des(){
        super(); 
        this.valDes = 0;
        try {
            un = ImageIO.read(new File("src/Des/un.png"));
            deux = ImageIO.read(new File("src/Des/deux.png"));
            trois = ImageIO.read(new File("src/Des/trois.png"));
            quatre = ImageIO.read(new File("src/Des/quatre.png"));
            cinq = ImageIO.read(new File("src/Des/cinq.png"));
            six = ImageIO.read(new File("src/Des/six.png"));
        } catch (IOException ex) {
            Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public void updateDes(int valDes){
        this.valDes = valDes;
        repaint();
    }

    @Override
    public void paint(Graphics g) {   
        this.setSize(100,100);
        
      
            switch(valDes){
            case 0 : 
                g.drawImage(un, 0, 0, null);
                break;
            case 1:
                 g.drawImage(un, 0, 0, null);
                break;
            case 2 : 
                 g.drawImage(deux, 0, 0, null);
                break;
            case 3:
                 g.drawImage(trois, 0, 0, null);
                break;
            case 4 :
                 g.drawImage(quatre, 0, 0, null);
                break;
            case 5:
                 g.drawImage(cinq, 0, 0, null);
                break;
            case 6 : 
                 g.drawImage(six, 0, 0, null);
                break;    
            }
        
        
       
        
    }
    
    
}
