/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout.game;

import java.awt.Color;

/**
 *
 * @author 627997
 */
public class Brick extends Object{
    boolean alive;
    
    public Brick(int x, int y) {
        
        super(x, y, Color.RED, 50, "brick");
        alive = true;
    }
    
  
}