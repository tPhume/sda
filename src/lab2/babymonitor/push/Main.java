package lab2.babymonitor.push;

public class Main {
    public static void main(String[] args) {
        Baby marla = new Baby("marla");
        // one monitor with one baby
        SimpleMonitor livingRoom = new SimpleMonitor("kitchen ", marla);
        marla.setData(true, 1);

        // one monitor listening to two babies
        Baby charlie = new Baby("Charlie");
        AdvanceMonitor kitchen = new AdvanceMonitor("Living room ", marla, charlie);
        marla.setData(true, 2);
        charlie.setData(true,1);
    }
}

