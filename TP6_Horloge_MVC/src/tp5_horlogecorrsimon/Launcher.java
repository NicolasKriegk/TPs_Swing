/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5_horlogecorrsimon;

import tp5_horlogecorrsimon.controller.Controller;
import tp5_horlogecorrsimon.model.Model;
import tp5_horlogecorrsimon.view.View;

/**
 *
 * @author imie
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model m = new Model();
        View v = new View(m);
        Controller c = new Controller(m, v);
        m.addObserver(v);
        v.addObserver(c);
    }
}
