package lab3.slot;

public class NVSlotStore extends SlotStore {
	
	protected Slot makeSlot(slottype type) {
		if (type.equals(slottype.straight)) return new NVSlotStraight();
		if (type.equals(slottype.bonus)) return new NVSlotBonus();
		if (type.equals(slottype.progressive)) return new NVSlotProgressive();
		return null;
	}
}
