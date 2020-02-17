package lab4.slot;

public class SlotMachineApp {
	public static void main(String[] args) {
		SlotFactory njFactory = new NJSlotFactory();

		Slot slot1 = njFactory.orderSlot("bonus");
		System.out.println("Taj Mahal ordered a " + slot1 + "\n");
	}
}
