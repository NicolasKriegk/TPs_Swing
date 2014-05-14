/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5_horlogecorrsimon.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import tp5_horlogecorrsimon.model.Model;

/**
 *
 * @author imie
 */
public class View extends Observable implements Observer {

    private Model m;
    private JLabel secondLabel;
    private JLabel minuteLabel;
    private JLabel hourLabel;

    public View(Model m) {
        this.m = m;
        createGUI();
    }

    @Override
    public void update(Observable o, Object o1) {
        NumberFormat nFormat = new DecimalFormat("00");
        if (secondLabel != null) {
            secondLabel.setText(nFormat.format(m.getSecond()));
        }
        if (minuteLabel != null) {
            minuteLabel.setText(nFormat.format(m.getMinute()));
        }
        if (hourLabel != null) {
            hourLabel.setText(nFormat.format(m.getHour()));
        }
    }

    private void createGUI() {
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
                        setChanged();
                        notifyObservers("incSecond");
                    }
                });
                constraints.gridx = 5;
                jFrame.add(buttonIncSecond, constraints);

                JButton buttonIncMinute = new JButton("+");
                buttonIncMinute.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        setChanged();
                        notifyObservers("incMinute");
                    }
                });
                constraints.gridx = 3;
                jFrame.add(buttonIncMinute, constraints);

                JButton buttonIncHour = new JButton("+");
                buttonIncHour.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        setChanged();
                        notifyObservers("incHour");
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
                        setChanged();
                        notifyObservers("decSecond");
                    }
                });
                constraints.gridx = 5;
                jFrame.add(buttonDecSecond, constraints);

                JButton buttonDecMinute = new JButton("-");
                buttonDecMinute.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        setChanged();
                        notifyObservers("decMinute");
                    }
                });
                constraints.gridx = 3;
                jFrame.add(buttonDecMinute, constraints);

                JButton buttonDecHour = new JButton("-");
                buttonDecHour.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        setChanged();
                        notifyObservers("decHour");
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
                        m.synch();
                    }
                });
                constraints.gridy = 1;
                jFrame.add(buttonSync, constraints);

                JButton buttonRaz = new JButton("raz");
                buttonRaz.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        m.raz();
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
                        m.start();
                    }
                });
                constraints.gridy = 1;
                jFrame.add(buttonStart, constraints);

                JButton buttonStop = new JButton("stop");
                buttonStop.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        m.stop();
                    }
                });
                constraints.gridy = 2;
                jFrame.add(buttonStop, constraints);

                jFrame.pack();
                jFrame.setVisible(true);
            }
        });


    }
}
