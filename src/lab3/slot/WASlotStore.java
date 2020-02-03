package lab3.slot;

public class WASlotStore extends SlotStore {
    protected Slot makeSlot(slottype type) {
        if (type.equals(slottype.straight)) return new WASlotStraight();
        if (type.equals(slottype.bonus)) return new WASlotBonus();
        if (type.equals(slottype.progressive)) return new WASlotProgressive();
        return null;
    }
}
