package lab3.slot;

public class NJSlotStraight extends Slot {
    public NJSlotStraight() {
        name="NJ Straight";
        software = "Windows ME";
        components.add("Small");
        components.add("coins");
        components.add("LCD");
        components.add("ARM");
    }

    void ship() {
        System.out.println("having uncle vinnie drop it off");
    }
}
