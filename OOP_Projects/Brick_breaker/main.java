/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brick_breaker;

import javax.swing.JFrame;

/**
 *
 * @author betus
 */
public class main {
    public static void main(String[] args){
        JFrame obj = new JFrame();
        Gameplay gameplay = new Gameplay();  // We created object
        obj.setBounds(10, 10, 700, 600);
        obj.setTitle("Breakout Ball");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);       // We've created object now we will add this object in object of Jframe.

    }
}
