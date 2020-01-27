package lab2.babymonitor.pull;

import java.util.Observable;
import java.util.Observer;

public class SimpleMonitor implements Observer {
    private Observable mdata;
    private String name;
    private boolean crying;

    public SimpleMonitor(String location, Baby d) {
        this.mdata = d;
        this.name = location;
        mdata.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Baby baby = (Baby) o;
        this.crying = baby.isCrying();
        display();
    }

    public void display() {
        if (crying) {
            System.out.println("Monitor:" + name + " baby is crying");
        }
    }
}
