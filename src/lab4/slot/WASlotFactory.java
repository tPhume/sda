package lab4.slot;

public class WASlotFactory extends SlotFactory {
    @Override
    Slot makeSlot(String item) {
        Slot slot=null;
        SlotComponentFactory componentFactory;

        if (item.equals("bonus")) {
            componentFactory = new WASlotComponentFactory("bonus");
            slot=new BonusSlot(componentFactory);
            slot.setName("Washington Style Bonus Slot");
        }
        else if (item.equals("progressive")) {
            componentFactory = new WASlotComponentFactory("progressive");
            slot=new ProgressiveSlot(componentFactory);
            slot.setName("Washington Style Progressive Slot");
        } else if (item.equals("straight")) {
            componentFactory = new WASlotComponentFactory("straight");
            slot = new StraightSlot(componentFactory);
            slot.setName("Washington Style Straight Slot");
        }

        return slot;
    }
}
