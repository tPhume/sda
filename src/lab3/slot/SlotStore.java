package lab3.slot;

public abstract class SlotStore {
    public Slot orderSlot(slottype type) {
        Slot slot;
        System.out.println("================================================================================");
        slot = makeSlot(type);
        slot.collectParts();
        slot.assembleParts();
        slot.test("hardware");
        slot.uploadSoftware();
        slot.ship();
		System.out.println("================================================================================");
        return slot;
    }

    protected abstract Slot makeSlot(slottype type);
}
