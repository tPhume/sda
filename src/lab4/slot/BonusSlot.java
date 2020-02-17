package lab4.slot;

public class BonusSlot extends Slot {
    SlotComponentFactory componentFactory;

    public BonusSlot(SlotComponentFactory componentFactory) {
        this.componentFactory = componentFactory;
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
