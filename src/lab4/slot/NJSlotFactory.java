package lab4.slot;

public class NJSlotFactory extends SlotFactory {

	protected Slot makeSlot(String item) {
		Slot slot=null;
		SlotComponentFactory componentFactory;

		if (item.equals("bonus")) {
			componentFactory = new NJSlotComponentFactory("bonus");
			slot=new BonusSlot(componentFactory);
			slot.setName("New Jersey Style Bonus Slot");
		}
		else if (item.equals("progressive")) {
			componentFactory = new NJSlotComponentFactory("progressive");
			slot=new ProgressiveSlot(componentFactory);
			slot.setName("New Jersey Style Progressive Slot");
		} else if (item.equals("straight")) {
			componentFactory = new NJSlotComponentFactory("straight");
			slot = new StraightSlot(componentFactory);
			slot.setName("New Jersey Style Straight Slot");
		}

		return slot;
	}
}