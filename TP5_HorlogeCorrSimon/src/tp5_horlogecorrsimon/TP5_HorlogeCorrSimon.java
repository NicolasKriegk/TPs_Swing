/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5_horlogecorrsimon;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author imie
 */
public class TP5_HorlogeCorrSimon {


    static Integer time = 0;
    static Integer second = 0;
    static Integer minute = 0;
    static Integer hour = 0;
    static JLabel secondLabel;
    static JLabel minuteLabel;
    static JLabel hourLabel;
    static Boolean running = false;

    public static void incrementCentisecond() {
        if (running) {
            time++;
            businessRule();
        }
    }

    public static void businessRule() {
        if (time >= 100) {
            second++;
            time -= 100;
        }

        if (second >= 60) {
            minute++;
            second -= 60;
        }

        if (second < 0) {
            minute--;
            second += 60;
        }

        if (minute >= 60) {
            hour++;
            minute -= 60;
        }

        if (minute < 0) {
            hour--;
            minute += 60;
        }

        if (hour >= 24) {
            hour -= 24;
        }

        if (hour < 0) {
            hour += 24;
        }
    }

    public static void incSecond() {
        second++;
        businessRule();
    }

    public static void decSecond() {
        second--;
        businessRule();
    }

    public static void incMinute() {
        minute++;
        businessRule();
    }

    public static void decMinute() {
        minute--;
        businessRule();
    }

    public static void incHour() {
        hour++;
        businessRule();
    }

    public static void decHour() {
        hour--;
        businessRule();
    }

    public static void synch() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);


        businessRule();
    }

    public static void raz() {
        second = 0;
        minute = 0;
        hour = 0;
        time = 0;
    }

    public static void start() {
        running = true;
    }

    public static void stop() {
        running = false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jFrame = new JFrame();
                jFrame.setPreferredSize(new Dimension(400, 200));
                jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
                jFrame.setLayout(new GridBagLayout());
                GridBagConstraints constraints = new GridBagConstraints();
                // Labels
                constraints.gridy = 1;
                constraints.gridheight = 2;
                constraints.gridx = 5;
                secondLabel = new JLabel();
                secondLabel.setFont(new Font("Arial", Font.PLAIN, 40));
                jFrame.add(secondLabel, constraints);
                constraints.gridx = 4;
                jFrame.add(new JLabel(":"), constraints);
                constraints.gridx = 3;
                minuteLabel = new JLabel();
                minuteLabel.setFont(new Font("Arial", Font.PLAIN, 40));
                jFrame.add(minuteLabel, constraints);
                constraints.gridx = 2;
                jFrame.add(new JLabel(":"), constraints);
                constraints.gridx = 1;
                hourLabel = new JLabel();
                hourLabel.setFont(new Font("Arial", Font.PLAIN, 40));
                jFrame.add(hourLabel, constraints);

                //Inc Button
                constraints.gridy = 0;
                constraints.gridheight = 1;

                JButton buttonIncSecond = new JButton("+");
                buttonIncSecond.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        incSecond();
                    }
                });
                constraints.gridx = 5;
                jFrame.add(buttonIncSecond, constraints);

                JButton buttonIncMinute = new JButton("+");
                buttonIncMinute.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        incMinute();
                    }
                });
                constraints.gridx = 3;
                jFrame.add(buttonIncMinute, constraints);

                JButton buttonIncHour = new JButton("+");
                buttonIncHour.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        incHour();
                    }
                });
                constraints.gridx = 1;
                jFrame.add(buttonIncHour, constraints);

                //Dec Button
                constraints.gridy = 3;

                JButton buttonDecSecond = new JButton("-");
                buttonDecSecond.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        decSecond();
                    }
                });
                constraints.gridx = 5;
                jFrame.add(buttonDecSecond, constraints);

                JButton buttonDecMinute = new JButton("-");
                buttonDecMinute.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        decMinute();
                    }
                });
                constraints.gridx = 3;
                jFrame.add(buttonDecMinute, constraints);

                JButton buttonDecHour = new JButton("-");
                buttonDecHour.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        decHour();
                    }
                });
                constraints.gridx = 1;
                jFrame.add(buttonDecHour, constraints);



                //synch -raz
                constraints.gridx = 6;
                JButton buttonSync = new JButton("synch");
                buttonSync.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        synch();
                    }
                });
                constraints.gridy = 1;
                jFrame.add(buttonSync, constraints);

                JButton buttonRaz = new JButton("raz");
                buttonRaz.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        raz();
                    }
                });
                constraints.gridy = 2;
                jFrame.add(buttonRaz, constraints);

                //start - stop
                constraints.gridx = 0;
                JButton buttonStart = new JButton("start");
                buttonStart.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        start();
                    }
                });
                constraints.gridy = 1;
                jFrame.add(buttonStart, constraints);

                JButton buttonStop = new JButton("stop");
                buttonStop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        stop();
                    }
                });
                constraints.gridy = 2;
                jFrame.add(buttonStop, constraints);

                jFrame.pack();
                jFrame.setVisible(true);
            }
        });


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        break;
                    }
                    incrementCentisecond();
                    System.out.println(time);
                    NumberFormat nFormat = new DecimalFormat("00");
                    if (secondLabel != null) {
                        secondLabel.setText(nFormat.format(second));
                    }
                    if (minuteLabel != null) {
                        minuteLabel.setText(nFormat.format(minute));
                    }
                    if (hourLabel != null) {
                        hourLabel.setText(nFormat.format(hour));
                    }
                }
                System.out.println("End IncrementThread");
            }
        });


        thread.start();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(JavaApplication7.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //   thread.interrupt();
    }
}

