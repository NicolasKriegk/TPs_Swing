/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5_horloge;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author imie
 */
public class TP5_Horloge {

    static JFrame frame;
    static JPanel timerView;
    static JPanel timerSettings;
    static JPanel timer;
    static JLabel timerViewHour;
    static JLabel timerViewMinute;
    static JLabel timerViewSeconde;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Timer10ms test = new Timer10ms();
        Thread timerThread = new Thread(test);
        timerThread.start();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException ie) {
//            Logger.getLogger(TP5_Horloge.class.getName()).log(Level.SEVERE, "Normalement 10s");
//        }
//        timerThread.interrupt();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                //affichage du temps
                timerView = new JPanel();
                //timerView.setLayout(new GridBagLayout());
                timerView.setLayout(new BoxLayout(timerView,BoxLayout.LINE_AXIS));
                timerViewHour = new JLabel();
                timerViewMinute = new JLabel();
                timerViewSeconde = new JLabel();
                timerView.add(timerViewHour);
                timerView.add(new JLabel(" : "));
                timerView.add(timerViewMinute);
                timerView.add(new JLabel(" : "));
                timerView.add(timerViewSeconde);
                
                
                //boutons de l'horloge
                timerSettings = new JPanel();
                timerSettings.setLayout(new BoxLayout(timerSettings,BoxLayout.LINE_AXIS));
                //JPanel timerSettingsHour = new JPanel();
                
                
                //horloge
                timer = new JPanel();
                timer.add(timerView);
                timer.add(timerSettings);



                frame = new JFrame("Horloge");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(500, 500));
                frame.setLocation(400, 500);


                frame.setContentPane(timer);


                //Display the window.
                frame.pack();
                frame.setVisible(true);



            }
        });

        Thread affTimer = new Thread(new AffTimer(test));
        affTimer.start();


    }

    static class Timer10ms implements Runnable {

        private int compteur;
        private long heures;
        private long minutes;
        private long secondes;
        private long reste;
        private long facteurCorrection = 100;
        private long precision = 10;

        public long getHeures() {
            return heures;
        }

        public void setHeures(long heures) {
            this.heures = heures;
        }

        public long getMinutes() {
            return minutes;
        }

        public void setMinutes(long minutes) {
            this.minutes = minutes;
        }

        public long getSecondes() {
            return secondes;
        }

        public void setSecondes(long secondes) {
            this.secondes = secondes;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(precision);
                } catch (InterruptedException ie) {
                    break;
                }
                compteur++;
                System.out.println(compteur);
                long valeurCorrigee = compteur / facteurCorrection;
                heures = valeurCorrigee / (facteurCorrection * 3600);
                reste = valeurCorrigee % (facteurCorrection * 3600);
                minutes = reste / (60);
                reste = reste % (60);
                secondes = reste;
                System.out.println(heures + ":" + minutes + ":" + secondes);

            }
//            System.out.println("End of timer");

        }
    }
    static class AffTimer implements Runnable {
        private Timer10ms timer;
        
        public AffTimer(Timer10ms timer){
            super();
            this.timer = timer;
        }
        
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    break;
                }
                NumberFormat nf = new DecimalFormat("00");
                timerViewHour.setText(nf.format(timer.getHeures()));
                timerViewMinute.setText(nf.format(timer.getMinutes()));
                timerViewSeconde.setText(nf.format(timer.getSecondes()));
            }

            
        }
    }
}
