package lab4.slot;

public class StraightSlot extends Slot {
    SlotComponentFactory componentFactory;

    public StraightSlot(SlotComponentFactory componentFactory) {
        this.componentFactory= componentFactory;
    }

    void build() {
        System.out.println("Building " + name);
        cabinet = componentFactory.createCabinet();
        payment = componentFactory.createPayment();
        display = componentFactory.createDisplay();
        gpu = componentFactory.createGPU();
        os = componentFactory.createOS();
    }
}
