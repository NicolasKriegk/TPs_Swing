/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_helloworld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author imie
 */
public class TP2_HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//Create and set up the window.

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                final JFrame frame = new JFrame("HelloWorldSwing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //Add the ubiquitous "Hello World" label.
//        JLabel label = new JLabel("Hello World");
//        frame.getContentPane().add(label);

                final JPanel panel = new JPanel();
                frame.add(panel);
                JButton testButton = new JButton("Hello!");
                panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
                panel.add(testButton);
//                panel.setPreferredSize(400);

                testButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        //Add the ubiquitous "Hello World" label.
                        JLabel label = new JLabel("Hello World");
                        panel.add(label);
                        //Display the window.
                        frame.pack();
//                        frame.setVisible(true);
                    }
                });


                //Display the window.
                frame.pack();
                frame.setVisible(true);



            }
        });

    }
}
