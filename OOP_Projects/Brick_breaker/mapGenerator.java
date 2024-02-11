/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brick_breaker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * We will create generic map because we have given the value of 21 if we want to change values of 
 * bricks we should change it.
 * @author betus
 */
public class mapGenerator {
    public int map[][];// This array will contain all bricks.
    public int brickWidth;
    public int brickHeight;
    
    public mapGenerator(int row, int col){
        map = new int[row][col];
        for(int i = 0; i< map.length; i++){
            for(int j = 0; j< map[0].length; j++){
                map[i][j] = 1;
            }
        }
        brickHeight = 150/row;
        brickWidth = 540/col;
    }
    public void draw(Graphics2D g){
        // When this function will be called the bricks will be drawn on the particular positions where there is a value of 1.
        for(int i = 0; i< map.length; i++){
            for(int j = 0; j< map[0].length; j++){
                // inside these loops we need to check if the particular value is greater than zero or not
                // then create that particular brick inside that particular position.
                if(map[i][j] > 0){
                    g.setColor(Color.WHITE);
                    g.fillRect(j*brickWidth + 80,i* brickHeight + 50, brickWidth, brickHeight);
                    
                    // We need border around individual bricks. 
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*brickWidth + 80,i* brickHeight + 50, brickWidth, brickHeight);
                    
                    // Until here there is no intersection, ball should intersect with brick and change its value to zero.
                    }
                }
            }
         }     
    // We will create function for detect the intersection of ball and individual bricks in Gameplay class.
    
    
    
    public void setBrickValue(int value, int row, int col){
        map[row][col] = value; 
    }
        
   
        
        
        
        
        
        
    }

