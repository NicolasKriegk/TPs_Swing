/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5_horlogecorrsimon.controller;

import java.util.Observable;
import java.util.Observer;
import tp5_horlogecorrsimon.model.Model;
import tp5_horlogecorrsimon.view.View;

/**
 *
 * @author imie
 */
public class Controller implements Observer {

    private Model m;
    private View v;

    public Controller(Model m, View v) {
           this.m = m;
           this.v = v;
    }

    @Override
    public void update(Observable o, Object o1) {
        if ("incSecond".equals(o1.toString())) {
            m.incSecond();
        }
        if ("incMinute".equals(o1.toString())) {
            m.incMinute();
        }
        if ("incHour".equals(o1.toString())) {
            m.incHour();
        }
        if ("decSecond".equals(o1.toString())) {
            m.decSecond();
        }
        if ("decMinute".equals(o1.toString())) {
            m.decMinute();
        }
        if ("decHour".equals(o1.toString())) {
            m.decHour();
        }

    }
}
