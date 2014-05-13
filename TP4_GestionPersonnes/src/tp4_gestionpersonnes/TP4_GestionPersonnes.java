/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4_gestionpersonnes;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import model.Person;

/**
 *
 * @author imie
 */
public class TP4_GestionPersonnes {

    static JFrame frame;
    static JPanel cards;
    static JPanel usersTablePage;
    static JPanel personForm;
    static List<Person> persons = new ArrayList<Person>();
    static final Dimension STD_BUTTON_DIM = new Dimension(50, 20);
//    static SimpleDateFormat SDF = "dd/MM/yyyy";
    
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

                //Create the "cards"-----------------------------------------------------------------------
                usersTablePage = new JPanel();
//                usersTablePage.setLayout(new BorderLayout());
                usersTablePage.setName("Users list");
                //create users JTable
                UsersTableModel usersTableModel = new UsersTableModel();
                usersTableModel.fillTable(persons);
                JTable usersTable = new JTable(usersTableModel);
                 JScrollPane usersTableScrollPane = new JScrollPane(usersTable);
//               usersTablePage.add(usersTableScrollPane, BorderLayout.CENTER);
               usersTablePage.add(usersTableScrollPane);
                //usersTable.
                
                
                personForm = new JPanel();
                personForm.setName("User information");

                //Create the panel that contains the "cards".
                cards = new JPanel(new CardLayout());
                cards.add(usersTablePage, usersTablePage.getName().toString());
                cards.add(personForm, personForm.getName().toString());

                System.out.println(personForm.getName().toString());
                System.out.println(usersTablePage.getName().toString());

                //navigation buttons------------------------------------------------------
                //persons table page
                JButton buttonAddUser = new JButton("Add user");
//                buttonAddUser.setPreferredSize(null);
//                usersTablePage.add(buttonAddUser, BorderLayout.SOUTH);
                usersTablePage.add(buttonAddUser);
                buttonAddUser.addActionListener(new CardChangeListener(cards, personForm.getName().toString()));

                JButton buttonModifUser = new JButton("Modify user");
//                usersTablePage.add(buttonModifUser, BorderLayout.SOUTH);
                usersTablePage.add(buttonModifUser);

                 JButton buttonQuit = new JButton("Quit");
//                usersTablePage.add(buttonQuit, BorderLayout.SOUTH);
                usersTablePage.add(buttonQuit);
                buttonQuit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        System.exit(0);
                    }
                });

               //person form
                JButton buttonOKForm = new JButton("OK");
                personForm.add(buttonOKForm);
                //buttonOKForm
                
                JButton buttonCancelForm = new JButton("Cancel");
                personForm.add(buttonCancelForm);
                buttonCancelForm.setOpaque(true);
                buttonCancelForm.addActionListener(new CardChangeListener(cards, usersTablePage.getName().toString()));


                frame = new JFrame("User management");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(500, 500));
                  frame.setLocation(900, 900);
                         
                
                frame.setContentPane(cards);

                CardLayout cl = (CardLayout) (cards.getLayout());

                //Display the window.
                frame.pack();
                frame.setVisible(true);
                cl.show(cards, (String) usersTablePage.getName().toString());


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
