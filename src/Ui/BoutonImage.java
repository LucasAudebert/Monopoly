/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author blachert
 */
public class BoutonImage extends JPanel {
    
    private Image img;
    
    public BoutonImage(String imgPath){
        try{
            img = ImageIO.read(new File(imgPath));
        }catch(IOException e){
            System.err.println(e);
        }
    }
    
    public void paint(Graphics g){
        g.drawImage(img, 0, 0, this);
    }
    
}
