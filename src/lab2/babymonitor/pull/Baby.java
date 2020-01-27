package lab2.babymonitor.pull;

import java.util.Observable;

public class Baby extends Observable {
    private String babyname;
    private int level = 0;
    private boolean crying = false;

    public Baby(String name) {
        this.babyname = name;
    }

    public void setData(boolean crying, int level) {
        this.crying = crying;
        this.level = level;
        setChanged();
        notifyObservers();
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
