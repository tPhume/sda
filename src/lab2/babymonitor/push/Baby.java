package lab2.babymonitor.push;

import java.util.ArrayList;
import java.util.Observable;

public class Baby extends Observable {
    private String babyname;
    private int level = 0;
    private boolean crying = false;

    public Baby(String name){
        this.babyname=name;
    }

    public void setData(boolean crying, int level) {
        this.crying=crying;
        this.level=level;

        ArrayList data = new ArrayList();
        data.add(this.babyname);
        data.add(crying);
        data.add(level);

        setChanged();
        notifyObservers(data);
    }


    public boolean isCrying() {
        return crying;
    }

    public String getBabyname() {
        return babyname;
    }

    public int getLevel() {
        return level;
    }
}
