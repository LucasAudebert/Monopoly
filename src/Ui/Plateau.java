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
        
    }

  @Override
    public void paint(Graphics g) {
        Dimension dim = this.getSize();
       Image plateau = null;
     //  Image desACoudre = null;
        try {
            plateau = ImageIO.read(new File("src\\Image_Plateau.jpg"));
           // desACoudre = ImageIO.read(new File("src\\desACoudre.png"));
        } catch (IOException ex) {
            Logger.getLogger(Plateau.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        g.drawImage(plateau, 0,0, null);
        //g.drawImage(desACoudre, dim.height -50,50, null);
        
        
        
    }
    
    
    
}
