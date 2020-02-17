package lab4.slot;

public class NVSlotFactory extends SlotFactory {

    @Override
    Slot makeSlot(String item) {
        Slot slot = null;
        SlotComponentFactory componentFactory;

        if (item.equals("bonus")) {
            componentFactory = new NVSlotComponentFactory("bonus");
            slot = new BonusSlot(componentFactory);
            slot.setName("Nevada Style Bonus Slot");
        } else if (item.equals("progressive")) {
            componentFactory = new NVSlotComponentFactory("progressive");
            slot = new ProgressiveSlot(componentFactory);
            slot.setName("Nevada Style Progressive Slot");
        } else if (item.equals("straight")) {
            componentFactory = new NVSlotComponentFactory("straight");
            slot = new StraightSlot(componentFactory);
            slot.setName("Nevada Style Straight Slot");
        }

        return slot;
    }
}