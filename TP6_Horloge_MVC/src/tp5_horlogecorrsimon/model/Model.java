/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5_horlogecorrsimon.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Observable;

/**
 *
 * @author imie
 */
public class Model extends Observable {

    private Integer time = 0;
    private Integer second = 0;
    private Integer minute = 0;
    private Integer hour = 0;

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    private Boolean running = false;

    public Model() {
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

                }
                System.out.println("End IncrementThread");
            }
        });


        thread.start();

    }

    private void incrementCentisecond() {
        if (running) {
            time++;
            businessRule();
        }
    }

    public void incSecond() {
        second++;
        businessRule();
    }

    public void decSecond() {
        second--;
        businessRule();
    }

    public void incMinute() {
        minute++;
        businessRule();
    }

    public void decMinute() {
        minute--;
        businessRule();
    }

    public void incHour() {
        hour++;
        businessRule();
    }

    public void decHour() {
        hour--;
        businessRule();
    }

    public void synch() {
//        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
        businessRule();
    }

    public void raz() {
        second = 0;
        minute = 0;
        hour = 0;
        time = 0;
        businessRule();
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg); //To change body of generated methods, choose Tools | Templates.
        
    }

    private void businessRule() {
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

        //modele mis a jour, notification aux abonnés
        setChanged();
        notifyObservers();

    }
}
