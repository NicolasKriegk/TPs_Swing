/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_helloworld;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author imie
 */
public class TP1_HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
