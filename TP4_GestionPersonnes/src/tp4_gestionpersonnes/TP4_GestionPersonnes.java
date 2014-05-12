/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4_gestionpersonnes;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import model.Person;

/**
 *
 * @author imie
 */
public class TP4_GestionPersonnes {

    static JFrame frame;
    static JPanel panel;
    static JPanel personsTable;
    static JPanel personForm;
    static List<Person> persons = new ArrayList<Person>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        SwingUtilities.invokeLater(
                new Runnable() {
            @Override
            public void run() {

                persons.add(new Person("Lecroc", "Odile"));
                persons.add(new Person("Rie", "Anne"));

                //Create the "cards".
                personsTable = new JPanel();
                personsTable.setName("Tableau");
                   personsTable.add(new JLabel("Salut"));

                personForm = new JPanel();
                personForm.setName("Formulaire");

                //Create the panel that contains the "cards".
                panel = new JPanel(new CardLayout());
                panel.add(personsTable, personsTable.getName().toString());
                panel.add(personForm, personForm.getName().toString());

                System.out.println(personForm.getName().toString());
                System.out.println(personsTable.getName().toString());
                
                //navigation buttons------------------------------------------------------
                //persons table
                JButton buttonAddUser = new JButton("Add user");
                personsTable.add(buttonAddUser);
                buttonAddUser.addActionListener(new CardChangeListener(panel, personForm.getName().toString()));

                //person form
                personForm.add(new JButton("Modify"));
                JButton buttonCancelForm = new JButton("Cancel");
                personForm.add(buttonCancelForm);
                buttonCancelForm.setOpaque(true);
                buttonCancelForm.addActionListener(new CardChangeListener(panel, personsTable.getName().toString()));


                frame = new JFrame("Gestion Personnes");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(500, 500));

                frame.setContentPane(panel);
//                   frame.add(new JLabel("Salut"));
                   
                CardLayout cl = (CardLayout) (panel.getLayout());

                //Display the window.
                frame.pack();
                frame.setVisible(true);
                cl.show(panel, (String) personsTable.getName().toString());


            }
        });


    }

    static class CardChangeListener implements ActionListener {

        private Container panel;
        private String nextPage;

        public CardChangeListener(Container panel, String nextPage) {
            super();
            this.panel = panel;
            this.nextPage = nextPage;
        }

        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) (panel.getLayout());
            cl.show(panel, nextPage);
        }
    }
}
