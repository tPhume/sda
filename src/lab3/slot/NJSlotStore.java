package lab3.slot;

public class NJSlotStore extends SlotStore {

	protected Slot makeSlot(slottype type) {
		if (type.equals(slottype.straight)) return new NJSlotStraight();
		if (type.equals(slottype.bonus)) return new NJSlotBonus();
		if (type.equals(slottype.progressive)) return new NJSlotProgressive();
		return null;
	}
}
