/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 627997
 */
public class Object {
    private int x;
    private int y;
    private int vx;
    private int vy;
    private Color color;
    private int size;
    private String name;
    
    
    
    
    public Object(int x, int y, Color color, int size, String name) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
        this.name = name;
        vx = 0;
        vx = 0;
    }    
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getVx() {
        return vx;
    }
    
    public int getVy() {
        return vy;
    }
    
    public Color getColor() {
        return color;
    }
    
    public int getSize() {
        return size;
    }
    
    public String getName() {
        return name;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setVx(int vx) {
        this.vx = vx;
    }   
    
    public void setVy(int vy) {
        this.vy = vy;
    }
      
    public void setColor(Color color) {
        this.color = color;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
  
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 45, 20);
    }
    public void draw2(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 10, 10);
    }
    
    public void die(Brick b){
        b.setX(-1000);
    }
    
    //public void kill(Paddle c) {
    //   c.setSize(0);
    //}

    public void move(int vx, int vy) {
        x += vx * 3;
        y += vy * 3;
    }
    
    public void update() {
        move(vx, vy);
    }
    
    /**
     * Makes the character reverse direction on X axis
     */
   
    public void reverseX() {
        //TODO Implement this method
        vx = -vx;
        move(vx, vy); 
    }
    
    /**
     * makes the character reverse directions on Y axis
     */
    
    public void reverseY() {
        vy = -vy;
        move (vx, vy);
    }

    
}