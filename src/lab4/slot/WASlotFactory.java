package lab4.slot;

public class WASlotFactory extends SlotFactory {
    @Override
    Slot makeSlot(String item) {
        Slot slot=null;
        SlotComponentFactory componentFactory = new WASlotComponentFactory();

        if (item.equals("bonus")) {
            slot=new BonusSlot(componentFactory);
            slot.setName("Washington Style Bonus Slot");
        }
        else if (item.equals("progressive")) {
            slot=new ProgressiveSlot(componentFactory);
            slot.setName("Washington Style Progressive Slot");
        } else if (item.equals("straight")) {
            slot = new StraightSlot(componentFactory);
            slot.setName("Washington Style Straight Slot");
        }

        return slot;
    }
}
