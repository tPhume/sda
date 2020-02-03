package lab3.slot;

public class NJSlotBonus extends Slot {
    public NJSlotBonus() {
        name="NJ Bonus";
        software = "Windows ME";
        components.add("Large");
        components.add("coins");
        components.add("reels");
        components.add("ARM");
    }

    void ship() {
        System.out.println("having uncle vinnie drop it off");
    }
}
