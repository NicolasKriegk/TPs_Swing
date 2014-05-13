/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4_gestionpersonnes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Person;

/**
 *
 * @author imie
 */
public class UsersTableModel extends AbstractTableModel {

    private String[] columnNames = {
        "Name",
        "Firstname",
        "Birthdate",
        "Training"};
    private List<Person> data = new ArrayList<Person>();

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return data.get(row).getName();
            case 1:
                return data.get(row).getFirstname();
            default:
                return null;
        }
    }

    //ajout d'une ligne
    public void addRow(Person user) {
        //mise a jour table
        data.add(user);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    //remplissage complet de la table
    public void fillTable(List<Person> users) {
        //mise a jour table
        data.addAll(users);
        fireTableRowsInserted(0, data.size() - 1);
    }

}
