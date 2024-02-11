/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brick_breaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;   //It is used to perform GUI activities at regular intervals.
import javax.swing.JPanel;

/**
 * Here we will run our game. We need to add this panel inside the main's JFrame.
 * @author betus
 */
public class Gameplay extends JPanel implements KeyListener, ActionListener{
    private boolean play = false; // Because when game started it shouldn't play by itself.
    private int score = 0;  // Starting Score
    
    private int totalBricks = 21;
    private Timer timer;         // For setting the time of ball that how fast it should move.
    private int delay = 8;
    
    // Properties for the x and y axis of the slider and bar ball: 
    private int playerX = 310;  // Starting pozition of our slider.
    
    private int ballposX = 120;        // Starting position of the ball.
    private int ballposY = 350;
    
    // Direction of the ball:
    private int ballXdir = -1;
    private int ballYdir = -2;
    
    // Creating variable for mapGenerator
    private mapGenerator map;
    
    // Creating Constructer; because when we create Gameplay object in main class we want these values.
    public Gameplay(){
        map = new mapGenerator(3,7); // Number of rows 3 and column 7
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this); // speed of it is delay variable and context is "this". 
        timer.start();
    }
    
    
    // Function for Graphics object:
    public void paint(Graphics g){
        // Background : 
        g.setColor(Color.DARK_GRAY);
        g.fillRect(1, 1, 692, 592);
        
        // Drawing map
        map.draw((Graphics2D)g);
        
        // Borders :
        g.setColor(Color.MAGENTA);
        g.fillRect(0, 0, 3, 592); // We need 3 rectangles for the border.
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);
        
        // Scores :
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString(""+score, 590, 30);  // others are position
        
        // The Paddle :
        g.setColor(Color.PINK);
        g.fillRect(playerX, 550, 100, 8);
        
        // The Ball:
        g.setColor(Color.magenta);
        g.fillOval(ballposX,ballposY, 20, 20);  
        
        // How we can detect if the game is finish? - If the totalbrics are 0.
        if(totalBricks <= 0){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(Color.pink);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("You WON",260,300); 
            
            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart",230,350);   // We need to detect Enter in KeyPressed function.
        
        }
        
        // For Game Over
        if(ballposY > 570){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(Color.pink);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Game Over, Scores:",190,300); 
            
            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart",230,350);   // We need to detect Enter in KeyPressed function.
        }
        
        
        g.dispose();  // This code snippet uses the dispose() method to release the memory and system resources of a graphics object
        // created during the painting operations of a specific component. This helps prevent unnecessary retention of resources for an 
        // extended period, contributing to a more efficient and performant operation of the program.
    }
    
    // For moving it we need to add key listeners that it should detect if I have passed the right arrow key or 
    // I have pressed the left arrow key.
    
    
    
    
    // These methods are required by the KeyListener.
    
    // These 2 is required because when we do not add them we get error.
    @Override
    public void keyTyped(KeyEvent e) {// We do not need it.
    }       
    @Override
    public void keyReleased(KeyEvent e) {// We do not need it.
    }    
              
    @Override
    public void actionPerformed(ActionEvent e) { // This method automatically called we do not need to call it inside
        timer.start();
       
        // For Ball 
        if(play) { // if play is true (if we pressed right or left key it will be true.) we need to detect if ball touching the top left or right.

            // Intersection with the paddel. Ball should detecth paddel.
            // We need rectangle around for ball because for detecting intersection of two different pbjects we can do it with a rectangle.
            if( new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))){ // if ball and players rectangle intersects
                                                                                                            // it will return true.
                ballYdir = -ballYdir;  // when we detect intersection ball moves opposite direction.
            }
            
            // We need to create every brick so we add loop.
            A: for(int i = 0; i < map.map.length; i++){     //first map is our variable. Second map is mapGenerator class's map(array) variable.
                                                         // So we are accessing 2d array with object that we have created in Gameplay class.
                for(int j = 0; j< map.map.length; j++){  // We need to change spelling of length.
                    if(map.map[i][j]>0){   // if true detect intersection.
        // for intersection first we need to detect position of ball and brick with respect to the width and height of brick. So we create 4 variables.
                        int brickX = j*map.brickWidth + 80;
                        int brickY = i*map.brickHeight + 50;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;
                        
                        // We created rectangle around that brick:
                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
                        Rectangle brickRect = rect;
                        // We have created variables, let's check if it intersects or not.
                        if(ballRect.intersects(brickRect)){
                            map.setBrickValue(0, i, j);   // 0 for position, i row, j column.
                            totalBricks --;  // less than previous value
                            score +=5;
                            
                            // It will create problem left and right intersection
                            if(ballposX +19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width){
                                // Here we need to move the ball opposite direction.
                                ballXdir = -ballXdir;
                            }else {
                                ballYdir = -ballYdir;
                            }
                            break A;   // We add label A
                            
                        }
                    }
                }
            }
           
            ballposX += ballXdir;
            ballposY += ballYdir;
            
            // For left border
            if(ballposX < 0){
                ballXdir = -ballXdir;
            }
            
            // For top border
            if(ballposY < 0){
                ballYdir = -ballYdir;
            }  
            
            // For right border
            if(ballposX > 670){
                ballXdir = -ballXdir;
            }            
            
        }
        
        repaint();   // it will recall paint method and draw everything again. We need it because when we just increment the playerX value
        // (moveRight/ Left). If we do not use it there is no change shown, because we need to redraw paddle and call paint method again.
        // So we call it again wiht repaint function.
        

        }
    
    @Override
    public void keyPressed(KeyEvent e) {
        // Inside it we can detect arrow keys.
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){  // We check if we clicked right arrow
           if(playerX >= 600)   // if right arrow key pressed : (Player should not go outside the panel.)
               playerX = 600;
           else 
               moveRight();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){  // We check if we clicked left arrow
           if(playerX < 10)   // if right arrow key pressed : (Player should not go outside the panel.)
               playerX = 10;
           else 
               moveLeft();            
        }   
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(!play){
                play = true;
                ballposX = 120;
                ballposY = 350;
                ballXdir = -1;
                ballYdir = -2;
                playerX = 310;
                score = 0;
                totalBricks = 21;
                map = new mapGenerator(3, 7);
                
                repaint();
            }
        }
         }
    
    public void moveRight(){
        play = true;  // We change it true because it was set to false.
        playerX += 20; // And we want to change values of PlayerX, if  it pressed right then it should move 20 pixels to the right side.        
        }
    public void moveLeft(){
        play = true;  
        playerX -= 20;       
        }    
    

 
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
}
