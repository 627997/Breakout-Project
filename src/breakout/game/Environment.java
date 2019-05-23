/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;





public class Environment extends JPanel {

    final int marginX;
    final int marginY;
    private Paddle paddle;  
    private Brick[][] bricks;
    private Ball ball;
    private Timer timer;
    private boolean gameover = false;
    private boolean youwin = false;
    int cols = 20;
    int rows = 4;
    int[][] brickArray = new int[cols][rows];
    
public Environment() {
    super();
    marginX = 5;
    marginY = 5;
    paddle = new Paddle(550, 700, Color.CYAN, 50, "Paddle");
    bricks = new Brick[cols][rows];
    ball = new Ball(550 + 20, 700 - 10, Color.WHITE, 50, "ball");
    timer = new Timer();
    timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/20);
    ball.setVx(3);
    ball.setVy(3);
    spawnBricks();
}
    

private void spawnBricks() {
           for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    bricks[i][j] = new Brick(100 + i * 48, 30 + j * 50);
                    } 
 }
        
}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        
        paddle.draw(g);
        ball.draw2(g);
        //g.dispose();  
        
        
        for (int i = 0; i < cols; i++) {
            
            for (int j = 0; j < rows; j++){
                    if(bricks[i][j].alive){
                bricks[i][j].draw(g);
                    }
            }
        }
        
        if(gameover == true) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            g.setColor(Color.WHITE);
            g.drawString("Game Over", 325, 400);
}
        if(youwin == true) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            g.setColor(Color.WHITE);
            g.drawString("You Win", 325, 400);
}
        
        for (int i = 20; i < cols; i++) {
            
            for (int j = 4; j < rows; j++){
            bricks[i][j].alive = false;
            youwin = true;
            
        
        
    }}}
    
       
       
        private class ScheduleTask extends TimerTask {
    
        @Override
        public void run() {
            paddleWallCollisions(paddle);
            ballWallCollisions(ball);
            ballPaddleCollisions(ball, paddle);
            
            for (int i = 0; i < cols; i++) {
            
            for (int j = 0; j < rows; j++){
            ballVsBrick(ball, bricks[i][j]);
            }
            }
            
            paddle.update();
            
            for (int i = 0; i < cols; i++) {
            
            for (int j = 0; j < rows; j++){
            bricks[i][j].update();
            }
            }
            
            ball.update();
            repaint();
            
            
        }
    }
    public void ballVsBrick(Ball b, Brick p){
        if (b.getX()+ 45 >= p.getX() && b.getY() + 20 >= p.getY()) {
            if (b.getX() <= p.getX() + 45  && b.getY() <= p.getY() + 20) {
               

                p.alive = false;
                    //b.setVy(-ball.getVy());
            }
        }
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.setVx(7);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.setVx(-7);
        }
    }
    
    
    
    
    
    
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            paddle.setVx(0);   
        if (e.getKeyCode() == KeyEvent.VK_LEFT) 
            paddle.setVx(0);   
    }
           
    private void ballPaddleCollisions(Ball b, Paddle p) {
        if (b.getX()+ 45 >= p.getX() && b.getY() + 20 >= p.getY()) {
            if (b.getX() <= p.getX() + 45  && b.getY() <= p.getY() + 20) {
                b.setVy(-b.getVy());
            }
        }
    }
    
    

    
    
    /**
     * Makes the paddle bounce off walls
     */
    private void paddleWallCollisions(Paddle c) {
       
        if (c.getX() <= 0){
            c.setX(1);
            c.setVx(0);
        }
        if (c.getX() >= 1100){
            c.setX(1099);
            c.setVx(0);
        }
    }
    
    private void ballWallCollisions(Ball c) {
       
        if (c.getX() <= 0 || c.getX() >= 1100){
            c.setVx(-c.getVx());
        }
        
        if (c.getY() <= 0){
            c.setVy(-c.getVy());
        }
            
        if (c.getY() + 30 >= 800){
            c.setVx(0);
            c.setVy(0);
            gameover = true;
        }
    }
    
    
    /*private void ballBrickCollisions(Brick p, Ball b) {
        if (b.getX()+ 45 >= p.getX() && b.getY() + 20 >= p.getY()) {
            if (b.getX() <= p.getX() + 45  && b.getY() <= p.getY() + 20) {
                //ball.kill(brick);
                //p.setX(-2000);
                //b.setVx(-b.getVx());
                b.setVy(-b.getVy());
                p.setX(-1000);
            }
        }
    }*/
    
}

    
