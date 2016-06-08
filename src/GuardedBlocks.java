/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author audeberl
 */
public class GuardedBlocks {
    private boolean joy = false;
    
    public GuardedBlocks() {
        
    }
    
    public synchronized void guardedJoy() {
        while (!joy) {
            try {
                wait();
            } catch(interruptedException e) {}
        }
    }
    
    public synchronized void notifyJoy() {
        joy = true;
        notifyAll();
    }
}
